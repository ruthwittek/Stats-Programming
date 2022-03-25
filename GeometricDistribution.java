// Ruth Wittek / John Hughes

public class GeometricDistribution {

    public static void main(String[] args) {
    	// Plug in your values
         double p = 6.0/9.0;
         double n = 5;
        
         double r = Math.pow(1.0-p, n-1) * p;
        
        System.out.printf("%.3f", r);
    }
}

