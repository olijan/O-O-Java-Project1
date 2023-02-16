package Project1;

public class Main {

	public static void main(String[] args) {
		//Read in and print file
		Predictor predict = new Predictor ("./project1/weather.numeric.arff");
		System.out.println(predict);
		//Testing activities
		String activity = predict.Prediction("sunny",85,85,"FALSE");
		System.out.println("Your activity is " + activity);
		activity = predict.Prediction("rainy",75,80,"FALSE");
		System.out.println("Your activity is " + activity);
		activity = predict.Prediction("overcast",72,90,"TRUE");
		System.out.println("Your activity is " + activity);
		
		System.out.println();
		//Adding new instances
		Instance inst1 = new Instance("sunny", 86, 70, "FALSE", "tan");
		Instance inst2 = new Instance("cloudy", 50, 67, "TRUE", "read");
		
		predict.addInst(inst1);
		predict.addInst(inst2);
		System.out.println(predict);
		//Writing new instances to the file
		predict.writeFile("./project1/weather.numeric.arff");


	}

}
