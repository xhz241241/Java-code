package BookSystem.BookOperation;
import BookSystem.Book;
import BookSystem.BookList;
import java.util.Scanner;


public class AddOperation implements IOperation{
    //增加一本书的信息
    @Override
    public void work(BookList bookList){
        System.out.println("新增书籍");
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入新增书籍的名字:");
        String name = sc.nextLine();
        System.out.println("请输入该书的作者名: ");
        String author = sc.nextLine();
        System.out.println("请输入该书的价格: ");
        int price = sc.nextInt();
        System.out.println("请输入该书的类型: ");
        String type = sc.next();
        Book book = new Book(name, author, price, type);
        int curSize = bookList.getSize();
        bookList.setBook(curSize, book);
        bookList.setSize(curSize+1);
        System.out.println("新增成功!");
    }
}
