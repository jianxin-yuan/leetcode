package thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

/**
 * https://leetcode-cn.com/problems/fizz-buzz-multithreaded/solution/1ge-reentrantlock-1ge-condition-1ge-volatilebian-l/
 */
public class FizzBuzzForReentrantLock2 {

    private int n;
    private ReentrantLock lock = new ReentrantLock();
    private Condition c1 = lock.newCondition();
    private Condition c3 = lock.newCondition();
    private Condition c5 = lock.newCondition();
    private Condition c15 = lock.newCondition();
    private int i;

    public FizzBuzzForReentrantLock2(int n) {
        this.n = n;
        this.i = 1;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        lock.lock();
        while (i <= n) {
            if (i % 3 == 0 && i % 5 != 0) {
                printFizz.run();
                i++;
                c1.signalAll();
            }else{
                c3.await();
            }
        }
        lock.unlock();
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        lock.lock();;
        while (i <= n) {
            if (i % 3 != 0 && i % 5 == 0) {
                printBuzz.run();
                i++;
                c1.signalAll();
            }else{

                c5.await();
            }
        }
        lock.unlock();
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        lock.lock();
        while (i <= n) {
            if (i % 3 == 0 && i % 5 == 0) {
                printFizzBuzz.run();
                i++;
                c1.signalAll();
            }else{
                c15.await();
            }
        }
        lock.unlock();
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        lock.lock();
        while (i <= n) {
            if (i % 3 != 0 && i % 5 != 0) {
                printNumber.accept(i);
                i++;
            } else {
                if (i % 15 == 0) {
                    c15.signalAll();
                    c1.await();
                }
                //交给fizzbuzz()方法处理
                else if (i % 5 == 0) {
                    c5.signalAll();
                    c1.await();
                }
                //交给buzz()方法处理
                else {
                    c3.signalAll();
                    c1.await();
                }
            }

        }
        c1.signalAll();
        c3.signalAll();
        c15.signalAll();
        c5.signalAll();
        lock.unlock();

    }
}