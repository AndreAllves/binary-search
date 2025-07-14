package binarysearch;


public class ValeyPoint {
    
    public int valeyPoint(int [] array){
        return  valeyPoint(array, 0, array.length - 1);
    }

    private int valeyPoint(int [] array, int leftIndex, int rightIndex){
        int result = 0;

        if(array != null && array.length > 0 && leftIndex >= 0 && rightIndex < array.length && leftIndex <= rightIndex){
            int m = (leftIndex + rightIndex) / 2;

            boolean isFirst = (m == 0);
            boolean isLast = (m == array.length - 1);

            boolean leftIsBigger = isFirst || array[m] < array[m-1];
            boolean rightIsBigger = isLast || array[m] < array[m+1];

            if(leftIsBigger && rightIsBigger){
                result = array[m];
            }
            else if (!leftIsBigger){
                result = valeyPoint(array, leftIndex, m-1);
            }
            else{
                result = valeyPoint(array, m+1, rightIndex);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ValeyPoint v = new ValeyPoint();
        System.out.println(v.valeyPoint(new int[]{8,4,2,1,7,12,16,20,32,37}));
    }
}
