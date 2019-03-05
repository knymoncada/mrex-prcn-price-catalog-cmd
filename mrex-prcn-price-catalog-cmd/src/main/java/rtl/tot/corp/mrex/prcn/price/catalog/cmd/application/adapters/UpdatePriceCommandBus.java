package rtl.tot.corp.mrex.prcn.price.catalog.cmd.application.adapters;


import org.springframework.stereotype.Component;

import rtl.tot.corp.mrex.prcn.price.catalog.cmd.domain.ports.CommandBus;

@Component
public class UpdatePriceCommandBus implements CommandBus<UpdatePriceCommandImpl> {

	
	UpdatePriceHandler handler;

	public UpdatePriceCommandBus(UpdatePriceHandler handler) {
		super();
		this.handler = handler;
	}


	@Override
	public boolean execute(UpdatePriceCommandImpl command) throws Exception {
	 	return handler.handle(command);
		
	}






    
}