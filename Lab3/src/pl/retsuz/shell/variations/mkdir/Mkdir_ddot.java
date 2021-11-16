package pl.retsuz.shell.variations.mkdir;

import pl.retsuz.shell.gen.ICommand;
import pl.retsuz.shell.variations.gen.CommandVariation;
import pl.retsuz.shell.variations.gen.ICommandVariation;

public class Mkdir_ddot extends CommandVariation {
    public Mkdir_ddot(ICommandVariation next, ICommand parent) {
        super(next, parent, "\\.\\.");
    }
    @Override
    public void make(String params) {
        System.out.println("Bledna komenda!");
    }
}
