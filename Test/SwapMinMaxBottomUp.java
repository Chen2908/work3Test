import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class SwapMinMaxBottomUp {

    Program programDriver = new Program();

    //fail - throw ArrayIndexOutOfBoundsException
    @Test
    public void swapMinMax(){
        int [] arr = {1, 3, 8, 5};
        int [] arrSwap = {8, 3, 1, 5};
        assertArrayEquals(arrSwap, programDriver.swapMinMax(arr));
    }

    //fail - throw ArrayIndexOutOfBoundsException
    @Test
    public void swapMinMaxEmpty(){
        int [] arr = {};
        assertArrayEquals(arr, programDriver.swapMinMax(arr));
    }

    @Test (expected = NullPointerException.class)
    public void swapMinMaxNull(){
        int [] arr = null;
        programDriver.swapMinMax(arr);
    }
}
