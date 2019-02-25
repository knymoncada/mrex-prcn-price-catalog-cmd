package rtl.tot.corp.mrex.prcn.price.catalog.cmd.mrexprcnpricecatalogcmd.application.adapters;


import org.springframework.stereotype.Component;

import rtl.tot.corp.mrex.prcn.price.catalog.cmd.mrexprcnpricecatalogcmd.domain.ports.CommandBus;

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