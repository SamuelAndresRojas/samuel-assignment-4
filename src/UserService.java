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
				BufferedWriter course1 = new BufferedWriter(new FileWriter("course1.txt"));
				BufferedWriter course2 = new BufferedWriter(new FileWriter("course2.txt"));
				BufferedWriter course3 = new BufferedWriter(new FileWriter("course3.txt"))) {
			int i = 0;
			String line = null;
			Student[] students = new Student[101];

			while ((line = fileReader.readLine()) != null) {
				String[] data = line.split(",");
				Student student = new Student(data[0], data[1], data[2], data[3]);
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
			course1.write("Student ID,Student Name,Course,Grade \n");
			for (Student student : compSciStudents) {
				course1.write(student.getStudentID() + ",");
				course1.write(student.getStudentName() + ",");
				course1.write(student.getCourse() + ",");
				course1.write(student.getGrade() + "\n");

			}
			Arrays.sort(statStudents);
			course2.write("Student ID,Student Name,Course,Grade \n");
			for (Student student : statStudents) {
				course2.write(student.getStudentID() + ",");
				course2.write(student.getStudentName() + ",");
				course2.write(student.getCourse() + ",");
				course2.write(student.getGrade() + "\n");
			}
			Arrays.sort(apmthStudents);
			course3.write("Student ID,Student Name,Course,Grade \n");
			for (Student student : apmthStudents) {
				course3.write(student.getStudentID() + ",");
				course3.write(student.getStudentName() + ",");
				course3.write(student.getCourse() + ",");
				course3.write(student.getGrade() + "\n");
			}
			return students;

		}
	}

}