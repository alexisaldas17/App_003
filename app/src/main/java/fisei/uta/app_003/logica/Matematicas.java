package fisei.uta.app_003.logica;

public class Matematicas {
    public long Potencia(int base, int exponente){
        long resultado = 1;
        for(int i=1; i<= exponente; i++){
            resultado *= base;
        }

        return resultado;
    }
    public static int Sumar(int a , int b){
        return a + b;
    }
}
