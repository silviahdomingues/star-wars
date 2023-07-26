package com.starwars.model;
import java.util.List;

//it represents the response from the SWAPI API
public class SwapiResponse {
    private List<Planet> results;

    public List<Planet> getResults(){
        return results;
    }

    public void setResults(List<Planet> results){
        this.results = results;
    }
}
