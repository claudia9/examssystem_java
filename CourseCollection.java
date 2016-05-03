import java.util.ArrayList;


public class CourseCollection implements Iterable<Course> {

	private ArrayList<Course> courses;
	
	public CourseCollection(){
		courses = new ArrayList<Course>;
	}
	
	public void add (Course c){
		courses.add(c);
	}
	
	public Iterator<Course> iterator(){
		return course.iterator();
	}
	
}
