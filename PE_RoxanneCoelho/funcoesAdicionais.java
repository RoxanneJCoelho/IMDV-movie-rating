package PE_RoxanneCoelho;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class funcoesAdicionais {
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

    public static String[][] ficheiroParaMatriz(String caminho) throws FileNotFoundException {

        // Saber quantas linhas tem o ficheiro (atenção ao cabeçalho (-1))
        int numeroLinhas = contarLinhas(caminho) - 1;

        // Saber quantas colunas tem o ficheiro
        int numeroColunas = contarColunas(caminho);

        // Criar uma matriz com o tamanho certo
        String[][] matrizCompleta = new String[numeroLinhas][numeroColunas];

        // Criar as ferramentas de leitura
        File ficheiro = new File(caminho);
        Scanner sc = new Scanner(ficheiro);

        // Avançar o cabeçalho
        sc.nextLine();

        // Controlar o numero da linha
        int numLinhaAtual = 0;

        // Enquanto houver linhas e colunas
        while (sc.hasNextLine()) {
            String linha = sc.nextLine();
            String[] linhaSeparada = linha.split(",");

            for (int i = 0; i < matrizCompleta[0].length; i++) {
                matrizCompleta[numLinhaAtual][i] = linhaSeparada[i];
            }

            numLinhaAtual++;

        }

        return matrizCompleta;
    }
}
