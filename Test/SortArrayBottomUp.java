import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class SortArrayBottomUp {

    Program programDriver = new Program();

    //fail -  first element is 2 instead -5 because it has 2 in all cells in the array because
    @Test
    public void sortArray(){
        int [] arr = {2, -5, -4, -5, 6};
        int [] sortedArray = {-5, -5, -4, 2, 6};
        assertArrayEquals(sortedArray, programDriver.sortArray(arr));
    }

    @Test
    public void sortArrayEmpty(){
        int [] arr = {};
        assertArrayEquals(arr, programDriver.sortArray(arr));
    }

    @Test
    public void sortArrayNull(){
        int [] arr = null;
        assertArrayEquals(null,programDriver.copyArr(arr));
    }

}
