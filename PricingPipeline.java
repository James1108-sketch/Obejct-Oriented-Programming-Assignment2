package Parking_Permit;

import java.math.BigDecimal;
import java.util.List;

public class PricingPipeline {
	
	private List<RateModifier> modifiers;
	
	public PricingPipeline(List<RateModifier> modifiers) {
		this.modifiers = modifiers;
	}

	public BigDecimal applyModifiers(BigDecimal price) {
		
		for (RateModifier modifier: modifiers) {
			price = modifier.apply(price);
		}
		return price;
	}
}
