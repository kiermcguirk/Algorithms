package lab4;

import java.util.ArrayList;
import java.util.Random;

public class Sorting {
    private Integer[] x = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
    private static Random r = new Random(System.currentTimeMillis());
    private static final int INSERTION_THRESHOLD = 10;
    public static void selection_sort(int[] array) {
        int temp;
        int m_index;

        for (int i = 0; i < array.length - 1; i++) {
            m_index = i;

            for (int j = i + 1; j < array.length; j++) {
                if (array[m_index] > array[j]) {
                    m_index = j;
                }
            }
            temp = array[i];
            array[i] = array[m_index];
            array[m_index] = temp;
        }
    }

    public static void insertion_sort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int val = array[i];
            int j = i;
            while (j > 0 && array[j - 1] > val) {
                array[j] = array[j - 1];
                j--;
            }
            array[j] = val;
        }
    }

    public void varySelection()
    {


        int type = 4;


        ///adjust input size to vary size of arrays
        for (int inputSize = 1; inputSize < 20; inputSize++) {
        //vary total Runs to give you many empirical tests
            System.out.print("inputSize " + inputSize);

            int totalRuns = 1000;
            System.out.println("total runs " + totalRuns);


            long totalruntime = 0;

            for (int run = 0; run < totalRuns; run++) {

                int[] nums = new int[inputSize];

                for (int i = 0; i < nums.length; i++) {
                    nums[i] = r.nextInt(5 * inputSize);
                }


                long time = System.nanoTime();

                switch (type) {
                    case 0:
                        //selectionsort algorithm
                        selection_sort(nums);
                        break;

                    case 1:
                        //insertsort algorithm
                        insertion_sort(nums);
                        break;

                    case 2:
                        //some silly algorithm
                        break;

                    case 3:
                        ArrayList<Integer>arrList = new ArrayList<Integer>();
                        for(int i =0; i< nums.length; i++)
                        {
                            arrList.add(nums[i]);
                        }
                        mergeSort(arrList);
                        break;
                    case 4:
                        //Quick sort algorithm
                        QuickSort(nums,0, nums.length-1);
                        break;
                    default:
                        System.err.printf("\nBad sort ID '%d'", type);
                        System.exit(-2);

                }


                totalruntime += System.nanoTime() - time;

            }
            //printout runtime.
            System.out.println(" total run time " + totalruntime);
        }

    }

    void silly_sort(int[] array) {
        int num_shuffle = 0;
        for (; !isSorted(array); num_shuffle++)
            shuffle(array);

        System.out.println("Number of shuffles: " + num_shuffle);
    }

    void shuffle(int[] array) {

        int i = array.length - 1;
        while (i > 0)
            swap(array, i--, (int) (Math.random() * i));
    }

    void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    boolean isSorted(int[] array) {

        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[i - 1])
                return false;
        }
        return true;
    }

    public static void mainCaller()
    {
        //Sorting sort = new Sorting();
        //sort.varySelection();
        int[] array = new int[10];
        int[] array2 = new int[10];
        int[] array3 = new int[10];

        System.out.println("\n\n**Practical 4,5,6 Sorting**");
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(10);
            array2[i] = random.nextInt(10);
            array3[i] = random.nextInt(10);
        }

        Sorting x = new Sorting();

        System.out.println("**Selection Sort**");
        System.out.print("Before: ");
        print_array(array);
        System.out.println();
        final long startTime1 = System.currentTimeMillis();
        x.selection_sort(array);
        final long elapsedTime1 = System.currentTimeMillis() - startTime1;
        System.out.print("After:  ");
        print_array(array);
        System.out.print(" the time taken " + elapsedTime1);

        System.out.println("\n\n**Insertion Sort**");
        final long startTime2 = System.currentTimeMillis();
        System.out.print("Before: ");
        print_array(array2);
        x.insertion_sort(array2);
        final long elapsedTime2 = System.currentTimeMillis() - startTime2;
        System.out.print("\nAfter:  ");
        print_array(array2);

        System.out.print(" the time taken " + elapsedTime2);
        System.out.println();

        System.out.println("\n\n**Silly Sort (Bogo Sort)**");
        final long startTime = System.currentTimeMillis();
        System.out.print("Before: ");
        print_array(array3);
        System.out.println();
        x.silly_sort(array3);
        System.out.print("After:  ");
        final long elapsedTime = System.currentTimeMillis() - startTime;
        print_array(array3);
        System.out.print(" the time taken " + elapsedTime);


        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(10);
            array2[i] = random.nextInt(10);
            array3[i] = random.nextInt(10);
        }

        System.out.println("\n\n**Merge Sort**");
        System.out.print("Before: ");
        ArrayList<Integer> mergesortarray = new ArrayList<>();
        for (int num : array) {
            System.out.print(num + " ");
            mergesortarray.add(num);
        }
        System.out.println();
        System.out.print("After:  ");
        System.out.print(x.mergeSort(mergesortarray));
        System.out.println();
        int[] array4 = new int[10];
        int i = 0;
        for (int num : mergesortarray) {
            array4[i] = num;
            i++;
        }
        print_array(array4);


        System.out.println("\n\n**Quick Sort**");
        System.out.print("Before: ");
        print_array(array3);
        x.QuickSort(array3,0,array3.length -1);
        //System.out.println("( ͡° ͜ʖ ͡°)");
        System.out.print("\nAfter:  ");
        print_array(array3);
    }
    public static void main(String[] args) {
        mainCaller();
    }

    static void print_array(int[] array) {
        for (int i = 0; i < array.length; i++)
        {
            System.out.print(array[i] + " ");
        }
    }


    public ArrayList<Integer> mergeSort(ArrayList<Integer> array) {
        ArrayList<Integer> left = new ArrayList<>();
        ArrayList<Integer> right = new ArrayList<>();
        ArrayList<Integer> mergeArray = new ArrayList<>();
        int N = array.size();


        if(N <= INSERTION_THRESHOLD)
        {
            int[] arr = array.stream().mapToInt(i -> i).toArray();
            insertion_sort(arr);
            ArrayList<Integer> returnArray = new ArrayList<Integer>();
            for (int i:arr  ) {
                returnArray.add(i);
            }
            return returnArray;
        }
        int mid = N / 2;
        for (int i = 0; i < mid; i++) {
            left.add(array.get(i));
        }

        for (int i = mid; i < N; i++){
            right.add(array.get(i));
        }
        if (N == 1){
            return array;
        }

        left = mergeSort(left);
        right = mergeSort(right);

        mergeArray = merge(left, right);

        return mergeArray;
    }


    private ArrayList<Integer> merge(ArrayList<Integer> a, ArrayList<Integer> b) {
        ArrayList<Integer> S = new ArrayList<>();
        while (a.size() != 0 && b.size() != 0)
        {
            if (a.get(0) <= b.get(0))
            {
                S.add(a.get(0));
                a.remove(0);
            } else if (b.get(0) <= a.get(0))
            {
                S.add(b.get(0));
                b.remove(0);
            }
        }

        if (a.size() > 0)
        {
            for (int x : a) {
                S.add(x);
            }
        }
        else if (b.size() > 0)
        {
            for (int x : b)
            {
                S.add(x);
            }
        }
        return S;
    }


    int partition(int array[], int low, int high) {
        int pivot = array[high];
        int i = (low - 1); // smallest element
        for (int j = low; j < high; j++) {
            // If current element is smaller than the pivot
            if (array[j] < pivot) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        int temp = array[i+1];
        array[i+1] = array[high];
        array[high] = temp;

        return i + 1;
    }


    void QuickSort(int array[], int low, int high)
    {
        if (low< high){
            int part = partition(array, low, high);
            QuickSort(array, low, part-1);
            QuickSort(array, part+1, high);
        }
    }
}
