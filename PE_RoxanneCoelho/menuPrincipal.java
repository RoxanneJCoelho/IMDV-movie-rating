package PE_RoxanneCoelho;

import java.io.FileNotFoundException;
import java.util.Scanner;

import static PE_RoxanneCoelho.menuAdmin.*;
import static PE_RoxanneCoelho.menuCopyRight.*;
import static PE_RoxanneCoelho.menuCliente.*;
import static PE_RoxanneCoelho.loginMenuAdmin.*;

public class menuPrincipal {

    /**
     * Função para imprimir o menuAdmin e invocar as suas respetivas funções
     *
     * @param caminho Caminho para o ficheiro a ser carregado
     * @throws FileNotFoundException Caso o ficheiro não seja encontrado
     */
    public static void menuAdmin(String caminho) throws FileNotFoundException {

        Scanner input = new Scanner(System.in);

        int opcaoMenuAdmin;

        // mostra o menu até o utilzador carregar em 4 (sair)

        do {
            System.out.println("\n------ Bem vind@ ao Menu Admin do IMDV ------");
            System.out.println("1 - Consulta de ficheiros");
            System.out.println("2 - Total de Ratings");
            System.out.println("3 - Imprimir estúdios");
            System.out.println("4 - Sair");

            System.out.print("\nInsira uma opção: ");
            opcaoMenuAdmin = input.nextInt();

            switch (opcaoMenuAdmin) {
                case 1:
                    ConsultaFicheiro(caminho);
                    break;
                case 2:
                    Ratings(caminho);
                    break;
                case 3:
                    Estudios();
                    break;
                case 4:
                    System.out.println("\nA sair do programa...");
                    break;
                default:
                    System.out.println("\nOpção Inválida!");
            }

        } while (opcaoMenuAdmin != 4);

    }

    /**
     * Função para imprimir o menuCliente e invocar as suas respetivas funções
     *
     * @throws FileNotFoundException Caso o ficheiro não seja encontrado
     */

    public static void menuCliente() throws FileNotFoundException {

        Scanner input = new Scanner(System.in);

        int opcaoMenuCliente;

        // mostra o menu até o utilzador carregar em 10 (sair)

        do {
            System.out.println("\n------ Bem vind@ ao Menu Cliente do IMDV ------");
            System.out.println("1 - Novo Registro");
            System.out.println("2 - Imprimir Catálogo");
            System.out.println("3 - Imprimir Catálogo Gráfico");
            System.out.println("4 - Imprimir Melhor Estúdio");
            System.out.println("5 - Imprimir Pior Estúdio");
            System.out.println("6 - Imprimir Crítica Mais Recente");
            System.out.println("7 - Quiz");
            System.out.println("8 - Imprimir Catálogo por Estúdio");
            System.out.println("9 - Imprimir Catálogo por Categoria");
            System.out.println("10 - Sair");

            System.out.print("\nInsira uma opção: ");
            opcaoMenuCliente = input.nextInt();

            switch (opcaoMenuCliente) {
                case 1:
                    NovoRegistro();
                    break;
                case 2:
                    ImprimirCatalogo();
                    break;
                case 3:
                    ImprimirCatalogoGrafico();
                    break;
                case 4:
                    MelhorEstudio();
                    break;
                case 5:
                    PiorEstudio();
                    break;
                case 6:
                    CriticaMaisRecente();
                    break;
                case 7:
                    Quiz();
                    break;
                case 8:
                    ImprimirCatalogoEstudio();
                    break;
                case 9:
                    ImprimirCatalogoCategoria();
                    break;
                case 10:
                    System.out.println("A sair do programa...");
                    break;
                default:
                    System.out.println("Opção Inválida!");
            }

        } while (opcaoMenuCliente != 10);

    }

    /**
     * Função para imprimir o primeiro Menu que aparece ao executar o programa e invocar as suas respetivas funções
     *
     * @throws FileNotFoundException Caso o ficheiro não seja encontrado
     */
    public static void primeiroMenu() throws FileNotFoundException {

        String caminho = "IMDV/IMDV.csv";
        Scanner input = new Scanner(System.in);

        int opcaoPrimeiroMenu;

        // mostra o menu até o utilzador carregar em 3 (sair)

        do {
            System.out.println("\n------ Bem vind@ ao IMDV ------");
            System.out.println("1 - Menu Admin");
            System.out.println("2 - Menu Cliente");
            System.out.println("3 - Sair");

            System.out.print("\nInsira uma opção: ");
            opcaoPrimeiroMenu = input.nextInt();

            switch (opcaoPrimeiroMenu) {
                case 1:
                    loginAdmin(caminho);
                    break;
                case 2:
                    menuCliente();
                    break;
                case 3:
                    System.out.println("\nA sair do programa...");
                    copyRight("IMDV/IMDV_Copyright.txt"); // mostra o ficheiro do copyright com o nome da desenvolvedora deste programa
                    break;
                default:
                    System.out.println("\nOpção Inválida!");
            }

        } while (opcaoPrimeiroMenu != 3);

    }

    // executa o programa
    public static void main(String[] args) throws FileNotFoundException {
        primeiroMenu();

    }

}
