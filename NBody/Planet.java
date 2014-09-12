public class Planet { 
  
  /** Written by Ryan D'souza
    * Represents a Planet */
  
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
  
  /** Constructor */
  public Planet(final Point initialPoint, final Point initialVelocity, final double mass, final String planetName) {
    this.initialVelocity = initialVelocity;
    this.initialPoint = initialPoint;
    this.mass = mass;
    this.planetName = planetName;
    
    //Cannot make a reference to initial point as it will affect initial point values
    this.currentPoint = new Point(initialPoint.getX(), initialPoint.getY());
    this.currentVelocity = new Point(initialVelocity.getX(), initialVelocity.getY());
  }
  
  /** Calculates Force in x direction */
  private double getFx() { 
    return (F * (sunPoint.getX() - this.currentPoint.getX())) / Point.getDistance(currentPoint, sunPoint);
  }
  
  /** Calculates Force in y direction */
  private double getFy() { 
    return (F * (sunPoint.getY() - this.currentPoint.getY())) / Point.getDistance(currentPoint, sunPoint);
  }
  
  /** Calculates acceleration and returns it as a Point */
  private Point getAcceleration() { 
    final double xAccel = getFx() / this.mass;
    final double yAccel = getFy() / this.mass;
    return new Point(xAccel, yAccel);
  }
  
  /** Calculates Velocity and updates global velocity variable */
  private void calculateVelocity() { 
    final Point acceleration = getAcceleration();
    this.currentVelocity.setX(this.currentVelocity.getX() + changeT * acceleration.getX());
    this.currentVelocity.setY(this.currentVelocity.getY() + changeT * acceleration.getY());
  }
  
  /** Calculates new position based off of velocity */
  private void calculatePoint() { 
    calculateVelocity();
    this.currentPoint.setX(this.currentPoint.getX() + changeT * this.currentVelocity.getX());
    this.currentPoint.setY(this.currentPoint.getY() + changeT * this.currentVelocity.getY());
  }
  
  /** Moves the planet by calculating its new position */
  public void move() { 
    calculatePoint();
  }
  
  /** Sets the mass of the sun, used for calculating gravity and force */
  public void setSunMass(double sunMass) { 
    this.sunMass = sunMass;
  }
  
  /** Sets the position of the sun, used for calculating gravity and force */
  public void setSunPoint(final Point sun) { 
    this.sunPoint = sun;
  }
  
  /** Sets the F value which is affects planets orbit */
  public void calculateF() { 
    //Distance formula from sun center to planet center
    this.r = currentPoint.getDistance(this.sunPoint); 
    this.F = (G * this.sunMass * this.mass) / Math.pow(r, 2);
  }
  
  /** Returns F*/
  public double getF() { 
    return this.F;
  }
  
  /** Returns planet name */
  public String getName() { 
    return this.planetName;
  }
  
  /** Returns current Point */
  public Point getPoint() { 
    return this.currentPoint;
  }
  
  /** Returns starting Point */
  public Point getInitialPoint() { 
    return this.initialPoint;
  }
  
  /** Returns current velocity */
  public Point getVelocity() { 
    return this.currentVelocity;
  }
  
  /** Returns initial velocity */
  public Point getInitialVelocity() { 
    return this.initialVelocity;
  }
  
  /** Returns planet's mass */
  public double getMass() { 
    return this.mass;
  }
}