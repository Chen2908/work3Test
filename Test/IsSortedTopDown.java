import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class IsSortedTopDown {

    Program program;
    @Before
    public void setUp()
    {
        program = new Program();
    }

    //pass
    @Test
    public void originalNullArray(){
        int[] arr = null;
        boolean res = program.isSorted(arr);
        assertTrue(res);

    }

    //fail - the function need return true becouse empty array aer equal
    @Test
    public void originalEmptyArray(){
         int[] arr = {};
         boolean res = program.isSorted(arr);
         assertTrue(res);
    }

    //pass
    @Test
    public void originalSortedArray(){
        int[] arr = {1 ,2 ,3,4};
        boolean res = program.isSorted(arr);
        assertTrue(res);
    }

    //fail - due to logic error - copy first element
    @Test
    public void originalUnsortedArray(){
        int[] arr = {2 ,1 ,4,3};
        boolean res = program.isSorted(arr);
        assertFalse(res);
    }

    //test with stubs
    public boolean isSortedWithStubs(int[] arr) {
        Stubs.StubSortArray stubSortArray = new Stubs.StubSortArray();
        Stubs.StubEqualArrays stubEqualArrays = new Stubs.StubEqualArrays();

        int[] sorted = stubSortArray.sortArray(arr);
        return stubEqualArrays.equalArrays(arr, sorted);
    }

    //pass
    @Test
    public void testWithStubsNullArray(){
        int[] arr = null;
        boolean res = isSortedWithStubs(arr);
        assertTrue(res);

    }

    //pass
    @Test
    public void testWithStubsEmptyArray(){
        int[] arr = {};
        boolean res =isSortedWithStubs(arr);
        assertTrue(res);
    }

    //pass
    @Test
    public void testWithStubsSortedArray(){
        int[] arr = {1 ,2 ,3,4};
        boolean res = isSortedWithStubs(arr);
        assertTrue(res);
    }

    //pass
    @Test
    public void testWithStubsUnsortedArray(){
        int[] arr = {2 ,1 ,4,3};
        boolean res = isSortedWithStubs(arr);
        assertFalse(res);
    }
}
