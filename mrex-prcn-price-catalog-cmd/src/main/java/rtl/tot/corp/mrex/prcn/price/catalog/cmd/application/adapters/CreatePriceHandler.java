package rtl.tot.corp.mrex.prcn.price.catalog.cmd.application.adapters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import rtl.tot.corp.mrex.prcn.price.catalog.cmd.domain.ports.Handler;

@Slf4j
@Component
public class CreatePriceHandler implements Handler<CreatePriceCommandImpl> {

	@Autowired
	PriceServiceApplicationImpl service;
	
	public CreatePriceHandler(PriceServiceApplicationImpl service) {
		this.service = service;
	}

	
	@Override
	public boolean handle(CreatePriceCommandImpl cmd) throws Exception {
		return service.addPrice((CreatePriceCommandImpl) cmd);
		
	}

}
