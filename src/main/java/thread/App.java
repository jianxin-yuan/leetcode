package thread;

/**
 * @author yuan
 * @date 2020/3/5 11:07 上午
 */
public class App {

    public static void main(String[] args) throws Exception {
        //FizzBuzzForObjectLock fizzbuzz = new FizzBuzzForObjectLock(15);
        //FizzBuzzForReentrantLock fizzbuzz = new FizzBuzzForReentrantLock(15);
        //FizzBuzzForReentrantLock2 fizzbuzz = new FizzBuzzForReentrantLock2(15);
        FizzBuzzForSemaphore fizzbuzz = new FizzBuzzForSemaphore(15);


        new Thread(() -> {
            try {
                fizzbuzz.buzz(() -> {
                    System.out.println("buzz");
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                fizzbuzz.fizz(() -> {
                    System.out.println("fizz");
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                fizzbuzz.fizzbuzz(() -> {
                    System.out.println("fizzbuzz");
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                fizzbuzz.number(System.out::println);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

    }
}
