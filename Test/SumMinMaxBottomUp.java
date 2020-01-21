import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SumMinMaxBottomUp {

    Program programDriver = new Program();


    //fail - throw ArrayIndexOutOfBoundsException instead the sum of min and max numbers
    @Test
    public void sumMinMax(){
        int [] arr = {1, 3, 5, 7};
        assertEquals(8, programDriver.sumMinMax(arr));
    }


    //fail - throw ArrayIndexOutOfBoundsException instead 0
    @Test
    public void sumMinMaxEmpty(){
        int [] arr = {};
        assertEquals(0, programDriver.sumMinMax(arr));
    }

    @Test (expected = NullPointerException.class)
    public void sumMinMaxNull(){
        int [] arr = null;
        programDriver.sumMinMax(arr);
    }
}
