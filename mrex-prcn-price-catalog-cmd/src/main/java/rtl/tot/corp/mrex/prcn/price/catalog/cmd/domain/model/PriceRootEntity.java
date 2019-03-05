package rtl.tot.corp.mrex.prcn.price.catalog.cmd.domain.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class PriceRootEntity {

	
		
	String sku;	
	Long store;
	Double currentPrice;	
	Double regularPrice;
	Double promotionPrice;
	Set<Tax> taxes = new HashSet<Tax>();
	Detraction detraction = new Detraction();

	
	
	public PriceRootEntity(String sku, Long store, Double currentPrice, Double regularPrice, Double promotionPrice,
			Set<Tax> taxes, Detraction detraction) {
		super();
		this.sku = sku;
		this.store = store;
		this.currentPrice = currentPrice;
		this.regularPrice = regularPrice;
		this.promotionPrice = promotionPrice;
		this.taxes = taxes;
		this.detraction = detraction;
	}
	
	
	
}
