public class RussianPeasant
{
    public static void main(String[] args)
    {

        mainCaller();

    }
    public static void mainCaller()
    {
        System.out.println("**Practical 1**");
        RussianPeasant x = new RussianPeasant();
        final long startTime = System.currentTimeMillis();
        System.out.println(x.RussianMultiply(1000000000, 100000));
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
