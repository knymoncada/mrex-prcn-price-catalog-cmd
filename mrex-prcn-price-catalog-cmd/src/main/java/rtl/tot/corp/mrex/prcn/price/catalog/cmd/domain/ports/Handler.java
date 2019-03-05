package rtl.tot.corp.mrex.prcn.price.catalog.cmd.domain.ports;

public interface Handler<Command> {
public boolean handle(Command cmd) throws Exception;
}
