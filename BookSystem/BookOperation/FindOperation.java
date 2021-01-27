package BookSystem.BookOperation;
import BookSystem.Book;
import BookSystem.BookList;
import java.util.Scanner;

public class FindOperation implements IOperation{
    //查找一本书的信息
    @Override
    public void work(BookList bookList){
        System.out.println("查找书籍");
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入您要查找的书籍名称: ");
        String name = sc.nextLine();

        for(int i = 0; i < bookList.getSize(); i++){
            Book book = bookList.getBook(i);
            if(book.getName().contains(name)){
                System.out.println(book);
                System.out.println("查找成功!");
                return;
            }
        }
        System.out.println("没有找到该书籍, 请核实书籍名称!");
    }
}
