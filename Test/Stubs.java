import java.util.Arrays;

public class Stubs {

    public static class StubprintArr extends Program{

        @Override
        public void printArr(int[] arr) {
            for(int val: arr)
                System.out.print(val+" ");
            System.out.println();
        }
    }

    public static class StubMaxValueIndex extends Program{

        @Override
        public int maxValueIndex(int[] arr) {
            if (arr.length < 1)
                return -1;
            int res = arr[0];
            int maxIndex = 0;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] > res) {
                    maxIndex = i;
                    res = arr[i];
                }
            }
            return maxIndex;
        }
    }

    public static class StubSortArray extends Program {
        @Override
        public int[] sortArray(int[] arr) {
            if (arr == null) return null;
            int[] res = sortArray(arr);
            return res;
        }
    }

    public static class StubEqualArrays extends Program {
        @Override
        public boolean equalArrays(int[] arr1, int[] arr2) {
          return  Arrays.equals(arr1,arr2);
        }
    }


    public static class StubMinValueIndex extends Program{

        @Override
        public int minValueIndex(int[] arr) {
            if (arr.length<1)
                return -1;
            int res = arr[0];
            int minIndex=0;
            for (int i=0; i<arr.length; i++) {
                if (arr[i] < res) {
                    minIndex = i;
                    res = arr[i];
                }
            }
            return minIndex;
        }
    }

    public static class StubMinValue extends Program {

        @Override
        public int minValue(int[] arr) {
            if (arr.length < 1)
                return -1;
            int res = arr[0];
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] < res) {
                    res = arr[i];
                }
            }
            return res;
        }
    }

    public static class StubMaxValue extends Program{

        @Override
        public  int maxValue(int[] arr) {
            if (arr.length<1)
                return -1;
            int res = arr[0];
            for (int i=0; i<arr.length; i++) {
                if (arr[i] > res) {
                    res = arr[i];
                }
            }
            return res;
        }
    }

    public static class StubCopyArr extends Program{

        @Override
        public int[] copyArr(int[] arr) {
            if (arr == null)
                return null;
            int[] res = new int[arr.length];
            for(int i=0; i<arr.length; i++)
                res[i] = arr[i];
            return res;
        }

    }
    public static class StubSize extends Program{

        @Override
        public int size(int[] arr) {
            return arr.length;
        }

    }
}
