package C12;
import java.util.Scanner;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;
/*
Алгоритм Барроуза — Уиллера для сжатия текстов основывается на преобразовании
Барроуза — Уиллера. Оно производится следующим образом:
для слова рассматриваются все его циклические сдвиги, которые затем сортируются
в алфавитном порядке, после чего формируется слово из последних
символов отсортированных циклических сдвигов. К примеру, для слова
JAVA циклические сдвиги — это JAVA, AVAJ, VAJA, AJAV. После сортировки
по алфавиту получим AJAV, AVAJ, JAVA, VAJA. Значит, результат
преобразования — слово VJAA. Реализовать программно преобразование
Барроуза — Уиллера для данного слова.
 */

public class Main implements Comparator<StringBuffer>{

    @Override public int compare(StringBuffer s1, StringBuffer s2)
    {
        return s1.toString().compareTo(s2.toString());
    }

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        String inputString=sc.nextLine();
        sc.close();
        
        StringBuffer[] shiftsOfInputString=new StringBuffer[inputString.length()];
        char[] charArray=inputString.toCharArray();
        Set<StringBuffer> sortedSet = new TreeSet<>(new Main());

        shiftsOfInputString[0]=new StringBuffer();
        shiftsOfInputString[0].append(charArray);
        sortedSet.add(shiftsOfInputString[0]);

        for (int j=1; j<inputString.length(); j++) {
            shiftsOfInputString[j]=new StringBuffer();
            char temp=charArray[inputString.length()-1];
            char temp_current;
            char temp_prev=charArray[0];

            for (int i=1; i<inputString.length(); i++){
                 temp_current=charArray[i];
                 charArray[i]=temp_prev;
                 temp_prev=temp_current;
            }
            charArray[0]=temp;
            shiftsOfInputString[j].append(charArray);
            sortedSet.add(shiftsOfInputString[j]);
        }

        StringBuffer[] ans2=sortedSet.toArray(new StringBuffer[sortedSet.size()]);

        for (int i=0; i<inputString.length(); i++){
            System.out.print(ans2[i].charAt(inputString.length()-1));
        }

    }
}
