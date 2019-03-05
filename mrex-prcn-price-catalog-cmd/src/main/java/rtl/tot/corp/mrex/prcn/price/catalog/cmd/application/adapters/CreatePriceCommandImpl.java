package rtl.tot.corp.mrex.prcn.price.catalog.cmd.application.adapters;

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;

import lombok.Data;
import rtl.tot.corp.mrex.prcn.price.catalog.cmd.domain.ports.CreatePriceCommand;
import rtl.tot.corp.mrex.prcn.price.catalog.cmd.infraestructure.adapters.http.rest.domain.Price;
import rtl.tot.corp.mrex.prcn.price.catalog.cmd.infraestructure.adapters.http.rest.domain.Price.Detraction;
import rtl.tot.corp.mrex.prcn.price.catalog.cmd.infraestructure.adapters.http.rest.domain.Price.Tax;

@Data
public class CreatePriceCommandImpl implements CreatePriceCommand<Price> {

	@Id
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
	public static class Tax{
		String tax;
		Double amountTax;
	}
	@Data
	public static class Detraction {
		String codeDetraction;
		String nameDetraction;
		Double percentDetraction;
	}

	public CreatePriceCommandImpl(Price price) {
		super();
		this.sku = price.getSku();
		this.store = price.getStore();
		this.currentPrice = price.getCurrentPrice();
		this.regularPrice = price.getRegularPrice();
		this.promotionPrice = price.getPromotionPrice();
		this.detraction.setCodeDetraction(price.getDetraction().getCodeDetraction());
		for (rtl.tot.corp.mrex.prcn.price.catalog.cmd.infraestructure.adapters.http.rest.domain.Price.Tax tax
				: price.getTaxes()) {
			Tax newTax = new Tax();
			newTax.setAmountTax(tax.getAmountTax());
			newTax.setTax(tax.getTax());
			this.taxes.add(newTax);
		}
	}

}