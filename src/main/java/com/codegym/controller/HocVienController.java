package com.codegym.controller;

import moduls.Classroom;
import moduls.HocVien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import service.IClassroomService;
import service.IHocVienService;

import javax.validation.Valid;
import java.util.ArrayList;

@Controller
public class HocVienController {
    @Autowired
    IHocVienService iHocVienService;
    @Autowired
    IClassroomService iClassroomService;

    @ExceptionHandler(Exception.class)
    public ModelAndView error(Exception e) {
        ModelAndView modelAndView = new ModelAndView("error");
        return modelAndView;
    }

    @ModelAttribute
    public ArrayList<Classroom> listClassroom(Exception e) {
        return iClassroomService.showAllClassroom();
    }

    @RequestMapping("home")
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject("list", iHocVienService.findAll());
        return modelAndView;
    }

    @GetMapping("create")
    public ModelAndView showCreate() {
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("listClass", new HocVien());
        return modelAndView;
    }

    @PostMapping("create")
    public ModelAndView create(@Valid @ModelAttribute("listClass") HocVien hocVien,BindingResult bindingResult){
        if(bindingResult.hasFieldErrors()){
            ModelAndView modelAndView = new ModelAndView("create");
            return modelAndView;
        }
        iHocVienService.save(hocVien);
        ModelAndView modelAndView = new ModelAndView("/redirect:/home");
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEdit(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("edit", "listClassroom", iClassroomService.showAllClassroom());
        modelAndView.addObject("list", iHocVienService.findById(id));
        return modelAndView;
    }

    @PostMapping("/edit/{index}")
    public ModelAndView edit(@ModelAttribute HocVien hocVien) {
        iHocVienService.edit(hocVien);
        return new ModelAndView("redirect:/home");
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable int id) {
        iHocVienService.delete(iHocVienService.findById(id));
        return new ModelAndView("redirect:/home");
    }

    @GetMapping("/findByName")
    public ModelAndView findByName(@RequestParam String findName) {
        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject("list", iHocVienService.findAllByName(findName));
        return modelAndView;
    }



}
