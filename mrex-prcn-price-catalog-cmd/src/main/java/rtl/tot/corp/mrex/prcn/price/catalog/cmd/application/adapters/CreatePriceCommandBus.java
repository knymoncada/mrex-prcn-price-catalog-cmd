package rtl.tot.corp.mrex.prcn.price.catalog.cmd.application.adapters;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import rtl.tot.corp.mrex.prcn.price.catalog.cmd.domain.ports.CommandBus;

@Component
public class CreatePriceCommandBus implements CommandBus<CreatePriceCommandImpl> {

	
	CreatePriceHandler handler;

	public CreatePriceCommandBus(CreatePriceHandler handler) {
		super();
		this.handler = handler;
	}


	@Override
	public boolean execute(CreatePriceCommandImpl command) throws Exception {
	 	return handler.handle(command);
		
	}






    
}