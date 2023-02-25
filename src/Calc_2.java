import java.util.Arrays;
import java.util.Scanner;

public class Calc_2 {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        StringBuilder log = new StringBuilder();
        String input;
        double result = 0;
        int step = 0;

        String[] operations = {"+", "-", "/", "*"};

        System.out.print("Введите числа и операции (" + String.join(",", operations) + ") >");

        String operation = "";

        do {
            input = keyboard.next();

            if (step % 2 == 0) {
                try {
                    double num = Double.parseDouble(input);

                    if (step == 0) {
                        result = num;
                        log.append(" ").append(num);
                    } else {
                        switch (operation) {
                            case "+" -> {
                                result += num;
                                log.append(" ").append(num);
                            }
                            case "-" -> {
                                result -= num;
                                log.append(" ").append(num);
                            }
                            case "/" -> {
                                if (num == 0) {
                                    System.out.println("На ноль делить нельзя. Введите другое число.");
                                    step--;
                                } else {
                                    result /= num;
                                    log.append(" ").append(num);
                                }
                            }
                            case "*" -> {
                                result *= num;
                                log.append(" ").append(num);
                            }
                        }
                    }

                } catch (NumberFormatException e) {
                    System.out.println("Введенное значение не получилось привести к типу double. Введите другое число.");
                    step--;
                }
            } else {
                if (Arrays.asList(operations).contains(input)) {
                    operation = input;
                    log.append(" ").append(operation);
                } else if (input.equals("=")) {
                    if (step > 2) {
                        System.out.println("Результат вычисления " + log + " = " + result);
                    } else {
                        System.out.println("Недостаточно аргументов.");
                    }
                } else {
                    System.out.println("Ожидается математическое действие (" + String.join(",", operations) + ") >");
                    step--;
                }
            }

            step++;
        } while (!input.equals("="));
    }
}
