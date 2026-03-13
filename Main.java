package Parking_Permit;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			
			try {
				
				System.out.println("Enter your permit (Commuter/Resident): ");
				PermitType permit = 
						PermitType.valueOf(scanner.nextLine().trim().toUpperCase());
						
				System.out.println("Enter Vehicle type (Car/SUV/Motorcycle): ");
				VehicleType vehicle = 
						VehicleType.valueOf(scanner.nextLine().trim().toUpperCase());
				
				System.out.println("Carpool? (Y/N): ");
                boolean carpool =
                        scanner.nextLine().equalsIgnoreCase("Y");

                System.out.println("Months (1-12): ");
                int months =
                        Integer.parseInt(scanner.nextLine());

                PermitSelection selection =
                        new PermitSelection(permit, vehicle, carpool, months);

                selection.validate();

                PricingStrategy strategy;

                if (permit == PermitType.RESIDENT) {
                    strategy = new ResidentPricingStrategy();
                } else {
                    strategy = new CommuterPricingStrategy();
                    
                }

                List<RateModifier> modifiers = new ArrayList<>();

                modifiers.add(vehicle);

                if (carpool) {
                    modifiers.add(new Carpool());
                }

                PricingPipeline pipeline =
                        new PricingPipeline(modifiers);

                PricingCalculator calculator =
                        new PricingCalculator(strategy, pipeline);

                BigDecimal subtotal =
                        calculator.calculateSubtotal(selection);

                BigDecimal fee =
                        calculator.campusFee(subtotal);

                BigDecimal total =
                        calculator.total(subtotal);

                Receipt.print(selection, subtotal, fee, total);

            }

            catch (InvalidSelectionException e) {

                System.out.println("Error: " + e.getMessage());

            }

            catch (Exception e) {

                System.out.println("Invalid input. Please try again.");

            }

            System.out.println("\nRun another simulation? (Y/N)");

            if (!scanner.nextLine().equalsIgnoreCase("Y")) {
                break;
            }
        }

        scanner.close();
    }
}
