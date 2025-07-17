package binarysearch;

public class LastOccorrence {
    public int fooc(int [] array, int x){
        return fooc(array, x, 0, array.length - 1);
    }

    private int fooc(int [] array, int x, int leftIndex, int rightIndex){
        int result = 0;

        if(array != null && array.length > 0 && leftIndex >= 0 && rightIndex < array.length && leftIndex <= rightIndex){
            int m = (leftIndex + rightIndex) / 2;

            if(x == array[m]){
                if(m == array.length - 1 || array[m+1] != x){
                    result = m;
                }
                else{
                    result = fooc(array, x, m+1, rightIndex);
                }
            }
            else if (array[m] > x){
                result = fooc(array, x, leftIndex, m-1);
            }
            else{
                result = fooc(array, x, m+1, rightIndex);
            }
        }
        return result;
    }

     public static void main(String[] args) {
        LastOccorrence f = new LastOccorrence();
        System.out.println(f.fooc(new int[]{1,2,2,3,4,4}, 4));
    }
}

