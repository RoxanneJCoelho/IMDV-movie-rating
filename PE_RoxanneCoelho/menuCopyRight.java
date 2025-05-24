package PE_RoxanneCoelho;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class menuCopyRight {
    /**
     * Função para ler um ficheiro e imprimir-lo na consola
     *
     * @param ficheiro Caminho para o ficheiro a ser carregado
     * @throws FileNotFoundException Caso o ficheiro não seja encontrado
     */
    public static void copyRight(String ficheiro) throws FileNotFoundException {

        // carregar e ler o ficheiro
        File ficheiroCopyright = new File(ficheiro);
        Scanner sc = new Scanner(ficheiroCopyright);

        // enquanto o ficheiro tiver linhas, ele imprime essas linhas uma a uma
        while (sc.hasNextLine()) {
            String linha = sc.nextLine();
            System.out.println(linha);
        }
    }
}

