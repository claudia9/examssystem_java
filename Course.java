import java.io.Serializable;

/**
 * This class represents a course
 * @author Morten, Nico, Stavro and Bjarki
 */
public class Course implements Serializable {
    private String courseName;
    
    /** 
     * The constructor for this class
     * @param courseName The name of the course
     */
    public Course(String courseName) {
	this.courseName = courseName;
    }
    
    /**
     * @return The name of the course
     */    
    public String getCourseName() {
	return courseName;
    }
}