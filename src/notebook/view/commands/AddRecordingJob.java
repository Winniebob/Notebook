package notebook.view.commands;

import notebook.view.ConsoleUI;

public class AddRecordingJob extends Command {


    public AddRecordingJob(ConsoleUI consoleUI){
        super("Add recording",consoleUI);
    }

    public void execute(){
        getConsoleUI().addRecording();
    }
}