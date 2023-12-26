import java.util.Scanner;

public class EnterHelper {
    public static int EnterInt(Scanner scanner, String preMessage) {
        int num = 0;
        boolean isEntered = false;

        do {
            System.out.print(preMessage);
            try {
                num = scanner.nextInt();
                isEntered = true;
            }
            catch (Exception e) {
                System.out.println("Что-то пошло не так при вводе числа. Повторите попытку...");
                scanner.nextLine();
            }
        } while (!isEntered);

        return num;
    }
}
