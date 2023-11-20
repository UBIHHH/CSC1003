import java.util.*;
import java.util.Arrays;

public class TestFibonacci {

    static Scanner input = new Scanner(System.in);

    static int fib(int[] list, int n) {
        int f;
        if(n <= 2){
            list[n - 1] = 1;
            return 1;
        }else{
            if(list[n - 1] > 0){
                return list[n - 1];
            }else{
                f = fib(list, n - 1) + fib(list, n - 2);
                list[n - 1] = f;

            }
            return f;
        }
    }

    static void reverse(int[] a) {

        for(int start=0,end=a.length-1;start<end;start++,end--) {
            int temp=a[start];
            a[start]=a[end];
            a[end]=temp;
        }
    }

    // here is the function you need to implement
	public static void parse_line(int n, int d) {
        String rev = "";
        if(d > n){
            rev = "invalid";
        }else{
            int[] fib_list = new int[n];
            fib(fib_list, n);
            reverse(fib_list);
            int[] revfib = Arrays.copyOfRange(fib_list, 0, d);
            for (int i = 0; i < revfib.length; i++) {
                if (i < revfib.length - 1) {
                    rev += revfib[i] + ", ";
                } else {
                    rev += revfib[i];
                }
            }
        }
        System.out.println(rev);

    }

    public static void main(String[] args) throws Exception {
        int line_number = Integer.parseInt(input.nextLine()); 
        for(int i=0; i<line_number; i++) {
            String s = input.nextLine();
            String t[] = s.split(", ");
            int n = Integer.parseInt(t[0]);
            int d = Integer.parseInt(t[1]);
            TestFibonacci.parse_line(n, d);
        }
    }
}