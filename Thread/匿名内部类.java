package Thread;

public class 匿名内部类 {
    public static void main(String[] args) {
        A a = new A(){//Thread.匿名内部类，本质是A的子类，但不能等同A类型
            //可以重写方法，或不重写（继承）
            @Override
            public void pro() {
                System.out.println("pro");
            }
        };
        a.pro();//想打印pro

        B b = new B() {//Thread.匿名内部类：B接口的实现类，不能等同于B
            @Override
            public void pro() {
                System.out.println("pro");
            }
        };
        b.pro();//打印pro
    }

    //静态内部类
    static class A{
        public void pro(){
            System.out.println("a pro");
        };
    }
    //内部接口
    interface B{
        void pro();
    }
}
