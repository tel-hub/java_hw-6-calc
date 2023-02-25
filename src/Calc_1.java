import java.util.Scanner;

public class Calc_1 {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        double result = 0;
        String input;
        System.out.print("Введите числа для суммирования >");

        do {
            input = keyboard.next();

            if (input.equals("=")) {
                System.out.println("Сумма равна " + result);
            } else {
                try {

                    double num = Double.parseDouble(input);

                    result += num;

                } catch (NumberFormatException e) {
                    e.printStackTrace();
                    System.out.println("Введенное значение не получилось привести к типу double");
                }
            }


        } while (!input.equals("="));

    }
}
