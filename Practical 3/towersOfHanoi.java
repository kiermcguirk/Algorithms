public class towersOfHanoi {

    static void TowersOfHanoi(int n, char source, char dest, char aux)
    {
        if(n == 1)
        {
            System.out.println("Move disk 1 from rod" + source + "to rod no." + dest);
            return;
        }
        TowersOfHanoi(n-1, source, aux, dest);
        System.out.println("Move disk no." + n + " from rod no." + source + " to rod no." + dest);
        TowersOfHanoi(n-1, aux, dest, source);
    }

    public static void main(String args[]) {
        int n = 4;
        TowersOfHanoi(n, 'A', 'C', 'B');
    }
}
