import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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
	
	public void readComplain(String complainId) {
		try (BufferedReader reader = new BufferedReader(new FileReader("Complain.txt"))) {
            String line;
            boolean complainFound = false;

            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data[0].equalsIgnoreCase(complainId)) { 
                    System.out.println("Complain for student with ID" + complainId + " :");
                    System.out.printf("Complain title: %s, Importance Level: %s, complain: %s, date: %s%n", data[1], data[2] , data[3] , data[4]);
                    complainFound = true;
                    break; 
                }
            }

            if (!complainFound) {
                System.out.println("Complain for student with ID: '" + complainId + "' not founded.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public void readRequest(String massageTitle) {
		super.readMessage(massageTitle);
	}
	
	public void assignCourse(String courseCode,String courseName,String credits,String type,String instructor,String date) {
		try {
			 FileWriter writer = new FileWriter("Courses.txt",true);
			 String newCourse = courseCode + "," + courseName + "," + credits + "," + type + "," + instructor + "," + date;
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

	
	public void approveRegistrationForCourse(String studentId) {
	    List<String> updatedRequests = new ArrayList<>();
	    boolean studentFound = false;
	    boolean canRegister = true;

	    Map<String, String[]> studentsRetakes = new LinkedHashMap<>();
	    Map<String, String[]> registrationRequests = new LinkedHashMap<>();

	    try (
	        BufferedReader retakesReader = new BufferedReader(new FileReader("StudentsRetakes.txt"));
	        BufferedReader requestsReader = new BufferedReader(new FileReader("RegistrationRequests.txt"))) {
	        
	    	// Reading StudentsRetakes.txt
	        String retakeLine;
	        while ((retakeLine = retakesReader.readLine()) != null) {
	            String[] data = retakeLine.split(",");
	            studentsRetakes.put(data[0], data);
	        }

	        // Reading RegistrationRequests.txt
	        String requestLine;
	        while ((requestLine = requestsReader.readLine()) != null) {
	            String[] data = requestLine.split(",");
	            registrationRequests.put(data[0], data);
	        }

	        if (studentsRetakes.containsKey(studentId)) {
	            studentFound = true;
	            String[] studentData = studentsRetakes.get(studentId);

	            if (registrationRequests.containsKey(studentId)) {
	                String[] requestData = registrationRequests.get(studentId);
	                String requestedCourse = requestData[1];
	                String deviatedСourse = requestData[2];
	                for (int i = 1; i < studentData.length; i += 2) {
	                    String course = studentData[i];
	                    int retakes = Integer.parseInt(studentData[i + 1]);

	                    if (course.equalsIgnoreCase(requestedCourse) && retakes > 0) {
	                        System.out.println("Student with ID '" + studentId + "' cannot register for '" + deviatedСourse + "' due to " + retakes + " retake(s) in " + requestedCourse +"\n");
	                        canRegister = false;
	                        break;
	                    }
	                }

	                if (canRegister) {
	                    System.out.println("Student with ID '" + studentId + "' is approved to register for '" + deviatedСourse + "'.\n");
	                    requestData[3] = "approved";
	                } 
	                else {
	                    requestData[3] = "denied";
	                }

	                updatedRequests.add(String.join(",", requestData));
	            } 
	            else {
	                System.out.println("No registration requests found for student with ID '" + studentId + "'.");
	            }
	        } 
	        else {
	            System.out.println("Student with ID '" + studentId + "' not found in StudentsRetakes.");
	        }

	        for (String id : registrationRequests.keySet()) {
	            if (!id.equals(studentId)) {
	                updatedRequests.add(String.join(",", registrationRequests.get(id)));
	            }
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	        return;
	    }

	    // ReWrite registration requests file
	    try (BufferedWriter requestsWriter = new BufferedWriter(new FileWriter("RegistrationRequests.txt"))) {
	        for (String updatedRequestLine : updatedRequests) {
	            requestsWriter.write(updatedRequestLine);
	            requestsWriter.newLine();
	        }

	        if (studentFound) {
	            System.out.println("Registration requests updated successfully.");
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}



}
