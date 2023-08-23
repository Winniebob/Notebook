package notebook;


import notebook.view.ConsoleUI;
import notebook.view.View;


public class Main {
    public static void main(String[] args)  {
        View view = new ConsoleUI();
        view.start();

    }

}