/*package solutions.egen.metrics;

import solutions.egen.metrics.Metric;
import com.egen.service.MetricService;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/metrics")
@RestController
public class MetricsController {

    @RequestMapping(value = "/read")
    public ResponseEntity<List<Metric>> read() {

        List<Metric> metricList = metricService.read();

        if (metricList.size() == 0)
            return new ResponseEntity<List<Metric>>(metricList, HttpStatus.NO_CONTENT);

        return new ResponseEntity<List<Metric>>(metricList, HttpStatus.OK);
    }
}
*/