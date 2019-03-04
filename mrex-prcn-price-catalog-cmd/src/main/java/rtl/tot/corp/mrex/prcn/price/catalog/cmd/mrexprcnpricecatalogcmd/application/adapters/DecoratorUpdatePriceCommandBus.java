package rtl.tot.corp.mrex.prcn.price.catalog.cmd.mrexprcnpricecatalogcmd.application.adapters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import rtl.tot.corp.mrex.prcn.price.catalog.cmd.mrexprcnpricecatalogcmd.domain.events.PriceCreatedIntegrationEvent;
import rtl.tot.corp.mrex.prcn.price.catalog.cmd.mrexprcnpricecatalogcmd.domain.ports.CommandBus;
import rtl.tot.corp.mrex.prcn.price.catalog.cmd.mrexprcnpricecatalogcmd.infraestructure.adapters.output.asb.EventPublisherService;
import rtl.tot.corp.mrex.prcn.price.catalog.cmd.mrexprcnpricecatalogcmd.infraestructure.adapters.output.asb.EventType;
@Component
@Slf4j
public class DecoratorUpdatePriceCommandBus implements CommandBus<UpdatePriceCommandImpl> {
	

	@Autowired
	EventPublisherService publisher;
	UpdatePriceCommandBus bus;
	
    public DecoratorUpdatePriceCommandBus(UpdatePriceCommandBus bus) {
    	this.bus = bus;
    }
    

    	@Override
	public boolean execute(UpdatePriceCommandImpl command) throws Exception {


    		PriceCreatedIntegrationEvent integrationEvent = null;
    		try {

    			integrationEvent = new PriceCreatedIntegrationEvent();

    			integrationEvent.setCurrentPrice(command.getCurrentPrice());
    			integrationEvent.setRegularPrice(command.getRegularPrice());
    			integrationEvent.setSku(command.getSku());
    			integrationEvent.setStore(command.getStore());
    	
    	        if  (this.bus.execute(command)) {
    	            log.info("Sending PriceUpdatedEvent integration Event " , command.getSku());
    	       	 
    	            return publisher.publish(EventType.PRICE_UPDATED, integrationEvent);    	        
    			}        
    		} catch (Exception e) {
    			log.error("Error Sending PriceUpdatedEvent integration Event " + integrationEvent.getMetadata() , e.getLocalizedMessage());
    		}

    		
    	
		
		return false;
	}


	}