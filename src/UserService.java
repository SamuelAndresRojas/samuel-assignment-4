import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class UserService {

	public Student[] getStudentsFromFile() throws IOException, NullPointerException, FileNotFoundException {

		Student[] compSciStudents = new Student[34];
		Student[] statStudents = new Student[33];
		Student[] apmthStudents = new Student[33];

		try (BufferedReader fileReader = new BufferedReader(new FileReader("MasterFile.txt"));
				BufferedWriter bw1 = new BufferedWriter(new FileWriter("course1.txt"));
				BufferedWriter bw2 = new BufferedWriter(new FileWriter("course2.txt"));
				BufferedWriter bw3 = new BufferedWriter(new FileWriter("course3.txt"))) {
			int i = 0;
			String line = null;
			Student[] students = new Student[101];

			while ((line = fileReader.readLine()) != null) {
				String[] lineData = line.split(",");
				Student student = new Student(lineData[0], lineData[1], lineData[2], lineData[3]);
				students[i] = student;
				i++;
			}
			int compSciStudentsIndex = 0;
			int statStudentsIndex = 0;
			int apmthStudentsIndex = 0;

			for (Student student : students) {
				if (student.getCourse().contains("COMPSCI")) {
					compSciStudents[compSciStudentsIndex] = student;
					compSciStudentsIndex++;

				}
				if (student.getCourse().contains("STAT")) {
					statStudents[statStudentsIndex] = student;
					statStudentsIndex++;

				}
				if (student.getCourse().contains("APMTH")) {
					apmthStudents[apmthStudentsIndex] = student;
					apmthStudentsIndex++;
				}
			}
			Arrays.sort(compSciStudents);
			bw1.write("Student ID,Student Name,Course,Grade \n");
			for (Student student : compSciStudents) {
				bw1.write(student.getStudentID() + ",");
				bw1.write(student.getStudentName() + ",");
				bw1.write(student.getCourse() + ",");
				bw1.write(student.getGrade() + "\n");

			}
			Arrays.sort(statStudents);
			bw2.write("Student ID,Student Name,Course,Grade \n");
			for (Student student : statStudents) {
				bw2.write(student.getStudentID() + ",");
				bw2.write(student.getStudentName() + ",");
				bw2.write(student.getCourse() + ",");
				bw2.write(student.getGrade() + "\n");
			}
			Arrays.sort(apmthStudents);
			bw3.write("Student ID,Student Name,Course,Grade \n");
			for (Student student : apmthStudents) {
				bw3.write(student.getStudentID() + ",");
				bw3.write(student.getStudentName() + ",");
				bw3.write(student.getCourse() + ",");
				bw3.write(student.getGrade() + "\n");
			}
			return students;

		}
	}

}