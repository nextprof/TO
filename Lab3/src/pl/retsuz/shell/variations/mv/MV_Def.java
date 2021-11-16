package pl.retsuz.shell.variations.mv;

import pl.retsuz.shell.gen.ICommand;
import pl.retsuz.shell.variations.gen.CommandVariation;
import pl.retsuz.shell.variations.gen.ICommandVariation;

public class MV_Def extends CommandVariation {
    public MV_Def(ICommandVariation next, ICommand parent) {
        super(next,parent,"");
    }
    @Override
    public void make(String params) {
        System.out.println("Zbyt mała liczba parametrów!");

    }
}
