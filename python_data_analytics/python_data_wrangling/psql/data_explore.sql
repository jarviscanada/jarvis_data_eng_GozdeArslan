-- Show table schema 
\d+ retail;

-- Show first 10 rows
SELECT * FROM retail limit 10;

-- Check # of records
SELECT  COUNT(*) FROM retail;

-- number of clients (e.g. unique client ID)
SELECT COUNT(DISTINCT customer_id) FROM retail;

