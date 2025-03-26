package ru.skqwk.note;

import java.util.List;

public interface NoteService {
    Note createNote();

    void removeNote(String id);

    List<Note> getAllNotes();

    void addAllNotes(List<Note> notes);

    Note findById(String id);
}
