import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNull;

public class MergeBottomUp {

    Program programDriver = new Program();

    //fail - logic error in copy function
    @Test
    public void merge(){
        int [] arr1 = {2, 4, 1};
        int [] arr2 = {3, 4, 8};
        int [] mergeArr = {1, 2, 3, 4, 4, 8};
        assertArrayEquals(mergeArr, programDriver.merge(arr1, arr2));
    }

    //fail - logic error in copy function
    @Test
    public void mergeOneEmpty(){
        int [] arr1 = {};
        int [] arr2 = {2, 1, 7};
        int [] sort = {1, 2, 7};
        assertArrayEquals(sort, programDriver.merge(arr1, arr2));
    }

    //fail - logic error in copy function
    @Test
    public void mergeOneNull(){
        int [] arr1 = null;
        int [] arr2 = {2, 1, 5};
        int [] sort = {1, 2, 5};
        assertArrayEquals(sort, programDriver.merge(arr1, arr2));
    }

    @Test
    public void mergeTwoNull(){
        int [] arr1 = null;
        int [] arr2 = null;
        assertNull(programDriver.merge(arr1,arr2));
    }

}
