package top.msjava.thread.base;

/**
 * @BelongsProject: thoughtful-code
 * @BelongsPackage: top.msjava.thread.test
 * @Author: msJava
 * @CreateTime: 2022-07-31  11:02
 * @Description: 测试-当前线程调用共享变量的wait()方法后只会释放当前共享变量上的锁，如果当前线程还持有其他共享变量的锁，则这些锁是不会被释放的；
 * @Version: 1.0
 */
public class ThreadWaitReleaseLockTest {

    private static volatile Object resourceA = new Object();
    private static volatile Object resourceB = new Object();

    public static void main(String[] args) throws InterruptedException {

        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    synchronized (resourceA) {
                        System.out.println("threadA get resourceA lock");
                        synchronized (resourceB) {
                            System.out.println("threadA get resourceB lock");
                            // 是线程A阻塞并且释放获取到的resourceA的监视器锁
                            System.out.println("threadA release resourceA lock");
                            resourceA.wait();
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    /// 休眠一秒
                    Thread.sleep(1000);
                    synchronized (resourceA) {
                        System.out.println("threadB get resourceA lock");
                        System.out.println("threadB try get resourceB lock");
                        synchronized (resourceB) {
                            System.out.println("threadB get resourceB lock");
                            System.out.println("threadB release resourceA lock");
                            resourceA.wait();
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });


        threadA.start();
        threadB.start();


        threadA.join();
        threadB.join();

        System.out.println("main over");
    }
}
