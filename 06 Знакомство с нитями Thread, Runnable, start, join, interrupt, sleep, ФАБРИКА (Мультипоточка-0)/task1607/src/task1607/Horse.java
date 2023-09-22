package task1607;

public class Horse extends Thread{
    private boolean isFinished;
    //по умолчанию инициализированный boolean = false;
    public Horse(String name) {
        super(name);
    }

    public boolean isFinished() {
        return isFinished;
    }

    public void run() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < 1001; i++) {   // Delay
            s.append("").append(i);
            if (i == 1000) {
                s = new StringBuilder(" has finished the race!");
                System.out.println(getName() + s);
                isFinished = true;
            }
        }
    }
}
