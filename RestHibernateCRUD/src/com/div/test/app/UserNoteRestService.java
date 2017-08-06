package com.div.test.app;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.div.test.model.Note;
import com.div.test.model.User;
import com.div.test.service.NoteService;
import com.div.test.service.NoteServiceImpl;
import com.div.test.service.UserService;
import com.div.test.service.UserServiceImpl;

@Path("/note")
public class UserNoteRestService {

	UserService userService = UserServiceImpl.getInstance();
	NoteService noteService = NoteServiceImpl.getInstance();

	/*
	 * This method will return the json of list of notes for the specified userid
	 */
	@GET
	@Path("/getNote/{userid}")
	@Produces("application/json")
	public Response getUserNotes(@PathParam("userid") String userid) {
		if (userid == null) {
			return Response.ok().entity("user id is null").build();
		}
		try {
			Integer.parseInt(userid);
		} catch (NumberFormatException e) {
			return Response.ok().entity("user id is not a valid number").build();
		}

		int userId = Integer.parseInt(userid);
		List<Note> userNotes = noteService.findNotesByUserId(userId);
		return Response.status(200).entity(userNotes).build();

	}

	/*
	 * This method will add the user note
	 */
	@POST
	@Path("/addNote/{userid}")
	@Consumes("application/json")
	public Response addUserNote(@PathParam("userid") String userid, Note note) {
		if (userid == null && note == null) {
			return Response.ok().entity("user id or Note object is null").build();
		}
		try {
			Integer.parseInt(userid);
		} catch (NumberFormatException e) {
			return Response.ok().entity("user id is not a valid number").build();
		}

		int userId = Integer.parseInt(userid);
		User user = userService.findById(userId);
		if (user == null) {
			return Response.ok().entity("Requested user is not available in Database").build();
		} else {
			note.setUser(user);
			noteService.saveNote(note);
			return Response.ok().entity("success").build();
		}

	}

	/*
	 * This method will delete the specified note using noteId
	 */
	@POST
	@Path("/deleteNote/{noteId}")
	public Response deleteNote(@PathParam("noteId") String noteid) {

		if (noteid == null) {
			return Response.ok().entity("note id is null").build();
		}
		try {
			Integer.parseInt(noteid);
		} catch (NumberFormatException e) {
			return Response.ok().entity("note id is not a valid number").build();
		}

		int noteId = Integer.parseInt(noteid);
		Note note = noteService.findById(noteId);
		if (note == null) {
			return Response.ok().entity("Requested note is not available in Database").build();
		} else {
			noteService.deleteNote(note);
			return Response.ok().entity("success").build();
		}
	}

	/*
	 * This method will update the note with passed note json object
	 */
	@POST
	@Path("/updateNote/{noteId}")
	@Consumes("application/json")
	public Response updateNote(@PathParam("noteId") String noteid, Note noteToUpdate) {
		if (noteid == null && noteToUpdate == null) {
			return Response.ok().entity("note id or Note object is null").build();
		}
		try {
			Integer.parseInt(noteid);
		} catch (NumberFormatException e) {
			return Response.ok().entity("note id is not a valid number").build();
		}

		int noteId = Integer.parseInt(noteid);
		Note note = noteService.findById(noteId);
		if (note == null) {
			return Response.ok().entity("Requested note is not available in Database").build();
		} else {
			note.setNote(noteToUpdate.getNote());
			note.setTitle(noteToUpdate.getTitle());
			note.setCreateTime(noteToUpdate.getCreateTime());
			note.setLastUpdateTime(noteToUpdate.getLastUpdateTime());
			noteService.updateNote(note);
			return Response.ok().entity("success").build();
		}
	}
}
