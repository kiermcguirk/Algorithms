import java.lang.*;

public class RussianPeasant
{
    public static void main(String[] args)
    {
        RussianPeasant x = new RussianPeasant();
        final long startTime = System.currentTimeMillis();
        System.out.println(x.RussianMultiply(4000, 100000000));
        final long elapsedTime = System.currentTimeMillis() - startTime;
        System.out.println("the time taken " + elapsedTime);


    }

    public int RussianMultiply(int n, int m)
    {
        int accumulator = 0;
        while(n != 0)
        {
            if((n % 2) != 0)
            {
                accumulator += m;
            }
            n /= 2;
            m *= 2;
        }
        return accumulator;
    }

}
