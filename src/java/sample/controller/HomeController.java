/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import sample.category.CategoryDAO;
import sample.course.CourseDAO;
import sample.product.ProductDAO;
import sample.student.StudentDAO;
import sample.teacher.TeacherDAO;

/**
 *
 * @author scien
 */
@Controller
public class HomeController {
    
    @Autowired
    private StudentDAO studentDAO;
    @Autowired
    private TeacherDAO teacherDAO;
    @Autowired
    private CourseDAO courseDAO;
    @Autowired
    private CategoryDAO categoryDAO;
    @Autowired
    private ProductDAO productDAO;
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home() {
        return "index";
    }
    
    @RequestMapping(value = "/student", method = RequestMethod.GET)
    public String student(Model model) {
        model.addAttribute("STUDENTS", studentDAO.getAllStudent());
        return "student";
    }
    
    @RequestMapping(value = "/teacher", method = RequestMethod.GET)
    public String teacher(Model model) {
        model.addAttribute("TEACHERS", teacherDAO.getAllTeacher());
        return "teacher";
    }
    
    @RequestMapping(value = "/course", method = RequestMethod.GET)
    public String course(Model model) {
        model.addAttribute("COURSES", courseDAO.getAllCourse());
        return "course";
    }
    
    @RequestMapping(value = "/product", method = RequestMethod.GET)
    public String product(Model model) {
        model.addAttribute("PRODUCTS", productDAO.getAllProduct());
        model.addAttribute("CATEGORIES", categoryDAO.getAllCategory());
        return "product";
    }
    
    @RequestMapping(value = "/category", method = RequestMethod.GET)
    public String category(Model model) {
        model.addAttribute("CATEGORIES", categoryDAO.getAllCategory());
        return "category";
    }
}
