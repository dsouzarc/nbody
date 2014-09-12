public class Point { 
  
  /** Written by Ryan D'souza
    * Represents a Point (double, double)
    * Replaces java.awt.Point whose constructors/main use is ints */
  
  private double xVal;
  private double yVal;
  
  /** Constructor */
  public Point(double xVal, double yVal) { 
    this.xVal = xVal;
    this.yVal = yVal;
  }
  
  /** Returns x value */
  public double getX() { 
    return this.xVal;
  }
  
  /** Returns y value */
  public double getY() { 
    return this.yVal;
  }
  
  /** Set x value */
  public void setX(double newX) { 
    this.xVal = newX;
  }
  
  /** Set y value */
  public void setY(double newY) { 
    this.yVal = newY;
  }
  
  /** Calculate distance between this Point and another Point */
  public double getDistance(final Point otherPoint) { 
    final double insideRadical = Math.abs(Math.pow(this.xVal - otherPoint.getX(), 2) + 
                                          Math.pow(this.yVal - otherPoint.getY(), 2));
    return Math.sqrt(insideRadical);
  }
  
  /** Calculate distance between two Points */
  public static double getDistance(final Point firstPoint, final Point secondPoint) { 
    final double insideRadical = Math.abs(Math.pow(firstPoint.getX() - secondPoint.getX(), 2) + 
                                          Math.pow(firstPoint.getY() - secondPoint.getY(), 2));
    return Math.sqrt(insideRadical);
  }
      
  /** Equals method */
  @Override
  public boolean equals(final Object other) { 
    if(!(other instanceof Point)) { 
      return false;
    }
    final Point otherPoint = (Point) other;
    return otherPoint.getX() == this.getX() && otherPoint.getY() == this.yVal;
  }
  
  /** To string method */
  @Override
  public String toString() { 
    return "X: " + this.xVal + "\tY: " + this.yVal;
  }
}