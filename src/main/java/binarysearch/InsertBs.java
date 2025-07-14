package binarysearch;

public class InsertBs {

    public int insertBs(int [] array, int x){
        return insertBs(array, x, 0, array.length - 1);
    }

    private int insertBs(int [] array, int x, int leftIndex, int rightIndex){
        int result = leftIndex;

        if(array != null && array.length > 0 & leftIndex >= 0 && rightIndex < array.length && leftIndex <= rightIndex){
            int m = (leftIndex+rightIndex) / 2;

            if(array[m] < x){
                result = insertBs(array, x, m+1, rightIndex);
            }
            else{
                result = insertBs(array, x, leftIndex, m-1);
            }
        }
        return result;
    }

     public static void main(String[] args) {
        InsertBs f = new InsertBs();
        System.out.println(f.insertBs(new int[]{1,3,4,4},2 ));
    }
    
}
