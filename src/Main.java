import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        File myFile = new File("Stih.txt");
        Scanner sc = null;
        try {
            sc = new Scanner(myFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        StringBuffer sb = new StringBuffer();
        while (sc.hasNext()) {
            sb.append(sc.nextLine());
        }

        sc.close();

        

            String[] str = sb.toString().split(" |/n|,");
            for (String s : str){
            System.out.println(s);
        }
    }
}
