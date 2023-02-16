package Project1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Predictor {
	private String filename;
	private ArrayList<Instance> dothis;
	
	private void readFile() {
		BufferedReader lineReader = null;
		try {
			FileReader fr = new FileReader(filename);
			lineReader = new BufferedReader(fr);
			String line = null;
			while ((line = lineReader.readLine())!=null) {
				String[] attribute  = line.split(",", 5);
                String outlook = attribute[0];
                int temperature = Integer.parseInt(attribute[1]);
                int humidity = Integer.parseInt(attribute[2]);
                String wind = attribute[3];
                String action = attribute[4];
                addInst( new Instance(outlook, temperature, humidity, wind, action ));
			}
		} catch (Exception e) {
			System.err.println("there was a problem with the file reader, try different read type.");
			try {
				lineReader = new BufferedReader(new InputStreamReader(this.getClass().getResourceAsStream(filename.substring(1))));
				String line = null;
				while ((line = lineReader.readLine())!=null) {
					String[] attribute  = line.split(",", 5);
	                String outlook = attribute[0];
	                int temperature = Integer.parseInt(attribute[1]);
	                int humidity = Integer.parseInt(attribute[2]);
	                String wind = attribute[3];
	                String action = attribute[4];
	                addInst( new Instance(outlook, temperature, humidity, wind, action ));			}
			} catch (Exception e2) {
				System.err.println("there was a problem with the file reader, try again.  either no such file or format error");
			} finally {
				if (lineReader != null)
					try {
						lineReader.close();
					} catch (IOException e2) {
						System.err.println("could not close BufferedReader");
					}
			}			
		} finally {
			if (lineReader != null)
				try {
					lineReader.close();
				} catch (IOException e) {
					System.err.println("could not close BufferedReader");
				}
		
		}
	}
	
	public Predictor() {
		filename = null;
		dothis = new ArrayList<Instance>();
	}
	
	public Predictor(String fn) {
		this();
		filename = fn;
		readFile();
		
	}

	public void addInst(Instance i)    {
        dothis.add(i);
    }
	
	public String Prediction(String outlook, int temperature, int humidity, String wind) {
		String prediction = "";
		
		for (Instance i : dothis) {
			
			String o = i.getOutlook();
			int t = i.getTemperature();
			int h = i.getHumidity();
			String w = i.getWind();
			
			if (o.equals(outlook)&& outlook.equals("sunny")) {
				prediction = i.getPrediction();
			}
			else if (o.equals(outlook)&& outlook.equals("rainy")) {
				prediction = i.getPrediction();
			}
			else if (o.equals(outlook)&& outlook.equals("overcast")) {
				prediction = i.getPrediction();
			}
			else
				prediction = "null";
		}
		return prediction;
		
	}
	
	public String toString() {
        // returns a string representation of this prediction
        String toReturn = "";
        for (Instance i : dothis)
        {
            System.out.println(i);
        }
        return toReturn;
    }
	
	public void writeFile () {
			doWrite(filename, dothis);
	} 

	public void writeFile(String altFileName) {
			doWrite(altFileName, dothis); 
	}

	private void doWrite(String fn, ArrayList<Instance> instance) {
		try	{
		FileWriter fw = new FileWriter(fn);
		BufferedWriter myOutfile = new BufferedWriter(fw);
		for (int i = 0; i < instance.size(); i++) {
			Instance prediction = instance.get(i);
			myOutfile.write (prediction.toString()+"\n"); 
		}
			myOutfile.flush();
			myOutfile.close();
		}
		catch (Exception e) {
			e.printStackTrace();
			System.err.println("Didn't save to " + fn);
		}
	}	
}
