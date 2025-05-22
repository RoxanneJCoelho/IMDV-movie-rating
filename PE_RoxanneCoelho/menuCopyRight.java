package PE_RoxanneCoelho;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class menuCopyRight {
    public static void copyRight(String ficheiro) throws FileNotFoundException {
        File ficheiroCopyright = new File(ficheiro);
        Scanner sc = new Scanner(ficheiroCopyright);

        while (sc.hasNextLine()) {
            String linha = sc.nextLine();
            System.out.println(linha);
        }
    }
}

