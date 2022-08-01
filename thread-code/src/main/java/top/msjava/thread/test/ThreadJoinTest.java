package top.msjava.thread.test;

/**
 * @BelongsProject: thoughtful-code
 * @BelongsPackage: top.msjava.thread.test
 * @Author: msJava
 * @CreateTime: 2022-08-01  21:46
 * @Description: 测试-等待线程执行结束的join方法
 * @Version: 1.0
 */
public class ThreadJoinTest {

    public static void main(String[] args) throws InterruptedException {


        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("child threadA over");
            }
        });

        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("child threadB over");
            }
        });

        threadA.start();
        threadB.start();

        System.out.println("wait all child thread over!");

        threadA.join();
        threadB.join();

        System.out.println("all child thread over!");
    }

}
