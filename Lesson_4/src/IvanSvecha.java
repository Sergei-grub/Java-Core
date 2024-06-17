import java.util.Scanner;


public class Ivan {
    public static void main(String[] args) {
        System.out.println("Каждый день Иван тратит 1 свечу, которую он делает из огарков (остатки свечи).\n" +
                "Одну свечу Иван делает из 5 огарков.");
        System.out.println(" - - - - - - - - - - - - - ");
        Scanner input = new Scanner(System.in);
        System.out.print("Введите количество огарков, чтобы узнать сколько дней Иван будет жечь свечи: ");
        int number = input.nextInt();
        String sday = null;
        
        final int svecha = 5;
        int days = 0;

        int res = number / 5;
        int cinder = number - res * 5;

        while (number > 0){
            number = number - svecha;
            if (number >= 0) days++;
        }
        res += cinder;
        System.out.println("Осталось огарков: " + res);
        System.out.println("Дней при свете: " + days);
        days += res / 5;
        System.out.println("Из остатков можно сделать еще свечей: " + res / 5);
        
        System.out.printf("\nИван сможет жечь %d %s!", days, daysString(days));
    }
    static String daysString(int num){
        int preLastDigit = num % 100 / 10;
        if (preLastDigit == 1) {
            return "дней";
        }
        switch (num % 10) {
            case 1:
                return "день";
            case 2:
            case 3:
            case 4:
                return "дня";
            default:
                return "дней";
        }
    }
}