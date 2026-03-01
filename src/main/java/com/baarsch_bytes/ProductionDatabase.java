package com.baarsch_bytes;

public class ProductionDatabase implements DatabaseConnection {

    private String db;

    ProductionDatabase(String dBConnection) {
        this.db = dBConnection;
    }
    @Override
    public double queryTemp(String city) {
        return 0;
    }
}
