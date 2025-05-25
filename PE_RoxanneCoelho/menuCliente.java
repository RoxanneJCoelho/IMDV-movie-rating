package PE_RoxanneCoelho;

import java.io.FileNotFoundException;
import java.util.Scanner;

import static PE_RoxanneCoelho.menuCopyRight.*;
import static PE_RoxanneCoelho.funcoesAdicionais.*;


public class menuCliente {

    /**
     * Função para simular um novo registro
     */

    public static void NovoRegistro() {

        Scanner input = new Scanner(System.in);

        String nome;
        int contacto;
        String email;

        System.out.println("\n------- Registar Utilizador -------");
        System.out.print("\nInsira Nome: ");
        nome = input.nextLine();

        System.out.print("\nInsira Contacto: ");
        contacto = input.nextInt();

        System.out.print("\nInsira Email: ");
        email = input.next();

        System.out.println("\nUtilizador Inserido com Sucesso: " + nome + " | " + contacto + " | " + email);

    }

    /**
     * Função para imprimir os filmes e respetiva avaliação
     */
    public static void ImprimirCatalogo() throws FileNotFoundException {
        String[][] matriz = ficheiroParaMatriz("IMDV/IMDV.csv");

        for (int linha = 0; linha < matriz.length; linha++) {
            System.out.println("Filme: " + matriz[linha][1] + " | Avaliação: " + matriz[linha][2]);
        }
    }

    /**
     * Função para imprimir os catálogos gráficos
     */
    public static void ImprimirCatalogoGrafico() throws FileNotFoundException {

        Scanner input = new Scanner(System.in);

        int opcao;

        // cria-se um menu para o utilizador dizer qual catálogo gráfico quer ver
        do {
            System.out.println("\n------- Catálogo Gráfico -------");
            System.out.println("1 - Harry Potter");
            System.out.println("2 - Interstellar");
            System.out.println("3 - Lord of the Rings");
            System.out.println("4 - Star Wars");
            System.out.println("5 - Sair");
            System.out.print("\nInsira uma opção: ");
            opcao = input.nextInt();

            switch (opcao) {
                case 1:
                    copyRight("IMDV/CatalogoGrafico/HarryPotter.txt");
                    break;
                case 2:
                    copyRight("IMDV/CatalogoGrafico/Interstellar.txt");
                    break;
                case 3:
                    copyRight("IMDV/CatalogoGrafico/LordOfTheRings.txt");
                    break;
                case 4:
                    copyRight("IMDV/CatalogoGrafico/StarWars.txt");
                    break;
                case 5:
                    System.out.println("\nA sair do catálogo gráfico... ");
                    break;
                default:
                    System.out.println("\nOpção inválida!");
            }
        } while (opcao != 5);
    }

    /**
     * Função para ver qual é o estúdio com maior avaliação e imprimir o resultado na consola
     */
    public static void MelhorEstudio() throws FileNotFoundException {

        // o ficheiro é transformado em matriz para ser mais fácil a sua manipulação
        String[][] matriz = ficheiroParaMatriz("IMDV/IMDV.csv");

        // iniciamos as duas variáveis com valores impossiveis para poderem entrar no loop for e não causar interferencia com outros valores possíveis
        double notaMaisAlta = -1;
        int posicaoMelhorEstudio = -1;

        // vamos a cada linha ver qual é o estudio com a melhor avaliação
        for (int linha = 0; linha < matriz.length; linha++) {

            // transformamos o rating de string para double para podermos comparar
            double rating = Double.parseDouble(matriz[linha][2]);

            // se encontrarmos um rating maior que a notaMaisAlta, substitui o valor e registamos a linha do mesmo, e assim se repete pelo ciclo for
            if (rating > notaMaisAlta) {
                notaMaisAlta = rating;
                posicaoMelhorEstudio = linha;
            }
        }

        // ao encontrarmos a posicao da notaMaisAlta vamos á coluna com o nome do estudio e imprimimos o resultado
        String melhorEstudio = matriz[posicaoMelhorEstudio][5];
        System.out.println("Melhor estúdio: " + melhorEstudio + " com avaliação de " + notaMaisAlta);
    }

