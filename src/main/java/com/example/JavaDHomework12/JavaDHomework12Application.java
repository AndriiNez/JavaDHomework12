package com.example.JavaDHomework12;

import com.example.JavaDHomework12.note.Note;
import com.example.JavaDHomework12.note.NoteService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
@RequiredArgsConstructor
@SpringBootApplication
public class JavaDHomework12Application {
    private final NoteService noteService;


    public static void main(String[] args) {
        SpringApplication.run(JavaDHomework12Application.class, args);
    }
    @PostConstruct
    public void init() {
        Note note1 = new Note();
        note1.setTitle("Title 1");
        note1.setContent("Content 1");
        Note note2 = new Note();
        note2.setTitle("Title 2");
        note2.setContent("Content 2");

        Note note3 = new Note();
        note3.setTitle("Title 3");
        note3.setContent("Content 3");
        Note note4 = new Note();
        note4.setTitle("Title 4");
        note4.setContent("Content 4");

        noteService.add(note1);
        noteService.add(note2);
        noteService.add(note3);
        noteService.add(note4);

        List<Note> allNotes = noteService.listAll();
        System.out.println("List of all notes : ");
        for (
                Note note : allNotes) {
            System.out.println(note);
        }

        Note updatedNote = new Note();
        updatedNote.setId(note1.getId());
        updatedNote.setTitle("Updated title");
        updatedNote.setContent("Updated content");
        noteService.update(updatedNote);

        System.out.println("List of all notes after update:");
        for (
                Note note : noteService.listAll()) {
            System.out.println(note);
        }

        noteService.deleteById(note2.getId());

        System.out.println("List of all notes after deletion:");
        for (Note note : noteService.listAll()) {
            System.out.println(note);
        }
    }
}


