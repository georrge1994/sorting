import com.company.Main;
import com.company.Sort;
import org.junit.Test;

import static junit.framework.TestCase.assertNull;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Zhore on 20.11.2016.
 */
public class TestSort {

    private static final int SIZE = 1;
    private static final int SIZE2 = 10;
    private static final int SIZE3 = 100;

    private int[] create(int[] numbers){

        int count = 1;

        for (int c = 0; c < numbers.length/2; c++) {
            numbers[c] = count++;
            numbers[c + numbers.length/2] = count++;
        }
        return numbers;
    }


    private boolean check(int[] arr){
        if(arr.length < 2)
            return true;

        for(int i = 1; i < arr.length; i++)
            if(arr[i - 1] > arr[i]) {
                return false;
            }
        return true;
    }

    @Test
    /* test, size = 1 */
    public void testSort1(){
        int []numbers       = new int[SIZE];
        numbers = create(numbers);
        int [] arr2 = Sort.mergeSort(numbers);
        assertTrue(check(arr2));
    }

    @Test
    /* test, size = 10 */
    public void testSort2(){
        int []numbers       = new int[SIZE2];
        numbers = create(numbers);
        int [] arr2 = Sort.mergeSort(numbers);
        assertTrue(check(arr2));
    }

    @Test
    /* test, size = 100 */
    public void testSort3(){
        int []numbers       = new int[SIZE3];
        numbers = create(numbers);
        int [] arr2 = Sort.mergeSort(numbers);
        assertTrue(check(arr2));
    }

    @Test
    /* test, array = null */
    public void testSort4(){
        int [] arr2 = Sort.mergeSort(null);
        assertNull(arr2);
    }
}
