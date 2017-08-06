package com.div.test.service;

import java.util.List;

import com.div.test.model.Note;

public interface NoteService {

	Note findById(int noteId);

	void saveNote(Note note);

	void updateNote(Note note);

	void deleteNote(Note note);

	List<Note> findNotesByUserId(int userId);

}
