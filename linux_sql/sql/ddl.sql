-- create `host_info` table if not exist --
CREATE TABLE IF NOT EXISTS PUBLIC.host_info
  (
     id                SERIAL PRIMARY KEY NOT NULL,
     hostname          VARCHAR NOT NULL,
     cpu_number        INTEGER NOT NULL,
     cpu_architecture  VARCHAR  NOT NULL,
     cpu_model         VARCHAR NOT NULL,
     cpu_mhz           INTEGER NOT NULL,
     l2_cache          INTEGER NOT NULL,
     total_mem         INTEGER NOT NULL,
     "timestamp"       TIMESTAMP NOT NULL,

       PRIMARY KEY (id),
        CONSTRAINT fk_hostname,


  );

  INSERT INTO host_info (id, hostname ,cpu_number,cpu_architecture,cpu_model ,cpu_mhz,l2_cache, total_mem ,
                      timestamp  )
    --create `host_usage` table if not exist--

  CREATE TABLE  IF NOT EXISTS PUBLIC.host_usage
                        (
                           "timestamp"      TIMESTAMP NOT NULL,
                           host_id         SERIAL PRIMARY KEY NOT NULL,
                           memory_free      INTEGER NOT NULL,
                           cpu_idle         INTEGER NOT NULL,
                           cpu_kernel       INTEGER NOT NULL,
                           disk_io          INTEGER NOT NULL,
                           disk_available   INTEGER NOT NULL,
                           PRIMARY KEY (host_id),
                              CONSTRAINT fk_host_id,
                                  FOREIGN KEY (host_id),
                                     REFERENCES host_info(id)


                        );


  INSERT INTO host_usage ("timestamp", host_id,memory_free,cpu_idle,cpu_kernel,disk_io,disk_available)

