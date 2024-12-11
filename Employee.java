import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class Employee implements SendMassage{
    private String typeEmployee;

    public Employee(String typeEmployee) {
        this.typeEmployee = typeEmployee;
    }

    public String getTypeEmployee() {
        return typeEmployee;
    }

    public void setTypeEmployee(String typeEmployee) {
        this.typeEmployee = typeEmployee;
    }
    
    public void addNewStudentInfo(String newStudentName,String newStudentId , String newGPA) {
		try {
			 FileWriter writer = new FileWriter("StudentsName.txt",true);
			 String newInfo = newStudentName + "," + newStudentId + "," + newGPA;
		        writer.append(newInfo + "\n");
		        writer.close();
		}
		catch (FileNotFoundException e) {
            System.out.println("File not founded");
            e.printStackTrace();
		}    
		catch(IOException e) {
			e.printStackTrace();
		}
	}
    
    public void viewStudentsInfo(String studentName , String studentId) {
        try (BufferedReader reader = new BufferedReader(new FileReader("StudentsName.txt"))) {
            String line;
            boolean studentFound = false;

            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data[0].equalsIgnoreCase(studentName) && data[1].equalsIgnoreCase(studentId)) { 
                    System.out.println("Information about a student:");
                    System.out.printf("Name: %s, ID: %s, GPA: %s%n", data[0], data[1], data[2]);
                    studentFound = true;
                    break; 
                }
            }

            if (!studentFound) {
                System.out.println("Student with name '" + studentName + "' not founded.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    
    public void viewTeacherInfo(String teacherName) {
    	try (BufferedReader reader = new BufferedReader(new FileReader("TeachersName.txt"))) {
            String line;
            boolean teacherFound = false;

            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data[0].equalsIgnoreCase(teacherName)) { 
                    System.out.println("Information about a teacher:");
                    System.out.printf("Name: %s, Surname: %s, Decepline: %s%n", data[0], data[1], data[2]);
                    teacherFound = true;
                    break; 
                }
            }

            if (!teacherFound) {
                System.out.println("Teacher with name '" + teacherName + "' not founded.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    
    @Override
    public void readMessage(String messageTitle) {
    	try (BufferedReader reader = new BufferedReader(new FileReader("Message.txt"))) {
            String line;
            boolean messageFound = false;

            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data[0].equalsIgnoreCase(messageTitle)) { 
                    System.out.println("Message with title" + messageTitle + " :");
                    System.out.printf("Importance Level: %s, message: %s, date: %s%n", data[1], data[2] , data[3]);
                    messageFound = true;
                    break; 
                }
            }

            if (!messageFound) {
                System.out.println("Meassage with title '" + messageTitle + "' not founded.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void sendMessage(String title,String importanceLevel,String message,String date) {
    	try {
			 FileWriter writer = new FileWriter("Message.txt",true); 
		        writer.append(title + "," + importanceLevel + "," + message + "," + date + "\n");
		        writer.close();
		}
		catch (FileNotFoundException e) {
           System.out.println("File not founded");
           e.printStackTrace();
		}    
		catch(IOException e) {
			e.printStackTrace();
		}
    }

    @Override
    public void sendComplain(String title,String importanceLevel,String complain,String date) {
    	try {
			 FileWriter writer = new FileWriter("Complain.txt",true); 
		        writer.append(title + "," + importanceLevel + "," + complain + "," + date + "\n");
		        writer.close();
		}
		catch (FileNotFoundException e) {
          System.out.println("File not founded");
          e.printStackTrace();
		}    
		catch(IOException e) {
			e.printStackTrace();
		}
    }

	@Override
	public void readComplain(String complainTitle) {
		try (BufferedReader reader = new BufferedReader(new FileReader("Complain.txt"))) {
            String line;
            boolean complainFound = false;

            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data[0].equalsIgnoreCase(complainTitle)) { 
                    System.out.println("Complain with title" + complainTitle + " :");
                    System.out.printf("Importance Level: %s, complain: %s, date: %s%n", data[1], data[2] , data[3]);
                    complainFound = true;
                    break; 
                }
            }

            if (!complainFound) {
                System.out.println("Complain with title '" + complainTitle + "' not founded.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
}
