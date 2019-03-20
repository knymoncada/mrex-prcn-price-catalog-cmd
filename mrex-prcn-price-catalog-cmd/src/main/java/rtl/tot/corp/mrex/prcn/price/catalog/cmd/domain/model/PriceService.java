package rtl.tot.corp.mrex.prcn.price.catalog.cmd.domain.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PriceService {

PriceRepository repository;

public PriceService(PriceRepository repository) {
	this.repository = repository;
}

public boolean addPrice(PriceAggregate priceAgg){
	
	Price price = new Price();
	price.setSku(priceAgg.priceRootentity.getSku());
	
	//this.repository.save(price);
	log.info("Price Saved successful ", price);
	return true;
		
}

}
