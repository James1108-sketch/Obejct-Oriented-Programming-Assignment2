package Parking_Permit;

import java.math.BigDecimal;
import java.math.RoundingMode;

public final class PricingCalculator {
	
	private PricingStrategy strategy;
	private PricingPipeline pipeline;

	public PricingCalculator(PricingStrategy strategy, PricingPipeline pipeline) {
		
		this.strategy = strategy;
		this.pipeline = pipeline;
	}
	
	public BigDecimal calculateSubtotal(PermitSelection selection) {
		
		BigDecimal monthly = strategy.computeMonthly(selection);
		
		monthly = pipeline.applyModifiers(monthly);
		
		return monthly.multiply(new BigDecimal(selection.getMonths()));
	}
	
	public BigDecimal campusFee (BigDecimal subtotal) {
		
		return subtotal
				.multiply(new BigDecimal(".05"))
				.setScale(2, RoundingMode.HALF_UP);
	}
	
	public BigDecimal total(BigDecimal subtotal) {
		
		return subtotal
				.add(campusFee(subtotal))
				.setScale(2, RoundingMode.HALF_UP);
	}
}
