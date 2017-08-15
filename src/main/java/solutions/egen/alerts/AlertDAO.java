package solutions.egen.alerts;

import solutions.egen.db.MorphiaContext;
import solutions.egen.alerts.Alert;
import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.*;
import org.mongodb.morphia.Key;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AlertDAO {

    private Datastore datastore;

    public AlertDAO() {
        datastore = MorphiaContext.getMorphiaContext().getDatastore();
    }

    public Key<Alert> create(Alert Alert) {
        return datastore.save(Alert);
    }

    public List<Alert> read() {
        Query<Alert> query = datastore.createQuery(Alert.class);
        return query.asList();
    }

    public List<Alert> readByTimeRange(long timestampBegin, long timestampEnd) {
        Query<Alert> query = datastore.createQuery(Alert.class)
                .filter("timeStamp >=", timestampBegin)
                .filter("timeStamp <=", timestampEnd);
        return query.asList();
    }
}
