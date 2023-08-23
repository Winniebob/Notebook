package notebook.view.commands;

import notebook.view.ConsoleUI;

public class ReadFile extends Command {

    public ReadFile( ConsoleUI consoleUI) {
        super("Read File" , consoleUI);
    }

    public void execute(){
        getConsoleUI().readFile();
    }
}