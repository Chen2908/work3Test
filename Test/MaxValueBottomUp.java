import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MaxValueBottomUp {

    Program programDriver = new Program();

    //fail - throw ArrayIndexOutOfBoundsException instead the specific maxValue
    @Test
    public void maxValue(){
        int [] arr = {1, 3, 5, 9};
        assertEquals(9, programDriver.maxValue(arr));
    }

    //assume that if the array is empty maxValue is -1.
    @Test
    public void maxValueEmpty(){
        int [] arr = {};
        assertEquals(-1, programDriver.maxValue(arr));
    }


    @Test(expected = NullPointerException.class)
    public void maxValueNull(){
        int [] arr = null;
        programDriver.maxValue(arr);
    }
}
