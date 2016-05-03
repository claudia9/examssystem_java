import java.util.Scanner;
import java.util.ArrayList;

public class ScheduleTUI {
    public static void main(String[] args) {
	Scanner keyboard = new Scanner(System.in);
	SOSU sosu = new SOSU();

	System.out.println("List of schools:");
	String[] schools = sosu.getAllSchoolNames();
	for (int i=0; i<schools.length; i++) {
	    System.out.println((i+1) + ": " + schools[i]);
	}
	System.out.print("Please enter a school number and press enter: ");
	int schoolIndex = keyboard.nextInt() - 1;
	keyboard.nextLine();

	System.out.print("Please enter your class name and press enter: ");
	String className = keyboard.nextLine();

	ArrayList<String[]> exams = sosu.getSchool(schoolIndex).getExamScheduleForClass(className);
	
	String scheduleText = sosu.getSchool(schoolIndex).getSchoolName() + "\n";
	scheduleText += "\nClass name: course name: date\n";
	scheduleText += "-------------------------------------\n";
	    
	// List information on all exams
	if (exams.size() != 0) { 	    
	    for (int i = 0; i < exams.size(); i++) {
		scheduleText += exams.get(i)[1] + ": " + exams.get(i)[0] + " - " + exams.get(i)[2] + "\n";
	    }
	// No exams were found
	} else {
	    scheduleText += "No exams found.";
	}

	System.out.println(scheduleText);
	
	System.out.println("Done. Program finisheded.");
	keyboard.close();
    }
}