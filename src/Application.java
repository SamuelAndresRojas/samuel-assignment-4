import java.io.IOException;

public class Application {

	public static void main(String[] args) throws IOException, NullPointerException {

		// Parse master list file
		// Separate (output) the data into 3 different CSV files
		// Each file will contain a list of students specific to the course
		// Sort the students by grade in descending order
		// Each separate class file will be called "course1.csv, course2.csv, and
		// course3.csv."
		// Hints
		// In order to sort an array, you'll need to figure out how to handle null
		// entries in your array. If you're trying to use Arrays.sort(yourArray), and
		// yourArray contains null values, the sort will crash.
		// When writing to a file, you can use "\n" to write a new line to the file.
		// Fore example: fileWriter.write("This is one line \n");
		// If you want to turn String input into an Integer, you can parse it like so:
		// Integer myIntVal = Integer.parseInt(myStringVal);
		UserService userService = new UserService();
		userService.getStudentsFromFile();
	}
}