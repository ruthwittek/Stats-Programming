// Ruth Wittek / John Hughes

import java.util.Scanner;

public class BinomialDistribution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Input from scanner
        double r = scanner.nextDouble();
        double y = scanner.nextDouble();
        double b = r/(r+y);
        double x = 6;
        double probability = 0;
        for(int i=3;i<=x;i++)
            probability+=Math.pow(b,i)*Math.pow(1-b,x-i)/(f(i)*f(x-i));
        System.out.printf("%.3f",f(x)*probability);
        scanner.close();
    }
    public static double f(double n){
        return n==0 ? 1 : n*f(n-1);
    }
}