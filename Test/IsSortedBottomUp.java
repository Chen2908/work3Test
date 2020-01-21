import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class IsSortedBottomUp {

    Program programDriver = new Program();

    @Test
    public void isSortedSortedArray(){
        int [] arr = {2, 4, 5};
        assertTrue(programDriver.isSorted(arr));
    }

    //fail - logic error
    @Test
    public void isSortedNotSortedArray(){
        int [] arr = {2, 9, 5};
        assertFalse(programDriver.isSorted(arr));
    }

    //fail - logic error
    @Test
    public void isSortedEmpty(){
        int [] arr = {};
        assertTrue(programDriver.isSorted(arr));
    }

    @Test
    public void isSortedNull(){
        int [] arr = null;
        assertTrue(programDriver.isSorted(arr));
    }

    //fail - logic error, it is descanting order and not ascending order
    @Test
    public void isSortedDescSort(){
        int [] arr = {5, 4, 2};
        assertFalse(programDriver.isSorted(arr));
    }

}
