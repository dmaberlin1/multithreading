package task1618;

/* 
Снова interrupt
Создай нить TestThread.
В методе main создай экземпляр нити, запусти, а потом прерви ее используя метод interrupt().


Requirements:
1. Класс TestThread должен быть унаследован от Thread.
2. Класс TestThread должен иметь public void метод run.
3. Метод main должен создавать объект типа TestThread.
4. Метод main должен вызывать метод start у объекта типа TestThread.
5. Метод main должен вызывать метод interrupt у объекта типа TestThread.*/

public class Solution {
    public static void main(String[] args) throws InterruptedException {
        //Add your code here - добавь код тут
        Thread testThread1 = new TestThread();
        Thread testThread2 = new TestThread();
        Thread testThread3 = new TestThread();

        testThread1.start();
        testThread1.join();
        testThread2.start();
        testThread2.interrupt();


    }


    //Add your code below - добавь код ниже
    public static class TestThread extends Thread {
        public static int count;

        public TestThread() {
            count++;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(1000);
                System.out.println("run from TestThread " + count);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}