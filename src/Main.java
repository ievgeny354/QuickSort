import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int k = 0;

    public static void main(String[] args) throws FileNotFoundException {
        int[] arr = readArrayFromTxt("array6.txt");
        System.out.println(Arrays.toString(arr));
        //bubbleSort(arr);
        //mergeSort(arr);
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
        System.out.println(k);
    }

    private static int[] readArrayFromTxt(String fileName) throws FileNotFoundException {
        Scanner scan = new Scanner(new File(fileName));
        int n = scan.nextInt();
        int[] mas = new int[n];
        for (int i = 0; i < mas.length; i++) {
            mas[i] = scan.nextInt();
        }
        return mas;
    }

    private static void quickSort(int[] mas, int start, int finish) {
        if (start >= finish) {
            return;
        }
        int p = partition(mas, start, finish);
        quickSort(mas, start, p - 1);
        quickSort(mas, p + 1, finish);
    }

    private static int partition(int[] mas, int start, int finish) {
        int pivot = mas[((finish - start) / 2 + start)];
        int i = start;  //слева
        int j = finish;  //справа
        int tmp;

        while (true) {                 //loop forever

            while (i <= finish && mas[i] < pivot) {
                i++;
                k++;
            }
            k++;
            while (i >= start && mas[j] > pivot) {
                j--;
                k++;
            }
            if (i < j) {
                if (mas[i] == mas[j])
                    i++;
                else {
                    tmp = mas[i];
                    mas[i] = mas[j];
                    mas[j] = tmp;
                }
            } else
                return j;
            return 0;
        }
    }
}
