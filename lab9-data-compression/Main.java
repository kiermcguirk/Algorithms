public class Main {



    public static void main(String[] args)
    {
        //Lab 1
        RussianPeasant lab1 = new RussianPeasant();
        //lab2
        ThreeSumA lab2A = new ThreeSumA();
        ThreeSumB lab2B = new ThreeSumB();
        //Lab 3
        Fibonacci lab3Fib = new Fibonacci();
        towersOfHanoi lab3ToH = new towersOfHanoi();
        //Lab 4 5 6
        Sorting sortLab = new Sorting();
        //Lab 7
        bruteForceSearch lab7 = new bruteForceSearch();
        //lab8
        Trie lab8 = new Trie();
        //Lab9
        RLE lab9 = new RLE();


        lab1.mainCaller();
        lab3Fib.mainCaller();
        lab3ToH.mainCaller();
        sortLab.mainCaller();
        lab7.mainCaller();
        lab8.mainCaller();
        lab9.mainCaller();
    }

}

