import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class CallCenter {
    private final int NUMBER_OF_CALLS = 60;
    private final int WORKING_HOURS = 3500;
    private final int PAUSE = 1000;
    private final BlockingQueue<String> calls = new ArrayBlockingQueue<>(NUMBER_OF_CALLS, true);

    public void generateCalls() {
        try {
            for (int i = 1; i <= NUMBER_OF_CALLS; i++) {
                calls.put(Thread.currentThread().getName() + " " + i);
                System.out.println("На очереди: " + Thread.currentThread().getName() + " " + i);
                Thread.sleep(PAUSE);
            }
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }
    }

    public void takeACallToWork() {
        String callMessage;
        try {
            while (calls.isEmpty()) {
                callMessage = calls.take();
                Thread.sleep(WORKING_HOURS);
                System.out.println(Thread.currentThread().getName() + " обработал: " + callMessage);
            }
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }
    }
}