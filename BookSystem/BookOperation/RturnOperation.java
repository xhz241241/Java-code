package BookSystem.BookOperation;

import BookSystem.Book;
import BookSystem.BookList;

import java.util.Scanner;

public class RturnOperation implements IOperation{
    @Override
    //还书操作
    public void work(BookList bookList) {
        System.out.println("归还书籍");
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入您归还的书的名称: ");
        String name = sc.nextLine();

        for(int i= 0; i < bookList.getSize(); i++){
            Book book = bookList.getBook(i);
            if (book.getName().equals(name)) {
                if(book.getBorrowed()){
                    book.setBorrowed(false);
                    System.out.println("还书成功!");
                    return;
                }
            }
        }
        System.out.println("没有找到该书, 请核实名字！");
    }
}
