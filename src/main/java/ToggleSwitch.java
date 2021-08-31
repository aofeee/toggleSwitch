public class ToggleSwitch {

    int count = 5;
    final int TOY_SLEEP = 1500;
    final int USER_SLEEP = 2000;
    volatile boolean tS = false;

    public void on() {
        while (count != 0) {
            try {
                if (!tS) {
                    Thread.sleep(USER_SLEEP);
                    tS = true;
                    System.out.printf("%s: Включаю тумблер\n", Thread.currentThread().getName());
                    count--;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void off() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Thread.sleep(TOY_SLEEP);
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