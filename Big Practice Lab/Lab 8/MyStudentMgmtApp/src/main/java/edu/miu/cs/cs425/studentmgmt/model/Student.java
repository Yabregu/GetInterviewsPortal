package edu.miu.cs.cs425.studentmgmt.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table (name = "student")
public class Student {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long studentId;

@NotBlank(message = "student number is required")
private String studentNumber;

@NotBlank(message = "first name is required")
@Column (name="first_name", unique=false, nullable=false)
private String firstName;


private String middleName;

@NotBlank(message = "last name is required")
private String lastName;
private Double cgpa;

@DateTimeFormat(pattern = "yyyy-MM-dd")
private LocalDate dateOfEnrollment;



@ManyToOne(cascade = CascadeType.ALL)
@JoinColumn(name="classroom_id", nullable = true)
	private Classroom classroom;
	 

@OneToOne(cascade = CascadeType.ALL)
@JoinColumn(name="transcript_id", nullable = true)
private Transcript transcript;

	public Student( String studentNumber,String firstName,String middleName,
			String lastName,Double cgpa,LocalDate dateOfEnrollment){
		this.dateOfEnrollment = dateOfEnrollment;
		 
		this.studentNumber = studentNumber;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.cgpa = cgpa;
	}
	public Student(Long studentId,String studentNumber,String firstName,String middleName,
			String lastName,Double cgpa,LocalDate dateOfEnrollment,Transcript transcript){
		this.dateOfEnrollment = dateOfEnrollment;
		this.studentId = studentId;
		this.studentNumber = studentNumber;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.cgpa = cgpa;
	}
	public Student() {
		super();
	}

	 
	@Override
	public String toString() {
		return String.format("Student "+studentNumber+" firstNmae "+firstName);
	}


	public Long getStudentId() {
		return studentId;
	}


	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}


	public String getStudentNumber() {
		return studentNumber;
	}


	public void setStudentNumber(String studentNumber) {
		this.studentNumber = studentNumber;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getMiddleName() {
		return middleName;
	}


	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public Double getCgpa() {
		return cgpa;
	}


	public void setCgpa(Double cgpa) {
		this.cgpa = cgpa;
	}


	public LocalDate getDateOfEnrollment() {
		return dateOfEnrollment;
	}


	public void setDateOfEnrollment(LocalDate dateOfEnrollment) {
		this.dateOfEnrollment = dateOfEnrollment;
	}
	public Transcript getTranscript() {
		return transcript;
	}
	public void setTranscript(Transcript transcript) {
		this.transcript = transcript;
	}
	public Classroom getClassroom() {
		return classroom;
	}
	public void setClassroom(Classroom classroom) {
		this.classroom = classroom;
	}
	
}
