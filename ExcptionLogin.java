import java.util.Scanner;

public class ExcptionLogin {
    private static String name = "xhzxhz";
    private static  String password = "xhz241";
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入您的用户名: ");
        String userinputname = sc.next();
        System.out.println("请输入您的密码: ");
        String userinputpassword = sc.next();
        try {
            login(userinputname, userinputpassword);
        } catch (NameException e) {
            e.printStackTrace();
        } catch (PasswordException e) {
            e.printStackTrace();
        }
    }

    public static void login(String userinputname, String userinputpassword) throws NameException, PasswordException {
        if(!userinputname.equals(name)){
            //NameException
            //因为NameException继承了受查异常, 所以需要被throws
            throw new NameException("用户名输入错误");
        }
        if(!userinputpassword.equals(password)){
            //PasswordException
            throw new PasswordException("密码输入错误");
        }
        System.out.println("登陆成功!");
    }
}
