package rtl.tot.corp.mrex.prcn.price.catalog.cmd.mrexprcnpricecatalogcmd.application.adapters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import rtl.tot.corp.mrex.prcn.price.catalog.cmd.mrexprcnpricecatalogcmd.domain.ports.Handler;

@Slf4j
@Component
public class UpdatePriceHandler implements Handler<UpdatePriceCommandImpl> {

	@Autowired
	PriceServiceApplicationImpl service;
	
	public UpdatePriceHandler(PriceServiceApplicationImpl service) {
		this.service = service;
	}

	
	@Override
	public boolean handle(UpdatePriceCommandImpl cmd) throws Exception {
		return service.updatePrice((UpdatePriceCommandImpl) cmd);
		
	}

}
