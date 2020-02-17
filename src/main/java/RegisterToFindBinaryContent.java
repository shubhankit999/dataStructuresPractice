import java.util.Scanner;

public class RegisterToFindBinaryContent {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        while(sc.hasNextInt()) {

            int numberOfInstructions = sc.nextInt();

            if (numberOfInstructions == 0) {
                return;
            }
            if (numberOfInstructions < 0 || numberOfInstructions > 100)
            {
                continue;
            }

            char bits[] = new char[32];

            for (int i = 0; i < 32; i++) {
                bits[i] = '?';
            }

            for (int i = 0; i < numberOfInstructions; i++) {
                String instruction = sc.next();
                doOperation(instruction, bits);
            }


            for (int i = 0; i < 32; i++) {
                System.out.print(bits[i]);
            }
            System.out.println();
        }
    }

    private static void doOperation(String instruction, char[] bits) {

        switch (instruction) {
            case "SET": {
                int a = sc.nextInt();
                if (checkCondition(a)) bits[31 - a] = '1';
            }
                break;
            case "CLEAR": {
                int a = sc.nextInt();
                if (checkCondition(a)) bits[31 - a] = '0';
            }
                break;
            case "OR": {
                int a = sc.nextInt();
                int b = sc.nextInt();
                if (checkCondition(a) && checkCondition(b)) {
                    if((bits[31-a] == '?') || (bits[31-b] == '?')) {
                        bits[31 - a] = '?';
                    } else {
                        bits[31 - a] = (char) (bits[31 - a] | bits[31 - b]);
                    }
                }

            }
                break;
            case "AND": {
                int a = sc.nextInt();
                int b = sc.nextInt();
                if (checkCondition(a) && checkCondition(b)) {
                    if((bits[31-a] == '?') || (bits[31-b] == '?')) {
                        bits[31 - a] = '?';
                    } else {
                        bits[31 - a] = (char) (bits[31 - a] & bits[31 - b]);
                    }
                }
            }
                break;
            default:
                break;
        }
    }

    private static boolean checkCondition(int a) {
        return ( a>=0 && a<32);
    }

//    private static void setDefault(char bits[], int a, int b) {
//        if((bits[31-a] == '?') || (bits[31-b] == '?')) {
//            bits[31 - a] = '?';
//        }
//    }
}
