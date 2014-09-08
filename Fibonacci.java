public class Fibonacci {
  /** Written by Ryan D'souza, with help Andrew Barry 
    * Calculates the FIB_NUMth digit of a Fibonacci sequence
    * No input needed
    * Prints FIB_NUMth digit
    * Run sequence: javac Fibonacci.java
    * java Fibonacci */
  
  //Fibonacci number we are calculating
  private static final int FIB_NUM = 30;
  
  //To hold previous values
  private static final int[] previousValues = new int[FIB_NUM];
  
  //Represents a number whose Fibonacci sequence we have not calculated
  private static final int NOT_CALCULATED = -19;
  
  /** Method on website */
  public static long Fib(long num) {
    if (num == 0) 
      return 0;
    if (num == 1) 
      return 1;
    return Fib(num-1) + Fib(num-2);
  }
  
  /** My way of getting the num digit of a fibonacci sequence 
    * @param fibonacci sequence number to find
    * @return number at the element of fibonacci sequence */
  public static long My_Fib(final int num) { 
    for(int i = 0; i < previousValues.length; i++) { 
      previousValues[i] = NOT_CALCULATED;
    }
    
    return calculateFib(num);
  }
  
  /** @return fibonacci number to calculate */
  private static int calculateFib(final int num) {
    if(num == 0 || num == 1) { 
      return num;
    }
    if(previousValues[num] == NOT_CALCULATED) { 
      return previousValues[num];
    }
    return calculateFib(num - 1) + calculateFib(num - 2);
  }
  
  public static void main(String[] ryan) { 
    
    //Tests how long it takes to print my version of fibonacci sequence 
    final long myStart = System.currentTimeMillis();
    for(int i = 0; i < FIB_NUM; i++) { 
      StdOut.println(i + "\t" + My_Fib(i));
    }
    System.out.println("My version executed in: " + (System.currentTimeMillis() - myStart));
    
    //Tests how long it takes to print website version of fibonacci sequence 
    final long webStart = System.currentTimeMillis();
    for(int i = 0; i < FIB_NUM; i++) { 
      StdOut.println(i + "\t" + Fib(i));
    }
    System.out.println("Website executed in: " + (System.currentTimeMillis() - webStart));
  }
}