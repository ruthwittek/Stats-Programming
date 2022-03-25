import java.math.BigDecimal;

public class HypergeometricDistribution {

	public static void main(String[] args){
	    BigDecimal[] prob = HyperGeometricDistribution(6,5,3,8);
	    String probx = prob[0] + "." +  prob[1];
	    System.out.println(probx);
	}

	private static BigDecimal factorial (BigDecimal n) {
	    BigDecimal solution = BigDecimal.ONE;
	    while (!n.equals(BigDecimal.ZERO)) {
	        solution = solution.multiply(n);
	        n = n.subtract(BigDecimal.ONE);
	    }
	    return solution;
	}

	@SuppressWarnings("deprecation")
	private static BigDecimal Binomial(int a, int b) {
	    return factorial(BigDecimal.valueOf(a)).divide(factorial(BigDecimal.valueOf(a-b)).multiply(factorial(BigDecimal.valueOf(b))), BigDecimal.ROUND_DOWN);
	}

	// X : Successes in Population
	// x : Successes in Sample
	// N : Population Size
	// n : Sample Size
	private static BigDecimal[] HyperGeometricDistribution(int X,int x, int N, int n){
	    return (Binomial(X,x).multiply(Binomial(N-X,n-x))).divideAndRemainder(Binomial(N,n));
	}
	
}
