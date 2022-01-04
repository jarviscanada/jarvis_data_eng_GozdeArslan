
 --Group hosts by hardware info/Query 1--
SELECT
   cpu_number,
   id,
   round(total_mem / 1000, 0) AS total_memory
FROM
   host_info
GROUP BY
   cpu_number,
   id
ORDER BY
   cpu_number;

--Average memory usage/Query 2--

 SELECT
   u.host_id AS Host_Id,
   i.hostname AS Host_Name,
   u.TIMESTAMP AS TIMESTAMP i.total_mem(round((hi.total_mem / 1000 - u.memory_free, 0)*100 AS avg_used_mem_percentage
FROM
   host_usage u host_info i
WHERE
   u.host_id = i.id
ORDER BY
   host_id;

--Detect host failure/Query 3---


SELECT
   u.host_id,
   round5(u.TIMESTAMP) AS ts COUNT(*) AS num_data_points
FROM
   host_usage u
GROUP BY
   host_id,
   ts
HAVING
   COUNT(*) < 3
ORDER BY
   ts;





