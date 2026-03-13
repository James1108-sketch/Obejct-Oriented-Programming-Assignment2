package Parking_Permit;

import java.math.BigDecimal;

public enum VehicleType implements RateModifier {
	
	Car{
		public BigDecimal apply(BigDecimal price){
			return price;
		}
	},
	SUV{
		public BigDecimal apply(BigDecimal price) {
			return price.multiply(new BigDecimal("1.15"));
		}
	},
	Motorcycle{
		public BigDecimal apply(BigDecimal price) {
			return price.multiply(new BigDecimal("0.70"));
		}
	};
	

}
