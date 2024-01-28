import java.util.Scanner;
class Calc {
    public static void main(String[] args) {
        System.out.println("Введите любое арифметическое действие, например : a + b, a * b, a / b, a - b");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println(calc(input));
    }
    public static String calc(String input) {
        String[] parts = input.split(" ");
        if (parts.length != 3) {
            throw new IllegalArgumentException("Неверный формат");
        }
        int a = Integer.parseInt(parts[0]);
        int b = Integer.parseInt(parts[2]);
        char operator = parts[1].charAt(0);
        if (a < 1 || a > 10 || b < 1 || b > 10) {
            throw new IllegalArgumentException("Числа на ввод принимаются от 1 до 10");
        }
        if (parts[2].length() > 1) {
            throw new IllegalArgumentException("Некорректное количество операндов и операторов");
        }
        int result = switch (operator) {
            case '+' -> a + b;
            case '-' -> a - b;
            case '*' -> a * b;
            case '/' -> a / b;
            default -> throw new IllegalArgumentException("Непподерживаемая арифметическая операция");
        };
        return String.valueOf(result);
    }
}