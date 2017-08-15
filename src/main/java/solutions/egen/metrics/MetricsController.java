package solutions.egen.metrics;

import solutions.egen.db.MorphiaContext;
import solutions.egen.metrics.Metric;
import solutions.egen.rules.UnderweightRule;
import solutions.egen.rules.OverweightRule;
import solutions.egen.metrics.MetricDAO;

import org.easyrules.api.RulesEngine;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import static org.easyrules.core.RulesEngineBuilder.aNewRulesEngine;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/metrics")
@RestController
public class MetricsController {

    @Autowired
    private MetricDAO metricDAO;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<Metric> create(@RequestBody Metric metric) {

        metricDAO.create(metric);

        return new ResponseEntity<Metric>(metric, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/read")
    public ResponseEntity<List<Metric>> read() {

        List<Metric> metricList = metricDAO.read();
        if (metricList.size() == 0)
            return new ResponseEntity<List<Metric>>(metricList, HttpStatus.NO_CONTENT);

        return new ResponseEntity<List<Metric>>(metricList, HttpStatus.OK);
    }

    @RequestMapping(value = "/readRange/{timestampBegin}/{timestampEnd}")
    public ResponseEntity<List<Metric>> readByTimeRange(@PathVariable Long timestampBegin, @PathVariable Long timestampEnd) {

        List<Metric> metricList = metricDAO.readByTimeRange(timestampBegin, timestampEnd);

        if (metricList.size() == 0)
            return new ResponseEntity<List<Metric>>(metricList, HttpStatus.NO_CONTENT);

        return new ResponseEntity<List<Metric>>(metricList, HttpStatus.OK);
    }
}
