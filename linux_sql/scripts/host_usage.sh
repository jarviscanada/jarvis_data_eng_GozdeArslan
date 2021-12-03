#!/bin/bash

psql_host=$1
psql_port=$2
db_name=$3
psql_user=$4
psql_password=$5

   #check # of CLI arguments
    if [ $# -ne 5 ]; then
      echo 'Create requires username and password'
      exit 1
    fi
    #save machine statistics in MB and current machine hostname variables
    vmstat_mb=$(vmstat --unit M)
    hostname=$(hostname -f)
    memory_free=$(echo "$vmstat_mb" | awk '{print $4}'| tail -n1 | xargs)
    cpu_idle=$(echo "$vmstat_mb" | awk '{print $15}' |tail -n1| xargs)
    cpu_kernel=$(echo "$vmstat_mb" | awk '{print $13}' |tail -n1| xargs)
    disk_io=$(echo "$vmstat_mb" | awk '{print $10}' |tail -n1|xargs)
    disk_available=$(df -BM| awk '{print $4}'|tail -n1 | xargs)
    timestamp=$(vmstat -t| awk '{print $18" \t "$19}' |tail -n1 |xargs)
    #retrieve hardware specifications
    #Subquery to find matching id in host_info table
    host_id="(SELECT id FROM host_info WHERE hostname='$hostname')";
    insert_stmt="INSERT INTO host_usage(id, memory_free,cpu_idle,cpu_kernel,disk_io,disk_available,
                                       timestamp) VALUES(id, memory_free,cpu_idle,cpu_kernel,disk_io,disk_available ,'$timestamp')";

#set up env var for pql cmd
export PGPASSWORD=$psql_password
#Insert date into a database
psql -h $psql_host -p $psql_port -d $db_name -U $psql_user -c "$insert_stmt
exit $?

esac
