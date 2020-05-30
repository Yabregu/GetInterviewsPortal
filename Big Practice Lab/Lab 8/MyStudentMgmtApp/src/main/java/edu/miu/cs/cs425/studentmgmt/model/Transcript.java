package edu.miu.cs.cs425.studentmgmt.model;
 

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="transcript")
public class Transcript {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer transcriptId;
	private String degreeTitle;
	
	@OneToOne(mappedBy="transcript")
	private Student student;
	 
	public Transcript(){
		super();
	}
	public Transcript(Integer transcriptId,String degreeTitle){
		 this.transcriptId = transcriptId;
		this.degreeTitle = degreeTitle;
	}
	public Transcript(String degreeTitle){
		 
		this.degreeTitle = degreeTitle;
	}
	public String getDegreeTitle() {
		return degreeTitle;
	}

	public void setDegreeTitle(String degreeTitle) {
		this.degreeTitle = degreeTitle;
	}

	public Integer getTranscriptId() {
		return transcriptId;
	}

	public void setTranscriptId(Integer transcriptId) {
		this.transcriptId = transcriptId;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}

	 
}
