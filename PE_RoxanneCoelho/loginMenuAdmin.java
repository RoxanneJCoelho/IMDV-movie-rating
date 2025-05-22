package PE_RoxanneCoelho;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class loginMenuAdmin {
    public static int contarLinhas(String caminho) throws FileNotFoundException {

        File ficheiro = new File(caminho);
        Scanner sc = new Scanner(ficheiro);

        int contagemLinhas = 0;

        while (sc.hasNextLine()) {
            sc.nextLine();
            contagemLinhas++;
        }

        return contagemLinhas;

    }
    public static int contarColunas(String caminho) throws FileNotFoundException {

        File ficheiro = new File(caminho);
        Scanner sc = new Scanner(ficheiro);

        if (sc.hasNextLine()) {
            String primeiraLinha = sc.nextLine();

            String[] colunas = primeiraLinha.split(";");
            return colunas.length;
        } else {
            // Se o ficheiro estiver vazio
            return 0;
        }
    }


    public static void main(String[] args) throws FileNotFoundException {
        System.out.println(" Existem "+ contarLinhas("IMDV/IMDV.csv") + "linhas e " + contarColunas("IMDV/IMDV.csv") + "colunas");

    }

}
