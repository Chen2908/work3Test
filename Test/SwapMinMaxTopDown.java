import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.*;

public class SwapMinMaxTopDown {

    public Program program;

    @Before
    public void setUp() {
        program = new Program();
    }


    //check original
    //pass
    @Test
    public void originalNullArray() {
        Exception exception = null;
        int[] arr = null;
        try {
            int[] result = program.swapMinMax(arr);
        } catch (Exception e) {
            exception = e;
        }
        assertEquals(NullPointerException.class, exception.getClass());
    }

    //fail - out of bound
    @Test
    public void originalMinMaxArray() {
        int[] arr = {1, 2};
        int[] expected = {2, 1};
        int[] result = program.swapMinMax(arr);
        assertArrayEquals(arr, expected);
    }

    //fail - out of bound
    @Test
    public void originalEmptyArray() {
        int[] arr = {};
        int[] result = program.swapMinMax(arr);
        assertNull(result);
    }

    //check 2nd level with stubs
    public int[] swapMinMaxWithStubs(int[] arr) {
        //stubs
        Stubs.StubCopyArr copyArr = new Stubs.StubCopyArr();
        Stubs.StubMaxValue maxValue = new Stubs.StubMaxValue();
        Stubs.StubMinValueIndex minValueIndex = new Stubs.StubMinValueIndex();
        int[] res = copyArr.copyArr(arr);
        int minInd = minValueIndex.minValueIndex(arr);
        int maxInd = maxValue.maxValue(arr);
        if (minInd < 0 || maxInd < 0)
            return null;
        res[minInd] = arr[maxInd];
        res[maxInd] = arr[minInd];
        return res;
    }


    //pass
    @Test
    public void stubsNullArray() {
        Exception exception = null;
        int[] arr = null;
        try {
            int[] result = swapMinMaxWithStubs(arr);
        } catch (Exception e) {
            exception = e;
        }
        assertEquals(NullPointerException.class, exception.getClass());
    }

    //fail, bad logic -maxValue not maxValueIndex
    @Test
    public void stubsMinMaxArray() {
        int[] arr = {1, 2};
        int[] expected = {2, 1};
        int[] result = swapMinMaxWithStubs(arr);
        assertArrayEquals(arr, expected);
    }

    //pass
    @Test
    public void stubsEmptyArray() {
        int[] arr = {};
        int[] result = swapMinMaxWithStubs(arr);
        assertNull(result);
    }

    //check one real with stubs
    public int[] swapMinMaxWithOneRealOtherStubs(int[] arr) {
        //stubs
        Stubs.StubCopyArr copyArr = new Stubs.StubCopyArr();
        Stubs.StubMaxValue maxValue = new Stubs.StubMaxValue();
        Stubs.StubMinValueIndex minValueIndex = new Stubs.StubMinValueIndex();
        int[] res = copyArrSizeStub(arr);
        int minInd = minValueIndex.minValueIndex(arr);
        int maxInd = maxValue.maxValue(arr);
        if (minInd < 0 || maxInd < 0)
            return null;
        res[minInd] = arr[maxInd];
        res[maxInd] = arr[minInd];
        return res;
    }

    //test B with stub
    private int[] copyArrSizeStub(int[] arr) {
        Stubs.StubSize size = new Stubs.StubSize();
        if (arr == null) return null;
        int[] res = new int[size.size(arr)];
        for (int i = 0; i < size.size(arr); i++)
            res[i] = arr[0];
        return res;
    }

    //pass
    @Test
    public void oneRealNullArray() {
        Exception exception = null;
        int[] arr = null;
        try {
            int[] result = swapMinMaxWithOneRealOtherStubs(arr);
        } catch (Exception e) {
            exception = e;
        }
        assertEquals(NullPointerException.class, exception.getClass());
    }

    //fail, bad logic -maxValue not maxValueIndex
    @Test
    public void oneRealMinMaxArray() {
        int[] arr = {1, 2};
        int[] expected = {2, 1};
        int[] result = swapMinMaxWithOneRealOtherStubs(arr);
        assertArrayEquals(arr, expected);
    }

    //pass
    @Test
    public void oneRealEmptyArray() {
        int[] arr = {};
        int[] result = swapMinMaxWithOneRealOtherStubs(arr);
        assertNull(result);
    }

    //check 2 real one  stubs
    public int[] swapMinMaxWitTwoRealOtherStubs(int[] arr) {
        //stubs
        Stubs.StubCopyArr copyArr = new Stubs.StubCopyArr();
        Stubs.StubMaxValue maxValue = new Stubs.StubMaxValue();
        Stubs.StubMinValueIndex minValueIndex = new Stubs.StubMinValueIndex();
        int[] res = copyArrSizeStub(arr);
        int minInd = program.minValueIndex(arr);
        int maxInd = maxValue.maxValue(arr);
        if (minInd < 0 || maxInd < 0)
            return null;
        res[minInd] = arr[maxInd];
        res[maxInd] = arr[minInd];
        return res;
    }

