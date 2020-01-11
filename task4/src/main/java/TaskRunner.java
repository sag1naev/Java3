import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;

public class TaskRunner implements Runnable {
    final Object mutex;   //монитор синхронизации
    String message; //сообщение которое поток будет добавлять в список

    //у вас могут быть другие решения и другие переменные
    volatile int cnt;
    volatile int inc;
    static volatile int iter = 0;
    //этот список будет проверяться на предмет синхронизации
    //данных
    //а именно: [1, 2, 3, 1, 2, 3, 1, 2, 3....]
    //в список будут писать из 3 потоков
    static volatile LinkedList<String> list = new LinkedList<>();


    public TaskRunner(Object mutex, String msg, int cnt) {
        this.mutex = mutex;
        message = msg; //каждый поток может писать в список только
        //его сообщение!!!
        this.cnt = cnt;
        inc = 0;
    }

    @Override
    public void run() {
        while (iter < 9) {
            synchronized (mutex) {
                if ((iter % 3) == cnt) {
                    list.add(message);
                    iter++;
                    mutex.notifyAll();
                } else {
                    try {
                        mutex.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

}