    /**
     * Função para ver qual é o estúdio com a menor avaliação e imprimir o resultado na consola
     */
    public static void PiorEstudio() throws FileNotFoundException {

        // o ficheiro é transformado em matriz para ser mais fácil a sua manipulação
        String[][] matriz = ficheiroParaMatriz("IMDV/IMDV.csv");


        // iniciamos as duas variáveis com valores impossíveis para poderem entrar no loop for e não causar interferencia com outros valores possíveis
        double notaMaisBaixa = 10;
        int posicaoPiorEstudio = -1;

        // vamos a cada linha ver qual é o estudio com a pior avaliação
        for (int linha = 0; linha < matriz.length; linha++) {

            // transformamos o rating de string para double para podermos comparar
            double rating = Double.parseDouble(matriz[linha][2]);

            // se encontrarmos um rating menor que a notaMaisBaixa, substitui o valor e registamos a linha do mesmo, e assim se repete pelo ciclo for
            if (rating < notaMaisBaixa) {
                notaMaisBaixa = rating;
                posicaoPiorEstudio = linha;
            }
        }

        // ao encontrarmos a posicao da notaMaisBaixa vamos á coluna com o nome do estudio e imprimimos o resultado
        String piorEstudio = matriz[posicaoPiorEstudio][5];
        System.out.println("Pior estúdio: " + piorEstudio + " com avaliação de " + notaMaisBaixa);
    }

    /**
     * Função para ver qual é a crítica mais recente (última linha do ficheiro dos filmes) e imprimir o resultado na consola
     */
    public static void CriticaMaisRecente() throws FileNotFoundException {

        // o ficheiro é transformado em matriz para ser mais fácil a sua manipulação
        String[][] matriz = ficheiroParaMatriz("IMDV/IMDV.csv");

        // a última linha será matriz.length-1, porque a primeira linha é o cabeçalho
        System.out.println("Última crítica: " + matriz[matriz.length - 1][0] + " " + matriz[matriz.length - 1][1] + " " + matriz[matriz.length - 1][2]);
    }

    /**
     * Função que mostra um quiz e no final mostra a pontuação (número de perguntas que acertou)
     */
    public static void Quiz() throws FileNotFoundException {

        // o ficheiro é transformado em matriz para ser mais fácil a sua manipulação
        String[][] matriz = ficheiroParaMatriz("IMDV/Quiz.csv");

        Scanner input = new Scanner(System.in);

        // inicializamos a variável pontuação a 0
        int pontuacao = 0;

        // for cada linha e coluna mostramos a pergunta e as opções com o número correspondente á coluna, esse número é que o utilizador deve colocar em "opcao"
        for (int linha = 0; linha < matriz.length; linha++) {
            for (int coluna = 0; coluna < matriz.length; coluna++) {
                System.out.println(coluna + " - " + matriz[linha][coluna]);
            }

            // em cada pergunta o utilizador deve colocar o número que pensa ser a opção correta
            String opcao;
            System.out.println("Opção correta (insira o número correspondente): ");
            opcao = input.nextLine();

            // as respostas corretas estão nesta coluna
            String resposta = matriz[linha][5];

            // por cada vez que o utilizador coloque um número igual á resposta (acerte a resposta), a pontuação aumenta
            if (resposta.equals(opcao)) {
                pontuacao++;
            }

        }
        // mostra ao utilizador a sua pontuação no final do quiz
        System.out.println("Pontuação: " + pontuacao);
    }

