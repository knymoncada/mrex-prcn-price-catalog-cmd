package rtl.tot.corp.mrex.prcn.price.catalog.cmd.infraestructure.adapters.http.rest.domain;

import java.util.HashSet;
import java.util.Set;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class Price {
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
	}
	@Data
	public class Detraction {
		String codeDetraction;
		String nameDetraction;
		Double percentDetraction;
	}
}

