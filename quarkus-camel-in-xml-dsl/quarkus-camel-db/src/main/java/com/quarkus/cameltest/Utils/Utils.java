package com.quarkus.cameltest.Utils;

import io.quarkus.runtime.annotations.RegisterForReflection;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;
import jakarta.inject.Named;
import org.apache.camel.Exchange;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;


@ApplicationScoped
@Named("utils")
@RegisterForReflection
public class Utils {

    public void successMessage(Exchange ex){
        Map<String, Object> map = new HashMap<>();
        map.put("message", "Message produced successfully");
        map.put("isTrue", false);
        ex.getIn().setBody(map);
    }

    public void contentNotFoundMessage(Exchange ex){
        Map<String, Object> map = new HashMap<>();
        int id = ex.getIn().getHeader("id", Integer.class);
        map.put("statusCode", 204);
        map.put("status", "success");
        map.put("message", "Data not found in database with given id :"+ id);
        ex.getIn().setHeader("Content-Type", "application/json");
        ex.getIn().setBody(map);
    }

    public void failedMessage(Exchange ex){
        Map<String, Object> map = new HashMap<>();
        map.put("message", "Message did not produce successfully");
        map.put("isTrue", false);
        ex.getIn().setBody(map);
    }


    public void internalServerError(Exchange ex){
        Map<String, Object> map = new HashMap<>();
        String exceptionMessage=ex.getProperty("ExpMsg", String.class);
        map.put("statusCode", 500);
        map.put("status", "failure");
        map.put("message", exceptionMessage);
        ex.getIn().setHeader("Content-Type", "application/json");
        ex.getIn().setHeader("CamelHttpResponseCode", 500);
        ex.getIn().setBody(map);
    }
}
