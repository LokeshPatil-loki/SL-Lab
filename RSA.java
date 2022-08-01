package EXP2;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;

public class RSA {
    public static void main(String[] args) {
        int p = 7, q = 11;
        int n = p*q;
        int z = (p-1)*(q-1);

        int e = computeE(z);
        int d = computeD(z,e);

        System.out.println("The value of d: " + d);
        System.out.printf("Public key (n,e): (%d,%d)\n",n,e);
        System.out.printf("Private key (d): (%d)\n",d);

//        Encrypt
        String text = "9";
        int m = 9;
        for(int i=0;i<text.length();i++){
            m += (int)text.charAt(i);
        }
        double c = ((Math.pow(m,e)) % n);
        System.out.println("Encrypted Message: " + c);

        BigInteger N = BigInteger.valueOf(n);
        BigInteger C = BigDecimal.valueOf(c).toBigInteger();
        System.out.println("Decrypted Message: " + (C.pow(d)).mod(N));
    }


    public static int computeD(int z, int e){
        int d = 0;
        for(int i=0;i<=9;i++){
            int x = 1 + (i*z);
            if(x%e==0){
                d = x / e;
                break;
            }
        }
        return d;
    }
    public static int computeE(int z){
        int e=0;
        for(e=2;e<z;e++){
            if(gcd(e,z) == 1){
                break;
            }
        }
        System.out.println("E: " + e);
        return e;
    }
    public static int gcd(int x, int y){
        int a = (x > y)?x:y;
        int b= (x < y)?x:y;
        int r = b;
        while(a%b != 0){
            r = a%b;
            a = b;
            b = r;
        }
        return r;
    }
}
