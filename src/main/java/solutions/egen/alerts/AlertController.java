package solutions.egen.controller;

import solutions.egen.MorphiaContext;
import solutions.egen.alerts.Alert;
import solutions.egen.alerts.AlertDAO;
import solutions.egen.metrics.Metric;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/alerts")
@RestController
public class AlertController {

    @Autowired
    private AlertService alertService;

    @RequestMapping(value = "/read")
    public ResponseEntity<List<Alert>> read() {

        List<Alert> alertList = alertDAO.read();

        if (alertList.size() == 0)
            return new ResponseEntity<List<Alert>>(alertList, HttpStatus.NO_CONTENT);

        return new ResponseEntity<List<Alert>>(alertList, HttpStatus.OK);
    }

    @RequestMapping(value = "/readRange/{timestampBegin}/{timestampEnd}")
    public ResponseEntity<List<Alert>> readByTimeRange(@PathVariable Long timestampBegin, @PathVariable Long timestampEnd) {

        List<Alert> alertList = alertService.readByRange(timestampBegin, timestampEnd);

        if (alertList.size() == 0)
            return new ResponseEntity<List<Alert>>(alertList, HttpStatus.NO_CONTENT);

        return new ResponseEntity<List<Alert>>(alertList, HttpStatus.OK);
    }
}
