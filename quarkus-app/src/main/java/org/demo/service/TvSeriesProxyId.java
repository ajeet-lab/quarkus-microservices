package org.demo.service;


import io.vertx.core.json.JsonArray;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.QueryParam;
import org.demo.entities.TvSeries;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;


@RegisterRestClient(baseUri = "https://api.tvmaze.com")
public interface TvSeriesProxyId {

    //https://api.tvmaze.com/search/people?q=lauren

    @GET
    @Path("/shows/{id}")
    public TvSeries getTvSeriesById(@PathParam("id") int id);

    @GET
    @Path("/search/people")
    public JsonArray getTvSeriesByPersonName(@QueryParam("q")  String personName);
}
