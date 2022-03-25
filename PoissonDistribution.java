// Ruth Wittek / John Hughes

import java.text.*;

public class PoissonDistribution {

    public static void main(String[] args) {
    	// Plug in your values
        double avg = 8d;
        double x = 10d;
        DecimalFormat df = new DecimalFormat("0.000");
	    System.out.println(df.format(Poisson(x, avg)));
    }
    
    public static double Poisson(double x, double avg){
        return Math.pow(avg, x) * Math.pow(Math.E, -avg) / Factorial(x);
    }
    
    public static double Factorial (double n){
        double x = 1;
        for(double i = 2; i <= n; i++){
            x *= i;
        }
        return x;
    }
}