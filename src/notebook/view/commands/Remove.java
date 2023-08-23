package notebook.view.commands;

import notebook.view.ConsoleUI;

public class Remove extends Command {

    public Remove( ConsoleUI consoleUI) {
        super("Remove id" , consoleUI);
    }

    public void execute(){
        getConsoleUI().remove();
    }
}