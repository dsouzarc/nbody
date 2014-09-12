import java.io.File;

public class PlanetSimulator { 
  
  /** Written by Ryan D'souza
    * Algorithms and Data Structures N-body assignment
    * http://www.cs.princeton.edu/courses/archive/spring14/cos126/assignments/nbody.html
    * Simulates our solar system
    * Run Instructions: 
    *   1. Compile all files (javac *.java)
    *   2. Run PlanetSimulator (java PlanetSimulator)
    */
  
  //Time variables
  public static final double changeT = 25000.0;
  public static final double T = 157788000.0;
  
  private final int numPlanets;
  private final double universeRadius;
  private final Planet[] planets;
  
  /** Constructor */
  public PlanetSimulator() { 
    
    //Reads info from file
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
    
    //Gets the mass and location of the Sun which is one of the planets
    double sunMass = 0;
    Point sunPoint = null;
    for(Planet planet : planets) { 
      if(planet.getName().contains("sun")) { 
        sunMass = planet.getMass();
        sunPoint = planet.getPoint();
      }
    }
    
    //Goes through all of the planets and sets their sunMass and sunPoint 
    //Values in order to calculate F, the effect of the sun's gravity on the planet's orbit
    for(Planet planet : planets) {
      if(!planet.getName().contains("sun")) { 
        planet.setSunMass(sunMass);
        planet.setSunPoint(sunPoint);
        planet.calculateF();
      }
    }
    
    //Draw the planets the first time
    drawPlanets();
    
    //Start at t = 0, increase by changeT until we've reached max time (T)
    for(double time = 0; changeT <= T; time += changeT) {
      for(Planet planet : planets) { 
        if(!planet.getName().contains("sun")) { 
          planet.move();
        }
      }
      drawPlanets();
    }
  }
  
  /** Draws all of the planets */
  private void drawPlanets() { 
    StdDraw.show(25);
    StdDraw.picture(0, 0, "starfield.jpg");
    for(Planet planet : planets) { 
      StdDraw.picture(planet.getPoint().getX(), planet.getPoint().getY(), planet.getName());
    }
  }
  
  /** Main method to begin simulation */
  public static void main(String[] ryan) { 
    PlanetSimulator theSim = new PlanetSimulator();
  }
}