package pl.retsuz.shell;

import pl.retsuz.context.IContext;
import pl.retsuz.filesystem.IComposite;
import pl.retsuz.shell.gen.ICommand;
import pl.retsuz.shell.specs.*;
import pl.retsuz.shell.variations.cd.CD_Path;
import pl.retsuz.shell.variations.cd.CD_ddot;
import pl.retsuz.shell.variations.cd.CD_def;
import pl.retsuz.shell.variations.gen.ICommandVariation;
import pl.retsuz.shell.variations.ls.LS_Def;
import pl.retsuz.shell.variations.ls.LS_Path;
import pl.retsuz.shell.variations.ls.LS_ddot;
import pl.retsuz.shell.variations.mkdir.Mkdir_Def;
import pl.retsuz.shell.variations.mkdir.Mkdir_Path;
import pl.retsuz.shell.variations.mkdir.Mkdir_ddot;
import pl.retsuz.shell.variations.more.More_Def;
import pl.retsuz.shell.variations.mv.MV_Def;
import pl.retsuz.shell.variations.mv.MV_Path;
import pl.retsuz.shell.variations.mv.MV_ddot;
import pl.retsuz.shell.variations.rm.RM_Def;
import pl.retsuz.shell.variations.rm.RM_Path;
import pl.retsuz.shell.variations.rm.RM_ddot;
import pl.retsuz.shell.variations.tree.Tree_Def;
import pl.retsuz.shell.variations.tree.Tree_Path;
import pl.retsuz.shell.variations.tree.Tree_ddot;

public abstract class DefShell {
    public static ICommand construct(IContext ctx){
        ICommand more = new More(ctx, null);
        ICommandVariation more_def= new More_Def(null, more);
        more.set_default(more_def);

        ICommand tree = new Tree(ctx, more);
        ICommandVariation tree_path= new Tree_Path(null, tree);
        ICommandVariation tree_ddot= new Tree_ddot(tree_path, tree);
        ICommandVariation tree_def= new Tree_Def(tree_ddot, tree);
        tree.set_default(tree_def);

        ICommand cd = new Cd(ctx, tree);
        ICommandVariation cd_path= new CD_Path(null, cd);
        ICommandVariation cd_ddot= new CD_ddot(cd_path, cd);
        ICommandVariation cd_def= new CD_def(cd_ddot, cd);
        cd.set_default(cd_def);

        ICommand ls = new Ls(ctx, cd);
        ICommandVariation ls_path= new LS_Path(null, ls);
        ICommandVariation ls_ddot= new LS_ddot(ls_path, ls);
        ICommandVariation ls_def= new LS_Def(ls_ddot, ls);
        ls.set_default(ls_def);

        ICommand rm = new Rm(ctx, ls);
        ICommandVariation rm_path= new RM_Path(null, rm);
        ICommandVariation rm_ddot = new RM_ddot(rm_path,rm);
        ICommandVariation rm_def = new RM_Def(rm_ddot,rm);
        rm.set_default(rm_def);

        ICommand mv = new Mv(ctx,rm);
        ICommandVariation mv_path= new MV_Path(null,mv);
        ICommandVariation mv_ddot= new MV_ddot(mv_path,mv);
        ICommandVariation mv_def= new MV_Def(mv_ddot,mv);
        mv.set_default(mv_def);

        ICommand mkdir = new MkDir(ctx,mv);
        ICommandVariation mkdir_path= new Mkdir_Path(null,mkdir);
        ICommandVariation mkdir_ddot= new Mkdir_ddot(mkdir_path,mkdir);
        ICommandVariation mkdir_def= new Mkdir_Def(mkdir_ddot,mkdir);
        mkdir.set_default(mkdir_def);

        return mkdir;
    }
}
