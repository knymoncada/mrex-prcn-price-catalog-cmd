package rtl.tot.corp.mrex.prcn.price.catalog.cmd.application.adapters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rtl.tot.corp.mrex.prcn.price.catalog.cmd.domain.model.PriceAggregate;
import rtl.tot.corp.mrex.prcn.price.catalog.cmd.domain.model.PriceService;

@Service
public class PriceServiceApplicationImpl {

	@Autowired
	PriceService service;
	PriceAggregate aggregate;
	
	
	public boolean addPrice(CreatePriceCommandImpl cmd) {
		
		
		aggregate = new  PriceAggregate.Builder()
				.sku(cmd.getSku())
				.build();
		if (this.aggregate.addPrice(service))
			return true;
		else
			return false;

	}
public boolean updatePrice(UpdatePriceCommandImpl cmd) {
		
		
		aggregate = new  PriceAggregate.Builder()
				.sku(cmd.getSku())
				.build();
		if (this.aggregate.addPrice(service))
			return true;
		else
			return false;

	}
}
