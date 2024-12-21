import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Teacher extends Employee{
	private TeacherTitle title = TeacherTitle.ASSISTANT;
	private Course course;
	
	public Teacher(String typeEmployee, TeacherTitle title) {
		super(typeEmployee);
		this.setTitle(title);
	}
	
	
	public Course getCourse() {
		return course;
	}
	
	public void setCourse(Course course) {
		this.course = course;
	}
	
	
	public TeacherTitle getTitle() {
		return title;
	}
	
	public void setTitle(TeacherTitle title) {
		this.title = title;
	}
	
	public void updateMarks(String studentName, String studentId, String newGPA) {
        String filePath = "StudentsName.txt";
        List<String> updatedLines = new ArrayList<>();
        boolean studentFound = false;

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data[0].equalsIgnoreCase(studentName) && data[1].equalsIgnoreCase(studentId)) {
                   
                    data[2] = newGPA;
                    studentFound = true;
                }
                updatedLines.add(String.join(",", data));
            }
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        // ReWrite file with updated info
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (String updatedLine : updatedLines) {
                writer.write(updatedLine);
                writer.newLine();
            }
            if (studentFound) {
                System.out.println("GPA updated successfully for " + studentName);
            } else {
                System.out.println("Student with name '" + studentName + "' not found.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	public void sendRequest(String title,String importanceLevel,String message,String date) {
		super.sendMessage(title, importanceLevel, message, date);
	}
	
	public void sendComplainAboutStudent(String title,String importanceLevel,String complain,String date) {
		super.sendComplain(title, importanceLevel, complain, date);
	}

}
