package com.ram.springboot.influxdbintegration.repository;

import com.influxdb.v3.client.InfluxDBClient;
import com.influxdb.v3.client.query.QueryParameters;
import com.influxdb.v3.client.query.QueryType;
import com.influxdb.v3.client.write.Point;
import com.influxdb.v3.client.write.WriteParameters;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

@Repository
public class InfluxDBSampleWriteRepositoryImpl implements InfluxDBSampleWriteRepository {

    @Value(value = "spring.influx.auth-token")
    public String authToken;

    @Value(value = "spring.influx.host-name")
    public String hostName;

    @Override
    public void write() {
        try (InfluxDBClient client = InfluxDBClient.getInstance(hostName, authToken.toCharArray(), null)) {

            String database = "census";

            Point[] points = new Point[] {
                    Point.measurement("census")
                            .addTag("location", "Klamath")
                            .addField("bees", 23),
                    Point.measurement("census")
                            .addTag("location", "Portland")
                            .addField("ants", 30),
                    Point.measurement("census")
                            .addTag("location", "Klamath")
                            .addField("bees", 28),
                    Point.measurement("census")
                            .addTag("location", "Portland")
                            .addField("ants", 32),
                    Point.measurement("census")
                            .addTag("location", "Klamath")
                            .addField("bees", 29),
                    Point.measurement("census")
                            .addTag("location", "Portland")
                            .addField("ants", 40)
            };

            for (Point point : points) {
                client.writePoint(point, new WriteParameters(database, null, null));
                Thread.sleep(1000); // separate points by 1 second
            }
            System.out.printf("| %-5s | %-5s | %-8s | %-30s |%n", "ants", "bees", "location", "time");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
