package notebook.model.Notebook.Notebook;

import notebook.model.Notebook.Recording.comparator.SortByData;
import notebook.model.Notebook.Recording.comparator.SortByName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Notebook<E extends NotebookItem<E>> implements Serializable, Iterable<E> {

    private List<E> recordingList;
    private List <E> recordingListDayWeek = new ArrayList<>();
    private int recordingId;

    public Notebook() {
        recordingList = new ArrayList<>();
    }

    public Notebook(List<E> recordingList, List<E> recordingListDayWeek) {
        this.recordingList = recordingList;
        this.recordingListDayWeek =recordingListDayWeek;
    }

    public List<E> getRecordingList() {
        return recordingList;
    }

    public boolean addRecording(E recording) {
        if (recordingList == null) {
            return false;
        }
        if (!recordingList.contains(recording)) {
            recordingList.add(recording);
            recording.setId(recordingId++);
            return true;
        }
        if (recordingList.contains(recording)) {
            recordingList.add(recording);
            recording.setId(recordingId++);
            return true;
        }
        return false;
    }


    public boolean removess(int recordingId) {
        if (checkId(recordingId)) {
            E e = getById(recordingId);
            return recordingList.remove(e);
        }
        return false;
    }
    public void removeWeek() {
             recordingListDayWeek.clear();
        }


    public boolean checkId(int id) {
        if (id >= recordingId || id < 0) {
            return false;
        }
        for (E recording : recordingList) {
            if (recording.getId() == id) {
                return true;
            }
        }
        return false;
    }

    public List<E> seachData(int  days){
        for(E recording : recordingList) {
            if (recording.getDay() == days) {
                recordingListDayWeek.add(recording);
                return recordingListDayWeek;
            }
        }return null;
    }

    public E getById(int id) {
        for (E recording : recordingList) {
            if (recording.getId() == id) {
                return recording;
            }
        }
        return null;
    }

    public String getRecordingInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("List recording:\n");
        for (E recording : recordingList) {
            stringBuilder.append(recording);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public String getRecordingInfoWeek() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("List recording:\n");
        for (E recording : recordingListDayWeek) {
            stringBuilder.append(recording);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }



    public String toStringWeek(){return  getRecordingInfoWeek();}

    @Override
    public String toString(){return getRecordingInfo();}


    public void sortByData() {
        recordingList.sort(new SortByData<>());
    }

    public void sortByName() {
        recordingList.sort(new SortByName<>());
    }


    @Override
    public Iterator<E> iterator() {
        return new RecordingIterator(recordingList);
    }
}
