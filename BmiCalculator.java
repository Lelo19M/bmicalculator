//package bmicalculator;

import java.util.Scanner;
import java.util.Locale;


public class BmiCalculator{

public static void main(String[] args) { 
	Scanner scanner = new Scanner(System.in);
	scanner.useLocale(Locale.US);
	
char repeat=0;

do{
	System.out.println("Discover your BMI with us!!!");
	System.out.println("Please Enter your Name:");
	String name = scanner.next();
	
	int unitChoice = getUnitChoice(scanner);
	double weight = (unitChoice == 1)? getValidInput(scanner, "Enter your weight in kilograms : " ,10, 600)
			: getValidInput(scanner, "Enter your weight in pounds", 22, 1300);
	double height = (unitChoice == 1)? getValidInput(scanner, "Enter your height in meters : " ,0.5, 2.5)
			: getValidInput(scanner, "Enter your weight in inches", 20, 100);
	
	double bmi = calculateBMI(unitChoice, weight, height);
	System.out.println("Hello " + name.toUpperCase() + " Your Bmi is "  + bmi);

	 
	if(bmi < 18.5){
		System.out.println("Underweight");
		System.out.println("Advice : Please try eating nutritious food");
	}else if(bmi <25){
		System.out.println("Normal weight");
		System.out.println("Feedback : Keep it up!!");
	}else if(bmi <30){
		System.out.println("Overweight");
		System.out.println("Advice :Consider eating healthy food and exercise regularly");
	}else if(bmi>35){
		System.out.println("obese");
		System.out.println("Advice : focus on a healthy diet and regular exercises");
	}else{
		System.out.println("Severely");
System.out.println("Advice : you must consult a healthcare professional");	
	}
	
		
//repeat = askToRepeat(scanner);
	
	
	

			System.out.println("Would you like to repeat? (Y/N)");
	repeat = 
	scanner.next().charAt(0);
	
	
	
}while (repeat == 'Y' || repeat == 'y'); 
scanner.close();
}
public static int getUnitChoice(Scanner scanner){
	int choice;
	
	while(true){
		System.out.println("Select a preferred unit:\n"
		+ "1.Metric (kg, m)\n"
		+ "2. Imperial(lbs, in)\n"
		+ "Please select either option 1 or 2");
		if (scanner.hasNextInt()){
			choice = scanner.nextInt();
			if (choice == 1 || choice == 2){
			break;	
				
			}else{
			System.out.println("Invalid choice. Please enter either 1 or 2");
			}
				
		}else{
		    System.out.println("Invalid input. Please enter a number (1 or 2");	
			
		}		
			}

			
		
	
	return choice;
	
}
public static double getValidInput(Scanner scanner, String prompt, double min, double max){
  double value;
while(true){
  System.out.println(prompt);
  
  if(scanner.hasNextDouble()){
	  value = scanner.nextDouble();
	  if (value >= min && value <= max){
		break;  
	  }
	  else {
		 System.out.printf("Please enter a value between %.1f and %.1f.\n", min, max);
	  }
  }
	  else{		 
		System.out.println("Invalid input. Please enter a value");  
		scanner.next();
	  }
	
  
}	
	return value;
}
  

public static double calculateBMI(int unitChoice, double weight, double height){
	double totalBMI;
	if(unitChoice ==1){
		 totalBMI = weight / (height *height);
	}else {
 totalBMI = (703 * weight) / (height / height);
	} 
	return totalBMI;
	
}
	
	
	
}