import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNull;

public class MargeTopDown {

    Program program;
    @Before
    public void setUp(){
        program = new Program();
    }

    @Test
    public void originalTwoNullNull(){
        int [] arr1 = null;
        int [] arr2 = null;
        int [] result = program.merge(arr1, arr2);
        assertNull(result);
    }




//    // Merges two arrays "ar1" and "ar2" into one sorted array and returns it
//    public int[] merge(int[] ar1, int[] ar2) {
//        if (ar1==null && ar2==null) return null;
//        if (ar1==null) return sortArray(ar2);
//        if (ar2==null) return sortArray(ar1);
//        int[] res = new int[ar1.length+ar2.length];
//        int i = 0;
//        for(int j=0; j<ar1.length; j++)
//            res[i++] = ar1[j];
//        for(int j=0; j<ar2.length; j++)
//            res[i++] = ar2[j];
//        return sortArray(res);
//    }

}
