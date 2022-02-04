-- Show table schema 
\d+ retail;

-- Question 1
-- Show first 10 rows
SELECT * FROM retail limit 10;

-- Question 2
-- Check # of records
SELECT  COUNT(*) FROM retail;

-- Question 3
-- number of clients (e.g. unique client ID)
SELECT COUNT(DISTINCT customer_id) FROM retail;

-- Question 4
-- Finds the invoice within the Date Range. (eg. Max/Min Dates)
SELECT MAX(invoice_date), MIN(invoice_date) FROM retail;

-- Question 5
-- Finds the Number of SKU/Merchants. (eg. Unique Stock Code)
SELECT COUNT(DISTINCT stock_code) FROM retail;

-- Question 6
-- Calculate an average invoice amount by excluding negative invoice amount. (eg. Canceled Orders have a Negative Amount)
SELECT AVG(invoice_amount)
   FROM (
        SELECT SUM(quantity * unit_price) AS invoice_amount
          FROM retail
           GROUP BY invoice_no
              HAVING SUM(quantity * unit_price) > 0 ) ;

-- Question 7
-- Finds the sum of Total Revenue.
SELECT SUM(unit_price * quantity) FROM retail;

-- Question 8
-- Finds total Revenue (format date: YYYYMM )

