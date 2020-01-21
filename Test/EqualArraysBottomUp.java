import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class EqualArraysBottomUp {

    Program programDriver = new Program();


    @Test
    public void equalArraysEqual(){
        int [] arr1 = {6, 4, 5, 9};
        int [] arr2 = {6, 4, 5, 9};
        assertTrue(programDriver.equalArrays(arr1, arr2));
    }

    //fail - it compares just between the first elements.
    @Test
    public void equalArraysNotEqual(){
        int [] arr1 = {6, 4, 5, 9};
        int [] arr2 = {6, 4, 7, 9};
        assertFalse(programDriver.equalArrays(arr1, arr2));
    }

    //fail - it return false instead true. their miss the check of empty array
    @Test
    public void equalArraysEmpty(){
        int [] arr1 = {};
        int [] arr2 = {};
        assertTrue(programDriver.equalArrays(arr1,arr2));
    }


    @Test
    public void equalArraysBothNull(){
        int [] arr1 = null;
        int [] arr2 = null;
        assertTrue(programDriver.equalArrays(arr1,arr2));
    }

    @Test
    public void equalArraysOneNull(){
        int [] arr1 = null;
        int [] arr2 = {2, 4, 8};
        assertFalse(programDriver.equalArrays(arr1, arr2));
    }

    @Test
    public void equalArraysDiffSize(){
        int [] arr1 = {2, 4};
        int [] arr2 = {2, 4, 8};
        assertFalse(programDriver.equalArrays(arr1, arr2));
    }
}
