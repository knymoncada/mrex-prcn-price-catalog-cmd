package rtl.tot.corp.mrex.prcn.price.catalog.cmd.mrexprcnpricecatalogcmd.domain.ports;

public interface Handler<Command> {
public boolean handle(Command cmd) throws Exception;
}
