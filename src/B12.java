import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
    Халыкбаев Алишер
    String, B12
    Из текста удалить все слова заданной длины, начинающиеся на согласную букву.
*/
public class B12 {
    public static void main(String[] args) {

        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        sc.close();
        ArrayList<String> answerArray=new ArrayList<>();

        try {
            FileInputStream fs = new FileInputStream("Text2.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(fs));
            String line;

            while ((line=br.readLine()) != null){

                String[] str = line.split(" ");

                Pattern pattern = Pattern.compile("^[йцкнгшщзхфвпрлджчсмтбЙЦКНГШЩЗХФВПРЛДЖЧСМТБ]");
                //Pattern pattern2 = Pattern.compile(",$");

                for (String word : str) {

                    Matcher matcher = pattern.matcher(word);
                    //Matcher matcher2 = pattern2.matcher(word);
                    boolean isWord=false;
                    if (matcher.find()){
                        if ((word.charAt(word.length()-1)!=',' || word.charAt(word.length()-1)!='.') && word.length()==n){
                            isWord=true;
                        }
                        //word.charAt(word.length()-1)!=','
                        if ((word.charAt(word.length()-1)==',' || word.charAt(word.length()-1)!=',')&& word.length()==n+1){
                            isWord=true;
                        }
                    }

                    if (!isWord){
                        answerArray.add(word + " ");
                    }
                }
                answerArray.add("\n");
            }

            for (int i=0; i<answerArray.size();  i++){
                System.out.print(answerArray.get(i));
            }


        }catch (IOException e){
            System.out.println("Ошибка");
        }

    }
}
