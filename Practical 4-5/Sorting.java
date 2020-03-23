
import java.lang.*;
import java.util.ArrayList;
import java.util.Random;

public class Sorting {
    private Integer[] x = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};

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

    public static void main(String[] args) {
        int[] array = new int[15];
        int[] array2 = new int[15];
        int[] array3 = new int[15];


        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(10);
            array2[i] = random.nextInt(10);
            array3[i] = random.nextInt(10);
        }

        Sorting x = new Sorting();

        print_array(array);
        System.out.println();
        final long startTime1 = System.currentTimeMillis();
        x.selection_sort(array);
        final long elapsedTime1 = System.currentTimeMillis() - startTime1;
        print_array(array);
        System.out.print(" the time taken " + elapsedTime1);

        System.out.println();
        final long startTime2 = System.currentTimeMillis();
        x.insertion_sort(array2);
        final long elapsedTime2 = System.currentTimeMillis() - startTime2;
        print_array(array2);
        System.out.print(" the time taken " + elapsedTime2);
        System.out.println();

        final long startTime = System.currentTimeMillis();
        //x.silly_sort(array3);
        final long elapsedTime = System.currentTimeMillis() - startTime;
        print_array(array3);
        System.out.print(" the time taken " + elapsedTime);

        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(20);
            array2[i] = random.nextInt(20);
            array3[i] = random.nextInt(20);
        }

        ArrayList<Integer> mergesortarray = new ArrayList<>();
        for (int num : array) {
            mergesortarray.add(num);
        }
        System.out.println("Merge Sort");
        System.out.println(x.mergeSort(mergesortarray));
        int[] array4 = new int[20];

        int i = 0;
        for (int num : mergesortarray) {
            array4[i] = num;
            i++;
        }
        print_array(array4);


        System.out.println("Quick sort");
        System.out.println("Array before");
        print_array(array3);
        x.QuickSort(array3,0,array3.length -1);
        //System.out.println("( ͡° ͜ʖ ͡°)");
        print_array(array3);
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
        int mid = N / 2;
        for (int i = 0; i < mid; i++)
        {
            left.add(array.get(i));
        }

        for (int i = mid; i < N; i++)
        {
            right.add(array.get(i));
        }
        if (N == 1)
        {
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


    int partition(int arr[], int low, int high) {
        int pivot = arr[high];
        int i = (low - 1); // index of smaller element
        for (int j = low; j < high; j++) {
            // If current element is smaller than the pivot
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }


    void QuickSort(int arr[], int low, int high)
    {
        if (low < high)
        {
            int pi = partition(arr, low, high);
            QuickSort(arr, low, pi-1);
            QuickSort(arr, pi+1, high);
        }
    }
}
