package com.fai.university.university.controller;

import com.fai.university.university.dao.IStudentReponsitory;
import com.fai.university.university.entity.Student;
import com.fai.university.university.services.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/student")
public class StudentController {
    final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    @GetMapping("/list")
    public String StudentService(Model model){
        List<Student> students = studentService.getAllStudents();
        model.addAttribute("students", students);
        return "student/index";
    }

    @PostMapping("/save")
    public String SaveStudent(@ModelAttribute("student") Student student) {
        studentService.addNewStudent(student);
        return "redirect:/students/list";
    }

    @GetMapping("formUpdate")
    public String ShowFormUpdate(@RequestParam("studentId") Integer id, Model model) {
        Optional<Student> student = studentService.getStudentById(id);
        model.addAttribute("student",student);
        return "students/addNew";
    }
    @GetMapping("delete")
    public String DeleteStudent(@RequestParam("studentId") Integer id,Model model){
        studentService.deleteStudent(id);
        return "redirect:/students/list";
    }
}