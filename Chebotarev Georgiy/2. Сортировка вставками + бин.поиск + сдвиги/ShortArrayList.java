package com.company;

import java.util.Arrays;

/**
 * Created by Zhore on 27.11.2016.
 */
public class ShortArrayList <T>{
    private Object array[];
    private int size;
    private int index;

    ShortArrayList(){
        size = 10;
        array = new Object[size];
        index = 0;
    }

    public void add(T element){
        array[index++] = element;

        if(index == size)
            resize();
    }

    public void removeLast(){
        index--;
    }

    public void set(int idex, T value){
        array[idex] = value;
    }

    public T get(int i){
        return (T) array[i];
    }

    public int size(){
        return index;
    }

    private void resize(){
        size = size*3/2;
        Object[] obj = Arrays.copyOf(array, size);
        array = obj;
    }
}

