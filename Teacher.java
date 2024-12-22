import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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
	
	


	
	public void updateMarks(String studentId, double newMark) {
	    List<String> updatedGPA = new ArrayList<>();
	    List<String> updatedTotalGPA = new ArrayList<>();
	    boolean studentFound = false;
	    ArrayList<Double> gpas = new ArrayList<>();
	    ArrayList<Integer> credits = new ArrayList<>();
	    Mark mark = new Mark();
	 
	    Map<String, String[]> studentsMarks = new LinkedHashMap<>();
	    Map<String, String[]> courses = new LinkedHashMap<>();
	    Map<String, String[]> studentNames = new LinkedHashMap<>();

	    try (BufferedReader reader = new BufferedReader(new FileReader("StudentsTotalMarks.txt"));
	         BufferedReader reader2 = new BufferedReader(new FileReader("Courses.txt"));
	         BufferedReader reader3 = new BufferedReader(new FileReader("StudentsName.txt"))) {
	    	
	    	Scanner input = new Scanner(System.in);
	    	
	        // Reading StudentsMarks.txt
	        String line;
	        while ((line = reader.readLine()) != null) {
	            String[] data = line.split(",");
	            studentsMarks.put(data[0], data); 
	        }

	        // Reading Courses.txt
	        String line2;
	        while ((line2 = reader2.readLine()) != null) {
	            String[] data2 = line2.split(",");
	            courses.put(data2[1], data2); 
	        }

	        // Reading StudentsName.txt
	        String line3;
	        while ((line3 = reader3.readLine()) != null) {
	            String[] data3 = line3.split(",");
	            studentNames.put(data3[0], data3); 
	        }

	        for (String studentIdInMarks : studentsMarks.keySet()) {
	            String[] studentData = studentsMarks.get(studentIdInMarks);
	            String[] studentNameData = studentNames.get(studentIdInMarks);

	            if (studentIdInMarks.equals(studentId)) {
	                System.out.println("1. Update " + studentData[1]);
	                System.out.println("2. Update " + studentData[4]);
	                System.out.println("3. Update " + studentData[7]);
	                System.out.println("4. Update " + studentData[10]);

	                int switcher = input.nextInt();
	                switch (switcher) {
	                    case 1:
	                    	studentData[2] = Double.toString(newMark);
	                    	studentData[3] = Double.toString(mark.calculateCourseGPA(newMark));
	                        studentFound = true;
	                        break;
	                    case 2:
	                    	studentData[5] = Double.toString(newMark);
	                        studentData[6] = Double.toString(mark.calculateCourseGPA(newMark));
	                        studentFound = true;
	                        break;
	                    case 3:
	                    	studentData[8] = Double.toString(newMark);
	                        studentData[9] = Double.toString(mark.calculateCourseGPA(newMark));
	                        studentFound = true;
	                        break;
	                    case 4:
	                    	studentData[11] = Double.toString(newMark);
	                        studentData[12] = Double.toString(mark.calculateCourseGPA(newMark));
	                        studentFound = true;
	                        break;
	                    default:
	                        System.out.println("Invalid choice. Try again.");
	                }

	                // Adding each GPA of courses to list of all GPA
	                for (int i = 3; i < studentData.length; i += 3) {
	                    gpas.add(Double.parseDouble(studentData[i]));
	                }

	                // Adding each credits of courses to list of all credits
	                for (int i = 1; i < studentData.length; i += 3) {
	                    String courseId = studentData[i];
	                    if (courses.containsKey(courseId)) {
	                        credits.add(Integer.parseInt(courses.get(courseId)[2])); 
	                    }
	                }

	                // Updating total GPA
	                if (studentNameData != null) {
	                    studentNameData[3] = Double.toString(mark.calculateSemesterGPA(gpas, credits));
	                }

	                updatedGPA.add(String.join(",", studentData));
	                updatedTotalGPA.add(String.join(",", studentNameData));
	            } 
	            else {
	                
	                updatedGPA.add(String.join(",", studentData));
	                updatedTotalGPA.add(String.join(",", studentNameData));
	            }
	        }

	    } 
	    catch (IOException e) {
	        e.printStackTrace();
	        return;
	    }

	    //ReWrite file with updated information
	    try (BufferedWriter writer = new BufferedWriter(new FileWriter("StudentsTotalMarks.txt"));
	         BufferedWriter writer2 = new BufferedWriter(new FileWriter("StudentsName.txt"))) {

	        for (String updatedGPALine : updatedGPA) {
	            writer.write(updatedGPALine);
	            writer.newLine();
	        }
	        for (String updatedTotalGPALine : updatedTotalGPA) {
	            writer2.write(updatedTotalGPALine);
	            writer2.newLine();
	        }

	        if (studentFound) {
	            System.out.println("GPA updated successfully");
	        } 
	        else {
	            System.out.println("Student not found.");
	        }

	    } 
	    catch (IOException e) {
	        e.printStackTrace();
	    }
	}



	
	public void sendRequest(String title,String importanceLevel,String message,String date) {
		super.sendMessage(title, importanceLevel, message, date);
	}
	
	public void sendComplainAboutStudent(String studentId, String title,String importanceLevel,String complain,String date) {
		super.sendComplain(studentId,title, importanceLevel, complain, date);
	}


}
