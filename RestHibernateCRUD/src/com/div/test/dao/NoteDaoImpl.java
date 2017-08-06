package com.div.test.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.div.test.model.Note;

public class NoteDaoImpl extends AbstractDao<Note> implements NoteDao {

	@Override
	public Note findById(int id) {
		return getByKey(id);
	}

	@Override
	public void saveNote(Note note) {
		persist(note);
	}

	@Override
	public void deleteNote(Note note) {
		// TODO Auto-generated method stub
		delete(note);
	}

	@Override
	public void updateNote(Note note) {
		// TODO Auto-generated method stub
		update(note);
	}

	@Override
	public List<Note> findNotesByUserId(int userId) {
		// TODO Auto-generated method stub
		List<Note> notes = new ArrayList<Note>();
		Transaction transaction = getSession().beginTransaction();
		Criteria noteCriteria = createEntityCriteria();
		Criteria userCriteria = noteCriteria.createCriteria("user", "u");
		userCriteria.add(Restrictions.eq("u.userId", userId));
		notes = noteCriteria.list();
		transaction.commit();
		return notes;
	}
}
