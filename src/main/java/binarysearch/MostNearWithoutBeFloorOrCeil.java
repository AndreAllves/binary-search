package binarysearch;

public class MostNearWithoutBeFloorOrCeil {

    public int mostNear(int [] v, int x){
        return mostNear(v, x, 0, v.length-1, v[0]);
    }

    private int mostNear(int[] v, int x, int leftIndex, int rightIndex, int bestSoFar){
        int result = bestSoFar;

        if(v != null && v.length > 0 && x > 0 && leftIndex >= 0 && rightIndex < v.length && leftIndex <= rightIndex){
            int m = (leftIndex + rightIndex) / 2;

            int difM = diference(v[m], x);
            int difS = diference(bestSoFar, x);

            if(difM < difS || (difM == difS && v[m] < bestSoFar)){
                result = v[m];
            }
            if(v[m] < x){
                result = mostNear(v, x, m+1, rightIndex, result);
            }
            else if(v[m] > x){
                result = mostNear(v, x, leftIndex, m-1, result);
            }
        }
        return result;
    }

    private int diference(int a, int b){
        int dif = a - b;

        if(dif < 0){
            dif = -dif;
        }

        return dif;
    }

    public static void main(String[] args) {
        MostNearWithoutBeFloorOrCeil m = new MostNearWithoutBeFloorOrCeil();
        System.out.println(m.mostNear(new int []{1,3,4,5}, 6));
    }
    
}
