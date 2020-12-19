//计算1/1-1/2+1/3-1/4+1/5 …… + 1/99 - 1/100 的值 。
public class Work6 {
    public static void main(String[] args) {
        double sum = 0;
        int flag = 1;
        for (int i = 1; i <= 100; i++) {
            sum = sum + flag*(1.0/i);
            flag = flag * -1;
        }
        System.out.println("sum = " + sum);
    }
}
