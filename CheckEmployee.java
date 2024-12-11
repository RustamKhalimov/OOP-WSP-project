
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class CheckEmployee {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Employee emp = new Employee("Manager");
		
		
		//System.out.println("Enter Student Name: ");
		//String name = input.nextLine();
		//System.out.println("Enter student ID: ");
		//String id = input.nextLine();
		//emp.viewStudentsInfo(name, id);
		
		
		//System.out.println("Enter name: ");
		//String name = input.nextLine();
		//System.out.println("Enter ID: ");
		//String id = input.nextLine();
		//System.out.println("Enter GPA: ");
		//String GPA = input.nextLine();
		//emp.addNewStudentInfo(name, id , GPA);
		System.out.println("Enter message title: ");
		String title = input.nextLine(); 
		//System.out.println("Enter message importance level: ");
		//System.out.println("Importance level:LOW,MEDIUM,HIGH");
		//String level = input.nextLine();
		//System.out.println("Message : ");
		//String message = input.nextLine();
	    //LocalDateTime date = LocalDateTime.now();
	    //DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	    //String formattedDate = date.format(formatter);

		
		//emp.sendMessage(title, level, message, formattedDate);
		
		emp.readMessage(title);
	}

}
