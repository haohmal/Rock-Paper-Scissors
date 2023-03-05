import java.util.*;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();

        Scanner scanner = new Scanner(System.in);

        char[] alpha = {'a','b','c','d','e','f','g','h','i','j','k'};
        char[] numeric = {'0','1','2','3','4','5','6','7','8','9'};

        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        int n = scanner.nextInt();
        int d = n - a - b - c;
        char[] password = new char[n];

        for (int i = 0; i < d; i++) {
            int k = random.nextInt(3);
            if (k == 0) {
                a++;
            } else if (k == 1) {
                b++;
            } else {
                c++;
            }
        }

        for (int i = 0; i < n; i++) {
            if (a > 0) {
                do {
                    password[i] = Character.toUpperCase(alpha[random.nextInt(alpha.length)]);
                } while (i > 0 && password[i] == password[i-1]);
                a--;
            } else if (b > 0) {
                do {
                    password[i] = alpha[random.nextInt(alpha.length)];
                } while (i > 0 && password[i] == password[i-1]);
                b--;
            } else if (c > 0) {
                do {
                    password[i] = numeric[random.nextInt(numeric.length)];
                } while (i > 0 && password[i] == password[i-1]);
                c--;
            }
        }
        System.out.println(String.valueOf(password));

    }
}