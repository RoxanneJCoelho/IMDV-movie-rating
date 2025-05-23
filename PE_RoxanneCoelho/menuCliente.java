package PE_RoxanneCoelho;

import java.io.FileNotFoundException;
import java.util.Objects;
import java.util.Scanner;

import static PE_RoxanneCoelho.menuCopyRight.*;
import static PE_RoxanneCoelho.funcoesAdicionais.*;


public class menuCliente {
    public static void NovoRegistro() {

        Scanner input = new Scanner(System.in);

        String nome;
        int contacto;
        String email;

        System.out.println("------- Registar Utilizador -------");
        System.out.print("Insira Nome: ");
        nome = input.nextLine();

        System.out.print("Insira Contacto: ");
        contacto = input.nextInt();

        System.out.print("Insira Email: ");
        email = input.next();

        System.out.println("Utilizador Inserido com Sucesso: " + nome + " | " + contacto + " | " + email);

    }
    public static void ImprimirCatalogo() {

    }
    public static void ImprimirCatalogoGrafico() throws FileNotFoundException {

        Scanner input = new Scanner(System.in);

        int opcao;

        do {
            System.out.println("------- Catálogo Gráfico -------");
            System.out.println("1 - Harry Potter");
            System.out.println("2 - Interstellar");
            System.out.println("3 - Lord of the Kings");
            System.out.println("4 - Star Wars");
            System.out.println("5 - Sair");
            System.out.println("Insira uma opção: ");
            opcao = input.nextInt();

            switch (opcao){
                case 1:
                    copyRight("IMDV/CatalogoGrafico/HarryPotter.txt");
                    break;
                case 2:
                    copyRight("IMDV/CatalogoGrafico/Interstellar.txt");
                    break;
                case 3:
                    copyRight("IMDV/CatalogoGrafico/LordOfTheKings.txt");
                    break;
                case 4:
                    copyRight("IMDV/CatalogoGrafico/StarWars.txt");
                    break;
                case 5:
                    System.out.println("A sair do catálogo gráfico... ");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao!=5);

    }
    public static void MelhorEstudio() throws FileNotFoundException {
        String[][] matriz = ficheiroParaMatriz("IMDV/IMDV.csv");

        double notaMaisAlta = -1;
        int posicaoMelhorEstudio = -1;


        for (int linha = 0; linha < matriz.length; linha++) {
            double rating = Double.parseDouble(matriz[linha][2]);
            if (rating > notaMaisAlta) {
                notaMaisAlta = rating;
                posicaoMelhorEstudio = linha;
            }

        }
        String melhorEstudio = matriz[posicaoMelhorEstudio][5];
        System.out.println("Melhor estúdio: " + melhorEstudio + " com avaliação de " + notaMaisAlta);


    }

    public static void PiorEstudio() throws FileNotFoundException {
        String[][] matriz = ficheiroParaMatriz("IMDV/IMDV.csv");

        double notaMaisBaixa = 10;
        int posicaoPiorEstudio = 0;


        for (int linha = 0; linha < matriz.length; linha++) {
            double rating = Double.parseDouble(matriz[linha][2]);
            if (rating < notaMaisBaixa) {
                notaMaisBaixa = rating;
                posicaoPiorEstudio = linha;
            }

        }
        String piorEstudio = matriz[posicaoPiorEstudio][5];
        System.out.println("Pior estúdio: " + piorEstudio + " com avaliação de " + notaMaisBaixa);
    }
    public static void CriticaMaisRecente() throws FileNotFoundException {
        String[][] matriz = ficheiroParaMatriz("IMDV/IMDV.csv");
        System.out.println("Última crítica: " + matriz[matriz.length-1][0] + " " + matriz[matriz.length-1][1] + " " + matriz[matriz.length-1][2]);

    }
    public static void Quiz() throws FileNotFoundException {
        String[][] matriz = ficheiroParaMatriz("IMDV/Quiz.csv");
        Scanner input = new Scanner(System.in);
        int pontuacao = 0;
        for (int linha = 0; linha < matriz.length;  linha++){
            for (int coluna = 0; coluna < matriz.length; coluna++){
                System.out.println(matriz [linha][coluna]);
            }

            String opcao;
            System.out.println("Opção correta: ");
            opcao = input.nextLine();

            String resposta = matriz[linha][5];


            if(resposta.equals(opcao)){
                pontuacao++;
            }

        }
        System.out.println("Pontuação: " + pontuacao);
    }
    public static void ImprimirCatalogoEstudio() {

        Scanner input = new Scanner(System.in);

        String estudio;
        System.out.println("Estúdio a pesquisar: ");
        estudio = input.nextLine();





        System.out.println("catalogo estudio");
    }
    public static void ImprimirCatalogoCategoria() {
        System.out.println("catalogo categoria");
    }
}
