package tollCollectionV3;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class toll {


	public static void main(String[] args) throws IOException {
		booth b = new booth();
		vehicle v = new vehicle();
		
	//file reading 
	File file = new File("/Users/zacharymixson/Desktop/vehichle.txt");
	Scanner scan = new Scanner(file);
	
	File f = new File("/Users/zacharymixson/Desktop/admin.txt");
	Scanner s = new Scanner(f);
	
	FileWriter writer = new FileWriter("/Users/zacharymixson/Desktop/Data.txt");

	
	
	int boothAmmount = Integer.parseInt(s.nextLine());
	String boothNames = s.nextLine();
	String paymentOptions = s.nextLine();
	String[] allBooths = boothNames.split(",");
	String[] paymentOptionsSplit = paymentOptions.split(",");
	
	
	while(scan.hasNextLine()){

		
		String boothLocation = scan.nextLine();
		String vehicleType = scan.nextLine();
		int axles = Integer.parseInt(scan.nextLine());
		String payType = scan.nextLine();
		String blank = scan.nextLine();
		
		double carTotal = v.vehicleAmmount(vehicleType) * v.axlesPrice(axles) * v.payment(payType, paymentOptions);
		
		double rounded = Math.round((carTotal)*100.0/100.0);
		int m = 1;
		int i = boothAmmount;
		int x =0;
		while(i> 0) {
			
			if (allBooths[x].equalsIgnoreCase(boothLocation)){
				b.boothTotals[x]= rounded + b.boothTotals[x];
				writer.write("The total for car " + m + " is $" + rounded + ".");

			}
			x= x +1;
			i= i-1;
			m = m + 1;

		}
		
		int j = 3;
		int y =0;
		while(j> 0) {
			
			if (paymentOptionsSplit[y].equalsIgnoreCase(payType)){
				b.paymentTotals[y]= rounded + b.paymentTotals[y];

			}
			b.total = b.total + rounded;
			y= y +1;
			j= j-1;
		}
		

	}
	int d = 0;
	int h = boothAmmount;
	while (h>0){
		
		writer.write(" The total for booth " + allBooths[d] + " is $" + b.boothTotals[d] + ". ");

		
		d = d +1;
		h= h-1;
	}
	int g = 0;
	int u = 3;
	while (u>0){
		
		writer.write(" The total for " + paymentOptionsSplit[g] + " is $" + b.paymentTotals[g] + ". ");

		
		g = g +1;
		u= u-1;
	}
	writer.write(" The total for everything is $" + b.total + ". ");

	writer.close();
	
	
	
	
	
	
	}
}
