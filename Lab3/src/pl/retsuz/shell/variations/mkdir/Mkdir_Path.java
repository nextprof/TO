package pl.retsuz.shell.variations.mkdir;

import pl.retsuz.filesystem.Composite;
import pl.retsuz.filesystem.IComposite;
import pl.retsuz.shell.gen.ICommand;
import pl.retsuz.shell.variations.gen.CommandVariation;
import pl.retsuz.shell.variations.gen.ICommandVariation;

public class Mkdir_Path extends CommandVariation {

    public Mkdir_Path(ICommandVariation next, ICommand parent) {
        super(next,parent,"[a-zA-Z0-9.l\\/_]*");
    }

    @Override
    public void make(String params) {

        Composite c = (Composite) (this.getParent().getContext().getCurrent());
        String[] paths = params.split("/");

        try {
            for (String path : paths) {
                try {
                    if (path.equals("..")) {
                        c = (Composite) c.getParent();
                    } else {
                        c = (Composite) c.getElement(c.findElementByPath(path));
                    }
                } catch (Exception e) {
                    IComposite newElement = new Composite();
                    newElement.setName(path);
                    c.addElement(newElement);
                    c = (Composite) c.getElement(newElement);
                }
            }
        }catch(Exception e){
            System.out.println("Docelowy element nie jest katalogiem lub obecny katalog nie zawiera elementu.");
        }


    }
}
