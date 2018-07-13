import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        char[] vowels= {'у', 'е', 'ы', 'а', 'о', 'э', 'я', 'и', 'ё', 'ю'};
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

            if (sb.charAt(i)==('.')){
                sb.deleteCharAt(i);
                sb.insert(i,' ');

            }
            if (sb.charAt(i)==(',')){
                sb.deleteCharAt(i);
                if (sb.charAt(i)!=(' ')){
                    sb.insert(i,' ');
                }
            }
        }

            String sbLowercase=sb.toString().toLowerCase();
            String[] str = sbLowercase.split(" ");



            for (String s : str){
            System.out.println(s);
        }
    }
}
