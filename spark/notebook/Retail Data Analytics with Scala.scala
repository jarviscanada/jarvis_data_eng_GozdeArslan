// Databricks notebook source
// MAGIC %md
// MAGIC #Retail Data Wrangling and Analytics

// COMMAND ----------

// MAGIC %scala
// MAGIC  // Configuration and Imports
// MAGIC     
// MAGIC import org.apache.spark.sql.functions._
// MAGIC import org.apache.spark.sql.DataFrameStatFunctions
// MAGIC import org.apache.spark.sql.expressions._
// MAGIC import org.apache.spark.ml.feature._
// MAGIC import org.apache.spark._

// COMMAND ----------

// MAGIC %md
// MAGIC Load and read csv file into spark data frame

// COMMAND ----------

// MAGIC %scala
// MAGIC //please note that The table Online_retail_II.csv is loaded via the create table Databricks UI //function, and it will be read it into a Spark DataFrame.
// MAGIC 
// MAGIC var retailData= spark.read.table("online_retail_ii_csv")
// MAGIC retailData.printSchema()
// MAGIC retailData.cache()
// MAGIC retailData.count()

// COMMAND ----------

// MAGIC %md
// MAGIC Total Invoice Amount Distribution
// MAGIC Invoice Amount

// COMMAND ----------

// MAGIC %scala
// MAGIC retailData.createOrReplaceTempView("online_retail_ii_csv")

// COMMAND ----------

// MAGIC %scala
// MAGIC val sqlDF = spark.sql("""
// MAGIC   SELECT invoice, Quantity*Price as Amount
// MAGIC   FROM online_retail_ii_csv
// MAGIC   WHERE Quantity * Price > 0
// MAGIC   ORDER BY invoice
// MAGIC """)
// MAGIC sqlDF.show()

// COMMAND ----------

// MAGIC %md
// MAGIC Invoice Amount Distribution Plots (Max, min,mean,mod and median)

// COMMAND ----------

// MAGIC %scala
// MAGIC //
// MAGIC val totalAmountDF = sqlDF
// MAGIC   .groupBy("invoice")
// MAGIC   .sum()
// MAGIC   .withColumnRenamed("sum(amount)", "Total_Amount")
// MAGIC   .orderBy("Total_Amount")
// MAGIC 
// MAGIC display(totalAmountDF)
// MAGIC   

// COMMAND ----------

// MAGIC %md
// MAGIC Total Invoice Amount Distribution (Max, min,mean,mod and median)

// COMMAND ----------

// MAGIC %scala
// MAGIC //show max min values if the he distribution amolunt
// MAGIC totalAmountDF.createOrReplaceTempView("totalAmountDF")
// MAGIC 
// MAGIC   
// MAGIC   val totalDF = spark.sql("""
// MAGIC   SELECT avg(Total_Amount), max(Total_Amount), min(Total_Amount)
// MAGIC   FROM totalAmountDF
// MAGIC """)
// MAGIC display(totalDF)

// COMMAND ----------

// MAGIC %scala
// MAGIC 
// MAGIC /*def medianCalculator(seq: Seq[Int]): Any = {
// MAGIC  
// MAGIC  
// MAGIC   val median = (totalDF.count() / 2).toInt
// MAGIC 
// MAGIC   if (totalDF.count() % 2 == 1) (return median)
// MAGIC 
// MAGIC    val med = totalDF
// MAGIC    .take(median)
// MAGIC   .last
// MAGIC   .get(1)
// MAGIC  
// MAGIC   return med
// MAGIC 
// MAGIC  
// MAGIC }
// MAGIC */
// MAGIC 
// MAGIC val medianDF = (totalAmountDF.count() / 2).toInt
// MAGIC val med = totalAmountDF
// MAGIC   .take(medianDF)
// MAGIC   .last
// MAGIC   .get(1)
// MAGIC 
// MAGIC 
// MAGIC print(med)
// MAGIC 
// MAGIC val modeDF = totalAmountDF
// MAGIC   .groupBy("Total_Amount")
// MAGIC   .count()
// MAGIC   .sort(desc("count"))
// MAGIC   .first
// MAGIC   .get(0)
// MAGIC  // print(totalDF,median,mod)
// MAGIC print(modeDF)
// MAGIC 
// MAGIC //display(med,modeDF)
// MAGIC /*def medianCalculator(seq: Seq[Int]): Int = {
// MAGIC   //In order if you are not sure that 'seq' is sorted
// MAGIC  
// MAGIC   val sortedSeq = totalDF.sortWith(_ < _)
// MAGIC  
// MAGIC   if (totalDF.size % 2 == 1) sortedSeq(sortedSeq.size / 2)
// MAGIC   else {
// MAGIC     val (up, down) = sortedSeq.splitAt(totalDF.size / 2)
// MAGIC     (up.last + down.head) / 2
// MAGIC   }
// MAGIC }
// MAGIC 
// MAGIC }*/

