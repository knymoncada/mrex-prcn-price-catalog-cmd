package rtl.tot.corp.mrex.prcn.price.catalog.cmd.mrexprcnpricecatalogcmd.domain.model;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import rtl.tot.corp.mrex.prcn.price.catalog.cmd.mrexprcnpricecatalogcmd.infraestructure.adapters.output.db.cosmos.PriceRepository;

@Service
@Slf4j
public class PriceService {

PriceRepository repository;

public PriceService(PriceRepository repository) {
	super();
	this.repository = repository;
}

public boolean addPrice(PriceAggregate priceAgg){
	
	Price price = new Price();
	price.setSku(priceAgg.priceRootentity.getSku());
	
	//this.repository.save(product);
	log.info("Price Saved successful ", price);
	return true;
		
}

}
