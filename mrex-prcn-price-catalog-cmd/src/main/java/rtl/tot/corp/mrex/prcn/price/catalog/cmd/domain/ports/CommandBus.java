package rtl.tot.corp.mrex.prcn.price.catalog.cmd.domain.ports;

public interface CommandBus<Command> {

    public boolean execute(Command command) throws Exception;
}