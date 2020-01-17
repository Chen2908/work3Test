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

    //test with one origin and other stub

    public boolean isSortedWithOneOrigin(int[] arr) {
        Stubs.StubSortArray stubSortArray = new Stubs.StubSortArray();

        int[] sorted = stubSortArray.sortArray(arr);
        return equalArraysWithStubs(arr, sorted);
    }

    public boolean equalArraysWithStubs(int[] arr1, int[] arr2) {
        Stubs.StubSize stubSize = new Stubs.StubSize();

        if (arr1==null && arr2 == null) return true;
        if (arr1==null || arr2 == null) return false;
        if (stubSize.size(arr1)!=stubSize.size(arr2)) return false;
        for (int i=0; i<stubSize.size(arr1); i++)
            if (arr1[i]==arr2[i]) return true;
        return false;
    }

    //pass
    @Test
    public void testWithOneOriginNullArray(){
        int[] arr = null;
        boolean res = isSortedWithOneOrigin(arr);
        assertTrue(res);

    }

    //fail - the logic not correct
    @Test
    public void testWithOneOriginEmptyArray(){
        int[] arr = {};
        boolean res =isSortedWithOneOrigin(arr);
        assertTrue(res);
    }

    //pass
    @Test
    public void testWithOneOriginSortedArray(){
        int[] arr = {1 ,2 ,3,4};
        boolean res = isSortedWithOneOrigin(arr);
        assertTrue(res);
    }

    //pass
    @Test
    public void testWithOneOriginUnsortedArray(){
        int[] arr = {2 ,1 ,4,3};
        boolean res = isSortedWithOneOrigin(arr);
        assertFalse(res);
    }

    //test with two origin and level under is stubs

    public boolean isSortedWithTwoOrigin(int[] arr) {

        int[] sorted = sortArrayCopySizeStubs(arr);
        return equalArraysWithStubs(arr, sorted);
    }

    private int[] sortArrayCopySizeStubs(int[] arr) {
        Stubs.StubCopyArr stubCopy = new Stubs.StubCopyArr();
        Stubs.StubSize stubSize = new Stubs.StubSize();
        if (arr == null)
            return null;
        int[] res = stubCopy.copyArr(arr);
        for(int i=0; i<stubSize.size(arr); i++)
            for (int j=0; j<stubSize.size(arr)-i-1; j++)
                if (res[j]>res[j+1]) {
                    int temp = res[j];
                    res[j] = res[j+1];
                    res[j+1] = temp;
                }
        return res;
    }

    //pass
    @Test
    public void testWithTwoOriginNullArray(){
        int[] arr = null;
        boolean res = isSortedWithTwoOrigin(arr);
        assertTrue(res);

    }

    //fail - the logic not correct
    @Test
    public void testWithTwoOriginEmptyArray(){
        int[] arr = {};
        boolean res =isSortedWithTwoOrigin(arr);
        assertTrue(res);
    }

    //pass
    @Test
    public void testWithTwoOriginSortedArray(){
        int[] arr = {1 ,2 ,3,4};
        boolean res = isSortedWithTwoOrigin(arr);
        assertTrue(res);
    }

    //pass
    @Test
    public void testWithTwoOriginUnsortedArray(){
        int[] arr = {2 ,1 ,4,3};
        boolean res = isSortedWithTwoOrigin(arr);
        assertFalse(res);
    }

    //size real copy stub

    private int[] sortArrayCopyStub(int[] arr) {
        Stubs.StubCopyArr stubCopy = new Stubs.StubCopyArr();
        if (arr == null)
            return null;
        int[] res = stubCopy.copyArr(arr);
        for(int i=0; i<program.size(arr); i++)
            for (int j=0; j<program.size(arr)-i-1; j++)
                if (res[j]>res[j+1]) {
                    int temp = res[j];
                    res[j] = res[j+1];
                    res[j+1] = temp;
                }
        return res;
    }

    public boolean isSortedWithSizeOrigin(int[] arr) {

        int[] sorted = sortArrayCopyStub(arr);
        return program.equalArrays(arr, sorted);
    }

    //pass
    @Test
    public void testWithSizeOriginNullArray(){
        int[] arr = null;
        boolean res = isSortedWithSizeOrigin(arr);
        assertTrue(res);

    }

    //fail - the logic not correct empty equal return false
    @Test
    public void testWithSizeOriginEmptyArray(){
        int[] arr = {};
        boolean res =isSortedWithSizeOrigin(arr);
        assertTrue(res);
    }

    //pass
    @Test
    public void testWithSizeOriginSortedArray(){
        int[] arr = {1 ,2 ,3,4};
        boolean res = isSortedWithSizeOrigin(arr);
        assertTrue(res);
    }

    //pass
    @Test
    public void testWithSizeOriginUnsortedArray(){
        int[] arr = {2 ,1 ,4,3};
        boolean res = isSortedWithSizeOrigin(arr);
        assertFalse(res);
    }

}
