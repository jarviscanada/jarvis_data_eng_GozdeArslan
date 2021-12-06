
  --Group hosts by hardware info/Query 1--
SELECT
    cpu_number,
    id,
    AVG(total_mem/1000) AS Total_memory
  FROM
    host_info
  ORDER BY
  cpu_number,
  total_memory DESC;


--Average memory usage/Query 2--

 SELECT
    u.host_id AS HOST ID,
    i.hostname AS HOST NAME ,
    u.timestamp AS TIMESTAMP
    i.total_mem(AVG(hi.total_mem/1000 -u.memory_free)*100 AS avg_used_mem_percentage
  FROM
     host_usage u
     host_info i
  WHERE
      u.host_id=i.id
  ORDER BY
         host_id;


--Detect host failure/Query 3---
SELECT
u.host_id,
round5(u.timestamp) AS TS
count(*) as num_data_points
FROM
host_usage u
Group by
host_id,
TS
HAVING
count(*)<3
ORDER BY
TS;



