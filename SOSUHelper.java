import java.util.ArrayList;
import java.io.*;

/* 
 * This class will provide file helper/utility methods for the SOSU class
 */
public class SOSUHelper {
    // This method is be run only once. It will create the schools array list.
    // Then serialize and save it into a binary file.
    // This binary file will be read by the SOSU class each time the SOSU class
    // is created.

    /**
     * This method will save the schools, educations and courses to a binary
     * file
     */
    public static void oneTimeSetup() {
	ArrayList<School> schools = new ArrayList<School>();
	// Create Courses
	Course c1 = new Course("Dansk");
	Course c2 = new Course("Samfundsfag");
	Course c3 = new Course("Paedagogik");
	Course c4 = new Course("Kultur- og aktivitetsfag");
	Course c5 = new Course("Bevaegelse og idraet");
	Course c6 = new Course("Sundhedsfag");
	Course c7 = new Course("Sprog, kommunikation og psykologi");
	Course c8 = new Course("IT og kommunikation");
	Course c9 = new Course("Paedagogik med psykologi");
	Course c10 = new Course("Naturfag");
	Course c11 = new Course("Engelsk");
	Course c12 = new Course("Koordinering, kvalitetssikring og dokumentation");
	Course c13 = new Course("Sygepleje");
	Course c14 = new Course("Somatisk sygdomslære og farmakologi");
	Course c15 = new Course("Psykiatrisk sygdomslaere og farmakologi");
	Course c16 = new Course("Forebyggelse og rehabilitering");
	Course c17 = new Course("SundhedsPaedagogik og kommunikation");
	Course c18 = new Course("Aktivitets- og praktisk fag");
	Course c19 = new Course("Social- og sundhedssektoren");
	Course c20 = new Course("Pleje og dokumentation");
	Course c21 = new Course("Psykologi og kommunikation");
	Course c22 = new Course("Rehabilitering og social- og sundhedsfaglig indsats");
	Course c23 = new Course("Social- og samfundsfag");

	// Create Educations
	Education e1 = new Education("Den paedagogiske assistentuddannelse (grundfag)");
	Education e2 = new Education("Den paedagogiske assistentuddannelse (omraadefag)");
	Education e3 = new Education("Den paedagogiske grunduddannelse (grundfag)");
	Education e4 = new Education("Den paedagogiske grunduddannelse (omraadefag)");
	Education e5 = new Education("Grundforloeb 1");
	Education e6 = new Education("Grundforloeb 2 mod pau retning");
	Education e7 = new Education("Grundforloeb 2 mod ssh retning");
	Education e8 = new Education("Grundforloebet");
	Education e9 = new Education("Social- og sundhedsassistentuddannelsen (grundfag)");
	Education e10 = new Education("Social- og sundhedsassistentuddannelsen (omraadefag) - ny ordning");
	Education e11 = new Education("Social- og sundhedshjaelperuddannelsen");
	Education e12 = new Education("Social- og sundhedshjaelperuddannelsen - ny ordning");

	

	
	
	// Add courses to educations
	e1.addCourse(c1);
	e1.addCourse(c2);

	e2.addCourse(c3);
	e2.addCourse(c4);
	e2.addCourse(c5);
	e2.addCourse(c6);
	e2.addCourse(c7);

	e3.addCourse(c1);
	e3.addCourse(c2);

	e4.addCourse(c8);
	e4.addCourse(c4);
	e4.addCourse(c9);
	e4.addCourse(c6);

	e5.addCourse(c1);

	e6.addCourse(c1);
	e6.addCourse(c1);

	e7.addCourse(c1);
	e7.addCourse(c10);

	e8.addCourse(c1);
	e8.addCourse(c11);
	e8.addCourse(c10);

	e9.addCourse(c1);
	e9.addCourse(c10);

	e10.addCourse(c12);
	e10.addCourse(c13);
	e10.addCourse(c14);
	e10.addCourse(c15);
	e10.addCourse(c16);
	e10.addCourse(c17);

	e11.addCourse(c18);
	e11.addCourse(c1);
	e11.addCourse(c10);
	e11.addCourse(c9);
	e11.addCourse(c23);
	e11.addCourse(c6);

	e12.addCourse(c19);
	e12.addCourse(c20);
	e12.addCourse(c21);
	e12.addCourse(c22);
	e12.addCourse(c1);
	e12.addCourse(c10);

	// Create Schools
	School s1 = new School("SOSU Nord");
	School s2 = new School("Social- og Sundhedsskolen Skive, Thisted, Viborg");
	School s3 = new School("Randers Social- og Sundhedsskole");
	School s4 = new School("Aarhus Social- og Sundhedsskole");
	School s5 = new School("Social- og Sundhedsskolen, Silkeborg");
	School s6 = new School("Social- og Sundhedsskolen, Herning");
	School s7 = new School("Social- og Sundhedsskolen, Fredericia – Horsens");
	School s8 = new School("Social- og Sundhedsskolen, Esbjerg");

	School s9 = new School("Social- og Sundhedsskolen, Syd");
	School s10 = new School("Social- og Sundhedsskolen, Fyn");
	School s11 = new School("Bornholms Sundheds- og Sygeplejeskole");
	School s12 = new School("Heilsuskuli Føroya");

	School s13 = new School("SOPU Koebenhavn & Nordsjaelland");
	School s14 = new School("UC Diakonissestiftelsen Social- og Sundhedsskole");
	School s15 = new School("SOSU C Social- og Sundhedsuddannelses Centret ");
	School s16 = new School("SOSU Sjaelland");
	School s17 = new School("SOSU Nykoebing F.");

	// Add educations to school
	s1.addEducation(e1);
	s1.addEducation(e2);
	s1.addEducation(e3);
	s1.addEducation(e4);
	s1.addEducation(e5);
	s1.addEducation(e6);
	s1.addEducation(e7);
	s1.addEducation(e8);
	s1.addEducation(e9);
	s1.addEducation(e10);
	s1.addEducation(e11);
	s1.addEducation(e12);

	s2.addEducation(e1);
	s2.addEducation(e2);
	s2.addEducation(e3);
	s2.addEducation(e4);
	s2.addEducation(e8);
	s2.addEducation(e9);
	s2.addEducation(e10);
	s2.addEducation(e11);
	s2.addEducation(e12);

	s3.addEducation(e1);
	s3.addEducation(e2);
	s3.addEducation(e3);
	s3.addEducation(e4);
	s3.addEducation(e5);
	s3.addEducation(e6);
	s3.addEducation(e7);
	s3.addEducation(e8);
	s3.addEducation(e9);
	s3.addEducation(e10);
	s3.addEducation(e11);
	s3.addEducation(e12);

	s4.addEducation(e1);
	s4.addEducation(e2);
	s4.addEducation(e3);
	s4.addEducation(e4);
	s4.addEducation(e5);
	s4.addEducation(e6);
	s4.addEducation(e7);
	s4.addEducation(e8);
	s4.addEducation(e9);
	s4.addEducation(e10);
	s4.addEducation(e11);
	s4.addEducation(e12);

	s5.addEducation(e1);
	s5.addEducation(e2);
	s5.addEducation(e3);
	s5.addEducation(e4);
	s5.addEducation(e5);
	s5.addEducation(e6);
	s5.addEducation(e7);
	s5.addEducation(e9);
	s5.addEducation(e10);
	s5.addEducation(e11);
	s5.addEducation(e12);
	
	s6.addEducation(e1);
	s6.addEducation(e2);
	s6.addEducation(e3);
	s6.addEducation(e4);
	s6.addEducation(e5);
	s6.addEducation(e6);
	s6.addEducation(e7);
	s6.addEducation(e9);
	s6.addEducation(e10);
	s6.addEducation(e11);
	s6.addEducation(e12);
	
	s7.addEducation(e1);
	s7.addEducation(e2);
	s7.addEducation(e3);
	s7.addEducation(e4);
	s7.addEducation(e5);
	s7.addEducation(e6);
	s7.addEducation(e7);
	s7.addEducation(e9);
	s7.addEducation(e10);
	s7.addEducation(e11);
	s7.addEducation(e12);
	
	s8.addEducation(e1);
	s8.addEducation(e2);
	s8.addEducation(e3);
	s8.addEducation(e4);
	s8.addEducation(e5);
	s8.addEducation(e6);
	s8.addEducation(e7);
	s8.addEducation(e9);
	s8.addEducation(e10);
	s8.addEducation(e11);
	s8.addEducation(e12);
	
	s9.addEducation(e1);
	s9.addEducation(e2);
	s9.addEducation(e3);
	s9.addEducation(e4);
	s9.addEducation(e5);
	s9.addEducation(e6);
	s9.addEducation(e7);
	s9.addEducation(e9);
	s9.addEducation(e10);
	s9.addEducation(e11);
	s9.addEducation(e12);
	
	s10.addEducation(e1);
	s10.addEducation(e2);
	s10.addEducation(e3);
	s10.addEducation(e4);
	s10.addEducation(e5);
	s10.addEducation(e6);
	s10.addEducation(e7);
	s10.addEducation(e9);
	s10.addEducation(e10);
	s10.addEducation(e11);
	s10.addEducation(e12);
	
	s11.addEducation(e1);
	s11.addEducation(e2);
	s11.addEducation(e3);
	s11.addEducation(e4);
	s11.addEducation(e5);
	s11.addEducation(e6);
	s11.addEducation(e7);
	s11.addEducation(e9);
	s11.addEducation(e10);
	s11.addEducation(e11);
	s11.addEducation(e12);

	s12.addEducation(e1);
	s12.addEducation(e2);
	s12.addEducation(e3);
	s12.addEducation(e4);
	s12.addEducation(e5);
	s12.addEducation(e6);
	s12.addEducation(e7);
	s12.addEducation(e8);
	s12.addEducation(e9);
	s12.addEducation(e10);
	s12.addEducation(e11);
	s12.addEducation(e12);
	
	s13.addEducation(e1);
	s13.addEducation(e2);
	s13.addEducation(e3);
	s13.addEducation(e4);
	s13.addEducation(e5);
	s13.addEducation(e6);
	s13.addEducation(e7);
	s13.addEducation(e8);
	s13.addEducation(e9);
	s13.addEducation(e10);
	s13.addEducation(e11);
	s13.addEducation(e12);
	
	s14.addEducation(e5);
	s14.addEducation(e6);
	s14.addEducation(e9);
	s14.addEducation(e11);
	
	s15.addEducation(e1);
	s15.addEducation(e2);
	s15.addEducation(e3);
	s15.addEducation(e4);
	s15.addEducation(e5);
	s15.addEducation(e6);
	s15.addEducation(e7);
	s15.addEducation(e9);
	s15.addEducation(e10);
	s15.addEducation(e11);
	s15.addEducation(e12);
	
	s16.addEducation(e1);
	s16.addEducation(e2);
	s16.addEducation(e3);
	s16.addEducation(e4);
	s16.addEducation(e5);
	s16.addEducation(e6);
	s16.addEducation(e7);
	s16.addEducation(e9);
	s16.addEducation(e10);
	s16.addEducation(e11);
	s16.addEducation(e12);
	
	s17.addEducation(e1);
	s17.addEducation(e2);
	s17.addEducation(e3);
	s17.addEducation(e4);
	s17.addEducation(e5);
	s17.addEducation(e6);
	s17.addEducation(e7);
	s17.addEducation(e9);
	s17.addEducation(e10);
	s17.addEducation(e11);
	s17.addEducation(e12);
	
	
	schools.add(s1);
	schools.add(s2);
	schools.add(s3);
	schools.add(s4);
	schools.add(s5);
	schools.add(s6);
	schools.add(s7);
	schools.add(s8);
	schools.add(s9);
	schools.add(s10);
	schools.add(s11);
	schools.add(s12);
	schools.add(s13);
	schools.add(s14);
	schools.add(s15);
	schools.add(s16);
	schools.add(s17);

	// Save the school array list to a file (for reading each time we start
	// the GUI):
	String filename = "schools.bin";

	ObjectOutputStream out = null;
	try {
	    File file = new File(filename);
	    FileOutputStream fos = new FileOutputStream(file);
	    out = new ObjectOutputStream(fos);
	    out.writeObject(schools); // serialize and save the object
	} catch (IOException e) {
	    System.out.println("Exception: " + filename);
	} finally {
	    try {
		out.close();
	    } catch (IOException e) {
		e.printStackTrace();
	    }
	}
    }

