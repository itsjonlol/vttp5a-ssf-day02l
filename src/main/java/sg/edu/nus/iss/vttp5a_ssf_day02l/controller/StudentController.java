package sg.edu.nus.iss.vttp5a_ssf_day02l.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import sg.edu.nus.iss.vttp5a_ssf_day02l.model.Student;

@Controller
@RequestMapping("/students")
public class StudentController {
    List<Student> students;
    
    //@ResponseBody // return the list for example, not string for responsebody
    @RequestMapping(path = {"", "/allStudents"}, method=RequestMethod.GET)
    //localhost:8080/students/allStudents
    public String studentListing(Model model) throws ParseException {

        students = new ArrayList<>();
        // convert a date string to epoch (long)
        String dob = "18 Dec 1975 10:25:00.000 SGT";
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy HH:mm:ss.SSS zzz");
        Date dDob = sdf.parse(dob);
        Long epochDob = dDob.getTime();

        Long epochTime = 188103300000L;
        Date dTime = new Date(epochTime);
        String formattedTime = sdf.format(dTime);

        Student s1 = new Student(1, "Damien", "Cumming", epochDob, dDob,formattedTime ,"damient@nus.edu.sg", "25 HMKT 119615");
        students.add(s1);

        Student s2 = new Student(1, "Darryl", "Ng", epochDob,dDob,formattedTime, "darrylng@nus.edu.sg", "25 HMKT 119615");
        students.add(s2);

        Student s3 = new Student(1, "Brandon", "Ng", epochDob,dDob,formattedTime, "bradonng@nus.edu.sg", "25 HMKT 119615");
        students.add(s3);

        // Student s4 = new Student(1, "Damien", "Cumming", dob, "damient@nus.edu.sg", "25 HMKT 119615");
        // students.add(s4);

        // Student s5 = new Student(1, "Darryl", "Ng", dob, "darrylng@nus.edu.sg", "25 HMKT 119615");
        // students.add(s5);

        // Student s6 = new Student(1, "Brandon", "Ng", dob, "bradonng@nus.edu.sg", "25 HMKT 119615");
        // students.add(s6);


        model.addAttribute("students", students);
        return "students_page";
    }
    
}
