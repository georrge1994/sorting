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
        for (int c = 0; c < numbers.length; c++) {
            numbers[c] = numbers.length - c;
        }
        return numbers;
    }

    @Test
    /* test, size = 1 */
    public void testSort1(){
        int []numbers       = new int[SIZE];
        numbers = create(numbers);
        int elem = Sort.kthElement(numbers, numbers.length/2);
        assertTrue(elem == numbers[numbers.length/2]);
    }

    @Test
    /* test, size = 10 */
    public void testSort2(){
        int []numbers       = new int[SIZE2];
        numbers = create(numbers);
        int elem = Sort.kthElement(numbers, numbers.length/2);
        assertTrue(elem == numbers[numbers.length/2]);
    }

    @Test
    /* test, size = 100 */
    public void testSort3(){
        int []numbers       = new int[SIZE3];
        numbers = create(numbers);
        int elem = Sort.kthElement(numbers, numbers.length/2);
        assertTrue(elem == numbers[numbers.length/2]);
    }

    @Test
    /* test, array = null */
    public void testSort4(){
        int elem = Sort.kthElement(null, 0);
        assertTrue(elem == -1);
    }
}
