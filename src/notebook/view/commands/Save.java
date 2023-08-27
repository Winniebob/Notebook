package notebook.view.commands;

import notebook.view.ConsoleUI;

public class Save extends Command {

    public Save( ConsoleUI consoleUI) {
        super("Save File" , consoleUI);
    }

    public void execute(){
        getConsoleUI().save();
    }
}