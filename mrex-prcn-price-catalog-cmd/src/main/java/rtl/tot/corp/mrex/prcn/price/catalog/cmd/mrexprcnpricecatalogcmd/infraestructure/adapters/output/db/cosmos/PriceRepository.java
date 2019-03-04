package rtl.tot.corp.mrex.prcn.price.catalog.cmd.mrexprcnpricecatalogcmd.infraestructure.adapters.output.db.cosmos;

import org.springframework.stereotype.Repository;

import com.microsoft.azure.spring.data.documentdb.repository.DocumentDbRepository;

import rtl.tot.corp.mrex.prcn.price.catalog.cmd.mrexprcnpricecatalogcmd.domain.model.Price;


@Repository
public interface PriceRepository extends DocumentDbRepository<Price, Long> {
 
}
