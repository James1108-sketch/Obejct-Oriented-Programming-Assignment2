package Parking_Permit;

import java.math.BigDecimal;
import java.math.RoundingMode;

public final class Receipt {

	public static void print(PermitSelection selection, BigDecimal subtotal, BigDecimal fee, BigDecimal total) {
		
		System.out.println("\n-----Parking Permit Recipt-----");
		
		System.out.println("Permit type: " + selection.getPermitType());
		System.out.println("Vehicle type: " + selection.getVehcileType());
		System.out.println("Carpool: " + selection.isCarpool());
		System.out.println("Months: " + selection.getMonths());
		
		System.out.println("Subtotal: $" + subtotal.setScale(2, RoundingMode.HALF_UP));
		
		System.out.println("Campus Fee (5%): $" + fee);
		
		System.out.println("Total: $" + total);
	}
}
