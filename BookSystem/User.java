package BookSystem;

import BookSystem.BookOperation.IOperation;

//作为父类, 存放管理员和普通用户的公共信息
//仅仅只需要被继承, 所以可以写成抽象类
abstract public class User {
    protected String name;
    protected IOperation[] operation;

    //身份不同对应的菜单也不同, 所以我们在父类中写一个抽象方法, 让不同的子类去重写这个方法
    public abstract int menu();

    public void doOperation(int choice, BookList bookList){
        this.operation[choice-1].work(bookList);
    }
}
