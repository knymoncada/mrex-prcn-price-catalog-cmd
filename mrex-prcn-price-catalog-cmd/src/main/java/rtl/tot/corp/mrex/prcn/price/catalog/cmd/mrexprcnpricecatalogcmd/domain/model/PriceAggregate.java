package rtl.tot.corp.mrex.prcn.price.catalog.cmd.mrexprcnpricecatalogcmd.domain.model;

import java.util.HashSet;
import java.util.Set;
public class PriceAggregate {

	final PriceRootEntity  priceRootentity;
	
	public PriceAggregate(Builder builder) {
		this.priceRootentity = new PriceRootEntity(
				builder.sku,
				builder.store,
				builder.currentPrice,
				builder.regularPrice,
				builder.promotionPrice,
				builder.taxes,
				builder.detraction
				);
		
	}
	
	public boolean isValid() {
		return true;
	}
	
	public boolean addPrice(PriceService service) {
		return service.addPrice(this);
	}
	
	

	public static class Builder{
		String sku;	
		Long store;
		Double currentPrice;	
		Double regularPrice;
		Double promotionPrice;
		Set<Tax> taxes = new HashSet<Tax>();
		Detraction detraction = new Detraction();
		
		
		
		
		public Builder sku(String sku) {
			this.sku = sku;
			return this;
		}

		public Builder store(Long store) {
			this.store = store;
			return this;
		}

		public Builder currentPrice(Double currentPrice) {
			this.currentPrice = currentPrice;
			return this;
		}

		public Builder regularPrice(Double regularPrice) {
			this.regularPrice = regularPrice;
			return this;
		}

		public Builder promotionPrice(Double promotionPrice) {
			this.promotionPrice = promotionPrice;
			return this;
		}

		public Builder taxes(Set<Tax> taxes) {
			this.taxes = taxes;
			return this;
		}

		public Builder detraction(Detraction detraction) {
			this.detraction = detraction;
			return this;
		}

		
		
		
		public PriceAggregate build() {
			
			return new PriceAggregate(this);
		}
		
		
	



		
	}
}
