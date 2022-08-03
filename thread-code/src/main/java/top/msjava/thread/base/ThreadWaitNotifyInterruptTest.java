package top.msjava.thread.base;

/**
 * @BelongsProject: thoughtful-code
 * @BelongsPackage: top.msjava.thread.test
 * @Author: msJava
 * @CreateTime: 2022-07-31  11:20
 * @Description: 测试：当一个线程调用共享对象的wait()方法被阻塞挂起后，如果其他线程中断了该线程，则该线程会抛出InterruptedException异常并返回；
 * @Version: 1.0
 */
public class ThreadWaitNotifyInterruptTest {

    private static Object object = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("---begin---");
                    synchronized (object) {
                        object.wait();
                    }
                    System.out.println("---end---");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
        Thread.sleep(1000);
        System.out.println("---begin interrupt thread");
        thread.interrupt();
        System.out.println("---end interrupt thread");
    }
}
