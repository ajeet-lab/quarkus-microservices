package org.demo.controllers;

import io.vertx.core.json.JsonArray;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Response;
import org.demo.service.TvSeriesProxyId;
import org.eclipse.microprofile.faulttolerance.CircuitBreaker;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Retry;
import org.eclipse.microprofile.faulttolerance.Timeout;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.temporal.ChronoUnit;

@Path("/tvseries")
public class TvSeriesController {

    private static final Logger log = LoggerFactory.getLogger(TvSeriesController.class);

    @RestClient
    TvSeriesProxyId proxyId;

    @GET
    @Path("/shows/{id}")
    @Fallback(fallbackMethod = "getTvSeriesDetailByIdFallBack")
    //@Retry(maxRetries = 3)
    @Timeout(1)
    @CircuitBreaker(requestVolumeThreshold = 4, failureRatio = 0.5, delay = 10, delayUnit = ChronoUnit.SECONDS)
    public Response getTvSeriesDetailById(@PathParam("id") int id){
        log.info("getTvSeriesDetailById in invoke !!");
        return Response.ok(proxyId.getTvSeriesById(id)).build();
    }

    public Response getTvSeriesDetailByIdFallBack(@PathParam("id") int id){
        return Response.ok("Service is under maintenance").status(Response.Status.INTERNAL_SERVER_ERROR).build();

    }


    @GET
    @Path("/search/person")
    public JsonArray getTvSeriesByPersonName(@QueryParam("q") String personName){
        return proxyId.getTvSeriesByPersonName(personName);
    }
}
