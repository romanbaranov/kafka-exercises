``
docker run --name local-db \
  -p 1521:1521 -p 5500:5500 \
  -e ORACLE_PWD=strong-password \
  -e ORACLE_CHARACTERSET=<your character set> \
  -v local-oradata:/opt/oracle/oradata \
  oracle/database:21.3.0-xe
``

Parameters:
--name:        The name of the container (default: auto generated)
-p:            The port mapping of the host port to the container port.
Two ports are exposed: 1521 (Oracle Listener), 5500 (EM Express)
-e ORACLE_PWD: The Oracle Database SYS, SYSTEM and PDB_ADMIN password (default: auto generated)
-e ORACLE_CHARACTERSET:
The character set to use when creating the database (default: AL32UTF8)
-v /opt/oracle/oradata
The data volume to use for the database.
Has to be writable by the Unix "oracle" (uid: 54321) user inside the container!
If omitted the database will not be persisted over container recreation.
-v /opt/oracle/scripts/startup | /docker-entrypoint-initdb.d/startup
Optional: A volume with custom scripts to be run after database startup.
For further details see the "Running scripts after setup and on startup" section below.
-v /opt/oracle/scripts/setup | /docker-entrypoint-initdb.d/setup
Optional: A volume with custom scripts to be run after database setup.
For further details see the "Running scripts after setup and on startup" section below.