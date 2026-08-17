package br.pucpr.planet;

public enum PlanetType {
  ROCK("Rochoso"),
  GAS("Gososo"),
  ICE("Gelado"),
  DWARF("Anão");

  private final String description;

  PlanetType(String description) {
    this.description = description;
  }

  @Override
  public String toString() {
    return description;
  }
}

