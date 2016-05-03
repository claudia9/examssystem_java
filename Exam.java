/**
 * The class represents an exam
 * @author Morten, Nico, Stavro and Bjarki
 */
public class Exam {
    private Course course;
    private Class _class;
    
    /** The constructor
     * @param course the course that is part of this exam
     * @param _class the class that is part of this exam
     */
    public Exam(Course course, Class _class) {
	this.course = course;
	this._class = _class;
    }
    
    /**
     * @return a description of this exam including the class name and course name
     */
    public String toString() {
	String res = "Exam: \nClass name: " + _class.getClassName() + ". ";
	res += "Course: " + course.getCourseName() + "\n\n";
	return res;
    }
}