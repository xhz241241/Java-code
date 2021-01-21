import java.util.Arrays;

class A{
   public A(String s){
        System.out.println(s);
    }
}

public class Day5 extends A {
//    String str = new String("hello");
//    transient String str2;//用transient标记了的实例变量不参与序列化的过程

    public Day5 (String s) {
        super("c");
        System.out.print(s);
    }
    public static void main(String[] args) {
        new Day5("b");

//        Day5 d = new Day5();
//        d.channge(d.str);
//        System.out.println(d.str);//hello 字符串无法被修改
//        int[] arr = {1, 2, 3, 4};
//        System.out.println(containsDuplicate(arr));
//
//        String name = "alex";
//        String typed = "aaleexa";
//        System.out.println(isLongPressedName(name, typed));
//        String s = "abcdef";
//        String s2 = new String(s);
//        if(s.equals(s2)){
//            System.out.println("equals");
//        }
//        if(s == s2){
//            System.out.println("==");
//        }
    }

    public static boolean isLongPressedName(String name, String typed) {
        char[] ch1 = name.toCharArray();
        char[] ch2 = typed.toCharArray();
        int i = 0, j = 0;
        //此处不能加i < ch1.length 避免name遍历完了, 但typed没有完, 后面还有不是长按出来的字母
        while(j < ch2.length){
            if(i < ch1.length && ch1[i] == ch2[j]){
                i++;
                j++;
            }
            //如果j是第一个元素, 就和name不相等, 那就直接返回false
            //若j不是第一个元素, 则判断它和j-1是否相等, 若相等则为长按出来的字母, 若不等也返回false
            else if(j > 0 && ch2[j] == ch2[j-1]){
                j++;
            }else{
                return false;
            }
        }
        //如果name遍历完毕并且typed也遍历完毕, i遍历到了最后一个字母, 说明name里面的字母全部合法
        if(i == ch1.length){
            return true;
        }
        return  false;
    }

    public static boolean containsDuplicate(int[] arr) {
        Arrays.sort(arr);
        for(int i = 0; i < arr.length-1; i++){
            if(arr[i] == arr[i+1]){
                return true;
            }
        }
        return false;
    }

    public void channge(String str){
        str = "abcd";
    }
}
