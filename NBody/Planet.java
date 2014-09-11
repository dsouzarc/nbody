public class Planet { 
  
  public static final double G = 6.67 * Math.pow(10, -11);
  
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