    /**
     * @return an array list of strings of all educations in SOSU
     */
    public static ArrayList<Education> getAllEducations() {
	ArrayList<Education> educations = new ArrayList<Education>();
	educations.add(new Education(
		"Den paedagogiske assistentuddannelse (grundfag)"));
	educations.add(new Education(
		"Den paedagogiske assistentuddannelse (omraadefag)"));
	educations.add(new Education(
		"Den paedagogiske grunduddannelse (grundfag)"));
	educations.add(new Education(
		"Den paedagogiske grunduddannelse (omraadefag)"));
	educations.add(new Education("Grundforloeb 1"));
	educations.add(new Education("Grundforloeb 2 mod pau retning"));
	educations.add(new Education("Grundforloeb 2 mod ssh retning"));
	educations.add(new Education("Grundforloebet"));
	educations.add(new Education(
		"Social- og sundhedsassistentuddannelsen (grundfag)"));
	educations
		.add(new Education(
			"Social- og sundhedsassistentuddannelsen (omraadefag) - ny ordning"));
	educations.add(new Education("Social- og sundhedshjaelperuddannelsen"));
	educations.add(new Education(
		"Social- og sundhedshjaelperuddannelsen - ny ordning"));
	return educations;
    }

    /**
     * @return the array list of schools (and the educations and courses they
     *         contain)
     */
    public static ArrayList<School> loadSchools() {
	ArrayList<School> res = new ArrayList<School>();

	String filename = "schools.bin";
	ObjectInputStream in = null;

	File file = new File(filename);

	// If the file doesn't exists (the system is not installed) then return a new empty array list of schools
	if (!file.exists()) {
	    return res;
	    // Otherwise the Schools array list from the binary file and return it
	} else {
	    try {

		FileInputStream fis = new FileInputStream(file);
		in = new ObjectInputStream(fis);

		// de-serialize and store the saved array list in the res array
		// list
		res = (ArrayList<School>) in.readObject();
	    } catch (IOException | ClassNotFoundException e) {
		e.printStackTrace();
	    } finally {
		try {
		    in.close();
		} catch (IOException e) {
		    e.printStackTrace();
		}
	    }
	    return res;
	}
    }

    /**
     * This class will update the binary file that stores the schools array list
     * 
     * @param schools
     *            the array list that is to be saved (updated) to a binary file
     */
    public static void saveUpdatedSchools(ArrayList<School> schools) {
	// update any changes that have been done to the program
	String filename = "schools.bin";
	ObjectOutputStream out = null;
	try {
	    File file = new File(filename);
	    FileOutputStream fos = new FileOutputStream(file);
	    out = new ObjectOutputStream(fos);
	    out.writeObject(schools); // serialize and save the object
	} catch (IOException e) {
	    System.out.println("Exception: " + filename);
	} finally {
	    try {
		out.close();
	    } catch (IOException e) {
		e.printStackTrace();
	    }
	}
    }
}