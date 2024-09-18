package com.icesi.HEM;
import com.microsoft.applicationinsights.TelemetryClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HemApplication {

	public static void main(String[] args) {


		TelemetryClient telemetryClient = new TelemetryClient();
		telemetryClient.trackEvent("Application started");

		SpringApplication.run(HemApplication.class, args);
	}

}
