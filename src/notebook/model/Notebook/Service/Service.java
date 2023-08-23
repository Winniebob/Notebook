package notebook.model.Notebook.Service;

import notebook.model.Notebook.Notebook.Notebook;
import notebook.model.Notebook.ReaderAndWriter.FileHandler;
import notebook.model.Notebook.Recording.Recording;

import java.time.LocalDate;
import java.util.Calendar;



public class Service {
    private Notebook notebook;

    private FileHandler fileHandler;

    public Service() {
        notebook = new Notebook();
        fileHandler = new FileHandler();
    }

    public void sortByData() {
        notebook.sortByData();
    }

    public void sortByName() {
        notebook.sortByName();
    }

    public void addRecordingJob(int id, String name, String home, String street, String city, LocalDate data, Calendar dataMeeting,
                                String myCollague, String job, String addNewInformation, int day){
        Recording recording = new Recording(id, name, home, street, city, data,dataMeeting, myCollague, job, addNewInformation, day);
        notebook.addRecording(recording);
        String filePath = "src/notebook/model/Notebook/Notebook/Notebook.out";
        fileHandler.saves(notebook, filePath);

    }

    public void remove(int recordingId){
        notebook.removess(recordingId);
        String filePath = "src/notebook/model/Notebook/Notebook/Notebook.out";
        fileHandler.saves(notebook, filePath);
    }

    public void removeWeek(){
        notebook.removeWeek();
    }
    public void readFile(){
        String filePath = "src/notebook/model/Notebook/Notebook/Notebook.out";
        notebook = (Notebook) fileHandler.read(filePath);
    }
    public void seachData(int days){notebook.seachData(days);}

    public String getInfo() {
        return notebook.getRecordingInfo();
    }
    public String getInfoWeek(){return  notebook.getRecordingInfoWeek();


    }


}
