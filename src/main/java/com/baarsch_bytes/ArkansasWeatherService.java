package com.baarsch_bytes;

public class ArkansasWeatherService {
    private DatabaseConnection db;

    public ArkansasWeatherService() {
        // PROBLEM: The Service is now "Glued" to a real Production Database
        this.db = new ProductionDatabase("jdbc:mysql://localhost:3306/weather");
    }


    public ArkansasWeatherService(DatabaseConnection db) {
        // Dependency is "Injected" via the constructor
        this.db = db;
    }


    public double getTemp(String city) {
        return db.queryTemp(city);
    }


}
