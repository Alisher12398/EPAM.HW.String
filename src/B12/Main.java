package B12;

import java.io.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
    Халыкбаев Алишер
    String, B12
    Из текста удалить все слова заданной длины, начинающиеся на согласную букву.
*/
public class Main {
    public static void main(String[] args) {


        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        sc.close();

        try {
            FileInputStream fs = new FileInputStream("Stih.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(fs));
            String line;

            while ((line=br.readLine()) != null){

                String sbLowercase=line.toLowerCase();
                String[] str = sbLowercase.split(" ");

                Pattern pattern = Pattern.compile("^[йцкнгшщзхфвпрлджчсмтб]");
                //FileWriter writer = new FileWriter("B12.txt", false);



                for (String word : str) {
                    Matcher matcher = pattern.matcher(word);
                    if (!matcher.find() && word.length()!=n) {

                        System.out.println(word);
                    }
                }
               // writer.write("\n");
            }
        }catch (IOException e){

        }



    }
}
