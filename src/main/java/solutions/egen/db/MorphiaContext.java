package solutions.egen.db;

import com.mongodb.MongoClient;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

public class MorphiaContext {

    private String packageName = "com.egen.model";

    private static MorphiaContext morphiaContext = new MorphiaContext();

    final private Datastore datastore;

    public MorphiaContext() {
        Morphia morphia = new Morphia();
        datastore = morphia.createDatastore(new MongoClient(), "morphia_pwt");
        datastore.ensureIndexes();
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public static MorphiaContext getMorphiaContext() {
        return morphiaContext;
    }

    public static void setMorphiaContext(MorphiaContext morphiaContext) {
        MorphiaContext.morphiaContext = morphiaContext;
    }

    public Datastore getDatastore() {
        return datastore;
    }
}
