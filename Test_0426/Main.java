package Test_0426;
//参数解析


import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String s = sc.nextLine();
            //count表示空格的个数
            int count = 0;
            for(int i = 0; i < s.length();i++){
                //遇到双引号时 需要一直遍历直到遇到第二个双引号
                if(s.charAt(i) == '"'){
                    //此处需要先进行i++跳过双引号
                    //不然可能无法判断下面的情况
                    // ""
                    i++;
                    while(s.charAt(i) != '"'){
                        i++;
                    }
                }
                if(s.charAt(i) == ' '){
                    count++;
                }
            }
            //参数的个数就是空格+1
            System.out.println(count+1);

            int flag = 1;
            for(int i = 0; i < s.length(); i++){
                //当前字符是双引号(需要变更flag的内容)
                if(s.charAt(i) == '"'){
                    flag ^= 1;
                }
                //当前字符不是双引号也不是空格(需打印)
                if(s.charAt(i) != ' ' && s.charAt(i) != '"'){
                    System.out.print(s.charAt(i));
                }
                //当前字符是空格但在双引号里面(需打印)
                if(s.charAt(i) == ' ' && flag == 0){
                    System.out.print(s.charAt(i));
                }
                //当前字符是空格但不在双引号里面(需换行)
                if(s.charAt(i) == ' ' && flag == 1){
                    System.out.println();
                }
            }
        }
    }
}




//import java.util.*;
//
//public class Main{
//    public static void main(String[] args){
//        Scanner sc = new Scanner(System.in);
//        while(sc.hasNext()){
//            String s = sc.nextLine();
//            ArrayList list = help(s);
//            System.out.println(list.size());
//            for(int i = 0; i < list.size(); i++){
//                System.out.println(list.get(i));
//            }
//        }
//    }
//
//    public static ArrayList<StringBuilder> help(String s){
//        ArrayList res = new ArrayList();
//        char[] ch = s.toCharArray();
//        int i= 0;
//        boolean flag = true;
//        while(flag){
//            //当前字符是双引号 需要把两个双引号之间的内容全部添加到顺序表中
//            //不包括双引号
//            if(ch[i] == '"'){
//                StringBuilder sb = new StringBuilder();
//                i++;
//                while(true){
//                    sb.append(ch[i]);
//                    i++;
//                    if(ch[i] == '"'){
//                        res.add(sb);
//                        i++;
//                        break;
//                    }
//                }
//            }else{
//                //当前字符不是双引号 是普通字符
//                //此时把空格之前的内容全部添加到顺序表中
//                StringBuilder sb = new StringBuilder();
//                while(true){
//                    //还需要判断一上来就是空格的情况
//                    if(ch[i] == ' '){
//                        i++;
//                    }
//                    sb.append(ch[i]);
//                    i++;
//                    //此处还需要小心数组下标越界的情况
//                    //再次添加字符之前需要判断下标是否越界
//                    if(i == ch.length){
//                        res.add(sb);
//                        flag = false;
//                        break;
//                    }
//                    if(ch[i] == ' '){
//                        res.add(sb);
//                        i++;
//                        break;
//                    }
//                }
//            }
//        }
//        return res;
//    }
//}