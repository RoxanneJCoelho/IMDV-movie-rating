package PE_RoxanneCoelho;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class funcoesAdicionais {
    /**
     * Função que conta as linhas duma matriz
     *
     * @param caminho Caminho para o ficheiro a ser carregado
     * @return contagemLinhas Número das linhas da matriz
     * @throws FileNotFoundException Caso o ficheiro não seja encontrado
     */
    public static int contarLinhas(String caminho) throws FileNotFoundException {

        // carregar e ler o ficheiro
        File ficheiro = new File(caminho);
        Scanner sc = new Scanner(ficheiro);

        // começamos a contagem a 0
        int contagemLinhas = 0;

        // enquanto houver linhas no ficheiro, ele conta uma linha
        while (sc.hasNextLine()) {
            sc.nextLine();
            contagemLinhas++;
        }

        // o resultado é o número total das linhas
        return contagemLinhas;

    }

    /**
     * Função que conta as colunas duma matriz
     *
     * @param caminho Caminho para o ficheiro a ser carregado
     * @return colunas.length Número das colunas da matriz
     * @throws FileNotFoundException Caso o ficheiro não seja encontrado
     */
    public static int contarColunas(String caminho) throws FileNotFoundException {

        // carregar e ler o ficheiro
        File ficheiro = new File(caminho);
        Scanner sc = new Scanner(ficheiro);

        if (sc.hasNextLine()) { // se o ficheiro tiver linhas
            String primeiraLinha = sc.nextLine(); // a primeira linha vai ser lida
            String[] colunas = primeiraLinha.split(";"); // vamos "cortar" essa linha pelo delimitador das colunas, neste caso é o ponto e vírgula
            return colunas.length; // o comprimento do array é o número de colunas
        } else {
            // Se o ficheiro tiver vazio
            return 0;
        }
    }

    /**
     * Função que carrega o conteúdo de um ficheiro para uma matriz
     *
     * @param caminho Caminho para o ficheiro a ser carregado
     * @return String[][] - matriz de Strings com o conteúdo do ficheiro
     * @throws FileNotFoundException Caso o ficheiro não seja encontrado
     */
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
            String[] linhaSeparada = linha.split(";");

            for (int i = 0; i < matrizCompleta[0].length; i++) {
                matrizCompleta[numLinhaAtual][i] = linhaSeparada[i];
            }

            numLinhaAtual++;

        }

        return matrizCompleta;
    }
}
