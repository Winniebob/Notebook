package notebook.model.Notebook.Notebook;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;

public interface NotebookItem <E> {
    String getName();

    E getHome();
    E getStreet();
    E getCity();
    Calendar getDataMeeting();
    E getJob();
    int getDay();



    void setId(int id);

    int getId();


    LocalDate getData();

    List<E> getMyCase();

    List<E> getPlace();

    List<E> getPeople();



}
