package com.fullstack.movies.backend.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class AlphaVantageService {

    @Value("${alpha.vantage.apikey}") // Injecte la clé API depuis application.properties
    private String apiKey;

    public double getCoursDuJour(String symbole) {
        try {
            RestTemplate restTemplate = new RestTemplate();
            String url = "https://www.alphavantage.co/query?function=GLOBAL_QUOTE&symbol=" + symbole + "&apikey=" + apiKey;

            Map<String, Object> response = restTemplate.getForObject(url, Map.class);

            if (response != null && response.containsKey("Global Quote")) {
                Map<String, String> globalQuote = (Map<String, String>) response.get("Global Quote");
                return Double.parseDouble(globalQuote.get("05. price"));
            }
            return generateRandomPrice(); // Retourner un prix aléatoire en cas d'échec
        } catch (Exception e) {
            System.err.println("Erreur lors de l'appel à Alpha Vantage : " + e.getMessage());
            return generateRandomPrice();
        }
    }

    private double generateRandomPrice() {
        return 20 + Math.random() * 180; // Génère un prix aléatoire entre 20 et 200
    }
}
