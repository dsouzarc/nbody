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
  
  @Override
  public String toString() { 
    return "X: " + this.xVal + "\tY: " + this.yVal;
  }
}