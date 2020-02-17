public class Palindrome {

    public static void main(String[] args) {
        int n = 132;
        int palindrome = 0;

        while(n != 0) {
            palindrome = (palindrome * 10) + (n%10);
            n = n/10;

        }
        System.out.println(palindrome);
    }
}
