package binarysearch;

public class Raiz {
    public double raiz(int numero, int raiz, double erro) {
        double result = -1;

        if(numero > 0 && raiz >= 0){
            result = raiz(numero, raiz, erro, 0, numero);
        }
        return result;
    }

    private double raiz(int numero, int raiz, double erro, int leftIndex, int rightIndex){
        double result = (leftIndex+rightIndex)/2;
        int middle = (leftIndex+rightIndex)/2;
        int pow = pow(middle, raiz);

        if(abs(pow-numero) <= erro){
            result = middle;
        }
        else if(pow > numero){
            result = raiz(numero, raiz, erro, leftIndex, middle - 1);
        }
        else{
            result = raiz(numero, raiz, erro, middle + 1, rightIndex);
        }
        return result;
    }

    private int pow(int number, int power) {
       int result = 1;

       if(number != 0){
            result = number * pow(number, power-1);
       }
       return result;
    }

    private int abs(int number){
        int result = number;
        if(number < 0){
            result = -number;
        }
        return result;
    }
}
