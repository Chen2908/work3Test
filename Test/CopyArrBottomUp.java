import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class CopyArrBottomUp {

    Program programDriver = new Program();



    //fail - it copies the first element from arr to all cells
    @Test
    public void copyArr(){
        int [] arr = {1, 2, 4, 7};
        assertArrayEquals(arr, programDriver.copyArr(arr));
    }

    @Test
    public void copyArrEmpty(){
        int [] arr = {};
        assertArrayEquals(arr, programDriver.copyArr(arr));
    }

    @Test
    public void copyArrNull(){
        int [] arr = null;
        assertArrayEquals(null,programDriver.copyArr(arr));
    }
}
