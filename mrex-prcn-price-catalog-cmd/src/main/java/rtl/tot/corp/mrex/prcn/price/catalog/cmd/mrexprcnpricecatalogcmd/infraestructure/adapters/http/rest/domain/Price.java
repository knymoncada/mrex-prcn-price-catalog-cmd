package rtl.tot.corp.mrex.prcn.price.catalog.cmd.mrexprcnpricecatalogcmd.infraestructure.adapters.http.rest.domain;

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
}

