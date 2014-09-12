public class Planet { 
  
  public static final double G = 6.67 * Math.pow(10, -11);
  public static final double changeT = 25000.0;
  public static final double T = 157788000.0;
  
  private final String planetName;
  private final Point initialVelocity;
  private final Point initialPoint;
  private final double mass;
  
  private Point currentPoint;
  private Point currentVelocity;
  private Point sunPoint;
  
  private double F;
  private double r;
  private double sunMass;
  
  public Planet(final Point initialPoint, final Point initialVelocity, final double mass, final String planetName) {
    this.initialVelocity = initialVelocity;
    this.initialPoint = initialPoint;
    this.mass = mass;
    this.planetName = planetName;
    
    //Cannot make a reference to initial point as it will affect initial point values
    this.currentPoint = new Point(initialPoint.getX(), initialPoint.getY());
    this.currentVelocity = new Point(initialVelocity.getX(), initialVelocity.getY());
  }
  
  public void setSunPoint(final Point sun) { 
    this.sunPoint = sun;
  }
  
  private double getFx() { 
    return (F * (Math.abs(this.currentPoint.getX() - sunPoint.getX()))) / Point.getDistance(currentPoint, sunPoint);
  }
  
  private double getFy() { 
    return (F * (Math.abs(this.currentPoint.getY() - sunPoint.getY()))) / Point.getDistance(currentPoint, sunPoint);
  }
  
  private Point getAcceleration() { 
    final double xAccel = getFx() / this.mass;
    final double yAccel = getFy() / this.mass;
    return new Point(xAccel, yAccel);
  }
  
  private void calculateVelocity() { 
    final Point acceleration = getAcceleration();
    this.currentVelocity.setX(this.currentVelocity.getX() + changeT * acceleration.getX());
    this.currentVelocity.setY(this.currentVelocity.getY() + changeT * acceleration.getY());
  }
  
  public void planetMove() { 
    
    
  }
  
  public void setSunMass(double sunMass) { 
    this.sunMass = sunMass;
  }
  
  public void setF(final Point sunPoint) { 
    //Distance formula from sun center to planet center
    this.r = currentPoint.getDistance(sunPoint); 
    
    this.F = (G * this.sunMass * this.mass) / Math.pow(r, 2);
  }
  
  public double getF() { 
    return this.F;
  }

  public String getName() { 
    return this.planetName;
  }
  
  public Point getPoint() { 
    return this.currentPoint;
  }
  
  public Point getInitialPoint() { 
    return this.initialPoint;
  }
  
  public Point getVelocity() { 
    return this.currentVelocity;
  }
  
  public Point getInitialVelocity() { 
    return this.initialVelocity;
  }
  
  public double getMass() { 
    return this.mass;
  }
}