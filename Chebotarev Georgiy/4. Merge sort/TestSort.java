import com.company.Main;
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

    private static final Main m = new Main();

    private boolean check(int[] arr){
        if(arr.length < 2)
            return true;

        for(int i = 1; i < arr.length; i++)
            if(arr[i - 1] > arr[i])
                return false;

        return true;
    }

    @Test
    /* test, size = 1 */
    public void testSort1(){
        int []arr       = new int[SIZE];

        for(int i = 0; i < arr.length; i++) {
            arr[i] = arr.length - i;
        }

        int [] arr2 = m.sortMerge(arr);
        assertTrue(check(arr2));
    }

    @Test
    /* test, size = 10 */
    public void testSort2(){
        int []arr       = new int[SIZE2];

        for(int i = 0; i < arr.length; i++) {
            arr[i] = arr.length - i;
        }

        int [] arr2 = m.sortMerge(arr);
        assertTrue(check(arr2));
    }

    @Test
    /* test, size = 100 */
    public void testSort3(){
        int []arr       = new int[SIZE3];

        for(int i = 0; i < arr.length; i++) {
            arr[i] = arr.length - i;
        }

        int [] arr2 = m.sortMerge(arr);
        assertTrue(check(arr2));
    }
    @Test
    /* test, array = null */
    public void testSort4(){
        int [] arr2 = m.sortMerge(null);
        assertNull(arr2);
    }
}
