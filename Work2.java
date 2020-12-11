//输出 1000 - 2000 之间所有的闰年
// 闰年分两种
//1.能被4整除不能被100整除的(普通闰年)
//2.能被400整除的(世纪闰年)
public class Work2 {
    public static void main(String[] args) {
        for(int i = 1000; i <= 2000; i++){
            if(((i % 4 == 0) && (i % 100 != 0)) || (i % 400 == 0)){
                System.out.print(i + " ");
            }
        }
    }
}
