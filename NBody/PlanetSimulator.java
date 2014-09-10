import java.io.File;

public class PlanetSimulator { 
  
  private final int numPlanets;
  private final double universeRadius;
  private final Planet[] planets;
  
  public PlanetSimulator() { 
    final In fileIn = new In(new File("planets.txt"));
    
    this.numPlanets = fileIn.readInt();
    this.universeRadius = fileIn.readDouble();
    
    this.planets = new Planet[numPlanets];
    
    for(int i = 0; i < this.numPlanets; i++) { 
      final double initialX = fileIn.readDouble();
      final double initialY = fileIn.readDouble();
      final double initialXVel = fileIn.readDouble();
      final double initialYVel = fileIn.readDouble();
      final double mass = fileIn.readDouble();
      final String planetName = fileIn.readString();
      this.planets[i] = new Planet(initialX, initialY, initialXVel, initialYVel, mass, planetName);
    }
    
    double sunMass;
    for(Planet planet : planets) { 
      if(planet.getName().contains("sun")) { 
        sunMass = planet.getMass();
      }
    }
    
    fileIn.close();
    
    drawPlanets();
  }
  
  private void drawPlanets() { 
    StdDraw.setScale(-1 * universeRadius, universeRadius);
    StdDraw.picture(0, 0, "starfield.jpg");
    for(Planet planet : planets) { 
      drawPlanet(planet);
    }
  }
  
  private void drawPlanet(final Planet thePlanet) { 
    StdDraw.picture(thePlanet.getX(), thePlanet.getY(), thePlanet.getName());
  }
  
  public static void main(String[] ryan) { 
    PlanetSimulator theSim = new PlanetSimulator();
  }
}