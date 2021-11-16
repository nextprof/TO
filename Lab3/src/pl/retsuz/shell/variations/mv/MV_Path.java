package pl.retsuz.shell.variations.mv;

import pl.retsuz.filesystem.Composite;
import pl.retsuz.filesystem.IComposite;
import pl.retsuz.shell.gen.ICommand;
import pl.retsuz.shell.variations.gen.CommandVariation;
import pl.retsuz.shell.variations.gen.ICommandVariation;

public class MV_Path extends CommandVariation {
    public MV_Path(ICommandVariation next, ICommand parent) {
        super(next,parent,"[a-zA-Z0-9.l\\/_]* [a-zA-Z0-9.l\\/_]*");
    }

    @Override
    public void make(String params) {

        Composite c= (Composite) (this.getParent().getContext().getCurrent());
        String[] tab = params.split(" ");

        IComposite element = null,destination = null;

        try {
            element = c.findElementByPath(tab[0]);
        }catch(Exception e){
            System.out.println("element nie istnieje - mv");
        }

        try {
            destination = c.findElementByPath(tab[1]);
        }catch(Exception e){
            System.out.println("miejsce docelowe nie istnieje - mv");
        }

        try {

            if(element!=null && destination!=null)
                Composite.moveElement(element.getParent(),destination,element);
        }catch(Exception e){
            System.out.println("Move error");
        }
    }
}
