public class Main {
    public static void main(String[] args) {

        ToggleSwitch toggleSwitch = new ToggleSwitch();
        Thread user = new Thread(null, toggleSwitch::on, "Юзер");
        Thread toy = new Thread(null, toggleSwitch::off, "Игрушка");
        System.out.println("Начало игры");

        try {
            user.start();
            toy.start();

            user.join();
            System.out.println("Игра закончена!");
            toy.interrupt();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}