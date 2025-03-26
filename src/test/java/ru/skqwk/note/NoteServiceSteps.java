package ru.skqwk.note;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

public class NoteServiceSteps {
    private static final String ID = "234";

    private final NoteService noteService = new NoteServiceImpl();
    private Note created = null;
    private Note founded = null;

    @Given("Service instantiated")
    public void givenServiceInstantiated() {
        assertNotNull(noteService);
    }

    @When("Invoke createNote")
    public void whenCreateNote() {
        created = noteService.createNote();
    }

    @Then("New note created and returned")
    public void thenNewNoteCreatedAndReturned() {
        assertNotNull(created);
    }

    @When("Invoke removeNote")
    public void invokeRemoveNote() {
        noteService.removeNote(ID);
    }

    @Then("Notes are empty")
    public void notesAreEmpty() {
        assertTrue(noteService.getAllNotes().isEmpty());
    }

    @Given("Service instantiated with note")
    public void serviceInstantiatedWithNote() {
        assertNotNull(noteService);

        Note note = new Note();
        note.setId(ID);

        noteService.addAllNotes(Collections.singletonList(note));
    }

    @When("Invoke findNoteById")
    public void invokeFindNoteById() {
        founded = noteService.findById(ID);
    }

    @Then("Return note")
    public void returnNote() {
        assertNotNull(founded);
    }

    @Then("Return null")
    public void returnNull() {
        assertNull(founded);
    }
}
