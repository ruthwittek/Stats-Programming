import java.util.ArrayList; // Mode
import java.util.Arrays; // Median
import java.util.HashMap; // Mode
import java.util.List; // Mode
import java.util.Map; // Mode

public class MeanMedianModeStDev {
	
/////////////////////////////////////////////////////
    public static double getMean(double[] data) {
    	if (data.length == 0) {
    		return 0;
    	}
    	
    	double sum = 0.0;
    	for (int i = 0; i != data.length; ++i) {
    		sum += data[i];
    	}
    	
    	return sum / data.length;
    }
/////////////////////////////////////////////////////
    public static double getMedian(double[] data) {
        double[] copy = Arrays.copyOf(data, data.length);
        Arrays.sort(copy);
        
        return (copy.length % 2 != 0) ? copy[copy.length / 2] : (copy[copy.length / 2] + copy[(copy.length / 2) - 1]) / 2;
    }
/////////////////////////////////////////////////////
    public static List<Integer> getMode(final int[] numbers) {
        final List<Integer> modes = new ArrayList<Integer>();
        final Map<Integer, Integer> countMap = new HashMap<Integer, Integer>();

        int max = -1;

        for (final int n : numbers) {
            int count = 0;

            if (countMap.containsKey(n)) {
                count = countMap.get(n) + 1;
            } 
            else {
                count = 1;
            }

            countMap.put(n, count);

            if (count > max) {
                max = count;
            }
        }

        for (final Map.Entry<Integer, Integer> tuple : countMap.entrySet()) {
            if (tuple.getValue() == max) {
                modes.add(tuple.getKey());
            }
        }

        return modes;
    }
/////////////////////////////////////////////////////
    public static double getStandardDeviation(double[] data) {
        final double mean = getMean(data);
        double sum = 0;
        
        for (int index = 0; index != data.length; ++index) {
            sum += Math.pow(Math.abs(mean - data[index]), 2);
        }
        
        return Math.sqrt(sum / data.length);
    }
/////////////////////////////////////////////////////
}
