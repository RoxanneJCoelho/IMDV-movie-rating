package PE_RoxanneCoelho;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static PE_RoxanneCoelho.funcoesAdicionais.*;

public class menuAdmin {

    /**
     * Função para ler o ficheiro dos filmes e imprimir-lo na consola, com um espaço entre os elementos
     *
     * @param caminho Caminho para o ficheiro a ser carregado
     * @throws FileNotFoundException Caso o ficheiro não seja encontrado
     */
    public static void ConsultaFicheiro(String caminho) throws FileNotFoundException {

        // carregar e ler o ficheiro
        File ficheiroCopyright = new File(caminho);
        Scanner sc = new Scanner(ficheiroCopyright);

        // enquanto o ficheiro tiver linhas ele vai dividir os elementos da linha pelo ponto e vírgula
        while (sc.hasNextLine()) {
            String linha = sc.nextLine();
            String[] elementos = linha.split(";");

            // depois, por cada elemento, ele vai ser imprimido na consola
            for (int i = 0; i < elementos.length; i++) {
                System.out.print(elementos[i]);
                if (i < elementos.length - 1) { // juntamente com a palavra vai imprimir um espaço até o último elemento, que não precisa de espaço
                    System.out.print(" ");
                }
            }
            System.out.println(); // imprime uma nova linha para os proximos elementos
        }
    }

    /**
     * Função para imprimir o total de ratings
     *
     * @param caminho Caminho para o ficheiro a ser carregado
     * @throws FileNotFoundException Caso o ficheiro não seja encontrado
     */
    public static void Ratings(String caminho) throws FileNotFoundException {

        // busca a função da contagem de linhas
        System.out.println("Total de Ratings : " + contarLinhas(caminho));
    }

    /**
     * Função para imprimir o nome dos estúdios sem duplicados
     *
     * @throws FileNotFoundException Caso o ficheiro não seja encontrado
     */

    public static void Estudios() throws FileNotFoundException {

        // o ficheiro é transformado em matriz para ser mais fácil a sua manipulação
        String[][] matriz = ficheiroParaMatriz("IMDV/IMDV.csv");

        // vamos ser criados dois arrays:
        // arrayComDuplicado - vai ter todos os nomes dos estúdios com repetições
        String[] arrayComDuplicado = new String[matriz.length];

        // arraySemDuplicado - vai ter todos os nomes dos estúdios sem repetições
        String[] arraySemDuplicado = new String[matriz.length];

        // esta variável é o número do indice do arraySemDuplicado
        int ultimoIndex = 0;

        // indica se o nome do estúdio está duplicado ou não
        boolean duplicado = false;

        // percorre a coluna de indice 5 da matriz e a cola no arrayComDuplicado
        for (int linha = 0; linha < matriz.length; linha++) {
            arrayComDuplicado[linha] = matriz[linha][5];
        }

        // percorre cada linha do arrayComDuplicado
        for (int linha = 0; linha < matriz.length; linha++) {

            // assume que que ainda não há duplicados
            duplicado = false;

            // percorre cada linha do arraySemDuplicados, se houver algum nome duplicado, o duplicado fica true
            for (int linhaSemDuplicados = 0; linhaSemDuplicados < matriz.length; linhaSemDuplicados++) {
                if (arrayComDuplicado[linha].equals(arraySemDuplicado[linhaSemDuplicados])) {
                    duplicado = true;
                }
            }

            // se o nome não for duplicado ele guarda no arraySemDuplicado
            if (duplicado == false) {
                arraySemDuplicado[ultimoIndex] = arrayComDuplicado[linha];
                ultimoIndex++; // ao incrementar ele passa o próximo nome para a posição seguinte

            }
        }

        // como o arrayComDuplicado e arraySemDuplicado têm o mesmo comprimento, no arraySemDuplicados vai aparecer null, então vamos só imprimir os que não são null
        for (int i = 0; i < arraySemDuplicado.length; i++) {
            if (arraySemDuplicado[i] != null) {
                System.out.println(arraySemDuplicado[i]);
            }
        }
    }
}


