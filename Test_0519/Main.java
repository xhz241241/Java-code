package Test_0519;
//不用加减乘数做加法

public class Main {
    public int Add(int num1,int num2) {
        // 5 + 7
        // 第一步先把两数异或^ 得到 2
        // 第二步两数 & 取进位 得到10 若取到的进位为 0 上一步就是最终结果
        // 第三步再把进位和第一步再次 ^
        //这里直接使用num2作为进位值 省去了新建变量的开销
        while(num2 != 0){
            int tem = num1 ^ num2;
            // & 操作完了后还要 << 一位
            num2 = (num1 & num2) << 1;
            num1 = tem;
        }
        return num1;
    }
}