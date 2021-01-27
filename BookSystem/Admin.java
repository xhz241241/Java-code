package BookSystem;

import BookSystem.BookOperation.*;

import java.util.Scanner;

public class Admin extends User{
    //管理员能支持的操作, 将若干个操作放在一个接口里
    // 这样就可以通过数组的形式来描述管理员支持的操作

    public Admin(String name) {
        this.name = name;
        //向上转型(多态)
        this.operation = new IOperation[]{
                new FindOperation(),
                new AddOperation(),
                new DelOperaton(),
                new DisplayOperation(),
                new ExitOperation()
        };
    }

    @Override
    public int menu() {
        System.out.println("========================");
        System.out.println(name + "欢迎进入图书管理系统~");
        System.out.println("1.查阅书籍信息");
        System.out.println("2.新增书籍信息");
        System.out.println("3.删除书籍信息");
        System.out.println("4.显示书籍信息");
        System.out.println("5.退出程序");
        System.out.println("========================");
        System.out.println("请输入您的选择: ");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        return choice;
    }
}
