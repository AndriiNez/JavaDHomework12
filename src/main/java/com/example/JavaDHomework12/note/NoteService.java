package com.example.JavaDHomework12.note;

import com.example.JavaDHomework12.generetId.GeneretId;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class NoteService {


    private final Map<Long, Note> notes = new HashMap<>();
    private GeneretId generetId;


    public NoteService(GeneretId generetId) {
        this.generetId = generetId;
    }


    public Note add(Note note) {
        long id = generetId.generet((long) notes.size());
        note.setId(id);
        notes.put(id, note);
        return note;

    }

    public void update(Note note) {
        long id = note.getId();
        if (!notes.containsKey(id)) {
            throw new RuntimeException("Note with id " + id + " not found");
        }
        notes.put(id, note);
    }

    public void deleteById(long id) {
        if (!notes.containsKey(id)) {
            throw new RuntimeException("Note with id " + id + " not found");
        }
        notes.remove(id);
    }

    public Note getById(long id) {
        if (!notes.containsKey(id)) {
            throw new RuntimeException("Note with id " + id + " not found");
        }
        return notes.get(id);
    }

    public List<Note> listAll() {
        return new ArrayList<>(notes.values());
    }

}
