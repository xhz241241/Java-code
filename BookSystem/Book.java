package BookSystem;

//表示一本书的信息
public class Book {
    private String name;
    private String author;
    private double price;
    private String type;
    private boolean isBorrowed = false;

    //使用构造方法初始化私有成员
    public Book(String name, String author, double price, String type) {
        this.name = name;
        this.author = author;
        this.price = price;
        this.type = type;
    }

    @Override
    public String toString() {
        return "book{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", type='" + type + '\'' +
                ", isBorrowed=" + isBorrowed +
                '}';
    }

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }

    public void setType(String type){
        this.type = type;
    }
    public String getType(){
        return type;
    }

    public void setPprice(double price){
        this.price = price;
    }
    public double getPrice(){
        return price;
    }

    public void setBorrowed(boolean Borrowed){
        this.isBorrowed = Borrowed;
    }
    public boolean getBorrowed(){
        return isBorrowed;
    }
}
