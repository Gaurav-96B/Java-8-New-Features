import java.util.*;
import java.util.stream.*;


class StudentGrade {


    private String studentName;
    private Map<String, Integer> grades;


    public StudentGrade(String studentName, Map<String, Integer> grades) {
        this.studentName = studentName;
        this.grades = grades;
    }


    public String getStudentName() {
        return studentName;
    }


    public Map<String, Integer> getGrades() {
        return grades;
    }


    @Override
    public String toString() {
        return studentName + " -> " + grades;
    }
}
public class Main
{
	public static void main(String[] args) {
	     List<StudentGrade> students = List.of(

                new StudentGrade(
                        "Gaurav",
		                        Map.of(
                                "Java", 90,
                                "Spring", 80,
                                "SQL", 95
                        )
                ),

                new StudentGrade(
                        "Rahul",
                        Map.of(
                                "Java", 70,
                                "Spring", 75,
                                "SQL", 80
                        )
                ),

                new StudentGrade(
                        "Amit",
                        Map.of(
                                "Java", 85,
                                "Spring", 88,
                                "SQL", 84
                        )
                )
        );
        // 1. Calculate average marks for each student

    //   Map<String,OptionalDouble>map=students.stream().collect(Collectors.toMap(student->student.getStudentName(),
    //   student->student.getGrades().entrySet().stream().mapToInt(entry->entry.getValue()).average()));
    //   map.forEach((key,value)->System.out.println(key+" "+value.getAsDouble()));
      
      Map<String,OptionalDouble>map=students.stream().collect(Collectors.toMap(student->student.getStudentName(),
      student->student.getGrades().entrySet().stream().mapToInt(entry->entry.getValue()).average()));
      map.forEach((key,value)->value.ifPresent(avg->System.out.println(key+" "+value.getAsDouble())));
      
      // 2. Find highest scoring student
      
      students.stream().sorted(Comparator.comparing(student->student.getGrades().entrySet()
      .stream().mapToInt(entry->entry.getValue()).sum(),Comparator.reverseOrder())).forEach(System.out::println);
    
    //3. Find subject in which highest-scoring student scored highest
    
    //4. Rank students according to total marks

      
      
      
      
}
}
