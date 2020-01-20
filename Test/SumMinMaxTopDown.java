import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class SumMinMaxTopDown {

    Program program;
    @Before
    public void setUp(){
        program = new Program();
    }

    @Test
    public void testSumNull (){
        Exception exception = null;
        int [] arr = null;
        try {
            int result = program.sumMinMax(arr);
        }catch (Exception e){
            exception=e;
        }
        assertEquals(exception.getClass(), NullPointerException.class);
    }

    //test fail - due to logical error in minValue- returns the max value index
    @Test
    public void testSum3(){
        int [] arr = {1,2};
        int result = program.sumMinMax(arr);
        assertEquals(3, result);
    }

    // fail due to logical error in minValue - trying to access arr[-1]
    @Test
    public void testSumEmpty(){
        int [] arr = {};
        int result = program.sumMinMax(arr);
        assertEquals(0, result);
    }

    //check second level, minValue+ maxValue are stubs;
    public  int sumMinMaxAllStubs(int[] arr) {
        Stubs.StubMinValue minValue = new Stubs.StubMinValue();
        Stubs.StubMaxValue maxValue = new Stubs.StubMaxValue();
        return minValue.minValue(arr) + maxValue.maxValue(arr);
    }
   
    @Test
    public void testSumNullStubs (){
        Exception exception = null;
        int [] arr = null;
        try {
            int result = sumMinMaxAllStubs(arr);
        }catch (Exception e){
            exception=e;
        }
        assertEquals(exception.getClass(), NullPointerException.class);
    }

    //test pass
    @Test
    public void testSum3Stubs(){
        int [] arr = {1,2};
        int result = sumMinMaxAllStubs(arr);
        assertEquals(3, result);
    }

    // assume that if the array is empty minValue and maxValue are -1
    @Test
    public void testSumEmptyStubs(){
        int [] arr = {};
        int result = sumMinMaxAllStubs(arr);
        assertEquals(-2, result);
    }

    //check third level, min value is real but minValueIndex is stub;
    public int sumMinMaxIndexesStubs(int[] arr) {
        Stubs.StubMaxValue maxValue = new Stubs.StubMaxValue();
        return minValueIndexStub(arr) + maxValue.maxValue(arr);
    }

    // Returns the minimum value in the array, valueindex stub
    public  int minValueIndexStub(int[] arr) {
        Stubs.StubMaxValueIndex maxValueIndex= new Stubs.StubMaxValueIndex();
        int ind = maxValueIndex.maxValueIndex(arr);
        return arr[ind];
    }

    @Test
    public void testSumNullMaxStub (){
        Exception exception = null;
        int [] arr = null;
        try {
            int result = sumMinMaxIndexesStubs(arr);
        }catch (Exception e){
            exception=e;
        }
        assertEquals(exception.getClass(), NullPointerException.class);
    }

    //fail due to logical error - minValue returns max so sum is 4
    @Test
    public void testSum3MaxStub(){
        int [] arr = {1,2};
        int result = sumMinMaxIndexesStubs(arr);
        assertEquals(3, result);
    }

    // fail due to logical error- minValue returns max
    @Test
    public void testSumEmptyMaxStub(){
        int [] arr = {};
        int result = sumMinMaxIndexesStubs(arr);
        assertEquals(-2, result);
    }


    //check third level, min value and max value are real but indexes are stubs
    public int sumMinMaxIndexesBothStubs(int[] arr) {
        return minValueIndexStub(arr) + maxValueIndexStub(arr);
    }

    // Returns the maximum value in the array, valueindex stub
    public  int maxValueIndexStub(int[] arr) {
        Stubs.StubMaxValueIndex maxValueIndex = new Stubs.StubMaxValueIndex();
        int ind = maxValueIndex.maxValueIndex(arr);
        return arr[ind];
    }

    @Test
    public void testSumNull3rdStubs (){
        Exception exception = null;
        int [] arr = null;
        try {
            int result = sumMinMaxIndexesBothStubs(arr);
        }catch (Exception e){
            exception=e;
        }
        assertEquals(exception.getClass(), NullPointerException.class);
    }

    //fail due to logical error - minValue returns max so sum is 4
    @Test
    public void testSum3Max3rdStubs(){
        int [] arr = {1,2};
        int result = sumMinMaxIndexesBothStubs(arr);
        assertEquals(3, result);
    }

    // fail due to logical error- minValue returns max
    @Test
    public void testSumEmpty3rdStub(){
        int [] arr = {};
        int result = sumMinMaxIndexesBothStubs(arr);
        assertEquals(-2, result);
    }





}
