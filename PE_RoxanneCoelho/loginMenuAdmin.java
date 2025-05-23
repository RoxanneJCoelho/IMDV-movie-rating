package PE_RoxanneCoelho;

import java.io.FileNotFoundException;
import java.util.Scanner;

import static PE_RoxanneCoelho.funcoesAdicionais.*;
import static PE_RoxanneCoelho.menuPrincipal.*;

public class loginMenuAdmin {

    public static boolean validacaoLogin(String[][] matriz, String utilizador, String password)  {
        for (int linha = 0; linha < matriz.length; linha++) {
            if (utilizador.equals(matriz[linha][0])  && password.equals(matriz[linha][1])) {
                return true;
            }
        }
        return false;

    }
    public static void loginAdmin() throws FileNotFoundException {

        Scanner input = new Scanner(System.in);

        String utilizador;
        String password;
        boolean login = true;
        String [][] matriz = ficheiroParaMatriz("IMDV/IMDV_AdminLogin.csv");

        do {
            System.out.println("Insira o seu nome de utilizador: ");
            utilizador = input.next();
            System.out.println("Insira a password: ");
            password = input.next();

            login = validacaoLogin(matriz, utilizador, password);

            if(login==false){
                System.out.println("Nome e/ou utilizador incorretos. Tente novamente.");
            }

        } while (login==false);
        System.out.println("Login realizado com sucesso!");
        menuAdmin();

    }

}

