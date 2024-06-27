package com.quarkus.cameltest.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import jakarta.enterprise.context.ApplicationScoped;



@ApplicationScoped
public class SqlQueryLoader {

    private Properties sqlQueries = new Properties();

    public SqlQueryLoader() {
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("sql.properties")) {
            if (input == null) {
                throw new RuntimeException("Unable to find sql.properties");
            }
            sqlQueries.load(input);
        } catch (IOException ex) {
            throw new RuntimeException("Failed to load SQL queries", ex);
        }
    }

    public String getQuery(String key) {
        return sqlQueries.getProperty(key);
    }
}