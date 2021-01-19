import java.util.Arrays;

public class String_Test {
    public static void main(String[] args) {
        String str = "abcde";
        String str2 = "FGHIjk";

//一. 字符串的比较
        //1.equals 比较两个字符串内容是否相等(区分大小写)
        System.out.println(str.equals(str2));//F

        //2.equalsIgnoreCase 比较两个字符换是否相等(不区分大小写)
        System.out.println(str.equalsIgnoreCase(str2));//F

        //3.compareTo 比较两个字符串的大小关系-通过字典序(返回的是大于0或小于0或等于0的数字)
        System.out.println(str.compareTo(str2));//-5

//二. 字符串的查找
        //1.contains 判断str中是否含有str2这个子字符串
        System.out.println(str.contains(str2));//F

        //2.indexOf 查找输入的字符串的位置, 并返回位置, 若没有返回-1
        System.out.println(str.indexOf("c"));//2

        //3.indexOf 从输入的位置查找所输入的字符串的位置
        System.out.println(str.indexOf("d", 2));//3

        //4.lastIndexOf 从后向前查找字符串的位置
        System.out.println(str.lastIndexOf("a"));//0

        //5.lastIndexOf 从指定位置从后向前查找字符串的位置
        System.out.println(str.lastIndexOf("a", 2));//0

        //6.startsWith 判断字符串是否以指定字符串开头
        System.out.println(str.startsWith("f"));//F

        //7.startsWith 从指定位置判断字符串是否以指定字符串开头
        System.out.println(str.startsWith("ab", 0));//T

        //8.endsWith 判断字符串是否以指定字符串结尾
        System.out.println(str.endsWith("f"));//F

//三. 字符串的替换
        //1.replaceAll 将字符串中所有的 a 替换成 f
        System.out.println(str.replaceAll("a", "f"));//fbcde

        //2.replaceFirst 将字符串中第一个 a 替换成 f
        System.out.println(str.replaceFirst("a", "f"));//fbcde

//四. 字符串的拆分
        //1.split 将字符串以 c 为分隔符拆分, 并返回一个字符串数组
        System.out.println(Arrays.toString(str.split("c")));//[ab, de]

        //2.split 将字符串以 b 为分隔符拆分, 并且数组长度最大为 2
        System.out.println(Arrays.toString(str.split("b", 2)));//[a, cde]

//五. 字符串的截取
        //1.substring 从 2 截取到字符串结尾
        System.out.println(str.substring(2));//cde

        //2.substring 从 2 截取到 4 (包括2不包括4 [2, 3))
        System.out.println(str.substring(2, 4));//cd

//六. 字符串的其他方法
        //1.toUpperCase 将字符串中的小写转成大写
        System.out.println(str.toUpperCase());//ABCDE

        //2.toLowerCase 将字符串中的小写字母转成大写
        System.out.println(str2.toLowerCase());//fghijk

        //3.intern 将字符串放入字符串常量池中, 方便之后使用
        System.out.println(str2.intern());//不返回任何值

//七. StringBuffer的各种用法(和StringBulider类似, 但Buffer更为安全)
        //1.apend 和拼接类似, 将制定字符追加到原字符串上(原字符串可以为空)
        StringBuffer sb = new StringBuffer("hel");
        sb.append("lo");
        System.out.println(sb);//hello

        //2.reverse 将字符串整个反转
        System.out.println(sb.reverse());//olleh

        //3.delete 删除指定范围内的字符串(包括2不包括4 [2, 4))
        System.out.println(sb.delete(2, 4));//heo

        //4.insert 在指定位置插入所输入的字符串
        System.out.println(sb.insert(2, "world"));//heworldllo

    }
}
