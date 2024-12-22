
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
		
//		System.out.println("Enter student ID: ");
//		String id = input.nextLine();
//		emp.viewStudentsInfo(id);
		
		//Add student
		
//		System.out.println("Enter ID: ");
//		String id = input.nextLine();
//		System.out.println("Enter year of study: ");
//		String yof = input.nextLine();
//		System.out.println("Enter full name: ");
//		String name = input.nextLine();
//		System.out.println("Enter GPA: ");
//		String gpa = input.nextLine();
//		System.out.println("Enter ECTS: ");
//		String ects = input.nextLine();
//		emp.addNewStudentInfo(id,yof,name,gpa,ects);
		
		
		
		//Message send
		
		//System.out.println("Enter message title: ");
		//String title = input.nextLine(); 
		//System.out.println("Enter message importance level: ");
		//System.out.println("Importance level:LOW,MEDIUM,HIGH");
		//String level = input.nextLine();
		//System.out.println("Message : ");
		//String message = input.nextLine();
	    //LocalDateTime date = LocalDateTime.now();
	    //DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	    //String formattedDate = date.format(formatter);

		
		//emp.sendMessage(title, level, message, formattedDate);
		
		//Read message
		
		//emp.readMessage(title);
			
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
//		 System.out.println("Input student ID");
//		 String id = input.nextLine();
//		 manager.approveRegistrationForCourse(id);
		
		
		//-------------------------------
		
		
		//Check teacher
//		String typeEmployee = "Teacher";
//        System.out.println("Enter the title of the teacher (PROFFESOR,LECTOR,TUTOR,SENIOR_LECTOR,ASSISTANT): ");
//        String titleInput = input.nextLine();
//        TeacherTitle title;
//        try {
//            title = TeacherTitle.valueOf(titleInput.toUpperCase());
//        } catch (IllegalArgumentException e) {
//            System.out.println("Invalid title! Defaulting to ASSISTANT.");
//            title = TeacherTitle.ASSISTANT;
//        }
//
//        Teacher teacher = new Teacher(typeEmployee, title);
//        
//      
//        
//        System.out.println("Enter student ID :");
//        String id = input.nextLine();
//        
//        System.out.println("Enter student new mark :");
//        String newMark = input.nextLine();
//        
//        teacher.putMarks(id, Double.parseDouble(newMark));
	}


}
