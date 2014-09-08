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
  private static final long[] previousValues = new long[FIB_NUM];
  
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
    if(num < 2) { 
      return num;
    }
    
    //Check to see if its calculated
    if(previousValues[num] != 0) { 
      return previousValues[num];
    }
    
    else { 
      previousValues[num] = My_Fib(num - 1) + My_Fib(num-2);
    }
    return previousValues[num];
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