import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class PrintSortedBottomUp {

    Program programDriver = new Program();

    final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    final PrintStream originalOut = System.out;
    final PrintStream originalErr = System.err;


    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }


    //logic error in copy function (in sortArray)
    @Test
    public void printSorted (){
        int [] arr = {2, 7, 4};
        programDriver.printSorted(arr);
        String[] output = outContent.toString().split("\r\n");
        assertEquals("2 7 4 ", output[0]);
        assertEquals("2 4 7 ", output[1]);
        assertEquals("2 7 4 ", output[2]);
    }

    @Test
    public void printSortedEmpty(){
        int [] arr = {};
        programDriver.printSorted(arr);
        String[] output = outContent.toString().split("\r\n");
        assertEquals(0, output.length);
        assertEquals(0, output.length);
        assertEquals(0, output.length);
    }

    //logic error, throw NullPointerException instead print "No array"
    @Test
    public void printSortedNull(){
        int [] arr = null;
        programDriver.printSorted(arr);
        String[] output = outContent.toString().split("\r\n");
        assertEquals("No array", output[0]);
    }

}
