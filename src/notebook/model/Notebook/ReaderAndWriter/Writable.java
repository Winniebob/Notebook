package notebook.model.Notebook.ReaderAndWriter;

import java.io.Serializable;

public interface Writable {
    boolean saves (Serializable serializable, String filePath);

    Object read (String filePath);
}
