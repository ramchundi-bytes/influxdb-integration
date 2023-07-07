package com.ram.springboot.influxdbintegration.service;


import com.ram.springboot.influxdbintegration.repository.InfluxDBSampleWriteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InfluxDBSampleWriteService {

    public InfluxDBSampleWriteRepository influxDBSampleWriteRepository;

    public InfluxDBSampleWriteService(
            @Autowired InfluxDBSampleWriteRepository influxDBSampleWriteRepository) {
        this.influxDBSampleWriteRepository = influxDBSampleWriteRepository;
    }

    public void write() {
        influxDBSampleWriteRepository.write();
    }
}
