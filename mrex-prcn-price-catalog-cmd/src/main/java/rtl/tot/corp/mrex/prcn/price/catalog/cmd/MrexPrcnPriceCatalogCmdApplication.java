package rtl.tot.corp.mrex.prcn.price.catalog.cmd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("rtl.tot.corp.mrex.prcn.price.catalog.cmd")
@SpringBootApplication
public class MrexPrcnPriceCatalogCmdApplication {

	public static void main(String[] args) {
		SpringApplication.run(MrexPrcnPriceCatalogCmdApplication.class, args);
	}

}
