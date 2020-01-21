import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MaxValueIndexBottomUp {

    Program programDriver = new Program();


    //fail - it returns the specific maxValue and not the index of it
    @Test
    public void maxValueIndex(){
        int [] arr = {-1, -2, -4, 6};
        assertEquals(3, programDriver.maxValueIndex(arr));
    }


    @Test
    public void maxValueIndexEmpty(){
        int [] arr = {};
        assertEquals(-1, programDriver.maxValueIndex(arr));
    }

    @Test(expected = NullPointerException.class)
    public void maxValueIndexNull(){
        int [] arr = null;
        programDriver.maxValueIndex(arr);
    }
}
