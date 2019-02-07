CREATE KEYSPACE tinyurl
    WITH replication = {'class': 'SimpleStrategy', 'replication_factor' : 3};