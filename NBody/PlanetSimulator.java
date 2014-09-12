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
      final Point initialPoint = new Point(fileIn.readDouble(), fileIn.readDouble());
      final Point initialVelocity = new Point(fileIn.readDouble(), fileIn.readDouble());
      final double mass = fileIn.readDouble();
      final String planetName = fileIn.readString();
      this.planets[i] = new Planet(initialPoint, initialVelocity, mass, planetName);
    }
    fileIn.close();
    
    StdDraw.setScale(-1 * universeRadius, universeRadius);
    
    double sunMass = 0;
    Point sunPoint = null;
    for(Planet planet : planets) { 
      if(planet.getName().contains("sun")) { 
        sunMass = planet.getMass();
        sunPoint = planet.getPoint();
      }
    }
    
    for(Planet planet : planets) {
      if(!planet.getName().contains("sun")) { 
        planet.setSunMass(sunMass);
        planet.setSunPoint(sunPoint);
        planet.setF(sunPoint);
      }
    }
    
    for(Planet planet : planets) { 
      System.out.println(planet.getF());
    }
    
    drawPlanets();
    
    for(int i = 0; i < 100; i++) {
      for(Planet planet : planets) { 
        if(!planet.getName().contains("sun")) { 
          //planet.calculateNewPoint((Math.abs(sunX - planet.getX())) + 1000000000, (Math.abs(sunY - planet.getY())) + 1000000000);
        }
      }
      drawPlanets();
    }
    
  }
  
  private void drawPlanets() { 
    StdDraw.picture(0, 0, "starfield.jpg");
    for(Planet planet : planets) { 
      drawPlanet(planet);
    }
  }
  
  private void drawPlanet(final Planet thePlanet) { 
    StdDraw.picture(thePlanet.getPoint().getX(), thePlanet.getPoint().getY(), thePlanet.getName());
  }
  
  public static void main(String[] ryan) { 
    PlanetSimulator theSim = new PlanetSimulator();
  }
}