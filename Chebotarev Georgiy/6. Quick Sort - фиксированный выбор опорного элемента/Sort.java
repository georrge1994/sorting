package com.company;

/**
 * Created by Zhore on 27.11.2016.
 */
public class Sort {

    public static int[] qSort(int[] array, int l, int r) {
        if (array == null)
            return null;

        if(array.length < 2)
            return array;

        int i = l;
        int j = r;
        int x = array[(l + r) / 2];
        while (i <= j) {
            while (array[i] < x) {
                i++;
            }
            while (array[j] > x) {
                j--;
            }
            if (i <= j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }
        if (l<j){
            qSort(array, l, j);
        }
        if(i<r){
            qSort(array, i, r);
        }
        return array;
    }
}
