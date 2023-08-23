package notebook.view;

import notebook.model.Notebook.Presenter.Presenter;


import java.time.LocalDate;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class ConsoleUI implements View {
    private Presenter presenter;
    private Scanner scanner;
    private boolean flag;
    private MainMenu menu;

    public ConsoleUI() {
        scanner = new Scanner(System.in);
        presenter = new Presenter(this);
        flag = true;
        menu = new MainMenu(this);
    }

    public void sortByData() {
        presenter.sortByData();
    }

    public void sortByName() {
        presenter.sortByName();
    }

    @Override
    public void start() {

        while (flag) {
            printMenu();
            execute();
        }
    }

    @Override
    public void printAnswer(String answer) {
        System.out.println(answer);
    }

    public void finish() {
        System.out.println("GoodBuy");
        flag = false;
        scanner.close();
    }

    public void seachData() {
        try {
            System.out.println("Enter a day.");
            while (scanner.hasNextInt()) {
                int days = scanner.nextInt();
                if (days <= 7 & days > 0) {
                    presenter.seachData(days);
                    break;
                }
                System.out.println("Days per week 7");
                break;
            }
        } catch (NullPointerException e) {
            inputError();
        }
    }

    public void readFile() {
        presenter.readFile();
    }

    public void remove() {
        try {


            System.out.println("Delet is?:");
            int recordingId = 0;
            while (scanner.hasNextInt()) {
                recordingId = scanner.nextInt();
                break;
            }
            presenter.remove(recordingId);
        } catch (NullPointerException e) {
            inputError();
        }
    }

    public void addRecording() {
        try {
            int id = 0;
            System.out.println("Enter a name : ");
            String name = scanner.next();
            System.out.println("Enter a home");
            String home = scanner.next();
            System.out.println("Enter a street");
            String street = scanner.next();
            System.out.println("Enter a city");
            String city = scanner.next();
            System.out.println("Enter a colleague");
            String myCollague = scanner.next();
            System.out.println("Enter a Job");
            String job = scanner.next();
            System.out.println("Enter a Information");
            String addNewInformation = scanner.next();
            System.out.println("Enter a data.");
            System.out.println("Enter a day.");
            while (scanner.hasNextInt()) {
                int Day = scanner.nextInt();
                System.out.println("Enter a month.");
                int Month = scanner.nextInt();
                System.out.println("Enter a Year.");
                int Year = scanner.nextInt();
                LocalDate data = LocalDate.of(1, 1, 1);
                int Days = Integer.valueOf(Day);
                int Months = Integer.valueOf(Month);
                int Years = Integer.valueOf(Year);
                if (Days > 0 && Days < 31 && Months > 0 && Months <= 12 && Years > 0 && Years < 2030) {
                    data = data.plusDays(Days);
                    data = data.minusDays(1);
                    data = data.plusMonths(Months);
                    data = data.minusMonths(1);
                    data = data.plusYears(Years);
                    data = data.minusYears(1);
                } else {
                    System.out.println("Data not supported");
                    break;
                }
                System.out.println("Enter a time.");
                System.out.println("Enter a hour.");
                Calendar dataMeeting = null;
                while (scanner.hasNextInt()) {
                    int hour = scanner.nextInt();
                    System.out.println("Enter a minute.");
                    int minute = scanner.nextInt();
                    System.out.println("Enter a second.");
                    int second = scanner.nextInt();
                    dataMeeting = new GregorianCalendar(Years, Month, Days);
                    dataMeeting.set(Calendar.HOUR, hour);
                    dataMeeting.set(Calendar.MINUTE, minute);
                    dataMeeting.set(Calendar.SECOND, second);
                    break;
                }
                int day = dataMeeting.get(Calendar.DAY_OF_WEEK);
                presenter.addRecordingJob(id, name, home, street, city, data, dataMeeting, myCollague, job, addNewInformation, day);
                break;
            }
        } catch (NullPointerException e) {
            inputError();
        }
    }

    public void getInfo() {
        presenter.getInfo();
    }

    private void execute() {
        String line = scanner.next();
        if (checkTextForInt(line)) {
            int numCommand = Integer.parseInt(line);
            if (checkCommand(numCommand)) {
                menu.execute(numCommand);
            }
        }
    }

    private boolean checkTextForInt(String text) {
        if (text.matches("[0-9]+")) {
            return true;
        } else {
            inputError();
            return false;
        }
    }

    private boolean checkCommand(int numCommand) {
        if (numCommand <= menu.getSize()) {
            return true;
        } else {
            inputError();
            return false;
        }
    }

    private void printMenu() {
        System.out.println(menu.menu());
    }

    private void inputError() {
        System.out.println("Errors, function not supported");
    }


}
