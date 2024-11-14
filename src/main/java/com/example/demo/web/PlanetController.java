package com.example.demo.web;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.domain.Planet;
import com.example.demo.domain.PlanetService;

@RestController
@RequestMapping("/planets")
public class PlanetController {

  @Autowired
  private PlanetService planetService;

  @PostMapping
  public ResponseEntity<Planet> create(@RequestBody Planet entity) {
    Planet planetCreated = planetService.create(entity);
    URI uri = ServletUriComponentsBuilder
        .fromCurrentRequest()
        .path("/{id}")
        .buildAndExpand(planetCreated.getId())
        .toUri();
    return ResponseEntity.created(uri).body(planetCreated);
  }

}
