package solutions.egen.microservices.metrics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Import;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import solutions.egen.metrics.MetricDAO;
import solutions.egen.db.MorphiaContext;

@EnableAutoConfiguration
@EnableDiscoveryClient
public class MetricsServer {

    public static void main(String[] args) {
        System.setProperty("spring.config.name", "metrics-server");

        SpringApplication.run(MetricsServer.class, args);
    }
}
