package StudentApplication.WebProject.Controller;

import StudentApplication.WebProject.Model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

//This is a controller class that's why we are using @Controller
@Controller
public class StudentController
{
    List<Student> studentList = new ArrayList<>();
    {
        studentList.add(new Student(1,"ANIKET","12345","PUNE",500,400));
        studentList.add(new Student(2,"ABHISHEK","54321","WAKAD",500,50));
        studentList.add(new Student(3,"ANUJ","43215","DECCAN",500,368));
        studentList.add(new Student(4,"AJAY","53214","MAGARPATTA",500,460));
        studentList.add(new Student(5,"AKASH","31425","AUNDH",500,100));
    }
    //MODEL FROM UI PACKAGE
    @GetMapping("/display")
    public String  displayStudentData(Model model){
        model.addAttribute("studentData",studentList);
        return "displayStudentData";
    }
    // it is get method
    @GetMapping("/addStudent")
    public String createObject(Model model){
        model.addAttribute("studentObject",new Student());
        return "studentForm";
    }
    //it is post method
    @PostMapping("/saveStudent")
    public String  saveStudent(Student student){//here getting the object of the student which is being returned from html page
        studentList.add(student);// here we are adding the student in arraylist
        return "redirect:/display";
    }

    @GetMapping("/updateStudent/{id}")
    public String  fetchObject(@PathVariable int id ,Model model){//@path variable get the id from the url
        for (Student s:studentList){
            if (s.getStudentRollNumber() == id){
                model.addAttribute("matchingObject",s);
                break;
            }
        }
        return "updateStudent";
    }

    @PostMapping("/saveUpdatedStudent")
    public String saveUpdatedStudent(Student student){
        for(Student s:studentList){
            if (s.getStudentRollNumber() == student.getStudentRollNumber()){
                studentList.set(studentList.indexOf(s),student);
                break;
            }
        }
        return "redirect:/display";
    }

    @GetMapping("/deleteStudent/{id}")
    public String  deleteStudent(@PathVariable int id){//@path variable get the id from the url
        for (Student s: studentList){
            if (s.getStudentRollNumber() == id){
                studentList.remove(s);
                break;
            }
        }
        return "redirect:/display";
    }
}
