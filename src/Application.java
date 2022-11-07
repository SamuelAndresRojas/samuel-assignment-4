import java.io.IOException;

public class Application {

	public static void main(String[] args) throws IOException, NullPointerException {

		UserService userService = new UserService();
		userService.getStudentsFromFile();
	}
	
}