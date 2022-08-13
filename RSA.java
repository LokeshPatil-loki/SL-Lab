package EXP2;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;

public class RSA {
    public static void main(String[] args) {
        int p = 3, q = 11;
        int n = p*q;
        int z = (p-1)*(q-1);

        int msg = 12;

        int e = computeE(z);
        int d = computeD(z,e);

        double c = Math.pow(msg,e) % n;
        System.out.println("Encrypted Text: " + c);

        BigInteger N = BigInteger.valueOf(n);

        // converting float value of c to BigInteger
        BigInteger C = BigDecimal.valueOf(c).toBigInteger();
        BigInteger msgback = (C.pow(d)).mod(N);
        System.out.println("Decrypted message is : "
                + msgback);
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
