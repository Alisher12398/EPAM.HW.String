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

        for (int i=0; i<sb.length();i++) {
            String a=" ";
            if (sb.charAt(i)==('.')){
                //sb.replace(i,i+1, a);
                sb.deleteCharAt(i);
                sb.insert(i,' ');
            }
            if (sb.charAt(i)==(',') && sb.charAt(i+1)=='\n'){
                sb.deleteCharAt(i);
                sb.insert(i,' ');
            }

            if (sb.charAt(i)==(',')) {
                sb.deleteCharAt(i);
            }
        }
            String[] str = sb.toString().split(" ");


            for (String s : str){
            System.out.println(s);
        }
    }
}
