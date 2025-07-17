package binarysearch;

public class Count {
    
    public int count(int[] array, int x){
        int looc = looc(array, x, 0, array.length-1);
        int fooc = fooc(array, x, 0, array.length-1);

        int result = looc - fooc + 1;

        if(looc == -1 && fooc == -1){
            result = 0;
        }

        return result;
    }

    private int looc(int [] array, int x, int leftIndex, int rightIndex){
        int result = -1;

        if(array != null && array.length > 0 && leftIndex >= 0 && rightIndex < array.length && leftIndex <= rightIndex){
            int m = (leftIndex+rightIndex)/2;

            if(array[m] == x){
                if(m == array.length - 1 || array[m+1] != x){
                    result = m;
                }
                else{
                    result = looc(array, x, m+1, rightIndex);
                }
            }
            else if(array[m] >= x){
                result = looc(array, x, leftIndex, m-1);
            }
            else{
                result = looc(array, x, m+1, rightIndex);
            }
        }
        return result;

    }

    private int fooc(int [] array, int x, int leftIndex, int rightIndex){
        int result = -1;

        if(array != null && array.length > 0 && leftIndex >= 0 && rightIndex < array.length && leftIndex <= rightIndex){
            int m = (leftIndex+rightIndex)/2;

            if(array[m] == x){
                if(m == 0 || array[m-1] != x){
                    result = m;
                }
                else{
                    result = fooc(array, x, leftIndex, m-1);
                }
            }
            else if(array[m] >= x){
                result = fooc(array, x, leftIndex, m-1);
            }
            else{
                result = fooc(array, x, m+1, rightIndex);
            }
        }
        return result;

    }

    public static void main(String[] args) {
        Count c = new Count();
        int [] a = new int[]{1,2,3,3,3,3,3,3,3,4,4,4,5,5,5,5,5};
        System.out.println(c.fooc(a, 10, 0, a.length));
        System.out.println(c.looc(a, 10, 0, a.length));
        System.out.println(c.count(a, 10));

    }

}
