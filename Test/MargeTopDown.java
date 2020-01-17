import org.junit.Before;
import org.junit.Test;
import java.util.Arrays;
import static org.junit.Assert.*;

public class MargeTopDown {

    Program program;
    @Before
    public void setUp(){
        program = new Program();
    }

    //pass
    @Test
    public void originalTwoNull(){
        int [] arr1 = null;
        int [] arr2 = null;
        int [] result = program.merge(arr1, arr2);
        assertNull(result);
    }

    //fails due to logic error - copy copies only the first element
    @Test
    public void originalFirstNull(){
        int [] arr1 = null;
        int [] arr2 = {2,1};
        int [] result = program.merge(arr1, arr2);
        Arrays.sort(arr2);
        assertArrayEquals(result, arr2);
    }


    //fails due to logic error - copy copies only the first element
    @Test
    public void originalTwoNotSorted(){
        int [] arr1 = {7, 5, 3};
        int [] arr2 = {4, 3, 1};
        int [] result = program.merge(arr1, arr2);
        int [] realResult = {1,3,3,4,5,7};
        assertArrayEquals(result, realResult);
    }

    //fails due to logic error - copy copies only the first element
    @Test
    public void originalTwoSorted(){
        int [] arr1 = {1,2};
        int [] arr2 = {3,4};
        int [] result = program.merge(arr1, arr2);
        int [] realResult = {1,2,3,4};
        assertArrayEquals(result, realResult);
    }


    //all stubs
    public int[] mergeAllStubs(int[] ar1, int[] ar2) {
        Stubs.StubSortArray stubSortArray = new Stubs.StubSortArray();
        if (ar1==null && ar2==null) return null;
        if (ar1==null) return stubSortArray.sortArray(ar2);
        if (ar2==null) return stubSortArray.sortArray(ar1);
        int[] res = new int[ar1.length+ar2.length];
        int i = 0;
        for(int j=0; j<ar1.length; j++)
            res[i++] = ar1[j];
        for(int j=0; j<ar2.length; j++)
            res[i++] = ar2[j];
        return stubSortArray.sortArray(res);
    }

    //pass
    @Test
    public void allStubsTwoNull(){
        int [] arr1 = null;
        int [] arr2 = null;
        int [] result = mergeAllStubs(arr1, arr2);
        assertNull(result);
    }

    //pass- corrected copy
    @Test
    public void allStubsFirstNull(){
        int [] arr1 = null;
        int [] arr2 = {2,1};
        int [] result = mergeAllStubs(arr1, arr2);
        Arrays.sort(arr2);
        assertArrayEquals(result, arr2);
    }


    //pass- corrected copy
    @Test
    public void allStubsTwoNotSorted(){
        int [] arr1 = {7, 5, 3};
        int [] arr2 = {4, 3, 1};
        int [] result = mergeAllStubs(arr1, arr2);
        int [] realResult = {1,3,3,4,5,7};
        assertArrayEquals(result, realResult);
    }

    //pass- corrected copy
    @Test
    public void allStubsTwoSorted(){
        int [] arr1 = {1,2};
        int [] arr2 = {3,4};
        int [] result = mergeAllStubs(arr1, arr2);
        int [] realResult = {1,2,3,4};
        assertArrayEquals(result, realResult);
    }


    //sort real but copy and size are stub
    //all stubs
    public int[] mergeRealSortCopySizeStub(int[] ar1, int[] ar2) {
        if (ar1==null && ar2==null) return null;
        if (ar1==null) return sortArrayCopySizeStubs(ar2);
        if (ar2==null) return sortArrayCopySizeStubs(ar1);
        int[] res = new int[ar1.length+ar2.length];
        int i = 0;
        for(int j=0; j<ar1.length; j++)
            res[i++] = ar1[j];
        for(int j=0; j<ar2.length; j++)
            res[i++] = ar2[j];
        return sortArrayCopySizeStubs(res);
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
    public void copyAndSizeStubsTwoNull(){
        int [] arr1 = null;
        int [] arr2 = null;
        int [] result = mergeRealSortCopySizeStub(arr1, arr2);
        assertNull(result);
    }

    //pass
    @Test
    public void copyAndSizeStubsFirstNull(){
        int [] arr1 = null;
        int [] arr2 = {2,1};
        int [] result = mergeRealSortCopySizeStub(arr1, arr2);
        Arrays.sort(arr2);
        assertArrayEquals(result, arr2);
    }

    //pass
    @Test
    public void copyAndSizeStubsTwoNotSorted(){
        int [] arr1 = {7, 5, 3};
        int [] arr2 = {4, 3, 1};
        int [] result = mergeRealSortCopySizeStub(arr1, arr2);
        int [] realResult = {1,3,3,4,5,7};
        assertArrayEquals(result, realResult);
    }


    //pass
    @Test
    public void copyAndSizeStubsTwoSorted(){
        int [] arr1 = {1,2};
        int [] arr2 = {3,4};
        int [] result = mergeRealSortCopySizeStub(arr1, arr2);
        int [] realResult = {1,2,3,4};
        assertArrayEquals(result, realResult);
    }


    //sort real copy real size stub
    public int[] mergeRealSortCopyStub(int[] ar1, int[] ar2) {
        if (ar1==null && ar2==null) return null;
        if (ar1==null) return sortArrayCopyStub(ar2);
        if (ar2==null) return sortArrayCopyStub(ar1);
        int[] res = new int[ar1.length+ar2.length];
        int i = 0;
        for(int j=0; j<ar1.length; j++)
            res[i++] = ar1[j];
        for(int j=0; j<ar2.length; j++)
            res[i++] = ar2[j];
        return sortArrayCopyStub(res);
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


    //pass
    @Test
    public void copyStubTwoNull(){
        int [] arr1 = null;
        int [] arr2 = null;
        int [] result = mergeRealSortCopySizeStub(arr1, arr2);
        assertNull(result);
    }

    //pass
    @Test
    public void copyStubFirstNull(){
        int [] arr1 = null;
        int [] arr2 = {2,1};
        int [] result = mergeRealSortCopyStub(arr1, arr2);
        Arrays.sort(arr2);
        assertArrayEquals(result, arr2);
    }

    //pass
    @Test
    public void copyStubTwoNotSorted(){
        int [] arr1 = {7, 5, 3};
        int [] arr2 = {4, 3, 1};
        int [] result = mergeRealSortCopyStub(arr1, arr2);
        int [] realResult = {1,3,3,4,5,7};
        assertArrayEquals(result, realResult);
    }

    //pass
    @Test
    public void copyStubTwoSorted(){
        int [] arr1 = {1,2};
        int [] arr2 = {3,4};
        int [] result = mergeRealSortCopyStub(arr1, arr2);
        int [] realResult = {1,2,3,4};
        assertArrayEquals(result, realResult);
    }







}
