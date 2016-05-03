import java.util.Scanner;

public class ExamTUI {
    public static void main(String[] args) {
	Scanner keyboard = new Scanner(System.in);
	SOSU sosu = new SOSU();

	String doAddExamReport = "yes";
	
	new SOSU().install();

	while (doAddExamReport.equals("yes")) {
	    System.out.println("List of schools:");
	    String[] schools = sosu.getAllSchoolNames();
	    
	    
	    for (int i=0; i<schools.length; i++) {
	    	System.out.println((i+1) + ": " + schools[i]);
	    }
	    System.out.print("\nPlease enter a school number and press enter: ");
	    int schoolIndex = keyboard.nextInt() - 1;
	    System.out.println();

	    String[] educations = sosu.getSchool(schoolIndex).getAllEducationNames();

	    for (int i=0; i<educations.length; i++) {
		System.out.println((i+1) + ": " + educations[i]);
	    }
	    System.out.print("\nPlease enter an education number and press enter: ");
	    int educationIndex = keyboard.nextInt() - 1;
	    keyboard.nextLine();
	    System.out.println();

	    System.out.println("\nPlease enter one or more classes that you would like to create an exam for (seperate class names by semi-colon): ");
	    String classes = keyboard.nextLine();
	    
	    System.out.print("\nPlease enter your name: ");
	    String responsible = keyboard.nextLine();
	    
	    System.out.print("\nPlease the date for the exam(s) in format d/m/y: ");
	    String examsDate = keyboard.nextLine();

	    String report = sosu.generateExamReport(responsible, examsDate, schoolIndex, educationIndex, classes);

	    System.out.print("Would you like to save the report (yes/no)? ");
	    String doSave = keyboard.nextLine().toLowerCase();

	    if (doSave.equals("yes")) {
		System.out.print("Please enter a filename: ");
		String filename = keyboard.nextLine();
		sosu.saveReport(filename,  report);
		System.out.println("The following report was saved to disk:");   
	    }	

	    System.out.println(report);

	    System.out.print("Would you like to make another exam report? (yes/no): ");
	    doAddExamReport = keyboard.nextLine().toLowerCase();
	}
	System.out.println("Done. Program finished.");
	keyboard.close();
    }
}