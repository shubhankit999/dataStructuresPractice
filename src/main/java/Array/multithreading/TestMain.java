package Array.multithreading;

import org.springframework.util.StringUtils;

public class TestMain {

    public static void main(String[] args) {
        int ar[] = {100, 200, 30, -20, 5, 2, 75, 300};

        int a[] = new int[ar.length];
        a[0] = 100;
        a[1] = 200;

        for(int i=2;i<ar.length; i++) {
            a[i] = Math.max(a[i-1],a[i-2]+ar[i]);
        }

        for(int i=0; i<ar.length; i++) {
            System.out.println(a[i]);
        }

    }
}
