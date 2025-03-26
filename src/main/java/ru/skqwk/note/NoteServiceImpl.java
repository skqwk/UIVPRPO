package ru.skqwk.note;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class NoteServiceImpl implements NoteService {
    private final List<Note> notes = new ArrayList<>();

    @Override
    public Note createNote() {
        Note note = new Note();
        note.setCreatedAt(LocalDateTime.now());
        note.setId(UUID.randomUUID().toString());

        return note;
    }

    @Override
    public void removeNote(String id) {
        List<Note> filtered = notes.stream()
                .filter(note -> note.getId().equals(id)).toList();
        this.notes.clear();
        this.notes.addAll(filtered);
    }

    @Override
    public List<Note> getAllNotes() {
        return new ArrayList<>(this.notes);
    }

    @Override
    public void addAllNotes(List<Note> notes) {
        this.notes.addAll(notes);
    }

    @Override
    public Note findById(String id) {
        return notes.stream()
                .filter(note -> note.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}
