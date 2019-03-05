package rtl.tot.corp.mrex.prcn.price.catalog.cmd.application.adapters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import rtl.tot.corp.mrex.prcn.price.catalog.cmd.application.adapters.UpdatePriceCommandImpl.Tax;
import rtl.tot.corp.mrex.prcn.price.catalog.cmd.domain.events.PriceCreatedIntegrationEvent;
import rtl.tot.corp.mrex.prcn.price.catalog.cmd.domain.events.PriceUpdatedIntegrationEvent;
import rtl.tot.corp.mrex.prcn.price.catalog.cmd.domain.ports.CommandBus;
import rtl.tot.corp.mrex.prcn.price.catalog.cmd.infraestructure.adapters.output.asb.EventPublisherService;
import rtl.tot.corp.mrex.prcn.price.catalog.cmd.infraestructure.adapters.output.asb.EventType;
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


    		PriceUpdatedIntegrationEvent integrationEvent = null;
    		try {

    			integrationEvent = new PriceUpdatedIntegrationEvent();

    			integrationEvent.setCurrentPrice(command.getCurrentPrice());
    			integrationEvent.setRegularPrice(command.getRegularPrice());
    			integrationEvent.setSku(command.getSku());
    			integrationEvent.setStore(command.getStore());
    			integrationEvent.setPromotionPrice(command.getPromotionPrice());
    			integrationEvent.getDetraction().setCodeDetraction(command.getDetraction().getCodeDetraction());
    			integrationEvent.getDetraction().setNameDetraction(command.getDetraction().getNameDetraction());
    			integrationEvent.getDetraction().setPercentDetraction(command.getDetraction().getPercentDetraction());
       
    			for(Tax tax: command.getTaxes()) {
    				PriceUpdatedIntegrationEvent.Tax newTax = new PriceUpdatedIntegrationEvent.Tax();
    				newTax.setAmountTax(tax.getAmountTax());
    				newTax.setTax(tax.getTax());
    				integrationEvent.getTaxes().add(newTax);
    			}
    	
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