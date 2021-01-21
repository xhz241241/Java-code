import java.util.Arrays;

public class StringMethod {
    public static void main(String[] args) {
        String s = new String("hello world");
        String s2 = "zell";
        //1.实现方法 split, 能够指定分割符将字符串拆分成字符串数组(不必支持正则表达式)
        System.out.println(Arrays.toString(my_Split(s, 'w')));

        //2.实现方法 replace, 能够替换字符串中的某个部分
        System.out.println(my_Replace(s, 'l', 'h'));

        //3.实现方法 indexOf, 能够找出字符串子串存在的位置
        System.out.println(my_IndexOf(s, "wor"));

        //4.实现方法 contains, 能够判定字符串中是否包含子串
        System.out.println(my_contains(s, "wor"));

        //5.实现方法 compareTo, 能够实现按照字典序比较字符串大小
        System.out.println(my_compareTo(s, s2));
    }

    public static int my_compareTo(String s, String s2) {
        char[] ch1 = s.toCharArray();
        char[] ch2 = s2.toCharArray();
        int i = 0, j = 0;
        while(i < ch1.length && j < ch2.length){
            if(ch1[i] > ch2[j]){
                return 1;
            }
            else if(ch1[i] < ch2[j]){
                return -1;
            }else{
                i++;
                j++;
            }
        }
        return 0;
    }

    public static boolean my_contains(String s, String toSearch) {
        char[] ch1 = s.toCharArray();
        char[] ch2 = toSearch.toCharArray();
        for(int i = 0; i < ch1.length;){
            int j = 0;
            while(j < ch2.length && i < ch1.length){
                if(ch1[i] == ch2[j]){
                    i++;
                    j++;
                }else{
                    i++;
                    break;
                }
            }
            if(j == ch2.length){
                return true;
            }
        }
        return false;
    }

    public static int my_IndexOf(String s, String toSearch) {
        char[] ch1 = s.toCharArray();
        char[] ch2 = toSearch.toCharArray();
        for(int i = 0; i < ch1.length; i++){
            int j = 0;
            int tem = 0;
            while(j < ch2.length){
                if(ch1[i] == ch2[j]){
                    tem = i;
                    j++;
                    i++;
                }else{
                    break;
                }
            }
            if(j == ch2.length){
                return tem-ch2.length+1;
            }
        }
        return -1;
    }

    public static String my_Replace(String s, char target, char tochange) {
        String str = "";
        char[] ch = s.toCharArray();
        for(int i = 0; i < s.length(); i++){
            if(ch[i] == target){
                ch[i] = tochange;
            }
        }
        for(int i = 0; i < s.length(); i++){
            str = str + ch[i];
        }
        return str;
    }

    public static String[] my_Split (String s, char target) {
        String[] str = new String[2];
        char[] ch = s.toCharArray();
        String tem = "";
        int t = 0;
        int cur = 0;
        for(int i = 0; i < s.length(); i++){
            if(ch[i] == target){
                while(t < i){
                    tem = tem + ch[t];
                    t++;
                }
                str[cur] = tem;
                cur++;
                t = t + 1;
                tem = "";
            }
            else if(i == s.length()-1){
                while(t <= i){
                    tem = tem + ch[t];
                    t++;
                }
                str[cur] = tem;
            }
        }
        return str;
    }
}