    //pass
    @Test
    public void twoRealNullArray() {
        Exception exception = null;
        int[] arr = null;
        try {
            int[] result = swapMinMaxWitTwoRealOtherStubs(arr);
        } catch (Exception e) {
            exception = e;
        }
        assertEquals(NullPointerException.class, exception.getClass());
    }

    //fail, bad logic -maxValue not maxValueIndex
    @Test
    public void twoRealMinMaxArray() {
        int[] arr = {1, 2};
        int[] expected = {2, 1};
        int[] result = swapMinMaxWitTwoRealOtherStubs(arr);
        assertArrayEquals(arr, expected);
    }

    //pass
    @Test
    public void twoRealEmptyArray() {
        int[] arr = {};
        int[] result = swapMinMaxWitTwoRealOtherStubs(arr);
        assertNull(result);
    }

    //check 3 real
    public int[] swapMinMaxWitThreeRealOtherStubs(int[] arr) {
        //stubs
        Stubs.StubCopyArr copyArr = new Stubs.StubCopyArr();
        Stubs.StubMaxValue maxValue = new Stubs.StubMaxValue();
        Stubs.StubMinValueIndex minValueIndex = new Stubs.StubMinValueIndex();
        int[] res = copyArrSizeStub(arr);
        int minInd = program.minValueIndex(arr);
        int maxInd = maxValueStubs(arr);
        if (minInd < 0 || maxInd < 0)
            return null;
        res[minInd] = arr[maxInd];
        res[maxInd] = arr[minInd];
        return res;
    }

    private int maxValueStubs(int[] arr) {
        Stubs.StubMaxValueIndex stubMaxValueIndex = new Stubs.StubMaxValueIndex();
        int ind = stubMaxValueIndex.maxValueIndex(arr);
        return arr[ind];
    }


    //pass
    @Test
    public void threeRealNullArray() {
        Exception exception = null;
        int[] arr = null;
        try {
            int[] result = swapMinMaxWitThreeRealOtherStubs(arr);
        } catch (Exception e) {
            exception = e;
        }
        assertEquals(NullPointerException.class, exception.getClass());
    }

    //fail, bad logic -maxValue not maxValueIndex
    @Test
    public void threeRealMinMaxArray() {
        int[] arr = {1, 2};
        int[] expected = {2, 1};
        int[] result = swapMinMaxWitThreeRealOtherStubs(arr);
        assertArrayEquals(arr, expected);
    }

    //fail due to bad logic in minValueIndex- returns -1 when array is null and not when empty
    @Test
    public void threeRealEmptyArray() {
        int[] arr = {};
        int[] result = swapMinMaxWitThreeRealOtherStubs(arr);
        assertNull(result);
    }


    //check 3 real maxValueIndex real with stub
    public int[] swapMinMaxWitThreeReal2ndLevel(int[] arr) {
        //stubs
        Stubs.StubCopyArr copyArr = new Stubs.StubCopyArr();
        Stubs.StubMaxValue maxValue = new Stubs.StubMaxValue();
        Stubs.StubMinValueIndex minValueIndex = new Stubs.StubMinValueIndex();
        int[] res = copyArrSizeStub(arr);
        int minInd = program.minValueIndex(arr);
        int maxInd = maxValueRealMaxValueIndexStub(arr);
        if (minInd < 0 || maxInd < 0)
            return null;
        res[minInd] = arr[maxInd];
        res[maxInd] = arr[minInd];
        return res;
    }


    private int maxValueRealMaxValueIndexStub(int[] arr) {
        Stubs.StubSize size = new Stubs.StubSize();
        if (size.size(arr)<1) return -1;
        int res = arr[0];
        for (int val: arr)
            if (val>res) res = val;
        return res;
    }


    //pass
    @Test
    public void threeRealdownLevalNullArray() {
        Exception exception = null;
        int[] arr = null;
        try {
            int[] result = swapMinMaxWitThreeReal2ndLevel(arr);
        } catch (Exception e) {
            exception = e;
        }
        assertEquals(NullPointerException.class, exception.getClass());
    }

    //fail, bad logic -maxValue not maxValueIndex
    @Test
    public void threeRealdownLevalMinMaxArray() {
        int[] arr = {1, 2};
        int[] expected = {2, 1};
        int[] result = swapMinMaxWitThreeReal2ndLevel(arr);
        assertArrayEquals(arr, expected);
    }

    //fail due to bad logic in minValueIndex- returns -1 when array is null and not when empty
    @Test
    public void threeRealdownLevalEmptyArray() {
        int[] arr = {};
        int[] result = swapMinMaxWitThreeReal2ndLevel(arr);
        assertNull(result);
    }



}
