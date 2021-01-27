package BookSystem.BookOperation;

import BookSystem.Book;
import BookSystem.BookList;
import com.sun.security.jgss.GSSUtil;

import java.util.Scanner;

public class DelOperaton implements IOperation{
    //删除一本书的信息
    @Override
    public void work(BookList bookList){
        System.out.println("删除书籍");
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要删除书籍的名字:");
        String name = sc.nextLine();
        int i= 0;
        for(; i < bookList.getSize(); i++){
            Book book = bookList.getBook(i);
            if(book.getName().equals(name)){
                break;
            }
        }
        if(i == bookList.getSize()){
            System.out.println("未找到您输入的书名, 请核实后再输入!");
            return;
        }

        //开始删除操作
        //如果是最后一本书
        if(i == bookList.getSize()-1){
            bookList.setSize(bookList.getSize()-1);
        }
        //如果是中间元素
        //先把最后一个元素赋值到要删除的位置, 再删除最后一个元素
        bookList.setBook(i, bookList.getBook(bookList.getSize()-1));
        bookList.setSize(bookList.getSize()-1);
        System.out.println("删除成功!");
    }
}

