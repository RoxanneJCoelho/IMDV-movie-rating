package PE_RoxanneCoelho;

import java.io.FileNotFoundException;
import java.util.Scanner;

import static PE_RoxanneCoelho.menuAdmin.*;
import static PE_RoxanneCoelho.menuCopyRight.*;
import static PE_RoxanneCoelho.menuCliente.*;
import static PE_RoxanneCoelho.loginMenuAdmin.*;

public class menuPrincipal {

    public static void menuAdmin() {

        Scanner input = new Scanner(System.in);

        int opcaoMenuAdmin;

        do {
            System.out.println("------ Bem vind@ ao Menu Admin do IMDV ------");
            System.out.println("1 - Consulta de ficheiros");
            System.out.println("2 - Total de Ratings");
            System.out.println("3 - Imprimir estúdios");
            System.out.println("4 - Sair");

            System.out.print("Insira uma opção: ");
            opcaoMenuAdmin = input.nextInt();

            switch (opcaoMenuAdmin) {
                case 1:
                    ConsultaFicheiro();
                    break;
                case 2:
                    Ratings();
                    break;
                case 3:
                    Estudios();
                    break;
                case 4:
                    System.out.println("A sair do programa...");
                    break;
                default:
                    System.out.println("Opção Inválida!");
            }

        } while (opcaoMenuAdmin != 4);

    }

    public static void menuCliente() {

        Scanner input = new Scanner(System.in);

        int opcaoMenuCliente;

        do {
            System.out.println("------ Bem vind@ ao Menu Cliente do IMDV ------");
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

            System.out.print("Insira uma opção: ");
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


    public static void primeiroMenu() throws FileNotFoundException {

        Scanner input = new Scanner(System.in);

        int opcaoPrimeiroMenu;

        do {
            System.out.println("------ Bem vind@ ao IMDV ------");
            System.out.println("1 - Menu Admin");
            System.out.println("2 - Menu Cliente");
            System.out.println("3 - Sair");

            System.out.print("Insira uma opção: ");
            opcaoPrimeiroMenu = input.nextInt();

            switch (opcaoPrimeiroMenu) {
                case 1:
                    loginAdmin();
                    break;
                case 2:
                    menuCliente();
                    break;
                case 3:
                    System.out.println("A sair do programa...");
                    copyRight("IMDV/IMDV_Copyright.txt");
                    break;
                default:
                    System.out.println("Opção Inválida!");
            }

        } while (opcaoPrimeiroMenu != 3);

    }


    public static void main(String[] args) throws FileNotFoundException {
        primeiroMenu();

    }

}
