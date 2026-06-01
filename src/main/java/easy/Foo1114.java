package easy;

import java.util.concurrent.Semaphore;

public class Foo1114 {
    private Semaphore a = new Semaphore(1);
    private Semaphore b = new Semaphore(0);
    private Semaphore c = new Semaphore(0);


    public Foo1114() {
    }

    public void first(Runnable printFirst) throws InterruptedException {
        try {
            a.acquire();
            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            b.release();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
        try {
            b.acquire();
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();

            c.release();
        } catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    public void third(Runnable printThird) throws InterruptedException {
        try {
            b.acquire();
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();

            c.release();
        } catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}
