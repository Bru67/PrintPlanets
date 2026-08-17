package br.pucpr.planet;

import br.pucpr.user.Theme;
import java.util.ArrayList;

public class PlanetasPrinter {
  public void print(ArrayList<Planet> planets, boolean alignRight, Theme theme) {
    if (planets == null || planets.isEmpty()) {
      System.out.println("ERRO: Lista de planetas vazia ou nula.");
      return;
    }
    final var borderChar = theme.getBorderChar();

    // Borda superior e cabeçalho
    final var BORDER_WIDTH = 83;
    var sb = new StringBuilder();
    sb.repeat(borderChar, BORDER_WIDTH).append("\n");
    sb.append(String.format("| %-10s | %-11s | %-18s | %-14s | %-14s | %n", "NOME", "DIÂMETRO", "DIST. SOL (km)", "DIST. SOL (ua)", "TIPO"));
    sb.repeat(borderChar, BORDER_WIDTH).append("\n");
    for (var planet : planets) {
      if (planet == null) {
        continue;
      }
      sb.append(
              String.format(
                      "| %-10s | %-11s | %-18s | %-14s | %-14s | %n",
                      formatName(planet),
                      validateAndFormatDiameter(planet.diameterKm()),
                      validateAndFormatSunDistanceKm(planet.sunDistanceKm()),
                      validateAndFormatSunDistanceUa(planet.sunDistanceUa()),
                      validateType(planet.type())));
    }
    // Borda inferior
    sb.repeat(borderChar, BORDER_WIDTH).append("\n");

    // Espaçamento
    if (alignRight) {
      var lines = sb.toString().split("\n");
      for (var line : lines) {
        System.out.println("            " + line);
      }
    } else {
      System.out.print(sb);
    }
  }

  // Validadores e formatadores
  private static String formatName(Planet planet) {
    var name = planet.name();
    if (name == null || name.isEmpty()) {
      return "NÃO INFORMADO";
    }
    if (name.length() > 20) {
      name = name.substring(0, 17) + "...";
    }
    return name;
  }

  public static String validateAndFormatDiameter(double diameter) {
    if (diameter > 0) {
      return String.format("%,.1f", diameter);
    } else {
      return "Inválido";
    }
  }

  public static String validateAndFormatSunDistanceKm(long distanceKm) {
    if (distanceKm > 0) {
      return String.format("%,d", distanceKm);
    } else {
      return "Inválido";
    }
  }

  public static String validateAndFormatSunDistanceUa(double distanceUa) {
    if (distanceUa > 0) {
      return String.format("%,.2f", distanceUa);
    } else {
      return "Inválido";
    }
  }

  public static String validateType(PlanetType type) {
    if (type != null) {
      return type.toString();
    } else {
      return "Inválido";
    }
  }

  }





