package com.ram.springboot.influxdbintegration.controller;


import com.ram.springboot.influxdbintegration.service.InfluxDBSampleWriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InfluxWriteController {

    @Autowired
    InfluxDBSampleWriteService influxDBSampleWriteService;

    @GetMapping(path = "/")
    public String write() {
        influxDBSampleWriteService.write();
        return "Complete. Return to the InfluxDB UI." ;
    }
}
