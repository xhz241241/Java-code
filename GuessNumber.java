import java.util.Random;
import java.util.Scanner;

//完成猜数字游戏 ，用户输入数字，判断该数字是大于，小于，还是等于随机生成的数字，等于的时候退出程序
public class GuessNumber {
    public static void main(String[] args) {
        //1.生成一个随机数
        //2.设置提示栏让用户输入
        //3.判断永华输入的数字与随机数是否相等
        Random random = new Random();
        int toGuess = random.nextInt(100) + 1;
        while(true) {
            System.out.println("请输入您要猜的数字:");
            Scanner sc = new Scanner(System.in);
            int num = sc.nextInt();
            if (num > toGuess) {
                System.out.println("高了");
            } else if (num < toGuess) {
                System.out.println("低了");
            } else {
                System.out.println("猜中了!");
                break;
            }
        }

    }
}
