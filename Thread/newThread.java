package Thread;

public class newThread {
    public static void main(String[] args) {
        // 1. 通过匿名内部各类的方式创建线程
        Thread thread = new Thread(){
            @Override
            public void run() {
                System.out.println("runSuccess!");
            }
        };
        // 1.1 启动线程
        thread.start();//runSuccess!
        thread.run();//runSuccess!

        // 2. 通过继承Thread的方式创建线程
        A a = new A();
        Thread thread1 = new A();
    }

}

class A extends Thread{
    @Override
    public void run() {
        System.out.println("extendsSuccess!");
    }
}
