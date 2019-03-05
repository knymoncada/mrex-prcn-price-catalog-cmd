package rtl.tot.corp.mrex.prcn.price.catalog.cmd.infraestructure.adapters.http.rest.domain;

import java.util.HashSet;
import java.util.Set;
import javax.validation.constraints.NotNull;
import lombok.Data;
import rtl.tot.corp.mrex.prcn.price.catalog.cmd.application.adapters.CreatePriceCommandImpl.Tax;

@Data
public class UpdatePrice {
	@NotNull
	String sku;	
	@NotNull
	Long store;
	@NotNull
	Double currentPrice;	
	@NotNull
	Double regularPrice;
	@NotNull
	Double promotionPrice;
	@NotNull
	Set<Tax> taxes = new HashSet<Tax>();
	Detraction detraction = new Detraction();
	@Data
	public 	static class Tax{
		String tax;
		Double amountTax;
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Tax other = (Tax) obj;
			if (tax == null) {
				if (other.tax != null)
					return false;
			} else if (!tax.equals(other.tax))
				return false;
			if (tax.equals(other.tax)) return true;
			return true;
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((tax == null) ? 0 : tax.hashCode());
			return result;
		}
		
		
	
	}
	@Data
	public class Detraction {
		String codeDetraction;
		String nameDetraction;
		Double percentDetraction;
	}
}

