import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class PrintSortedTopDown {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    Program program;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
        program = new Program();

    }
    @After
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    //fail - not support in Null case, logical problem
    @Test
    public void originalPrintNull(){
        int[] arr = null;
        program.printSorted(arr);
        String[] out = outContent.toString().split("\r\n");
        assertEquals("No array", out[0]);

    }

    //pass
    @Test
    public void originalPrintEmpty(){
        int[] arr = {};
        program.printSorted(arr);
        String[] out = outContent.toString().split("\r\n");
        assertEquals( 0, out.length);
        assertEquals( 0, out.length);
        assertEquals( 0, out.length);


    }

    //fails due to logic error - copy copies only the first element
    @Test
    public void originalPrintSorted(){
        int[] arr = {2,4,6,8};
        program.printSorted(arr);
        String[] out = outContent.toString().split("\r\n");
        assertEquals( "2 4 6 8 ", out[0]);
        assertEquals( "2 4 6 8 ", out[1]);
        assertEquals( "2 4 6 8 ", out[2]);
    }

    //fails due to logic error - copy copies only the first element
    @Test
    public void originalPrintUnSorted(){
        int[] arr = {2,-1,9,8};
        program.printSorted(arr);
        String[] out = outContent.toString().split("\r\n");
        assertEquals( "2 -1 9 8 ", out[0]);
        assertEquals( "-1 2 8 9 ", out[1]);
        assertEquals( "-1 2 8 9 ", out[2]);
    }

    //test with stubs
    public void printSortedWithStubs(int[] arr) {
        Stubs.StubprintArr stubprintArr = new Stubs.StubprintArr();
        Stubs.StubSortArray stubSortArray = new Stubs.StubSortArray();

        if (arr==null)
            System.out.println("No array");
        stubprintArr.printArr(arr);
        arr = stubSortArray.sortArray(arr);
        stubprintArr.printArr(stubSortArray.sortArray(arr));
        stubprintArr.printArr(arr);
    }

    //fail - not support in Null case, logical problem
    @Test
    public void PrintNullWithStubs(){
        int[] arr = null;
        printSortedWithStubs(arr);
        String[] out = outContent.toString().split("\r\n");
        assertEquals("No array", out[0]);

    }

    //pass
    @Test
    public void PrintEmptyWithStubs(){
        int[] arr = {};
        printSortedWithStubs(arr);
        String[] out = outContent.toString().split("\r\n");
        assertEquals( 0, out.length);

    }

    //pass
    @Test
    public void PrintSortedWithStubs(){
        int[] arr = {2,4,6,8};
        printSortedWithStubs(arr);
        String[] out = outContent.toString().split("\r\n");
        assertEquals( "2 4 6 8 ", out[0]);
        assertEquals( "2 4 6 8 ", out[1]);
        assertEquals( "2 4 6 8 ", out[2]);
    }

    //pass
    @Test
    public void PrintUnSortedWithStubs(){
        int[] arr = {2,-1,9,8};
        printSortedWithStubs(arr);
        String[] out = outContent.toString().split("\r\n");
        assertEquals( "2 -1 9 8 ", out[0]);
        assertEquals( "-1 2 8 9 ", out[1]);
        assertEquals( "-1 2 8 9 ", out[2]);
    }

    //printArr original other stub
    public void printSortedWithOneOriginal(int[] arr) {
        Stubs.StubSortArray stubSortArray = new Stubs.StubSortArray();

        if (arr==null)
            System.out.println("No array");
        program.printArr(arr);
        arr = stubSortArray.sortArray(arr);
        program.printArr(stubSortArray.sortArray(arr));
        program.printArr(arr);
    }

    //fail - not support in Null case, logical problem
    @Test
    public void PrintNullWithOneOriginal(){
        int[] arr = null;
        printSortedWithOneOriginal(arr);
        String[] out = outContent.toString().split("\r\n");
        assertEquals("No array", out[0]);

    }

    //pass
    @Test
    public void PrintEmptyWithOneOriginal(){
        int[] arr = {};
        printSortedWithOneOriginal(arr);
        String[] out = outContent.toString().split("\r\n");
        assertEquals( 0, out.length);

    }

    //pass
    @Test
    public void PrintSortedWithOneOriginal(){
        int[] arr = {2,4,6,8};
        printSortedWithOneOriginal(arr);
        String[] out = outContent.toString().split("\r\n");
        assertEquals( "2 4 6 8 ", out[0]);
        assertEquals( "2 4 6 8 ", out[1]);
        assertEquals( "2 4 6 8 ", out[2]);
    }

    //pass
    @Test
    public void PrintUnSortedWithOneOriginal(){
        int[] arr = {2,-1,9,8};
        printSortedWithOneOriginal(arr);
        String[] out = outContent.toString().split("\r\n");
        assertEquals( "2 -1 9 8 ", out[0]);
        assertEquals( "-1 2 8 9 ", out[1]);
        assertEquals( "-1 2 8 9 ", out[2]);
    }

    //two original
    public void printSortedWithTwoOriginal(int[] arr) {
        Stubs.StubSortArray stubSortArray = new Stubs.StubSortArray();

        if (arr==null)
            System.out.println("No array");
        program.printArr(arr);
        arr = sortArrayCopySizeStubs(arr);
        program.printArr(sortArrayCopySizeStubs(arr));
        program.printArr(arr);
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

    //fail - not support in Null case, logical problem
    @Test
    public void PrintNullWithTwoOriginal(){
        int[] arr = null;
        printSortedWithTwoOriginal(arr);
        String[] out = outContent.toString().split("\r\n");
        assertEquals("No array", out[0]);

    }

    //pass
    @Test
    public void PrintEmptyWithOTwoOriginal(){
        int[] arr = {};
        printSortedWithTwoOriginal(arr);
        String[] out = outContent.toString().split("\r\n");
        assertEquals( 0, out.length);

    }

    //pass
    @Test
    public void PrintSortedWithTwoOriginal(){
        int[] arr = {2,4,6,8};
        printSortedWithTwoOriginal(arr);
        String[] out = outContent.toString().split("\r\n");
        assertEquals( "2 4 6 8 ", out[0]);
        assertEquals( "2 4 6 8 ", out[1]);
        assertEquals( "2 4 6 8 ", out[2]);
    }

    //pass
    @Test
    public void PrintUnSortedWithTwoOriginal(){
        int[] arr = {2,-1,9,8};
        printSortedWithTwoOriginal(arr);
        String[] out = outContent.toString().split("\r\n");
        assertEquals( "2 -1 9 8 ", out[0]);
        assertEquals( "-1 2 8 9 ", out[1]);
        assertEquals( "-1 2 8 9 ", out[2]);
    }

    //size real copy stub

    public void printSortedWithSizeOriginalCopyStub(int[] arr) {

        if (arr==null)
            System.out.println("No array");
        program.printArr(arr);
        arr = sortArrayCopyStub(arr);
        program.printArr(sortArrayCopySizeStubs(arr));
        program.printArr(arr);
    }

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

    //fail - not support in Null case, logical problem
    @Test
    public void PrintNullWithSizeOriginalCopyStub(){
        int[] arr = null;
        printSortedWithSizeOriginalCopyStub(arr);
        String[] out = outContent.toString().split("\r\n");
        assertEquals("No array", out[0]);

    }

    //pass
    @Test
    public void PrintEmptyWithOSizeOriginalCopyStub(){
        int[] arr = {};
        printSortedWithSizeOriginalCopyStub(arr);
        String[] out = outContent.toString().split("\r\n");
        assertEquals( 0, out.length);

    }

    //pass
    @Test
    public void PrintSortedWithSizeOriginalCopyStub(){
        int[] arr = {2,4,6,8};
        printSortedWithSizeOriginalCopyStub(arr);
        String[] out = outContent.toString().split("\r\n");
        assertEquals( "2 4 6 8 ", out[0]);
        assertEquals( "2 4 6 8 ", out[1]);
        assertEquals( "2 4 6 8 ", out[2]);
    }

    //pass
    @Test
    public void PrintUnSortedWithSizeOriginalCopyStub(){
        int[] arr = {2,-1,9,8};
        printSortedWithSizeOriginalCopyStub(arr);
        String[] out = outContent.toString().split("\r\n");
        assertEquals( "2 -1 9 8 ", out[0]);
        assertEquals( "-1 2 8 9 ", out[1]);
        assertEquals( "-1 2 8 9 ", out[2]);
    }


}
