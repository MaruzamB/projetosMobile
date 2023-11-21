package devandroid.maruzam.appgaseta.util;

public class UtilGasEta {

    // método não estatico precisa criar instancia

    public void metodNaoEstatico(){}

    public static void metodoEstatico(){}

    public static String mensagem(){

        return  "Seja Bem Vindo!!!";
    }

    public static String calcularMelhorOpcao(double gasolina, double etanol){

        double precoIdeal = gasolina * 0.70;
        String mensagemRetorno;

        if (etanol <= precoIdeal) {
            mensagemRetorno = "Abastecer com etanol";
        }else {
            mensagemRetorno = "Abastecer com Gasoina";
        }
        return mensagemRetorno;
    }

}
