package solutions.egen.metrics;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Property;

@Entity("metrics")
public class  Metric {
    @Id
    private ObjectId id;
    @Property("timestamp")
    private long timestamp;
    @Property("value")
    private int value;

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId metricId) {
        this.id = id;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
