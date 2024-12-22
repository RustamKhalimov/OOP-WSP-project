import java.util.ArrayList;

public class Mark {
	private double gpa;

	public double getGpa() {
		return gpa;
	}

	public double calculateCourseGPA(double digitGrade) {
        if (digitGrade >= 95) {
        	return 4.00;
        }
        else if (digitGrade >= 90) {
        	return 3.67;
        }
        else if (digitGrade >= 85) {
        	return 3.33;
        }
        else if (digitGrade >= 80) {
        	return 3.00;
        }
        else if (digitGrade >= 75) {
        	return 2.67;
        }
        else if (digitGrade >= 70) {
        	return 2.33;
        }
        else if (digitGrade >= 65) {
        	return 2.00;
        }
        else if (digitGrade >= 60) {
        	return 1.67;
        }
        else if (digitGrade >= 55) {
        	return 1.33;
        }
        else if (digitGrade >= 50) {
        	return 1.00;
        }
        else {
        	return 0.00;
        }
    }
	
	public double calculateSemesterGPA(ArrayList<Double> gpas, ArrayList<Integer> credits) {
	    double totalWeightedGPA = 0.0;
	    int totalCredits = 0;
	    if (gpas.size() != credits.size()) {
	        throw new IllegalArgumentException("GPA list and credits list must have the same size.");
	    }

	    for (int i = 0; i < gpas.size(); i++) {
	        totalWeightedGPA += gpas.get(i) *  credits.get(i);
	        totalCredits += credits.get(i);
	    }

	    if (totalCredits == 0) {
	        throw new ArithmeticException("Total credits cannot be zero.");
	    }
	    return totalWeightedGPA / totalCredits;
	}
	
}
