import java.util.Scanner;

public class SameOrbit {

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);
//        int test = sc.nextInt();
//
//        if(test < 0 || test > 10) {
//            System.out.println("Can't give more than 10 test cases at a time");
//            return;
//        }

        for(int i=0; i<10; i++) {

            int earthDays = -1;
            int marsDays = -1;

            if(sc.hasNextInt() ) {
                earthDays = sc.nextInt();
            }
            if(sc.hasNextInt()) {
                marsDays = sc.nextInt();
            }

            if((0 <= earthDays && earthDays < 365) && (0 <= marsDays && marsDays < 687)) {
                System.out.println("Case " + (i + 1) + ": " + findDayOfMeetUpAtZero(earthDays, marsDays));
            } else {

            }
        }
    }

    private static int findDayOfMeetUpAtZero(int earthDays, int marsDays) {

        int result = 0;
        while (earthDays != 0 || marsDays != 0)
        {
            result += 1;
            earthDays = (earthDays + 1) % 365;
            marsDays = (marsDays + 1) % 687;
        }
        return result;
    }
}