    /**
     * Função que dado um estúdio que o utilizador colocou, mostra as suas categorias e os respetivos filmes
     */
    public static void ImprimirCatalogoEstudio() throws FileNotFoundException {

        // o ficheiro é transformado em matriz para ser mais fácil a sua manipulação
        String[][] matriz = ficheiroParaMatriz("IMDV/IMDV.csv");

        Scanner input = new Scanner(System.in);

        // o utilizador escreve o nome do estúdio
        String estudio;
        System.out.print("\nEstúdio a pesquisar: ");
        estudio = input.nextLine();
        System.out.println("\n ******** " + estudio + " ******** ");

        // por cada linha onde encontremos o nome do estudio, guardamos o nome da categoria
        for (int linha = 0; linha < matriz.length; linha++) {
            if (matriz[linha][5].equalsIgnoreCase(estudio)) {
                String categoria = matriz[linha][7];

                // estava a aparecer várias vezes repetidas o nome das categorias e os respetivos filmes, então criei um boolean para certificar que apenas imprimo o nome da categoria uma vez
                boolean duplicado = false;

                // por todas as linhas anteriores a nossa, se virmos o nome do estudio e o nome da categoria juntos mais que uma vez, é um duplicado
                for (int i = 0; i < linha; i++) {
                    if (matriz[i][5].equalsIgnoreCase(estudio) && matriz[i][7].equalsIgnoreCase(categoria)) {
                        duplicado = true;
                    }
                }

                // se não for duplicado, imprimimos o nome da categoria e os respetivos filmes
                if (duplicado==false) {
                    System.out.println("_ " + categoria + " _");

                    // por cada linha da matriz, se o filme for do estudio e categoria pretendidos, imprimimos
                    for (int j = 0; j < matriz.length; j++) {
                        if (matriz[j][5].equalsIgnoreCase(estudio) && matriz[j][7].equalsIgnoreCase(categoria)) {
                            System.out.println(" - " + matriz[j][1]);
                        }
                    }
                    System.out.println(); // dá uma linha em branco entre as várias categorias para ficar visualmente mais agradável
                }
            }
        }
    }

    /**
     * Função que dado uma categoria que o utilizador colocou, mostra os seus estúdios e os respetivos filmes
     */
    public static void ImprimirCatalogoCategoria() throws FileNotFoundException {

        // o ficheiro é transformado em matriz para ser mais fácil a sua manipulação
        String[][] matriz = ficheiroParaMatriz("IMDV/IMDV.csv");

        Scanner input = new Scanner(System.in);

        // o utilizador escreve o nome da categoria
        String categoria;
        System.out.print("\nCategoria a pesquisar: ");
        categoria = input.nextLine();
        System.out.println("\n ******** " + categoria + " ******** ");

        // por cada linha onde encontremos o nome da categoria, guardamos o nome do estúdio
        for (int linha = 0; linha < matriz.length; linha++) {
            if (matriz[linha][7].equalsIgnoreCase(categoria)) {
                String estudio = matriz[linha][5];

                // criei um boolean para certificar que apenas imprimo o nome do estúdio uma vez
                boolean duplicado = false;

                // por todas as linhas anteriores a nossa, se virmos o nome do estudio e o nome da categoria juntos mais que uma vez, é um duplicado
                for (int i = 0; i < linha; i++) {
                    if (matriz[i][7].equalsIgnoreCase(categoria) && matriz[i][5].equalsIgnoreCase(estudio)) {
                        duplicado = true;
                    }
                }

                // se não for duplicado, imprimimos o nome do estudio e os respetivos filmes
                if (duplicado==false) {
                    System.out.println("_" + estudio + "_");

                    // por cada linha da matriz, se o filme for da categoria e estúdio pretendidos, imprimimos
                    for (int j = 0; j < matriz.length; j++) {
                        if (matriz[j][7].equalsIgnoreCase(categoria) && matriz[j][5].equalsIgnoreCase(estudio)) {
                            System.out.println(" - " + matriz[j][1]);
                        }
                    }

                    System.out.println(); // dá uma linha em branco entre as várias categorias para ficar visualmente mais agradável
                }
            }
        }

    }
}
