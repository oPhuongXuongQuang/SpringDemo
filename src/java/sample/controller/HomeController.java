/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import sample.student.Student;
import sample.student.StudentDAO;

/**
 *
 * @author scien
 */
@Controller
public class HomeController {
    
    @Autowired
    private StudentDAO studentDAO;
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Model model) {
        model.addAttribute("STUDENTS", studentDAO.getAllStudent());
        return "index";
    }
    
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("txtName");
        String address = request.getParameter("txtAddr");
        studentDAO.persist(new Student(name, address));
        return "redirect:/";
    }
    
    @RequestMapping(value = "/action", method = RequestMethod.POST)
    public String action(HttpServletRequest request, HttpServletResponse response) {
        String action = request.getParameter("btnAction");
        
        if (action.equals("Update")) {
            update(request, response);
        } else {
            delete(request, response);
        }
        return "redirect:/";
    }
    
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("txtId");
        String name = request.getParameter("txtName");
        String addr = request.getParameter("txtAddr");
        studentDAO.update(new Student(Integer.parseInt(id), name, addr));
        return "redirect:/";
    }
    
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String delete(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("txtId");
        studentDAO.delete(Integer.parseInt(id));
        return "redirect:/";
    }
}
