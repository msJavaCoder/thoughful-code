package top.msjava.thread.base;

/**
 * @BelongsProject: thoughtful-code
 * @BelongsPackage: top.msjava.thread.test
 * @Author: msJava
 * @CreateTime: 2022-08-01  22:10
 * @Description: 测试-ThreadLocal
 * @Version: 1.0
 */
public class ThreadLocalTest {


    static ThreadLocal<String> localVaruable=new ThreadLocal<>();

    static void print(String str){
        System.out.println(str+":"+localVaruable.get());
        localVaruable.remove();
    }

    public static void main(String[] args) {
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                localVaruable.set("threadA local variable");
                print("threadA");
                System.out.println("threadA remove after : "+localVaruable.get());
            }
        });
        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                localVaruable.set("threadB local variable");
                print("threadB");
                System.out.println("threadB remove after : "+localVaruable.get());
            }
        });


        threadA.start();
        threadB.start();
    }

}
