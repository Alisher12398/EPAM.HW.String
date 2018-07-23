package A12;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/*
    Халыкбаев Алишер
    String, A12
    В стихотворении найти количество слов, начинающихся и заканчивающихся гласной буквой.
*/
public class Main {

    public static void main(String[] args) {

        int n=0;

        try{

            FileInputStream fs = new FileInputStream("Stih.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(fs));
            String line;

            while ((line = br.readLine()) != null){

                String sbLowercase=line.toLowerCase();
                String[] str = sbLowercase.split("[ —,;:.!?]");

                Pattern pattern = Pattern.compile("^[уеёыаоэяию].*[уеёыаоэяию]$");

                for (String word : str) {
                   Matcher matcher = pattern.matcher(word);
                    if (matcher.find()) {
                        n++;
                        System.out.println(word);
                    }
                }
            }

            System.out.println(n);
        }catch (IOException e){
            System.out.println("Ошибка");
        }

    }
}
