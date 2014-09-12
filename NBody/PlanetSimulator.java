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
          planet.move();
        }
      }
      drawPlanets();
    }
  }
  
  private void drawPlanets() { 
    StdDraw.show(40);
    StdDraw.picture(0, 0, "starfield.jpg");
    for(Planet planet : planets) { 
      StdDraw.picture(planet.getPoint().getX(), planet.getPoint().getY(), planet.getName());
    }
  }
  
  public static void main(String[] ryan) { 
    PlanetSimulator theSim = new PlanetSimulator();
  }
}