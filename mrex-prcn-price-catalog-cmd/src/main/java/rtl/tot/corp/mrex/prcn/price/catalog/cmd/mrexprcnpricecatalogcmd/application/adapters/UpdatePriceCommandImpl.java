package rtl.tot.corp.mrex.prcn.price.catalog.cmd.mrexprcnpricecatalogcmd.application.adapters;

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;

import lombok.Data;
import rtl.tot.corp.mrex.prcn.price.catalog.cmd.mrexprcnpricecatalogcmd.domain.ports.CreatePriceCommand;
import rtl.tot.corp.mrex.prcn.price.catalog.cmd.mrexprcnpricecatalogcmd.infraestructure.adapters.http.rest.domain.Price;
import rtl.tot.corp.mrex.prcn.price.catalog.cmd.mrexprcnpricecatalogcmd.infraestructure.adapters.http.rest.domain.Price.Detraction;
import rtl.tot.corp.mrex.prcn.price.catalog.cmd.mrexprcnpricecatalogcmd.infraestructure.adapters.http.rest.domain.Price.Tax;
import rtl.tot.corp.mrex.prcn.price.catalog.cmd.mrexprcnpricecatalogcmd.infraestructure.adapters.http.rest.domain.UpdatePrice;

@Data
public class UpdatePriceCommandImpl implements CreatePriceCommand<UpdatePrice> {

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
	private static class Tax{
		String tax;
		Double amountTax;
	}
	@Data
	private static class Detraction {
		String codeDetraction;
		String nameDetraction;
		Double percentDetraction;
	}

	public UpdatePriceCommandImpl(UpdatePrice price) {
		super();
		this.sku = price.getSku();
		this.store = price.getStore();
		this.currentPrice = price.getCurrentPrice();
		this.regularPrice = price.getRegularPrice();
		this.promotionPrice = price.getPromotionPrice();
		this.detraction.setCodeDetraction(price.getDetraction().getCodeDetraction());
		for (rtl.tot.corp.mrex.prcn.price.catalog.cmd.mrexprcnpricecatalogcmd.infraestructure.adapters.http.rest.domain.UpdatePrice.Tax tax
				: price.getTaxes()) {
			Tax newTax = new Tax();
			newTax.setAmountTax(tax.getAmountTax());
			newTax.setTax(tax.getTax());
			this.taxes.add(newTax);
		}
	}

}