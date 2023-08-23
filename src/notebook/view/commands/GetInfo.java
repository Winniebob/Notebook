package notebook.view.commands;

import notebook.view.ConsoleUI;

public class GetInfo extends Command {


    public GetInfo(ConsoleUI consoleUI){
        super("Display recording",consoleUI);
    }

    public void execute(){
        getConsoleUI().getInfo();
    }
}