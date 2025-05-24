package PE_RoxanneCoelho;

import java.io.FileNotFoundException;
import java.util.Scanner;

import static PE_RoxanneCoelho.funcoesAdicionais.*;
import static PE_RoxanneCoelho.menuPrincipal.*;

public class loginMenuAdmin {

    /**
     * Função que determina se o login foi válido ou não
     *
     * @param matriz, utilizador, password (a matriz com o nome de utilizador e a password)
     * @return true se o login for válido (o utilizador e a password são da mesma linha) || false se o login for inválido
     */
    public static boolean validacaoLogin(String[][] matriz, String utilizador, String password) {
        for (int linha = 0; linha < matriz.length; linha++) {
            if (utilizador.equals(matriz[linha][0]) && password.equals(matriz[linha][1])) {
                return true;
            }
        }
        return false;
    }

    /**
     * Função do login do admin
     *
     * @param caminho Caminho para o ficheiro a ser carregado
     * @throws FileNotFoundException Caso o ficheiro não seja encontrado
     */
    public static void loginAdmin(String caminho) throws FileNotFoundException {

        Scanner input = new Scanner(System.in);

        String utilizador;
        String password;
        boolean login = true;
        String[][] matriz = ficheiroParaMatriz("IMDV/IMDV_AdminLogin.csv");

        // pede ao utilizador para escrever o nome e password

        do {
            System.out.print("\nInsira o seu nome de utilizador: ");
            utilizador = input.next();
            System.out.print("\nInsira a password: ");
            password = input.next();

            // valida o login
            login = validacaoLogin(matriz, utilizador, password);

            // se o login for inválido, repete o loop até acertar
            if (login == false) {
                System.out.println("\nNome e/ou utilizador incorretos. Tente novamente.");
            }

        } while (login == false);

        // quando o login for validado, entra no menuAdmin()
        System.out.println("\nLogin realizado com sucesso!");
        menuAdmin(caminho);

    }

}

