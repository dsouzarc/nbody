public class Planet { 
  
  public static final double G = 6.67 * Math.pow(10, -11);
  public static final double changeT = 25000.0;
  public static final double T = 157788000.0;
  
  private final String planetName;
  private final Point initialVelocity;
  private final Point initialPoint;
  private final double mass;
  
  private double currentPoint;
  private double currentVelocity;
  
  private double F;
  private double r;
  private double sunMass;
  
  public Planet(final Point initialPoint, final initialVelocity, final double mass, final String planetName) {
    this.initialVelocity = initialVelocity;
    this.initialPoint = initialPoint;
    this.mass = mass;
    this.planetName = planetName;
    
    //Cannot make a reference to initial point as it will affect initialpoint values
    this.currentPoint = new Point(initialPoint.getX(), initialPoint.getY());
    this.currentVelocity = new Point(initialVelocity.getX(), initialVelocity.getY());
  }
  
  public void setSunMass(double sunMass) { 
    this.sunMass = sunMass;
  }
  
  public void setF(final Point sunPoint) { 
    this.r = currentPoint.getDistance(sunPoint); //Distance formula from sun center to planet center
    this.F = (G * this.sunMass * this.mass) / Math.pow(r, 2);
  }
  
  public double getF() { 
    return this.F;
  }

  public String getName() { 
    return this.planetName;
  }
  
  public double getMass() { 
    return this.mass;
  }
}