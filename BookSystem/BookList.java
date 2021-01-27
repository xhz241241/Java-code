package BookSystem;

// 这个类的作用是把多本书组合到了一起
public class BookList {
    //100是能存放的最大书籍量
    private Book[] books = new Book[100];
    //size是当前存放的书籍量
    private int size = 0;

    public BookList() {
        books[0] = new Book("三国演义", "罗贯中", 100, "名著");
        books[1] = new Book("西游记", "吴承恩", 100, "名著");
        books[2] = new Book("红楼梦", "曹雪芹", 100, "名著");
        size = 3;
    }

    public Book getBook(int index){
        return books[index];
    }

    public void setBook(int index, Book book){
        books[index] = book;
    }

    public int getSize(){
        return size;
    }

    public void setSize(int size){
        this.size = size;
    }

}
