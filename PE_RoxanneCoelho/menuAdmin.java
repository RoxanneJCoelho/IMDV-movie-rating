package PE_RoxanneCoelho;


import java.io.FileNotFoundException;


import static PE_RoxanneCoelho.menuCopyRight.*;
import static PE_RoxanneCoelho.funcoesAdicionais.*;

public class menuAdmin {
    public static void ConsultaFicheiro(String caminho) throws FileNotFoundException {
        copyRight(caminho);

    }

    public static void Ratings(String caminho) throws FileNotFoundException {
        System.out.println("Total de Ratings : " + contarLinhas(caminho));
    }

    public static void Estudios() throws FileNotFoundException {
        String[][] matriz = ficheiroParaMatriz("IMDV/IMDV.csv");

        String[] arrayComDuplicado = new String[matriz.length];
        String[] arraySemDuplicado = new String[matriz.length];

        int ultimoIndex=0;

        boolean duplicado = false;

        for (int linha = 0; linha < matriz.length; linha++) {
            arrayComDuplicado[linha] = matriz[linha][5];
        }

        for (int linha = 0; linha < matriz.length; linha++) {
            duplicado = false;

            for (int linhaSemDuplicados = 0; linhaSemDuplicados < matriz.length; linhaSemDuplicados++) {
                if (arrayComDuplicado[linha].equals(arraySemDuplicado[linhaSemDuplicados])) {
                    duplicado = true;
                }
            }

            if (duplicado == false) {
                    arraySemDuplicado[ultimoIndex]=arrayComDuplicado[linha];
                    ultimoIndex++;

            }

        }

        //________________________________________
        for (int i = 0; i < arraySemDuplicado.length; i++) {
            if(arraySemDuplicado[i]!=null){

                System.out.println(arraySemDuplicado[i]);
            }
        }
    }
}


