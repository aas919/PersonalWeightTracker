package solutions.egen.microservices.alerts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Import;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import solutions.egen.alerts.AlertDAO;
import solutions.egen.db.MorphiaContext;

@SpringBootApplication
@EnableDiscoveryClient
public class AlertsServer {

    public static void main(String[] args) {
        System.setProperty("spring.config.name", "alerts-server");

        SpringApplication.run(AlertsServer.class, args);
    }
}
