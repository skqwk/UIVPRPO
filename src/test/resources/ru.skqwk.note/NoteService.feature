#language: en
Feature: Note service testing

Scenario: Create new notes
  Given Service instantiated
  When Invoke createNote
  Then New note created and returned

Scenario: Remove existed note
  Given Service instantiated
  When Invoke removeNote
  Then Notes are empty

Scenario: Find note by id
  Given Service instantiated with note
  When Invoke findNoteById
  Then Return note

Scenario: Find note by id, when no such note
  Given Service instantiated
  When Invoke findNoteById
  Then Return null