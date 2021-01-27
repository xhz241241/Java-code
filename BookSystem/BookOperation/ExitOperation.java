package BookSystem.BookOperation;

import BookSystem.BookList;

public class ExitOperation implements IOperation{
    @Override
    //退出程序
    public void work(BookList bookList) {
        System.out.println("退出系统");
        System.exit(1);
    }
}
