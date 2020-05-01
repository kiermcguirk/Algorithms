package lab7;

public class bruteForceSearch {


    private static Object KMPSearch;

    //* STEP 3 Q1: Complexity is O(n squared), due to the nested loop *//
    public static void search(String txt, String pat)
    {
        int M = pat.length();
        int N = txt.length();

        for (int i = 0; i <= N - M; i++) {

            int j;
            for (j = 0; j < M; j++)
            {
                if (txt.charAt(i + j) != pat.charAt(j)) {
                    break;
                }
            }
            if (j == M)
            {
                //System.out.println("Pat found at position " + i);
            }
        }
    }

    public static void mainCaller()
    {
        System.out.println("\n\n**Practical 7**");

        String txt2 = "ABABDABACDABABDABACDABABCABAB";
        String txt3 = "ABABDABACDABABDABACDABABDABACDABABCABAB";
        String txt4 = "ABABDABACDABABDABACDABABDABACDABABDABACDABABCABAB";
        String txt5 = "ABABDABACDABABDABACDABABDABACDABABDABACDABABDABACDABABCABAB";
        String txt1 = "ABABDABACDABABCABAB";
        String pat1 = "ABABCABAB";
        int runs = 1000;
        int totalruntime = 0;
        int num = 1;


        for (int i = 1; i <= 5; i++) {
            long time = System.nanoTime();
            totalruntime += System.nanoTime() - time;

            switch (i) {
                case 1:
                    System.out.println("Txt size: " + txt1.length());
                    for(int run = 0; run < runs; run ++)
                        new KMPSearch().KMPSearch(pat1, txt1);
                    break;
                case 2:
                    System.out.println("Txt size: " + txt2.length());
                    for(int run = 0; run < runs; run ++)
                        new KMPSearch().KMPSearch(pat1, txt1);
                    break;
                case 3:
                    System.out.println("Txt size: " + txt3.length());
                    for(int run = 0; run < runs; run ++)
                        new KMPSearch().KMPSearch(pat1, txt1);
                    break;
                case 4:
                    System.out.println("Txt size: " + txt4.length());
                    for(int run = 0; run < runs; run ++)
                        new KMPSearch().KMPSearch(pat1, txt1);
                    break;
                case 5:
                    System.out.println("Txt size: " + txt5.length());
                    for(int run = 0; run < runs; run ++)
                        new KMPSearch().KMPSearch(pat1, txt1);
                    break;
            }
            System.out.println("total run time: " + totalruntime);
        }


//        search(txt1, pat1);
    }
    public static void main(String[] args)
    {

        mainCaller();

    }

    static class KMPSearch {
        //** Step 3 Q2: Complexity of this search is O(n) **//
        void KMPSearch(String pat, String txt)
        {
            int M = pat.length();
            int N = txt.length();

            // create lps[] that will hold the longest
            // prefix suffix values for pattern
            int lps[] = new int[M];
            int j = 0; // index for pat[]

            // Preprocess the pattern (calculate lps[]
            // array)
            computeLPSArray(pat, M, lps);

            int i= 0;
            while (i< N)
            {
                if (pat.charAt(j) == txt.charAt(i))
                {
                    j++;
                    i++;
                }
                if (j==M)
                {
                    //System.out.println("Pattern found at position " + (i-j));
                    j=lps[j-1];
                }
                else if (i < N && pat.charAt(j) != txt.charAt(i)) {
                    if (j != 0)
                    {
                        j=lps[j-1];
                    }
                    else
                    {
                        i=i+1;
                    }
                }
            }
        }

        void computeLPSArray(String pat, int M, int lps[])
        {
            // length of the previous longest prefix suffix
            int len = 0;
            int i = 1;
            lps[0] = 0; // lps[0] is always 0

            // the loop calculates lps[i] for i = 1 to M-1
            while (i < M) {
                if (pat.charAt(i) == pat.charAt(len)) {
                    len++;
                    lps[i] = len;
                    i++;
                }
                else // (pat[i] != pat[len])
                {
                    // This is tricky. Consider the example.
                    // AAACAAAA and i = 7. The idea is similar
                    // to search step.
                    if (len != 0) {
                        len = lps[len - 1];

                        // Also, note that we do not increment
                        // i here
                    }
                    else // if (len == 0)
                    {
                        lps[i] = len;
                        i++;
                    }
                }
            }
        }
    }
}

