package binarysearch;

public class Count<T extends Comparable<T>> {
    
    public int count(T[] array, T x){
        int result = 0;

        if(array != null && x != null){
            int looc = looc(array, x, 0, array.length-1);
            int fooc = fooc(array, x, 0, array.length-1);
    
            result = looc - fooc + 1;
    
            if(looc == -1 && fooc == -1){
                result = 0;
            }
        }
        return result;
    }

    private int looc(T [] array, T x, int leftIndex, int rightIndex){
        int result = -1;

        if(leftIndex >= 0 && rightIndex < array.length && leftIndex <= rightIndex){
            int m = (leftIndex+rightIndex)/2;

            if(array[m].compareTo(x) == 0){
                if(m+1 >= array.length - 1 || array[m+1].compareTo(x) != 0){
                    result = m;
                }
                else{
                    result = looc(array, x, m+1, rightIndex);
                }
            }
            else if(array[m].compareTo(x) < 0){
                result = looc(array, x, m+1, rightIndex);
            }
            else{
                result = looc(array, x, leftIndex, m-1);
            }
        }
        return result;

    }

    private int fooc(T [] array, T x, int leftIndex, int rightIndex){
        int result = -1;

        if(array != null && array.length > 0 && leftIndex >= 0 && rightIndex < array.length && leftIndex <= rightIndex){
            int m = (leftIndex+rightIndex)/2;

            if(array[m].compareTo(x) == 0){
                if(m - 1 < 0 || array[m-1].compareTo(x) != 0){
                    result = m;
                }
                else{
                    result = fooc(array, x, leftIndex, m-1);
                }
            }
            else if(array[m].compareTo(x) < 0){
                result = fooc(array, x, m+1, rightIndex);
            }
            else{
                result = fooc(array, x, leftIndex, m-1);
            }
        }
        return result;

    }

    public static void main(String[] args) {
        Count c = new Count();
        Integer [] a = new Integer[]{1,2,3,3,3,3,3,3,3,4,4,4,5,5,5,5};
        Integer [] a1 = new Integer[]{};

        System.out.println(c.count(a, 10));
        System.out.println(c.count(a, 1));
        System.out.println(c.count(a, 2));
        System.out.println(c.count(a, 3));
        System.out.println(c.count(a, 4));
        System.out.println(c.count(a, 5));
        System.out.println(c.count(a1, 10));



    }

}
