package BookSystem;

import BookSystem.BookOperation.*;

import java.util.Scanner;

public class NormalUser extends User{

    public NormalUser(String name) {
        this.name = name;
        this.operation = new IOperation[]{
            new FindOperation(),
            new BorrowOperation(),
            new RturnOperation(),
            new ExitOperation()
        };
    }

    @Override
    public int menu() {
        System.out.println("========================");
        System.out.println(name + "欢迎进入图书管理系统~");
        System.out.println("1.查阅书籍信息");
        System.out.println("2.借阅书籍");
        System.out.println("3.归还书籍");
        System.out.println("4.退出程序");
        System.out.println("========================");
        System.out.println("请输入您的选择: ");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        return choice;
    }
}
