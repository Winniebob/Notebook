package notebook.model.Notebook.Recording.comparator;

import notebook.model.Notebook.Notebook.NotebookItem;

import java.util.Comparator;

public class SortByName <T extends NotebookItem> implements Comparator<T> {
    public int compare(T o1, T o2) {
        return o1.getName().compareTo(o2.getName());
    }
}