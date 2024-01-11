package StudentApplication.WebProject.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
// THIS IS A DTO CLASS

@Getter
@Setter
@AllArgsConstructor//it will create a parameterize constructor
@NoArgsConstructor//it will create a default or no parameterize constructor
public class Student
{
    private int studentRollNumber;
    private String studentName;
    private String studentContactNumber;
    private String studentAddress;
    private int studentTotalMarks;
    private int studentObtainedMarks;
}
