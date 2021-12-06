#!/bin/bash

psql_host=$1
psql_port=$2
db_name=$3
psql_user=$4
psql_password=$5

   #check # of CLI arguments
    if [ $# -ne 5 ]; then
      echo 'Error!Missing arguments. Please Enter arguments as this format'
      exit 1
    fi
    #save machine statistics in MB and current machine hostname variables

    lscpu_out=`lscpu`
    hostname=$(hostname -f)
    vmstat_out=$(vmstat --unit M)
    meminfo_out="$(cat /proc/meminfo)"
    cpu_number=$(echo "$lscpu_out"  | egrep "^CPU\(s\):" | awk '{print $2}' | xargs)
    cpu_architecture=$(echo "$lscpu_out"  | egrep "^Architecture:" | awk '{print $2}' | xargs)
    cpu_model=$(echo "$lscpu_out"  | egrep "^Model:" | awk '{print $2}' | xargs)
    cpu_mhz=$(echo "$lscpu_out"  | egrep "^CPU MHz:" | awk '{print $3}' | xargs)
    l2_cache=$(echo "$lscpu_out"  | egrep "^L2 cache:" | awk '{print $3}' |sed 's/K//'| xargs)
    total_mem=$(echo "$meminfo_out"  | egrep "^MemTotal:" | awk '{print $2}' | xargs)
    timestamp=$(vmstat -t| awk '{print $18" \t "$19}' |tail -n1 |xargs)

    #retrieve hardware specifications
    #Subquery to find matching id in host_info table
    insert_stmt="INSERT INTO host_info(hostname ,cpu_number,cpu_architecture,cpu_model ,cpu_mhz,l2_cache, total_mem ,
                                       timestamp) VALUES('$hostname' ,'$cpu_number','$cpu_architecture','$cpu_model' ,$cpu_mhz,$l2_cache, $total_mem ,'$timestamp')";

#set up env var for pql cmd
export PGPASSWORD=$psql_password
#Insert date into a database
psql -h $psql_host -p $psql_port -d $db_name -U $psql_user -c "$insert_stmt"
exit $?
