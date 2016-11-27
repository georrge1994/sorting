package com.company;

import java.util.Random;

/**
 * Created by Zhore on 27.11.2016.
 */
public class Sort {

    public static int  partition(int[] a, int left, int right, int pivot) {
        if (left > right) return right;
        int i = left, j = right, x = a[pivot];
        swap(a, j--, pivot); //Поменяли с крайним
        while (i <= j) {
            while (i <= j && a[i] < x) i++;
            while (i <= j && a[j] > x) j--;
            if (i >= j) break;
            swap(a, i++, j--);
        }
        swap(a, i, right); //Вернули на место
        return i;
    }

    public static void swap(int[] a, int i, int j) {
        int x = a[i];
        a[i] = a[j];
        a[j] = x;
    }

    public static int kthElement(int[] a, int k) {
        if(a == null)
            return -1;
        int left = 0, right = a.length - 1;
        while (right > left) {
            Random random = new Random();
            int pivotIdx = left + random.nextInt(right - left + 1);
            int idx = partition(a, left, right, pivotIdx);
            if (k < idx) right = idx - 1;
            else if (k > idx) left = idx + 1;
            else return a[k];
        }
        return a[0];
    }

}
