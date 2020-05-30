package edu.miu.cs.cs425.studentmgmt;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.assertj.core.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import edu.miu.cs.cs425.studentmgmt.model.Classroom;
import edu.miu.cs.cs425.studentmgmt.model.Student;
import edu.miu.cs.cs425.studentmgmt.model.Transcript;
import edu.miu.cs.cs425.studentmgmt.repository.StudentRepository;

@SpringBootApplication
public class MyStudentMgmtApp implements CommandLineRunner {
	
	@Autowired
	private StudentRepository studentRepository;

	@Override
	public void run(String... args) throws Exception {
		
		
/*
		Publisher p1 = new Publisher("Pearsons Inc.", null);
		List<Book> books = Arrays.asList(book1, book2);	
		p1.setBooksPublished(books);
		2019/5/24 
		
	*/	
		Transcript newtranscr = new Transcript("BS Computer Science");
		Student stu=new Student("000-61-0001","Anna","Lynn","Smith",3.45,LocalDate.of(2019, 5, 24)  );
		Classroom claassNew = new Classroom("McLaughlin building","M105");

		stu.setClassroom(claassNew);
		stu.setTranscript(newtranscr);
		Student saved1 = saveStudent(stu);
		//stu.setTranscript(newtranscr);
		System.out.println(saved1);

	}

	public static void main(String[] args) {
		SpringApplication.run(MyStudentMgmtApp.class, args);
	}
	
	private Student saveStudent(Student student) {
		return studentRepository.save(student);
	}

}
