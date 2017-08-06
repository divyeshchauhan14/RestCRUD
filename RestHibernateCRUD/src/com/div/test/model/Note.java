package com.div.test.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
@Table(name = "note")
public class Note implements Serializable {

	private static final long serialVersionUID = -8223013212025027296L;


	private int noteId;

	
	private String title;

	
	private String note;

	
	private Date createTime;

	
	private Date lastUpdateTime;


	private User user;

	public Note() {
	}

	public Note(int noteId, String title, String note, Date createTime, Date lastUpdateTime) {
		this.noteId = noteId;
		this.title = title;
		this.note = note;
		this.createTime = createTime;
		this.lastUpdateTime = lastUpdateTime;
	}

	@Column(name = "noteid")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getNoteId() {
		return noteId;
	}

	public void setNoteId(int noteId) {
		this.noteId = noteId;
	}

	@Column(name = "title", length = 50)
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "note", length=1000)
	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	@Column(name = "createtime")
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Column(name = "lastupdatetime")
	public Date getLastUpdateTime() {
		return lastUpdateTime;
	}

	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userid")
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
