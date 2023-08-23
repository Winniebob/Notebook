package notebook.model.Notebook.Presenter;

import notebook.model.Notebook.Service.Service;
import notebook.view.View;

import java.time.LocalDate;
import java.util.Calendar;


public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view) {
        this.view = view;
        service = new Service();
    }

    public void addRecordingJob(int id, String name, String home, String street, String city, LocalDate data, Calendar dataMeeting,
                                String myCollague, String job, String addNewInformation, int day){
        service.addRecordingJob(id, name, home, street, city, data,dataMeeting, myCollague, job, addNewInformation, day);
        getInfo();
    }


    public void seachData(int days){
        service.seachData( days);
        String answer = service.getInfoWeek();
        view.printAnswer(answer);
        service.removeWeek();

    }
    public void getInfo(){
        String answer = service.getInfo();
        view.printAnswer(answer);
    }
    public void readFile(){
        service.readFile();
        getInfo();
    }

    public void remove(int recordingId){
        service.remove(recordingId);
        getInfo();
    }

    public void sortByData() {
        service.sortByData();
        getInfo();
    }

    public void sortByName() {
        service.sortByName();
        getInfo();
    }
}
