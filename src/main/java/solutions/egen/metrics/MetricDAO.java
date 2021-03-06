package solutions.egen.metrics;

import solutions.egen.db.MorphiaContext;
import solutions.egen.metrics.Metric;
import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.*;
import org.mongodb.morphia.Key;
import org.springframework.stereotype.Component;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Component
public class MetricDAO {

    private Datastore datastore;

    MetricDAO() {
        datastore = MorphiaContext.getMorphiaContext().getDatastore();
    }

    public Key<Metric> create(Metric metric) {
        return datastore.save(metric);
    }

    public List<Metric> read() {
        Query<Metric> query = datastore.createQuery(Metric.class);
        return query.asList();
    }

    public List<Metric> readByTimeRange(long timestampBegin, long timestampEnd) {
        Query<Metric> query = datastore.createQuery(Metric.class)
                .filter("timestamp >=", timestampBegin)
                .filter("timestamp <=", timestampEnd);
        return query.asList();
    }
}
