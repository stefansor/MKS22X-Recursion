import java.util.ArrayList;


public class recursion{
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
    testFib(5);
    testSqrt(4);

  }



  public static boolean closeEnough(double a, double b){
    if(a==0.0 && b==0.0)return true;
    if(a==0.0)return b < 0.00000000001;
    if(b==0.0)return a < 0.00000000001;
    return Math.abs(a-b)/a < 0.0001;//This is the normal % difference allowed

}


//testcase must be a valid index of your input/output array
public static void testFib(int testcase){
  recursion r = new recursion();
  int[] input = {0,1,2,3,5,30};
  int[] output ={0,1,1,2,5,832040};
  int max = input.length;
  if(testcase < input.length){
    int in = input[testcase];
    try{

      int ans = r.fib(in);
      int correct = output[testcase];
      if(ans == correct){
        System.out.println("PASS test fib "+in+". "+correct);
      }
      else{
        System.out.println("FAIL test fib"+in+". "+ans+" vs "+correct);

      }
    }catch(IllegalArgumentException n){
      if(in < 0){
        System.out.println("PASS test fib"+in+" IllegalArgumentException");
      }else{
        System.out.println(" FAIL IllegalArgumentException in test case:"+in);
      }
    }catch(Exception e){
      System.out.println(" FAIL Some exception in test case:"+in);
    }
  }
}


//testcase must be a valid index of your input/output array
public static void testSqrt(int testcase){
  recursion r = new   recursion();
  double[] input = {0.0,1.0, 2.0, 4.0, 7.0};
  double[] output = {0.0,1.0,1.4142135623730951,2.0,2.6457513110645907};
  int max = input.length;
  if(testcase < input.length){
    double in = input[testcase];
    try{

      double ans = r.sqrt(in,.00001);
      double correct = Math.sqrt(in);
      if(closeEnough(ans,correct)){
        System.out.println("PASS test sqrt "+in+" "+ans);
      }
      else{
        System.out.println("FAIL test sqrt "+in+" "+ans+" vs "+correct);

      }
    }catch(IllegalArgumentException n){
      if(in < 0){
        System.out.println("PASS test sqrt"+in+" IllegalArgumentException");
      }else{
        System.out.println(" FAIL IllegalArgumentException in test case:"+in);
      }
    }catch(Exception e){
      System.out.println(" FAIL Some exception in test case:"+in);
    }
  }
}
}
