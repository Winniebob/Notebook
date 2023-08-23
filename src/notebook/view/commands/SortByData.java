package notebook.view.commands;

import notebook.view.ConsoleUI;

public class SortByData extends Command {

    public SortByData( ConsoleUI consoleUI) {
        super("Sort by data" , consoleUI);
    }

    public void execute(){
        getConsoleUI().sortByData();
    }
}