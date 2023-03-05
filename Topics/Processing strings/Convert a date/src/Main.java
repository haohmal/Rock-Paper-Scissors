import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String date = scanner.next();

        String[] dateParts = date.split("-");
        if (dateParts.length == 3) {
            System.out.printf("%s/%s/%s",dateParts[1], dateParts[2], dateParts[0]);
        }
    }
}