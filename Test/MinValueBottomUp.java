import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MinValueBottomUp {

    Program programDriver = new Program();


    //fail - throw ArrayIndexOutOfBoundsException instead the specific minValue
    @Test
    public void minValue(){
        int [] arr = {-1, 2, 4, 6};
        assertEquals(-1, programDriver.minValue(arr));
    }


    //assume that if the array is empty minValue is -1.
    @Test
    public void minValueEmpty(){
        int [] arr = {};
        assertEquals(-1, programDriver.minValue(arr));

    }

    @Test(expected = NullPointerException.class)
    public void minValueNull(){
        int [] arr = null;
        programDriver.minValue(arr);
    }
}
