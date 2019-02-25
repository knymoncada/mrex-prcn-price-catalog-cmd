package rtl.tot.corp.mrex.prcn.price.catalog.cmd.mrexprcnpricecatalogcmd.application.adapters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import rtl.tot.corp.mrex.prcn.price.catalog.cmd.mrexprcnpricecatalogcmd.domain.events.PriceCreatedIntegrationEvent;
import rtl.tot.corp.mrex.prcn.price.catalog.cmd.mrexprcnpricecatalogcmd.domain.ports.Handler;
import rtl.tot.corp.mrex.prcn.price.catalog.cmd.mrexprcnpricecatalogcmd.infraestructure.adapters.output.asb.EventPublisherService;
import rtl.tot.corp.mrex.prcn.price.catalog.cmd.mrexprcnpricecatalogcmd.infraestructure.adapters.output.asb.EventType;

@Slf4j
@Component
public class CreatePriceHandler implements Handler<CreatePriceCommandImpl> {

	@Autowired
	EventPublisherService publisher;

	public CreatePriceHandler() {

	}

	@Override
	public boolean handle(CreatePriceCommandImpl command) throws Exception {

		PriceCreatedIntegrationEvent integrationEvent = null;
		try {

			integrationEvent = new PriceCreatedIntegrationEvent();

			integrationEvent.setCurrentPrice(command.getCurrentPrice());
			integrationEvent.setRegularPrice(command.getRegularPrice());
			integrationEvent.setSku(command.getSku());
			integrationEvent.setStore(command.getStore());
			log.info("Sending PriceCreateEvent integration Event ", command.getSku());

			return publisher.publish(EventType.PRICE_CREATED, integrationEvent);
			

		} catch (Exception e) {
			log.error("Error Sending PriceCreateEvent integration Event " + integrationEvent.getMetadata(),
					e.getLocalizedMessage());
		}
		return false;

	}

}
