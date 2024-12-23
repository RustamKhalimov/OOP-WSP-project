import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Check {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean running = true;

        Employee emp = new Employee("Manager"); 
        String typeEmployeeManager = "Manager"; 
        String typeEmployeeTeacher = "Teacher"; 

        while (running) {
            System.out.println("\n=== Main Menu ===");
            System.out.println("1. Employee Operations");
            System.out.println("2. Teacher Operations");
            System.out.println("3. Manager Operations");
            System.out.println("4. Exit");
            System.out.print("Select who`s operations do you want to see: ");
            int choice = input.nextInt();
            input.nextLine(); 
            switch (choice) {
                case 1:
                    handleEmployeeOperations(emp, input);
                    break;

                case 2: 
                    handleTeacherOperations(typeEmployeeTeacher, input);
                    break;

                case 3: 
                    handleManagerOperations(typeEmployeeManager, input);
                    break;

                case 4:
                    running = false;
                    System.out.println("Exiting...");
                    System.out.println("Byeee");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void handleEmployeeOperations(Employee emp, Scanner input) {
        boolean employeeRunning = true;

        while (employeeRunning) {
            System.out.println("\n=== Employee Operations ===");
            System.out.println("1. Add Student");
            System.out.println("2. View Student");
            System.out.println("3. View Teacher");
            System.out.println("4. Read Message");
            System.out.println("5. Send Message");
            System.out.println("6. Send Complain");
            System.out.println("7. Back to Main Menu");
            System.out.print("Select an operation: ");
            int choice = input.nextInt();
            input.nextLine(); 

            switch (choice) {
                case 1:
                    addStudent(emp, input);
                    break;

                case 2:
                    viewStudent(emp, input);
                    break;

                case 3:
                    viewTeacher(emp, input);
                    break;

                case 4:
                    readMessage(emp, input);
                    break;

                case 5:
                    sendMessage(emp, input);
                    break;

                case 6:
                    sendComplain(emp, input);
                    break;

                case 7:
                    employeeRunning = false;
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void handleTeacherOperations(String typeEmployeeTeacher, Scanner input) {
        System.out.println("\nEnter the title of the teacher (PROFESSOR, LECTOR, TUTOR, SENIOR_LECTOR, ASSISTANT): ");
        String titleInput = input.nextLine();
        TeacherTitle title;
        try {
            title = TeacherTitle.valueOf(titleInput.toUpperCase());
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid title! Defaulting to ASSISTANT.");
            title = TeacherTitle.ASSISTANT;
        }
        Teacher teacher = new Teacher(typeEmployeeTeacher, title);

        boolean teacherRunning = true;

        while (teacherRunning) {
            System.out.println("\n=== Teacher Operations ===");
            System.out.println("1. Put Marks");
            System.out.println("2. Send Complain");
            System.out.println("3. View Courses");
            System.out.println("4. Send Request");
            System.out.println("5. Back to Main Menu");
            System.out.print("Select an operation: ");
            int choice = input.nextInt();
            input.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.println("Enter student ID: ");
                    String id = input.nextLine();
                    System.out.println("Enter new mark: ");
                    double mark = input.nextDouble();
                    input.nextLine(); 
                    teacher.putMarks(id, mark);
                    break;

                case 2:
                    System.out.println("Enter student ID: ");
                    String studentId = input.nextLine();
                    System.out.println("Enter complain title: ");
                    String complainTitle = input.nextLine();
                    System.out.println("Enter message importance level (LOW, MEDIUM, HIGH): ");
                    String level = input.nextLine();
                    System.out.println("Enter complain: ");
                    String complain = input.nextLine();
                    teacher.sendComplainAboutStudent(studentId, complainTitle, level, complain, getCurrentDate());
                    break;

                case 3:
                    System.out.println("Enter teacher full name: ");
                    String fullName = input.nextLine();
                    System.out.println("Enter course name: ");
                    String courseName = input.nextLine();
                    teacher.viewCourses(fullName, courseName);
                    break;

                case 4:
                    System.out.println("Enter request title: ");
                    String requestTitle = input.nextLine();
                    System.out.println("Enter message importance level (LOW, MEDIUM, HIGH): ");
                    String requestLevel = input.nextLine();
                    System.out.println("Enter request: ");
                    String request = input.nextLine();
                    teacher.sendRequest(requestTitle, requestLevel, request, getCurrentDate());
                    break;

                case 5:
                    teacherRunning = false;
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void handleManagerOperations(String typeEmployeeManager, Scanner input) {
        System.out.println("\nEnter manager type (OR, RECTOR, DEAN): ");
        String typeInput = input.nextLine();
        Managers type;
        try {
            type = Managers.valueOf(typeInput.toUpperCase());
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid type! Defaulting to OR.");
            type = Managers.OR;
        }
        Manager manager = new Manager(typeEmployeeManager, type);

        boolean managerRunning = true;

        while (managerRunning) {
            System.out.println("\n=== Manager Operations ===");
            System.out.println("1. Read Complain");
            System.out.println("2. Read Request");
            System.out.println("3. Assign Course");
            System.out.println("4. Approve Course Registration");
            System.out.println("5. Back to Main Menu");
            System.out.print("Select an operation: ");
            int choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Enter student ID: ");
                    String id = input.nextLine();
                    manager.readComplain(id);
                    break;

                case 2:
                    System.out.println("Enter request title: ");
                    String title = input.nextLine();
                    manager.readRequest(title);
                    break;

                case 3:
                    System.out.println("Enter course code: ");
                    String code = input.nextLine();
                    System.out.println("Enter course name: ");
                    String name = input.nextLine();
                    System.out.println("Enter course credits: ");
                    String credits = input.nextLine();
                    System.out.println("Enter course type: ");
                    String cType = input.nextLine();
                    System.out.println("Enter course instructor: ");
                    String instructor = input.nextLine();
                    System.out.println("Enter course date (Wd-hh-mm): ");
                    String manualDate = input.nextLine();
                    manager.assignCourse(code, name, credits, cType, instructor, manualDate);
                    break;

                case 4:
                    System.out.println("Enter student ID: ");
                    String studentId = input.nextLine();
                    manager.approveRegistrationForCourse(studentId);
                    break;

                case 5:
                    managerRunning = false;
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static String getCurrentDate() {
        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return date.format(formatter);
    }

    private static void addStudent(Employee emp, Scanner input) {
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
        emp.addNewStudentInfo(id, yof, name, gpa, ects);
    }

    private static void viewStudent(Employee emp, Scanner input) {
        System.out.println("Enter student ID: ");
        String id = input.nextLine();
        emp.viewStudentsInfo(id);
    }

    private static void viewTeacher(Employee emp, Scanner input) {
        System.out.println("Enter teacher full name: ");
        String fullName = input.nextLine();
        emp.viewTeacherInfo(fullName);
    }

    private static void readMessage(Employee emp, Scanner input) {
        System.out.println("Enter message title: ");
        String title = input.nextLine();
        emp.readMessage(title);
    }

    private static void sendMessage(Employee emp, Scanner input) {
        System.out.println("Enter message title: ");
        String title = input.nextLine();
        System.out.println("Enter message importance level (LOW, MEDIUM, HIGH): ");
        String level = input.nextLine();
        System.out.println("Enter message: ");
        String message = input.nextLine();
        emp.sendMessage(title, level, message, getCurrentDate());
    }

    private static void sendComplain(Employee emp, Scanner input) {
        System.out.println("Enter student ID: ");
        String id = input.nextLine();
        System.out.println("Enter complain title: ");
        String title = input.nextLine();
        System.out.println("Enter message importance level (LOW, MEDIUM, HIGH): ");
        String level = input.nextLine();
        System.out.println("Enter complain: ");
        String complain = input.nextLine();
        emp.sendComplain(id, title, level, complain, getCurrentDate());
    }
}
