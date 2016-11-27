package com.company;
import com.company.ShortArrayList;
/**
 * Created by Zhore on 27.11.2016.
 */
public class Sort {
    private static ShortArrayList<Integer> list = new ShortArrayList();

    public static int[] heapSort(int[] array){
        if(array == null)
            return null;

        buildHeap(array);
        for (int i = array.length - 1; i >= 0; i--){
            array[i] = getMax();
            heapify(0);
        }
        return array;
    }

    private static int getMax(){
        int result = list.get(0);
        list.set(0, list.get(list.size() - 1));
        list.removeLast();
        return result;
    }

    private static void buildHeap(int[] array){
        for(int i = 0; i < array.length; i++)
            list.add(array[i]);

        for (int i = list.size() / 2; i >= 0; i--)
            heapify(i);
    }

    private static void heapify(int i){
        int leftChild;
        int rightChild;
        int largestChild;

        for (; ; ){
            leftChild = 2 * i + 1;
            rightChild = 2 * i + 2;
            largestChild = i;

            if (leftChild < list.size() && list.get(leftChild) > list.get(largestChild))
                largestChild = leftChild;

            if (rightChild < list.size() && list.get(rightChild) > list.get(largestChild))
                largestChild = rightChild;

            if (largestChild == i)
                break;

            int temp = list.get(i);
            list.set(i,list.get(largestChild));
            list.set(largestChild,temp);
            i = largestChild;
        }
    }

}
