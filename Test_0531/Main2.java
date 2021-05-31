package Test_0531;
//mkdir

import java.util.*;

public class Main2{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            sc.nextLine();
            String[] s = new String[n];
            for(int i = 0; i < n; i++){
                s[i] = sc.nextLine();
            }
            Arrays.sort(s);
            List<String> list = new ArrayList<>();
            for(int i = 1; i < n; i++){
                if(!s[i].startsWith(s[i-1] + "/")){
                    list.add(s[i-1]);
                }
            }
            list.add(s[n-1]);
            for(int i = 0; i < list.size(); i++){
                System.out.println("mkdir -p " + list.get(i));
            }
            System.out.println();
        }
    }
}