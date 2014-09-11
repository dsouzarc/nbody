public class Planet { 
  
  public static final double G = 6.67 * Math.pow(10, -11);
  public static final double changeT = 25000.0;
  
  private final String planetName;
  private final double initialXVelocity, initialYVelocity;
  private final double initialX, initialY;
  private final double mass;
  
  private double currentX, currentY;
  private double velocityX, velocityY;
  
  private double F;
  private double r;
  private double sunMass;
  
  public Planet(final double initialX, final double initialY, final double initialXVelocity, 
                final double initialYVelocity, final double mass, final String planetName) { 
    this.planetName = planetName;
    this.initialX = initialX;
    this.initialY = initialY;
    this.initialXVelocity = initialXVelocity;
    this.initialYVelocity = initialYVelocity;
    this.mass = mass;
    
    this.currentX = initialX;
    this.currentY = initialY;
    this.velocityX = initialXVelocity;
    this.velocityY = initialYVelocity;
  }
  
  public void setSunMass(double sunMass) { 
    this.sunMass = sunMass;
  }
  
  public void setF(double sunX, double sunY) { 
    this.r = Math.sqrt( Math.pow((sunX - initialX), 2) + Math.pow((sunY - initialY), 2)); //Distance formula from sun center to planet center
    this.F = (G * this.sunMass * this.mass) / Math.pow(r, 2);
  }
  
  public double getFx(final double changeX) { 
    return F * (changeX / r);
  }
  
  public double getFy(final double changeY) { 
    return F * (changeY / r);
  }
  
  public double getAx(final double fX) { 
    return fX / mass;
  }
  
  public double getAy(final double fY) { 
    return fY / mass;
  }
  
  public void calculateNewVelocity(final double vX, final double aX, final double vY, final double aY) { 
    this.velocityX = vX + changeT * aX;
    this.velocityY = vY * changeT * aY;
  }
  
  public void calculateNewPoint() { 
    this.currentX = this.currentX + changeT * this.velocityX;
    this.currentY = this.currentY + changeT * this.velocityY;
  }
  
  public String getName() { 
    return this.planetName;
  }
  
  public double getInitialX() { 
    return this.initialX;
  }
  
  public double getInitialY() { 
    return this.initialY;
  }
  
  public double getMass() { 
    return this.mass;
  }
  
  public double getInitialXVelocity() { 
    return this.initialXVelocity;
  }
  
  public double getInitialYVelocity() { 
    return this.initialYVelocity;
  }
  
  public double getVelocityX() { 
    return this.velocityX;
  }
  
  public double getVelocityY() { 
    return this.velocityY;
  }
  
  public void setVelocityX(double newX) { 
    this.velocityX = newX;
  }
  
  public void setVelocityY(double newY) { 
    this.velocityY = newY;
  }
  
  public void setX(double newX) { 
    this.currentX = newX;
  }
  
  public void setY(double newY) { 
    this.currentY = newY;
  }
  
  public double getX() { 
    return this.currentX;
  }
  
  public double getY() { 
    return this.currentY;
  }
}