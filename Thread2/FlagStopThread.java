package Thread2;

public class FlagStopThread {
    //使用标志位判断是否继续执行线程中的内容
    //true中断  false继续执行
    private static boolean isStop = false;
    public static void main(String[] args) throws InterruptedException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("开始转账");
                    try {
                        while(!isStop) {
                            //转账一次需要一秒钟
                            System.out.println("转账ing...");
                            Thread.sleep(1000);
                        }
                        System.out.println("停止转账");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

            }
        }).start();
        //在第 10 秒的时候停止转账
        Thread.sleep(10*1000);
        //修改标志位
        isStop = true;
    }
}
