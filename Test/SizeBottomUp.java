import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SizeBottomUp {

    Program programDriver = new Program();

    @Test
    public void sizeThree(){
        int [] arr = {1, 2, 3};
        assertEquals(3,programDriver.size(arr));
    }

    @Test
    public void sizeZero (){
        int [] arr = {};
        assertEquals(0, programDriver.size(arr));
    }

    @Test(expected=NullPointerException.class)
    public void sizeNull(){
        int [] arr = null;
        programDriver.size(arr);
    }
}
