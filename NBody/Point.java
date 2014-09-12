public class Point { 
  private double xVal;
  private double yVal;
  
  public Point(double xVal, double yVal) { 
    this.xVal = xVal;
    this.yVal = yVal;
  }
  
  public double getX() { 
    return this.xVal;
  }
  
  public double getY() { 
    return this.yVal;
  }
  
  public void setX(double newX) { 
    this.xVal = newX;
  }
  
  public void setY(double newY) { 
    this.yVal = newY;
  }
  
  public double getDistance(final Point otherPoint) { 
    final double insideRadical = Math.abs(Math.pow(this.xVal - otherPoint.getX(), 2) + 
                                          Math.pow(this.yVal - otherPoint.getY(), 2));
    return Math.sqrt(insideRadical);
  }
  
  public static double getDistance(final Point firstPoint, final Point secondPoint) { 
    final double insideRadical = Math.abs(Math.pow(firstPoint.getX() - secondPoint.getX(), 2) + 
                                          Math.pow(firstPoint.getY() - secondPoint.getY(), 2));
    return Math.sqrt(insideRadical);
  }
      
  @Override
  public boolean equals(final Object other) { 
    if(!(other instanceof Point)) { 
      return false;
    }
    final Point otherPoint = (Point) other;
    return otherPoint.getX() == this.getX() && otherPoint.getY() == this.yVal;
  }
  
  @Override
  public String toString() { 
    return "X: " + this.xVal + "\tY: " + this.yVal;
  }
}