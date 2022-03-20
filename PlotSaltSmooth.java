import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;

public class PlotSaltSmooth {

	// Plotter
	public double function(double x) {

		double y;
		
		y = 2*x + 9; // Function (y = mx + b style)
		
		return y;

	} // End Plotter

	// Salter
	public double salt(double y) {

		Random rand = new Random();
		
		double yValues = rand.nextDouble() * 2; // Random numbers from y values
		
		return y * yValues;
	} // End Salter

    // Smoother
    public void smooth(ArrayList<Double> yValue, int xArea) {
    	
    	for (int i = 0; i < yValue.size(); i++) { // Loop through y values
			double value = yValue.get(i);
			int count = 1; // Set count at 1
			for (int j = 1; j <= xArea; j++) {
				if (i - j >= 0) {
		        value += yValue.get(i - j);
		        count++;
				} // End if
	        if (i + j < yValue.size()) {
	        	value += yValue.get(i + j);
	        	count++;
	        } // End if
		} // End inner for
		
		value = value / count; // Average y values
        yValue.set(i, value); // Replace with average
    	} // End outer for
    	
    } // End Smoother

public static void main(String[] args) {
    	
	String fileName = "Graphing.csv";
	PrintWriter outputStream = null;
	
	// Try-Catch block for csv file
	try {
		outputStream = new PrintWriter(new FileOutputStream(fileName, true));	
	}
	catch(FileNotFoundException e) {
		System.out.println("Error opening the file " + fileName);
		System.exit(0);
	}

    PlotSaltSmooth obj = new PlotSaltSmooth();

    ArrayList<Double> yValue = new ArrayList<>();
    ArrayList<Double> xValue = new ArrayList<>();
    ArrayList<Double> ySalted = new ArrayList<>();
    //ArrayList<Double> yDoubleSalted = new ArrayList<>();

    int xBegin = -10; // Parameters for x values
    int xEnd = 10;

    for (double i = xBegin; i <= xEnd; i += .5) { // x values

        yValue.add(obj.function(i));
        xValue.add(i);

        outputStream.println((i) + "," + obj.function(i));

    }
    outputStream.println();

    for (int i = 0; i < yValue.size(); i++) { // Salt the data
    	
	    ySalted.add(obj.salt(yValue.get(i)));
	
	    outputStream.println(xValue.get(i) + "," + ySalted.get(i));

    }
    System.out.println();

            /*for (int i = 0; i < ySalted.size(); i++) {
                    yDoubleSalted.add(obj.salt(ySalted.get(i)));

                    outputStream.println((xValue.get(i)) + "," + yDoubleSalted.get(i));

            }*/
    outputStream.println();

    int xArea = 10; // Area size
    // smoothening yValues
    obj.smooth(yValue, xArea); // Smooth the data

    for (int i = 0; i < xValue.size(); i++) {

            outputStream.println((xValue.get(i)) + "," + yValue.get(i));
    }
    System.out.println();

    obj.smooth(yValue, xArea); // Smooth the data again for more accuracy/precision

    for (int i = 0; i < xValue.size(); i++) {

            outputStream.println((xValue.get(i)) + "," + yValue.get(i));
    }
    outputStream.println();
    
    outputStream.close(); // Close PrintWriter

    }
}