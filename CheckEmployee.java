
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class CheckEmployee {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		//-------------------------
		//Check Employee
		Employee emp = new Employee("Manager");
		
		//View Student
		
		//System.out.println("Enter Student Name: ");
		//String name = input.nextLine();
		//System.out.println("Enter student ID: ");
		//String id = input.nextLine();
		//emp.viewStudentsInfo(name, id);
		
		//Add student
		
//		System.out.println("Enter name: ");
//		String name = input.nextLine();
//		System.out.println("Enter ID: ");
//		String id = input.nextLine();
//		System.out.println("Enter GPA: ");
//		String GPA = input.nextLine();
//		emp.addNewStudentInfo(name, id , GPA);
		
		
		
		//Message send
		
		//System.out.println("Enter message title: ");
		//String title = input.nextLine(); 
		//System.out.println("Enter message importance level: ");
		//System.out.println("Importance level:LOW,MEDIUM,HIGH");
		//String level = input.nextLine();
		//System.out.println("Message : ");
		//String message = input.nextLine();
	    //LocalDateTime date = LocalDateTime.now();
	    //DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	    //String formattedDate = date.format(formatter);

		
		//emp.sendMessage(title, level, message, formattedDate);
		
		//Read message
		
		//emp.readMessage(title);
		

		
		//------------------
		//Check Manager
//		System.out.println("Enter manager type (OR,RECTOR,DEAN): ");
//        String type = input.nextLine().toUpperCase(); 
//
//        try {
//            Managers managerType = Managers.valueOf(type);
//            Manager manager = new Manager("Manager", managerType);
//            
//            System.out.println("Input course name");
//            String name = input.nextLine();
//            
//            System.out.println("Input course credits");
//            String credits = input.nextLine();
//            
//            System.out.println("Input course type");
//            String cType = input.nextLine();
//            
//            LocalDateTime date = LocalDateTime.now();
//    	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//    	    String formattedDate = date.format(formatter);
//            
//            System.out.println("Input course instructor");
//            String instructor = input.nextLine();
//            
//            
//            manager.assignCourse(name, credits, cType, formattedDate, instructor);
//        } 
//        catch (IllegalArgumentException e) {
//            System.out.println("Invalid manager type! Please enter a valid type.");
//        }
		
		
		//-------------------------------
		
		
		//Check teacher
		String typeEmployee = "Teacher";
        System.out.println("Enter the title of the teacher (PROFFESOR,LECTOR,TUTOR,SENIOR_LECTOR,ASSISTANT): ");
        String titleInput = input.nextLine();
        TeacherTitle title;
        try {
            title = TeacherTitle.valueOf(titleInput.toUpperCase());
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid title! Defaulting to ASSISTANT.");
            title = TeacherTitle.ASSISTANT;
        }

        Teacher teacher = new Teacher(typeEmployee, title);
        
        System.out.println("Enter student name :");
        String name = input.nextLine();
        
        System.out.println("Enter student ID :");
        String id = input.nextLine();
        
        System.out.println("Enter student new GPA :");
        String gpa = input.nextLine(); 
        teacher.updateMarks(name, id, gpa);
	}


}
