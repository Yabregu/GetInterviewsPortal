package edu.miu.cs.cs425.studentmgmt.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="classroom")
public class Classroom {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer primaryKey;
	
	private String buildingName;
	private String roomNumber;

	@OneToMany(mappedBy = "classroom")
	private List<Student> students;
	
	public Classroom(String buildingName,String roomNumber){
		this.buildingName = buildingName;
		this.roomNumber = roomNumber;
	}
	
	public Integer getPrimaryKey() {
		return primaryKey;
	}
	public void setPrimaryKey(Integer primaryKey) {
		this.primaryKey = primaryKey;
	}
	public String getBuildingName() {
		return buildingName;
	}
	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}
	public String getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}
	public List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}
}
