public class ToggleSwitch {

    int count = 5;

    volatile boolean tS = false;

    public void on() {
        while (count != 0) {
            try {
                if (!tS) {
                    tS = true;
                    System.out.printf("%s: Включаю тумблер\n", Thread.currentThread().getName());
                    count--;
                    Thread.sleep(3000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void off() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Thread.sleep(3000);
                if (tS) {
                    tS = false;
                    System.out.printf("%s: Выключаю тумблер\n", Thread.currentThread().getName());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
        }

    }
}
