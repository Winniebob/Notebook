package notebook.view.commands;

import notebook.view.ConsoleUI;

public class Finish extends Command {


    public Finish(ConsoleUI consoleUI){
        super("Finish work.",consoleUI);
    }

    public void execute(){
        getConsoleUI().finish();
    }
}