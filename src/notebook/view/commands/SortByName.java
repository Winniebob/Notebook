package notebook.view.commands;

import notebook.view.ConsoleUI;

public class SortByName extends Command {

    public SortByName( ConsoleUI consoleUI) {
        super("Sort by Name", consoleUI);
    }

    public void execute(){
        getConsoleUI().sortByName();
    }
}