package notebook.view.commands;

import notebook.view.ConsoleUI;

public class SeachData extends Command {

    public SeachData( ConsoleUI consoleUI) {
        super("Seach Data" , consoleUI);
    }

    public void execute(){
        getConsoleUI().seachData();
    }
}