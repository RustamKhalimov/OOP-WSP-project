import java.util.Vector;
import java.util.Date;

public class Course {
    private String nameOfCourse;
    private int credits;
    private TypeOfCourse type = TypeOfCourse.Free; 
    private Date schedule;  
    private Vector<Teacher> instructors = new Vector<>();
    
    public Course(String nameOfCourse, int credits, Date schedule) {
        this.nameOfCourse = nameOfCourse;
        this.credits = credits;
        this.schedule = schedule;
    }

    public String getNameOfCourse() {
        return nameOfCourse;
    }

    public void setNameOfCourse(String nameOfCourse) {
        this.nameOfCourse = nameOfCourse;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public Date getSchedule() {
        return schedule;
    }

    public void setSchedule(Date schedule) {
        this.schedule = schedule;
    }

    public TypeOfCourse getType() {
        return type;
    }

    // Метод для изменения типа курса
    public void setType(TypeOfCourse type) {
        this.type = type;
    }

    // Метод для добавления преподавателя
    public void addInstructor(Teacher instructor) {
        this.instructors.add(instructor);
    }

    @Override
    public String toString() {
        return String.format("Курс: %s, Кредиты: %d, Тип: %s, Расписание: %s",
                nameOfCourse, credits, type, schedule);
    }
}
