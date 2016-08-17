//Your task is to calculate ab mod 1337 where a is a positive integer and b is an extremely large positive integer given in the form of an array.

public class SuperPow {

    public int superPow(int a, int[] b) {
    	int n=b.length;
        int res = get_mod(a, b[n-1]);
        int mod10=get_mod(a, 10);
        for (int i=n-2; i>=0; i--) {
        	res = product(res, get_mod(mod10, b[i]));
        	mod10=get_mod(mod10, 10);
        } 
        return res;
    }

    public int get_mod(int a, int pow) {
    	if (pow == 0) return 1;
    	if (pow == 1) return a%1337;
    	return product(get_mod(a, pow/2), get_mod(a, (pow+1)/2));
    }

    public int product(int a, int b) {    	
    	return ((a%1337) * (b%1337))%1337;
    }

    //3, 1268
    //res=3^8
    //res= res*(mod10 ^ 6), mod10=mod10^10
    //res=res*(mod10 ^ 2), mod10=mod10^10
    //res=res*(mod10^1), 

    //mod10: a^10 --> up

}