package solutions.egen;

import solutions.egen.microservices.registration.RegistrationServer;
import solutions.egen.microservices.metrics.MetricsServer;
import solutions.egen.microservices.alerts.AlertsServer;

public class PersonalWeightTrackerApplication  {

	public static void main(String[] args) {
        String serverName = "NO-VALUE";

        switch (args.length) {
            case 2:
                System.setProperty("server.port", args[1]);
            case 1:
                serverName = args[0].toLowerCase();
                break;
            default:
                return;
        }

        if (serverName.equals("registration") || serverName.equals("reg")) {
            RegistrationServer.main(args);
        } else if (serverName.equals("metrics")) {
            MetricsServer.main(args);
        } else if (serverName.equals("alerts")) {
            AlertsServer.main(args);
        } else {
            System.out.println("Unknown server type: " + serverName);
        }
	}

}
