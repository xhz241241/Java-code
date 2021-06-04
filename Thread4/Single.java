package Thread4;

public class Single {

    // 1. 饿汉模式
    //new对象是在类加载的时候就执行了
//    private static Single instance = new Single();
//    private Single(){}
//    public static Single getInstance(){
//        return instance;
//    }

    // 2. 懒汉模式 线程不安全
    //类加载时不着急创建对象
//    private static Single instance = null;
//    private Single(){}
//    public static Single getInstance(){
//        //获取对象实例时才初始化
//        if(instance == null ){
//            instance = new Single();
//        }
//        return instance;
//    }

    // 3. 懒汉模式 线程安全
//    private static Single instance = null;
//    private Single(){}
//    public synchronized static Single getInstance(){
//        //获取对象实例时才初始化
//        if(instance == null ){
//            instance = new Single();
//        }
//        return instance;
//    }

    // 4. 双重校验锁的单例模式
    private static volatile Single instance = null;
    private Single() {}
    public static Single getInstance(){
        //已经初始化了对象 就不需要加锁 只需要volatile就可以保证线程安全 因为有读操作
        //可以并发并行执行
        if(instance == null){
            //对象未初始化时 需要加锁来保证多个线程之间的安全性
            synchronized (Single.class){
                //如果不加这一层if判断 会导致当前没有申请到锁的线程又创建出了个对象 违背了单例模式的初衷
                if(instance == null){
                    instance = new Single();
                }
            }
        }
        return instance;
    }
}
