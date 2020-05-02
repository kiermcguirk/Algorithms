package lab3;

public class Fibonacci {

    static int fibonacciIterative(int n){
        if (n<=1){
            return 1;
        }
        int fib = 1;
        int prevFib =  1;
        for (int i = 2; i <= n; i++)
        {
            int temp = fib;
            fib = fib + prevFib;
            prevFib = temp;
        }
        return fib;
    }


    static int fibonacciRecursive(int n)
    {
        if(n >1)
        {
            return fibonacciRecursive(n-1) + fibonacciRecursive(n-2);
        }
        else if(n == 1 || n == 0)
        {
            return 1;
        }
        else
        {
            return 0;
        }
    }

    public static void main (String args[]){
        mainCaller();
    }

    public static void mainCaller()
    {
        System.out.println("**Practical 3 - Fibonacci Sequence**");
        System.out.println("\n-Print fibonacci sequence from 0-9");
        int n = 0;
        for(n = 0; n<10; n++)
        {
            System.out.print(fibonacciIterative(n) + " ");
            System.out.print(fibonacciRecursive(n));
            System.out.println();
        }
    }

}
