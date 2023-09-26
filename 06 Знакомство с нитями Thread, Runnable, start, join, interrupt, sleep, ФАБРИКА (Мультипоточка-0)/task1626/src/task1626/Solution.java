package task1626;

/* 
Создание по образцу
Разберись, как работает программа.
По образу и подобию CountdownRunnable создай нить CountUpRunnable, которая выводит значения в нормальном порядке - от 1 до number.


Requirements:
1. Класс CountUpRunnable должен реализовывать интерфейс Runnable.
2. Класс CountUpRunnable должен иметь публичный метод run без параметров.
3. Метод run класса CountUpRunnable должен работать примерно 2,5 секунды.
4. Метод run класса CountUpRunnable должен каждые полсекунды выводить имя потока,
двоеточие и значение счетчика от 1 до 5 (например: "Увеличиваем: 1").
5. Метод run класса CountUpRunnable должен вызывать Thread.sleep(500).*/

public class Solution {
    public static int number = 5;

    public static void main(String[] args) {
        new CountdownRunnable("Уменьшаем");
        new CountUpRunnable("Увеличиваем");
    }

    public static class CountUpRunnable implements Runnable {
        private int countUp = 1;
        private Thread thread;

        public CountUpRunnable(String name) {
            this.thread = new Thread(this, name);
            thread.start();
        }

        @Override
        public void run() {
            try {
                while (true) {
                    System.out.println(this);
                    countUp++;
                    if (countUp == Solution.number + 1) {
                        return;
                    }
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
                System.err.println(e);
            }

        }

        @Override
        public String toString() {
            return thread.getName() + ": " + countUp;
        }

        //Add your code here - добавь код тут
    }


    public static class CountdownRunnable implements Runnable {
        private int countIndexDown = Solution.number;
        private Thread thread;

        public CountdownRunnable(String name) {
            this.thread = new Thread(this, name);
            thread.start();
        }

        public void run() {
            try {
                while (true) {
                    System.out.println(toString());
                    countIndexDown -= 1;
                    if (countIndexDown == 0){
                        return;
                    }
                        Thread.sleep(500);
                }
            } catch (InterruptedException e) {
            }
        }

        public String toString() {
            return Thread.currentThread().getName() + ": " + countIndexDown;
        }
    }
}