// COMMAND ----------

// MAGIC %md
// MAGIC Showing the distribution of invoice amount for the first 85 quantiles

// COMMAND ----------

// MAGIC %scala
// MAGIC val quantiles = totalAmountDF.stat.approxQuantile("Total_Amount", Array(0.85), 0.25)(0)
// MAGIC 
// MAGIC var quantDf = totalAmountDF.filter($"Total_Amount" < quantiles)
// MAGIC print(quantDf)

// COMMAND ----------

// MAGIC %md
// MAGIC Monthly Placed and Canceled Orders
// MAGIC  - Get invoices for each months

// COMMAND ----------

// MAGIC %scala
// MAGIC val orderData = retailData.select( col("invoice").as("Invoice"),col("InvoiceDate").as("Year"))
// MAGIC orderData.show(10)

// COMMAND ----------

// MAGIC %md
// MAGIC Set a new dataframe with monthly total orders and cancelled orders

// COMMAND ----------

// MAGIC %scala
// MAGIC 
// MAGIC orderData.createOrReplaceTempView("orderData")
// MAGIC 
// MAGIC val totalMonthly= spark.sql("""
// MAGIC   SELECT Year, count(DISTINCT invoice) as total_monthly_orders
// MAGIC   FROM orderData
// MAGIC   GROUP BY Year
// MAGIC  
// MAGIC """)
// MAGIC 
// MAGIC val orderCancelled = orderData.filter(col("invoice").contains('C'))
// MAGIC 
// MAGIC orderCancelled.createOrReplaceTempView("orderCancelled")
// MAGIC val cancelledDf = spark.sql("""
// MAGIC   SELECT Year, count(DISTINCT invoice) AS cancelled_orders
// MAGIC   FROM orderCancelled
// MAGIC   GROUP BY Year
// MAGIC """)
// MAGIC 
// MAGIC val allOrders = totalMonthly.join(cancelledDf, totalMonthly("Year") === cancelledDf("Year"), "inner").withColumn("completed_order", col("total_monthly_orders") - col("cancelled_orders"))
// MAGIC allOrders.show(10)

// COMMAND ----------

// MAGIC %md
// MAGIC 1. The sales records for each month

// COMMAND ----------

// MAGIC %scala
// MAGIC val salesData = retailData.
// MAGIC select( col("invoice").as("Invoice"),  col("quantity").as("Quantity"), col("Price"), col("invoiceDate"),((col("quantity") * col("Price")).as("Sales_Amount")))
// MAGIC 
// MAGIC salesData.show(10)

// COMMAND ----------

// MAGIC %md
// MAGIC - The monthly sales 

// COMMAND ----------

// MAGIC %scala
// MAGIC val salesByMonthly = salesData
// MAGIC   .groupBy("invoiceDate").sum()
// MAGIC    .select("sum(invoice)","invoiceDate")
// MAGIC salesByMonthly.show(10)

// COMMAND ----------

// MAGIC %md
// MAGIC - Getting the active user invoice records for each month

// COMMAND ----------

// MAGIC %scala
// MAGIC 
// MAGIC val usersData = retailData.select(col("customer_id"), col("invoiceDate"))
// MAGIC 
// MAGIC usersData.show(10)

// COMMAND ----------


