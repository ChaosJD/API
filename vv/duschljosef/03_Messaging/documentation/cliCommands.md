#cli commands

------------------
######see what queues RabbitMQ had and how many messages ar in them
sudo rabbitmqctl list_queues

######basic commands

sudo service rabbitmq-server start
sudo service rabbitmq-server stop
sudo service rabbitmq-server status

######checks if loacl node in running & Cli tools can successfully authenticate with it

sudo rabbit-diagnostics ping

######print enabled components, TCP listeners, memory usage breakdown, alarms and so on

sudo rabbit-diagnostics status

######prints effective node configruation

sudo rabbit-diagnostics environments

#####performs a more extensive health check of the local node

sudo rabbit-diagnostics node_health_check

######to debug the failing basicAck

sudo rabbitmctl list_queues name mesages_ready messages_unacknowledged

######To list the exchanges on the server you can run the ever useful 

sudo rabbitmqctl list_exchanges

######Listing bindings

rabbitmqctl list_bindings

#LogFiles
/var/log/rabbitmq