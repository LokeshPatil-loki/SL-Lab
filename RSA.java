public class RSA
{
	public static void main(String[] args) {
        double p = 3;
        double q = 7;
        
         // First part of public key:
        double n = p * q;
        
        // Finding other part of public key.
        // e stands for encrypt
        double e = 2;
        double phi = (p-1)*(q-1);
        while(e < phi){
            if (gcd(e, phi) == 1)
                break;
            else
                e++;
        }
        
    // Private key (d stands for decrypt)
    // choosing d such that it satisfies
    // d*e = 1 + k * totient
    int k = 2; // A constant value
    double d = (1 + (k * phi)) / e;
 
    // Message to be encrypted
    double msg = 12;
    
    System.out.printf("Message data = %f", msg);
 
    // Encryption c = (msg ^ e) % n
    double c = Math.pow(msg, e);
    c = fmod(c, n);
    System.out.printf("\nEncrypted data = %f", c);
 
    // Decryption m = (c ^ d) % n
    double m = Math.pow(c, d);
    m = fmod(m, n);
    System.out.printf("\nOriginal Message Sent = %f", m);
        
	}
	
	public static double gcd(double a, double h){
	    double temp;
	    while(true){
	        temp = a % h;
	        if(temp == 0)
	            return h;
	        a = h;
	        h = temp;
	    }
	}
	public static double fmod(double a, double b) {
        int result = (int) Math.floor(a / b);
        return a - result * b;
    }
	
	
}
