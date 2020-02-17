import java.util.Scanner;

public class SumOfTwoDices {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int firstDice = sc.nextInt();
        int secondDice = sc.nextInt();

        if((firstDice > 20 || secondDice > 20 || firstDice < 4 || secondDice < 4)) {
            System.out.println("Dice can't be less than 4 or more than 20");
            return;
        }

        int numberOfMostLikelyOutcome[];

        if(firstDice == secondDice) {
            numberOfMostLikelyOutcome = new int[1];
            numberOfMostLikelyOutcome[0] = firstDice + 1;
        } else {
            int count = 0;

            if(secondDice > firstDice) {
                numberOfMostLikelyOutcome = new int[secondDice-firstDice+1];
                for(int i= (firstDice + 1) ; i<= (secondDice + 1); i++) {
                    numberOfMostLikelyOutcome[count++] = i;
                }
            } else {
                numberOfMostLikelyOutcome = new int[firstDice-secondDice+1];
                for(int i= (secondDice + 1) ; i<= (firstDice + 1); i++) {
                    numberOfMostLikelyOutcome[count++] = i;
                }
            }
        }

        for(int i=0; i<numberOfMostLikelyOutcome.length; i++) {
            System.out.print(numberOfMostLikelyOutcome[i] + " ");
        }
    }
}
