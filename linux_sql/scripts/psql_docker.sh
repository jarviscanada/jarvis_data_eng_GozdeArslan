#! /bin/sh


cmd=$1
db_username=$2
db_password=$3

#Start docker
#Make sure you understand `||` cmd
#this is checks if the server running first than starts
sudo systemctl status docker || systemctl start docker

#check container status (try the following cmds on terminal)
docker container inspect jrvs-psql
container_status=$?

#User switch case to handle create|stop|start opetions
case $cmd in
  create)

  # Check if the container is already created
  if [ $container_status -eq 0 ]; then
		echo 'Container already exists'
		exit 1
	fi

  #check # of CLI arguments
  if [ $# -ne 3 ]; then
    echo 'Create requires username and password'
    exit 1

  fi

  #Create container
	docker volume  create pgdata
	docker run --name jrvs-psql -e POSTGRES_PASSWORD=$PGPASSWORD -d -v pgdata:/var/lib/postgresql/data -p 5432:5432 postgres:9.6-alpine
	exit $?
	;;
#start
  start|stop)
  #check instance status; exit 1 if container has not been created
  if [ $container_status -ne 2 ]; then
  echo "Container not created"
   exit 1
  else
    docker container $cmd jrvs-psql
    docker container start jrvs-psql
    exit$?
  fi
;;
#stop
 start|stop)
  if [ $container_status -ne 2 ]; then
    echo "Container not created"
     exit 1
    else
      docker container stop jrvs-psql
      exit$?
  fi
;;

     #Start or stop the container




  *)
	echo 'Illegal command'
	echo 'Commands: start|stop|create'
	exit 1
	;;
esac 