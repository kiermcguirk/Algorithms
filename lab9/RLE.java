package lab9;

public class RLE {
    public static void printRLE(String in)
    {
        int n = in.length();

        //For each letter in string
        for(int i = 0; i < n; i++)
        {
            //Count occurences
            int counter = 1;
            while(i < n -1  && in.charAt(i) == in.charAt(i + 1))
            {
                counter++;
                i++;
            }

            //print out character and occurences
            System.out.println(in.charAt(i));
            if(counter > 1)
            {
                System.out.println(counter);
            }
        }
    }

    public static void main(String[] args)
    {
        mainCaller();
    }

    public static void mainCaller()
    {
        System.out.println("\n**Practical 9**");
        String in = "aaaabbbbb";
        printRLE(in);
    }

}
