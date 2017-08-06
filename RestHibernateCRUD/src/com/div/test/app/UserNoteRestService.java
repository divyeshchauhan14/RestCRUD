package com.div.test.app;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.div.test.model.Note;
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
	public Response getUserNotes(@PathParam("userid") String userid)
	{
		int userId = Integer.parseInt(userid);
		List<Note> userNotes = noteService.findNotesByUserId(userId);
		
		return Response.status(200).entity(userNotes).build();
	}
}
