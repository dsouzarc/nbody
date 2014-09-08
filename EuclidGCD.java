import java.util.Random;

/** Uses Euclid's algorithm to return
  * the Greatest Common Denominator of two integers */

public class EuclidGCD { 
  
  /** @return gcd of two integers
    * @param p: first integer
    * @param q: second integer */
  public static int gcd(int p, int q) {
    System.out.println("p: " + p + "\tq: " + q);
    if (q == 0) 
      return p;
    int r = p % q;
    return gcd(q, r );
  }
  
  public static void main(String[] ryan) { 
    System.out.println(gcd(1111111, 1234567));
  }
}