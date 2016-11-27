package com.company;
import java.util.Random;
/**
 * Created by Zhore on 27.11.2016.
 */
public class Sort {

    public static void swap(int[] a, int i, int j) {
        int x = a[i];
        a[i] = a[j];
        a[j] = x;
    }

    public static int[] qSort(int[] array, int l, int r) {
        if(array == null)
            return null;

        if(array.length < 2)
            return array;

        int v = array[l + rnd.nextInt(r - l + 1)];
        if (r <= l)
            return null;

        int i = l;
        int j = r - 1;
        int p = l - 1;
        int q = r;
        while(true) {
            while (array[i] < v){i++;};
            while (array[j] > v){j--;};

            if (i >= j)
                break;

            swap(array, i, j);

            if (array[i] == v){
                p++;
                swap(array, p, i);
            }

            if (array[j] == v){
                q--;
                swap(array, q, j);
            }
        }
        swap(array, i, r);
        j = i - 1;
        i++;

        for (int k = 0; k <= p; k++, j--)
            swap(array, k, j);

        for (int k = r; k >= q; k--, i++)
            swap(array, k, i);

        qSort(array, 0, j);
        qSort(array, i, r);

        return array;
    }
}
