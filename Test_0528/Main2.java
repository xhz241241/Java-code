package Test_0528;

import java.util.*;

public class Main2{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String s1 = sc.nextLine();
            String toFind = sc.next();
            String[] s = s1.split(",");
            int i = 0;
            for(; i < s.length; i++){

                if(s[i].equals(toFind)){
                    System.out.println("Ignore");
                    return;
                }
                else if(s[i].equals("\"")){
                    StringBuffer stringbuffer = new StringBuffer();
                    stringbuffer.append(s[i].substring(1, s[i].length()-1));
                    if(toFind.equals(stringbuffer.toString())){
                        System.out.println("Ignore");
                        return;
                    }
                }
            }
            if(i == s.length){
                System.out.println("Important!");
            }
        }
    }
}
