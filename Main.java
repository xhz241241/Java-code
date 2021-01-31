import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            //abcqweracb
            String str = sc.next();
            char[] ch = str.toCharArray();
            StringBuffer sb = new StringBuffer();
            for(int i = 0; i < ch.length; i++){
                String tem = sb.toString();
                if(!tem.contains(ch[i]+"")){
                    sb.append(ch[i]);
                }
            }
            System.out.println(sb);
        }
    }
}
