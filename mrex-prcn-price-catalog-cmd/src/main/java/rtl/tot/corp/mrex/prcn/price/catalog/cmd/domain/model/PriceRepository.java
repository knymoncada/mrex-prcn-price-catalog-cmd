package rtl.tot.corp.mrex.prcn.price.catalog.cmd.domain.model;

import org.springframework.stereotype.Repository;

import com.microsoft.azure.spring.data.documentdb.repository.DocumentDbRepository;

@Repository
public interface PriceRepository extends DocumentDbRepository<Price, Long> {
 
	
}
