public class Main {
    public static void main(String[] args) {
        CallCenter center = new CallCenter();
        Thread ats = new Thread(null, center::generateCalls, "Звонок");
        ats.start();
        while (!ats.isInterrupted()) {
            new Thread(null, center::takeACallToWork, "Специалист 1").start();
            new Thread(null, center::takeACallToWork, "Специалист 2").start();
            new Thread(null, center::takeACallToWork, "Специалист 3").start();
            }
        }
    }