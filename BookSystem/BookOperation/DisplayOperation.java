package BookSystem.BookOperation;

import BookSystem.BookList;

public class DisplayOperation implements IOperation{
    //显示书籍信息
    @Override
    public void work(BookList bookList) {
        System.out.println("显示所有图书");
        for(int i = 0; i < bookList.getSize(); i++){
            System.out.println(bookList.getBook(i));
        }
    }
}
