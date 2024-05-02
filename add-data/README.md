# kafka-exercises: jdbc-sink-timestamp-ext
Learn and get hands-on experience working with streaming data. Transform and add data not present in original message

## Prerequisites
- docker
- docker-compose
- gradle
- jdk11

## Startup confluent platform
```
cd kafka-exercises\jdbc-sink
docker-compose up -d
```

## Configure connector
### Create jdbc-sink connector, RUN in the connect container
```
curl -X POST -H "Content-Type: application/json" \
  --data @/connectors/timestamp-ext-connector.json \
    http://connect:8083/connectors
```

### Check connector status
```
curl http://connect:8083/connectors/jdbc-sink/status
```

## Test data, pass one by one into producer from the step above
- `{"order_id": "order1","customer_id": "cid23","customer_name": "Michael Scofield"}`
- `{"order_id": "order2","customer_id": "cid1","customer_name": "Rick Grimes"}`
- `{"order_id": "order42","customer_id": "cid29","customer_name": "Maggie Rhee"}`
- `{"order_id": "order98","customer_id": "cid42","customer_name": "Daryl Dixon"}`