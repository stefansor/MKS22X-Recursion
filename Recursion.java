import java.util.ArrayList;


public class Recursion{
  public static double sqrt(double n, double tolerance){
    return sqrtHelp(n, n/2, tolerance);
  }


  private static double sqrtHelp(double n, double g, double tol){
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



  public static int fib(int num){
    if(num == 0){
      return 0;
    }
    if(num == 2 || num == 1){
      return 1;
    }
    else{
      return fibHelp(num, 1, 0);
    }
  }
  private static int fibHelp(int num, int partial, int end){
    if(num == 0){
      return end;
    }
    else{
      return fibHelp(num - 1, partial + end, partial );
    }
  }
  public static ArrayList<Integer> makeAllSums(int n){
    ArrayList<Integer> sums = new ArrayList<Integer>();
    return makeAllSumsHelp(n, n, 0, sums);
  }

  private static ArrayList<Integer> makeAllSumsHelp(int n, int start, int sum, ArrayList<Integer> data){
    if(start == 0){
      data.add(sum);
    }
    else{
      makeAllSumsHelp(n, start - 1, sum + start, data);
      makeAllSumsHelp(n, start - 1, sum, data);
    }
    return data;
  }


  public String toString(ArrayList<Integer> data){
      String str = "[";
      for(int i = 0; i < data.size(); i++){
        if(i == data.size() - 1){
          str = str + data.get(i) + "]";
        }
        else{
          str = str + data.get(i) + ", ";
        }
      }
      return str;
  }


  public static void main(String args[]){
    System.out.println(sqrt(1, 0.01));
    System.out.println(sqrt(0, 0.01));
    System.out.println(sqrt(2, 0.01));
    System.out.println(sqrt(100, 0.01));
    //used codingbat to test fib tail recursion//
    System.out.println(makeAllSums(3));

  }
}
