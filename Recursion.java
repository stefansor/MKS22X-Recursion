
public class Recursion{
  public static double sqrt(double n, double tolerance){
    return sqrtHelp(n, n/2, tolerance);
  }


  public static double sqrtHelp(double n, double g, double tol){
    if(n == 0 || n == 1){
      return n;
    }
    if(Math.abs(g * g - n) < n * tol){
      return g;
    }
    else{
      return sqrtHelp(n, ( n / g + g) / 2, tol);
    }
  }

  public static void main(String args[]){
    System.out.println(sqrt(1, 0.01));
    System.out.println(sqrt(0, 0.01));
    System.out.println(sqrt(2, 0.01));
    System.out.println(sqrt(100, 0.01));
  }
}
