package BookSystem;

import java.util.Scanner;

//图书管理系统分为两种身份
//1.用户
//查看书籍列表
//借阅书籍
//归还书籍
//退出程序
//2.管理者
//查看书籍列表
//显示所有书籍
//增加书籍
//删除书籍
//退出程序
//不同的身份对应了不同的功能
//为这些功能里面的名词创建类
public class Main {
    public static void main(String[] args) {
        //1.准备书籍数据
        BookList bookList = new BookList();
        //2.创建用户(登录)
        User user = login();
        //3.进入菜单
        while(true){
            int choice = user.menu();
            user.doOperation(choice, bookList);
        }
    }

    public static User login(){
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入您的姓名:");
        String name = sc.next();
        System.out.println("请输入您的角色: 1.管理员 0.普通用户");
        int who = sc.nextInt();
        if(who == 1){
            return new Admin(name);
        }
        return new NormalUser(name  );
    }

}
