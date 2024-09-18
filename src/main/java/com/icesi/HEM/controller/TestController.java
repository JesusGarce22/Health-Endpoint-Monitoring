package com.icesi.HEM.controller;
import com.microsoft.applicationinsights.TelemetryClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class TestController {

    @Autowired
    private TelemetryClient telemetryClient;

    @GetMapping("/health")
    public String healthCheck() {
        // Crear un mapa para propiedades personalizadas
        Map<String, String> properties = new HashMap<>();
        properties.put("status", "operational");
        properties.put("environment", "development");
        properties.put("customProperty1", "value1");
        properties.put("customProperty2", "value2");

        // Enviar un evento de telemetría con propiedades adicionales
        telemetryClient.trackEvent("Health Check: Application is running", properties, null);

        // Devolver una respuesta simple para indicar que la aplicación está operativa
        return "Application is running!";
    }
}
