package Test_0522;
//最难的问题

import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String s = sc.nextLine();
            char[] code = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
                    'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
            char[] letter = {'V', 'W', 'X', 'Y', 'Z', 'A', 'B', 'C', 'D',
                    'E', 'F', 'G', 'H', 'I', 'J','K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U'};
            StringBuffer stringbuffer = new StringBuffer();
            for(int i = 0; i < s.length(); i++){
                if(s.charAt(i) == ' '){
                    stringbuffer.append(" ");
                }
                else{
                    for(int j = 0; j < code.length; j++){
                        if(s.charAt(i) == code[j]){
                            stringbuffer.append(letter[j]);
                        }
                    }
                }
            }
            System.out.println(stringbuffer.toString());
        }
    }
}