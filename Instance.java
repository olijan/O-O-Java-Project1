package Project1;

public class Instance {
	private String Outlook;
	private int Temperature;
	private int Humidity;
	private String Wind;
	private String Prediction;
	
	public Instance() 
	{
	Outlook = "not set";
	Temperature = 0;
	Humidity = 0;
	Wind = "not set";
	Prediction = "not set";
	}
	
	public Instance(String outlook, int temperature, int humidity, String wind, String prediction) 
	{
		Outlook = outlook;
		Temperature = temperature;
		Humidity = humidity;
		Wind = wind;
		Prediction = prediction;
	}
	
	public String getOutlook() {
	return Outlook;
	}
	
	public void setOutlook(String outlook) {
	this.Outlook = outlook;
	}
	
	public int getTemperature() {
	return Temperature;
	}
	
	public void setTemperature(int temperature) {
	this.Temperature = temperature;
	}
	
	public int getHumidity() {
	return Humidity;
	}
	
	public void setHumidity(int humidity) {
	this.Humidity = humidity;
	}
	
	public String getWind() {
	return Wind;
	}
	
	public void setWind(String wind) {
	this.Wind = wind;
	}
	
	public String getPrediction() {
	return Prediction;
	}
	
	public void setPrediction(String prediction) {
	this.Prediction = prediction;
	}
	
	public String toString() {
	return Outlook +"," + Temperature + "," + Humidity + "," + Wind +"," + Prediction;
	}


}
