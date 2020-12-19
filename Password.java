import java.util.Scanner;

//编写代码模拟三次密码输入的场景。 最多能输入三次密码
//密码正确，提示“登录成功”
//密码错误， 可以重新输入，最多输入三次。三次均错，则提示退出程序
public class Password {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String truecode = "xhz241";
        for(int i = 0; i < 3; i++){
            System.out.println("请输入您的密码:");
            String password = sc.nextLine();
            if(password.equals(truecode)){
                System.out.println("登陆成功!");
                break;
            }else{
                System.out.println("密码错误");
            }
        }
        System.out.println("退出程序!");
    }
}
