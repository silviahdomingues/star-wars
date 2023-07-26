package com.starwars.controller;

import com.starwars.service.PlanetService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

//it is responsible for handling HTTP requests coming from the client.
@RestController
@RequestMapping("/api/v1")
public class PlanetController {
    private final PlanetService planetService;

    public PlanetController(PlanetService planetService) {
        this.planetService = planetService;
    }

    @GetMapping("/planet")
    public ResponseEntity<Map<String, Object>> getPlanetResidents(@RequestParam String search) {
        int residents = planetService.getResidentCount(search);
        Map<String, Object> response = new HashMap<>();
        response.put("planet", search);
        response.put("residents", residents);

        return ResponseEntity.ok(response);
    }
}
