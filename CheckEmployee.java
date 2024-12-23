
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class CheckEmployee {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		//-------------------------
		//Check Employee
		Employee emp = new Employee("Manager");
		
		//Add student
		
		System.out.println("Enter ID: ");
		String id = input.nextLine();
		System.out.println("Enter year of study: ");
		String yof = input.nextLine();
		System.out.println("Enter full name: ");
		String name = input.nextLine();
		System.out.println("Enter GPA: ");
		String gpa = input.nextLine();
		System.out.println("Enter ECTS: ");
		String ects = input.nextLine();
		emp.addNewStudentInfo(id,yof,name,gpa,ects);
		
		
		//View Student
		
		System.out.println("Enter student ID: ");
		String id = input.nextLine();
		emp.viewStudentsInfo(id);
		

		//View teacher
		
		System.out.println("Enter teacher full name: ");
		String fullName = input.nextLine();
		emp.viewTeacherInfo(fullName);
		
		//Read message
		System.out.println("Enter message title: ");
		String title = input.nextLine();
		emp.readMessage(title);
		
		
		//Message send
		
		System.out.println("Enter message title: ");
		String title = input.nextLine(); 
		System.out.println("Enter message importance level: ");
		System.out.println("Importance level:LOW,MEDIUM,HIGH");
		String level = input.nextLine();
		System.out.println("Message : ");
		String message = input.nextLine();
	    LocalDateTime date = LocalDateTime.now();
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	    String formattedDate = date.format(formatter);		
		emp.sendMessage(title, level, message, formattedDate);
		
		
		//Send complain
		System.out.println("Enter student ID: ");
		String id = input.nextLine(); 
		System.out.println("Enter complain title: ");
		String title = input.nextLine(); 
		System.out.println("Enter message importance level: ");
		System.out.println("Importance level:LOW,MEDIUM,HIGH");
		String level = input.nextLine();
		System.out.println("Complain : ");
		String complain = input.nextLine();
	    LocalDateTime date = LocalDateTime.now();
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	    String formattedDate = date.format(formatter);		
		emp.sendComplain(id, title, level, complain, formattedDate);
		
			
		//------------------
		//Check Manager

		String typeEmployee = "Manager";		
		System.out.println("Enter manager type (OR,RECTOR,DEAN): ");
		String typeInput = input.nextLine(); 
		Managers type; 
        try {
            type = Managers.valueOf(typeInput.toUpperCase());
        } 
        catch (IllegalArgumentException e) {
            System.out.println("Invalid type! Defaulting to OR.");
        	  type = Managers.OR;
        }
		 Manager manager = new Manager(typeEmployee, type);

		//Read complain
		System.out.println("Input student ID");
		String id = input.nextLine();
		manager.readComplain(id);
		 
		//Read request
		System.out.println("Enter request title: ");
		String titleForRequest = input.nextLine();
		manager.readRequest(titleForRequest);
		 
		 
		//Assign course
	   System.out.println("Input course code");
	   String code = input.nextLine();
		 
	   System.out.println("Input course name");
       String name = input.nextLine();
       
       System.out.println("Input course credits");
       String credits = input.nextLine();
       
       System.out.println("Input course type");
       String cType = input.nextLine();
       
       System.out.println("Input course instructor");
       String instructor = input.nextLine();
       
       System.out.println("Input course date (Wd-hh-mm)");
       String manualDate = input.nextLine();   
       manager.assignCourse(code,name,credits,cType,instructor,manualDate);
		 
		 
		 //Approve registration for course
		 System.out.println("Input student ID");
		 String idForARFC = input.nextLine();
		 manager.approveRegistrationForCourse(idForARFC);
		
		
		//-------------------------------
		
		
		//Check teacher
		String typeEmployeeTeacher = "Teacher";
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
//        
//      
		  //Check put mark
        System.out.println("Enter student ID :");
        String idForMark = input.nextLine();
        
        System.out.println("Enter student new mark :");
        String newMark = input.nextLine();
        
        teacher.putMarks(idForMark, Double.parseDouble(newMark));
		
		//Send complain
		System.out.println("Enter student ID: ");
		String idForComplain = input.nextLine(); 
		System.out.println("Enter complain title: ");
		String complainTitle = input.nextLine(); 
		System.out.println("Enter message importance level: ");
		System.out.println("Importance level:LOW,MEDIUM,HIGH");
		String level = input.nextLine();
		System.out.println("Complain : ");
		String complain = input.nextLine();
	    LocalDateTime date = LocalDateTime.now();
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	    String formattedDate = date.format(formatter);		
		teacher.sendComplainAboutStudent(idForComplain, complainTitle, level, complain, formattedDate);
        
        //Check view course
        System.out.println("Input teacher full name :");
        String name = input.nextLine();
        System.out.println("Input course name :");
        String courseName = input.nextLine();
        teacher.viewCourses(name, courseName);
        
      //Send request
        System.out.println("Enter message title: ");
        String requestTitle = input.nextLine(); 
      	System.out.println("Enter message importance level: ");
  		System.out.println("Importance level:LOW,MEDIUM,HIGH");
        String level = input.nextLine();
      	System.out.println("Request : ");
      	String request = input.nextLine();
      	LocalDateTime date = LocalDateTime.now();
      	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
      	String formattedDate = date.format(formatter);		
        teacher.sendRequest(requestTitle, level, request, formattedDate);
	}


}
