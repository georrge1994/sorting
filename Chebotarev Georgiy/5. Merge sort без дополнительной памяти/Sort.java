package com.company;
import static java.lang.Math.sqrt;
/**
 * Created by Zhore on 27.11.2016.
 */
public class Sort {

    public static int[] mergeSort(int[] numbers){
        if(numbers == null)
            return null;

        if(numbers.length < 2)
            return numbers;

        // вычисляем длину блоков
        int n = (int) sqrt(numbers.length);
        // длина массива без остатка
        int size = numbers.length - numbers.length % n;
        // индекс буфера (последнего блока)
        int last_block = size - n;

        // поиск конца первого отсортированного участка (1 из 2)
        int end_first_part = findEndFistBlock(size, numbers, n);

        // меняем последний блок 1 части с последним целым блоком.
        // Далее будем использовать его как буфер
        swapBlock(end_first_part, last_block, numbers, n);

        // сортируем блоки
        sortBlocks(0, size - n, numbers, n);

        // Сортировка слиянием всех блоков, окромя буфера
        for(int i = 0; i < n - 1; i++)
            merger(i*n,(i+1)*n,last_block, numbers, n);

        int s = (numbers.length % n + n);   // буфера + остаток
        int S2 =  2*s;
        sortSelect(numbers.length - S2, numbers.length, numbers);

        // вычисляем индексы нового 1 блока и буфера (буфер теперь слева, 1 блок справа)
        end_first_part = numbers.length - S2;            // начало первого блока
        last_block = numbers.length % s;                 // начало последнего блока (буфера)
        n = s;

        // меняем первый блок с буфером местами
        swapBlock(end_first_part, last_block, numbers, n);

        // сортируем блоки ()
        sortBlocks(last_block, size - n, numbers, n);

        // Сортировка слиянием всех блоков, окромя буфера
        for(int i = (int)last_block / s; i > 0; i--){
            System.out.println((i-1)*n+" "+i*n + " " + last_block / s);
            merger((i-1)*n, i*n, last_block, numbers, n);
        }

        // сортировка буфера и остатка
        sortSelect(0, end_first_part + s, numbers);
        return numbers;
    }


    /* сортировка */
    private static void sortSelect(int i, int length, int[] numbers) {
        for (; i < length; i++) {
            int min = numbers[i];
            int imin = i;

            for (int j = i+1; j < length; j++) {
                if (numbers[j] < min) {
                    min = numbers[j];
                    imin = j;
                }
            }

            if (i != imin) {
                int temp = numbers[i];
                numbers[i] = numbers[imin];
                numbers[imin] = temp;
            }
        }
    }

    /** Слияние двух блоков через tmp
     * block - индекс первого блока
     * block2 - индекс второго блока
     * last_block - индекс буфера
     */
    private static void merger(int block, int block2, int last_block, int[] numbers, int n){
        swapBlock(block, last_block, numbers, n);   // меняем первый блок с последним блоком
        int j = block;  // инедкс куда будем писать
        int tmp, cnt1 = n, cnt2 = n;
        for(int i = 0; i < 2 * n; i++){
            if(numbers[block2] <= numbers[last_block] && cnt1 > 0){
                tmp = numbers[j];
                numbers[j] = numbers[block2];
                numbers[block2++] = tmp;
                cnt1--;//подсчитываем, сколько элементов осталось в первом блоке
                if(cnt1 == 0) // защита от выхода за пределы массива
                    block2--;
            }else if(cnt2 > 0){
                tmp = numbers[j];
                numbers[j] = numbers[last_block];
                numbers[last_block++] = tmp;
                cnt2--;// подсчет элементов во втором блоке
                if(cnt2 == 0) // защита от выхода за пределы массива
                    last_block--;
            }
            j++;
        }
    }

    /** Сортировка выбором для сортировки блоков*/
    private static void sortBlocks(int i, int size, int[] numbers, int n) {
        for (; i < size; i = i + n) {
            int min = numbers[i];
            int imin = i;

            for (int j = i + n; j < size; j = j + n) {
                if (numbers[j] <= min) {
                    min = numbers[j];
                    imin = j;
                }
            }

            if (i != imin && numbers[i] != numbers[imin])
                swapBlock(i, imin, numbers, n);
            else if(numbers[imin + n -1] < numbers[i + n - 1])
                swapBlock(i, imin, numbers, n);
        }
    }

    /** меняет блоки местами */
    private static void swapBlock(int end_first_part, int last_part, int[] numbers, int n){
        int tmp;
        for(int i = 0; i < n; i++){
            tmp = numbers[end_first_part];
            numbers[end_first_part] = numbers[last_part];
            numbers[last_part] = tmp;
            end_first_part++;
            last_part++;
        }
    }

    /** поиск конца первого отсортированного участка (1 из 2) */
    private static int findEndFistBlock(int size, int[] numbers, int n){
        int i = 0;
        for(i = 0; i < size - 1; i++){
            if(numbers[i] > numbers[i + 1])
                return i - (i % n);
        }
        return i - (i % n);
    }

}
