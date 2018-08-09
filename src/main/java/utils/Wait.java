package utils;

public class Wait {
    public void threadsSleepWait() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
        }
    }
}
