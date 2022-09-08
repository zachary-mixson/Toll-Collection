package tollCollectionV3;


public class vehicle {
	toll t = new toll();
	main m = new main();

	
	private double percentCharged;
	private double batteryCapacity;
	
	public double chargingCost(double initCharged, double initCap) {
		percentCharged = initCharged;
		batteryCapacity = initCap;
		double p = percentCharged * batteryCapacity;
		return p;
	}
	
	private int axles;
	
	public int axlesPrice(int ammountAxles){
		
	int[] axlesPrice = {0, 2, 3, 4, 9, 14, 19, 24, 29, 34, 39, 44, 49, 54, 59, 64, 69, 74, 79, 84, 89};
	
	axles = ammountAxles;
	return axlesPrice[axles];
	}
	
	
	private String payType;
	private String paymentOptions;
	public double payment(String paymentType,String payOption ){
	
		paymentOptions = payOption;
		payType = paymentType;
		
		String[] options = paymentOptions.split(",");
		
		double payAmmount[] = {1, 1.15, .80 };
		int ammount = 0;
		
		
		if (payType.equalsIgnoreCase(options[0])){
			ammount = 1;
		}
		if (payType.equalsIgnoreCase(options[1])){
			ammount = 0;
		}
		if (payType.equalsIgnoreCase(options[2])){
			ammount = 2;
		}

	return payAmmount[ammount];
	}
	
	private String vehicleType;
	
	public double vehicleAmmount(String TypeVehicle){
	//gas,electric,hybrid
	double vehicle[] = {1, .50, .25 };
	vehicleType = TypeVehicle;
	int number = 0;
	if (vehicleType.equalsIgnoreCase("gas")){
		number = 0;
	}
	if (vehicleType.equalsIgnoreCase("hybrid")){
		number = 2;
	}
	if (vehicleType.equalsIgnoreCase("electric")){
		number = 1;
	}
	return vehicle[number];
	
	

	}
}
