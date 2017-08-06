package com.div.test.service;

import java.util.List;

import com.div.test.dao.NoteDao;
import com.div.test.dao.NoteDaoImpl;
import com.div.test.model.Note;

public class NoteServiceImpl implements NoteService {

	NoteDao noteDao = new NoteDaoImpl();
	@Override
	public Note findById(int noteId) {
		// TODO Auto-generated method stub
		return noteDao.findById(noteId);
	}

	@Override
	public void saveNote(Note note) {
		// TODO Auto-generated method stub
		noteDao.saveNote(note);
	}

	@Override
	public void updateNote(Note note) {
		// TODO Auto-generated method stub
		noteDao.updateNote(note);
	}

	@Override
	public void deleteNote(Note note) {
		// TODO Auto-generated method stub
		noteDao.deleteNote(note);
	}

	/*
	 * This method will return the notes of corresponding user
	 */
	@Override
	public List<Note> findNotesByUserId(int userId) {
		// TODO Auto-generated method stub
		return noteDao.findNotesByUserId(userId);
	}

}
