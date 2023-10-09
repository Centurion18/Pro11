import java.util.Scanner;

class mentor {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String a = console.nextLine();
        try {
            String b = calc(a);
            System.out.println("Ответ: " + b);
        } catch (IllegalArgumentException f) {
            System.err.println("Ошибка: " + f.getMessage());
        }
        console.close();
    }

    public static String calc(String begin) {
        String[] strings = begin.split(" ");
        if (strings.length == 1) {
            throw new IllegalArgumentException("строка не является математической операцией");
        } else if (strings.length != 3) {
            throw new IllegalArgumentException("формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        }

        int x;
        if (Integer.parseInt(strings[0]) > 0 && Integer.parseInt(strings[0]) <= 10) {
            x = Integer.parseInt(strings[0]);
        } else {
            throw new IllegalArgumentException("на вход принимаются числа от 1 до 10 включительно, не более");
        }

        char symbol = strings[1].charAt(0);

        int y;
        if (Integer.parseInt(strings[2]) > 0 && Integer.parseInt(strings[2]) <= 10) {
            y = Integer.parseInt(strings[2]);
        } else {
            throw new IllegalArgumentException("на вход принимаются числа от 1 до 10 включительно, не более");
        }

        int res;

        switch (symbol) {
            case '+':
                res = x + y;
                break;
            case '-':
                res = x - y;
                break;
            case '*':
                res = x * y;
                break;
            case '/':
                res = x / y;
                break;
            default:
                throw new IllegalArgumentException("Только +, -, *, /");
        }
        return Integer.toString(res);
    }
}