package BookSystem.BookOperation;

import BookSystem.Book;
import BookSystem.BookList;

import java.util.Scanner;

public class BorrowOperation implements IOperation{
    @Override
    //借书
    public void work(BookList bookList) {
        System.out.println("借阅书籍");
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入您要借阅的书的名称: ");
        String name = sc.nextLine();

        for(int i= 0; i < bookList.getSize(); i++){
            Book book = bookList.getBook(i);
            if (book.getName().equals(name)) {
                //找到该书 判断是否可借
                if(!book.getBorrowed()){
                    book.setBorrowed(true);
                    System.out.println("借书成功!");
                    return;
                }else{
                    System.out.println("该书已被借走!");
                }
            }
        }
        System.out.println("没有找到该书, 请核实名字！");
    }
}
