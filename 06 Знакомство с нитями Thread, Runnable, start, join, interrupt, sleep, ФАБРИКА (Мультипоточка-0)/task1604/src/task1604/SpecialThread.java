package task1604;

import java.util.Arrays;

public class SpecialThread implements Runnable{
    @Override
    public void run() {
        getSelfStackTrace();
    }


    private void getSelfStackTrace() {
        for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
            System.out.println(stackTraceElement);
        }
    }
}
