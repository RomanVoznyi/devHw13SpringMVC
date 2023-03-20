package homework.service;

import homework.model.note.Note;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.thymeleaf.expression.Arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class NoteService {
    private final List<Note> notes = new ArrayList<>(List.of(
            new Note(1, "JS", "Learn JS"),
            new Note(2, "Java", "Learn Java"),
            new Note(3, "C#", "Learn C#"),
            new Note(4, "Python", "Learn Python")));

    public List<Note> listAll() {
        return notes;
    }

    public Note add(Note note) {
        note.setId(UUID.randomUUID().variant());
        notes.add(note);
        return note;
    }

    public void deleteById(long id) {
        Note note = notes.stream().filter(n -> n.getId() == id).findFirst().orElse(null);
        if (note == null) {
            throw new IllegalArgumentException("Note with id '" + id + "' does not exist");
        }
        notes.remove(note);
        System.out.println("Note with id '" + id + "' was successfully deleted");
    }

    public void update(Note note) {
        Note existNote = getById(note.getId());
        int index = notes.indexOf(existNote);
        notes.set(index, note);
        System.out.println("Note with id '" + note.getId() + "' was successfully updated");
    }

    public Note getById(long id) {
        Note note = notes.stream().filter(n -> n.getId() == id).findFirst().orElse(null);
        if (note == null) {
            throw new IllegalArgumentException("Note with id '" + id + "' does not exist");
        }
        return note;
    }
}
