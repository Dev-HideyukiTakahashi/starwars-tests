package com.example.demo.common;

import com.example.demo.domain.Planet;

public class PlanetConstants {
  public static final Planet PLANET = new Planet("name", "climate", "terrain");
  public static final Planet INVALID_PLANET = new Planet("", "", "");
}
