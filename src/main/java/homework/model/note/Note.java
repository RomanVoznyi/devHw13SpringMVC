package homework.model.note;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
public class Note {
    private long id;
    private String title;
    private String content;

    public Note() {
    }

    public Note(long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }
}
