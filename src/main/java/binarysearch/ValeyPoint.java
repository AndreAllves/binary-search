package binarysearch;


public class ValeyPoint<T extends Comparable<T>> {
    
     public int valeyPoint(Integer [] array){
        int result = -1;

        if(array != null){
            result = valeyPointRecursive(array, 0, array.length-1);
        }
        return result;
    }

    private int valeyPointRecursive(Integer[] array, int left, int right){
        int result = -1;

        if(left <= right && left >= 0 && right < array.length){
            int m = (left+right)/2;

            if(m == 0){
                if(m == array.length - 1 || array[m].compareTo(array[m+1]) < 0){
                    result = array[m];
                }
                else{
                    result = valeyPointRecursive(array, m+1, right);
                }
            }
            else if(m == array.length-1){
                if(array[m].compareTo(array[m-1]) < 0){
                    result = array[m];
                }
                else{
                    result = valeyPointRecursive(array, left, m-1);
                }
            }
            else{
                if(array[m].compareTo(array[m-1]) < 0){
                    if(array[m].compareTo(array[m+1]) < 0){
                        result = array[m];
                    }
                    else{
                        result = valeyPointRecursive(array, m+1, right);
                    }
                }
                else{
                    result = valeyPointRecursive(array, left, m-1);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ValeyPoint<Integer> v = new ValeyPoint<>();

        System.out.println(v.valeyPoint(new Integer[]{4,3,2,7,8,9,16}));
    }
}

