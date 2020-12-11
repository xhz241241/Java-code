import java.util.Scanner;
//根据输入的年龄, 来打印出当前年龄的人是少年(低于18), 青年(19-28), 中年(29-55), 老年(56以上)

public class Work5 {
    public static void main(String[] args) {
        System.out.println("请输入您的年龄: ");
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();

        if(i <= 18){
            System.out.println("少年");
        }
        else if(i >= 19 && i <= 28){
            System.out.println("青年");
        }
        else if(i >= 29 && i <= 55){
            System.out.println("中年");
        }
        else if(i >= 56){
            System.out.println("老年");
        }
    }
}
