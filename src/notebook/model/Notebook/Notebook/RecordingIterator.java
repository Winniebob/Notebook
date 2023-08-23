package notebook.model.Notebook.Notebook;


import java.util.Iterator;
import java.util.List;

public class RecordingIterator<T> implements Iterator<T> {
    private List<T> recordingList;
    private int index;

    public RecordingIterator(List<T> recordingList) { this.recordingList = recordingList;}

    @Override
    public boolean hasNext() {
        {return recordingList.size() > index;}
    }

    @Override
    public T next() {return  recordingList.get(index++);}
}
