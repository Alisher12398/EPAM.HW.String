package C12;

import java.util.Scanner;

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

public class Main {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        String st=sc.nextLine();
        StringBuffer[] sb=new StringBuffer[st.length()];
        char[] charArray=st.toCharArray();

        sb[0]=new StringBuffer("");
        sb[0].append(charArray);
        System.out.println(sb[0]);
        for (int j=1; j<st.length(); j++) {
            sb[j]=new StringBuffer("");
            char temp=charArray[st.length()-1];
            char temp_current;
            char temp_prev=charArray[0];

            for (int i=1; i<st.length(); i++){
                 temp_current=charArray[i];
                 charArray[i]=temp_prev;
                 temp_prev=temp_current;
            }
            charArray[0]=temp;
            sb[j].append(charArray);
            System.out.println(sb[j]);
        }
    }
}
