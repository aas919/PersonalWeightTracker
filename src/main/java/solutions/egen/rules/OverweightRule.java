package solutions.egen.rules;

import solutions.egen.db.MorphiaContext;
import solutions.egen.metrics.Metric;
import solutions.egen.alerts.Alert;
import solutions.egen.alerts.AlertDAO;

import org.easyrules.annotation.Action;
import org.easyrules.annotation.Condition;
import org.easyrules.annotation.Rule;
import org.mongodb.morphia.Datastore;
import org.springframework.beans.factory.annotation.Autowired;

@Rule(name = "Overweight rule", description = "Detects over weight – if the weight of the person shoots 10% over his base weight")
public class OverweightRule {

    private AlertDAO alertDAO;
    private Metric metric;

    public OverweightRule(Metric metric) {
        this.metric = metric;
        alertDAO = new AlertDAO();
    }

    @Condition
    public boolean when() {
        return true;
    }

    @Action(order = 1)
    public void then() throws Exception {
        Alert alert = new Alert("Overweight", metric.getTimestamp(), metric.getValue());
        alertDAO.create(alert);
    }

}
