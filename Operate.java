public class Operate {
    public static void main(String[] args){
       //int 转成 String
        int i = 4;
        System.out.println("hello " + i);
        //String 转成 int
        String str = "100";
        int num = Integer.parseInt(str);
        System.out.println(num);
        //逻辑运算符
        // && 逻辑与 指要两个操作数都为true则为true 否则为false
        int a = 5;
        int b = 10;
        int c = 15;
        System.out.println(a < b && b < c);//输出true
        System.out.println(a > b && b > c);//输出false
        // || 逻辑或 指两个操作数有一个true则为true 否则为false
        int d = 5;
        int e = 10;
        int f = 15;
        System.out.println(d > e || e < f);//输出true
        System.out.println(d > e || e > f);//输出false
        //这两个逻辑运算符都遵循"短路求值" 即 && 中发现一个false则后面的操作数不予求值 直接false

        //位运算符
        // & 按位与 指两个比特位都是1 则为1 否则为0
        int g = 10;
        int h = 20;
        System.out.println(g & h);//因为 10 和 20 的比特位中的 1 都不在同一位置上 所以 & 后全为 0
        // | 按位或 指两个比特位都是1 则为1 或者一1一0 也为1
        System.out.println(g | h);//结果为30
        // ^ 按位异或 指相同为0 不同为1
        System.out.println(g ^ h);//结果为30

        //移位运算
        // >> 右移 右移相当于除2
        int tem = 10;
        System.out.println(tem >> 1);//结果为5
        // << 左移 左移相当于乘2
        System.out.println(tem << 1);//结果为20
    }
}
