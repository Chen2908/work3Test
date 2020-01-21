import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MinValueIndexBottomUp {

    Program programDriver = new Program();

    //fail - it returns the specific minValue and not the index of it
    @Test
    public void minValueIndex(){
        int [] arr = {1, 2, -4, 6};
        assertEquals(2, programDriver.minValueIndex(arr));
    }


    //fail - throw ArrayIndexOutOfBoundsException instead return -1
    @Test
    public void minValueIndexEmpty(){
        int [] arr = {};
        assertEquals(-1, programDriver.minValueIndex(arr));

    }

    //fail - return -1 instead throw ArrayIndexOutOfBoundsException
    @Test (expected = ArrayIndexOutOfBoundsException.class)
    public void minValueIndexNull(){
        int [] arr = null;
        programDriver.minValueIndex(arr);
    }


}
