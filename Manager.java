import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Manager extends Employee {
	private Managers managerType = Managers.OR;
	
	public Manager(String typeEmployee , Managers managerType) {
		super(typeEmployee);
		this.managerType = managerType;
	}

	public Managers getManagerType() {
		return managerType;
	}

	public void setManagerType(Managers managerType) {
		this.managerType = managerType;
	}
	
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
	
	public void readRequest(String massageTitle) {
		super.readMessage(massageTitle);
	}
	
	public void assignCourse(String courseName,String credits , String type , String date , String instructor) {
		try {
			 FileWriter writer = new FileWriter("Courses.txt",true);
			 String newCourse = courseName + "," + credits + "," + type + "," + date + "," + instructor;
		        writer.append(newCourse + "\n");
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

}
