package controller;

import model.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import service.IServiceCustomer;
import service.ServiceCustomer;

@Controller
@RequestMapping("/customers")
public class CustomerController {
    IServiceCustomer serviceCustomer= new ServiceCustomer();
    @GetMapping("")
    public ModelAndView index(){
       ModelAndView modelAndView=new ModelAndView("list","customer",serviceCustomer.findAll());
       return modelAndView;
    }
    @GetMapping("/create")
    public ModelAndView formCreate(){
      ModelAndView modelAndView=new ModelAndView("create");
      modelAndView.addObject("customer",new Customer());
      return modelAndView;
    }
    @PostMapping("/create")
    public ModelAndView create (@ModelAttribute Customer customer){
        int id= serviceCustomer.findAll().size();
        customer.setId(id);
        serviceCustomer.save(customer);
        ModelAndView modelAndView=new ModelAndView("create","customer",new Customer());
        return modelAndView;
    }
    @GetMapping("/edit/{id}")
    public String formEdit(@PathVariable int id,Model model){
        model.addAttribute("customer",serviceCustomer.findById(id));
        return "/edit";
    }
    @PostMapping("/edit/{id}")
    public String edit(@PathVariable int id, @ModelAttribute Customer customer){
        serviceCustomer.update(id,customer);
        return "redirect:/customers";
    }
    @GetMapping("/delete/{id}")
    public String formDelete(@PathVariable int id,Model model){
        model.addAttribute("customer",serviceCustomer.findById(id));
        return "/delete";
    }
    @PostMapping("/delete/{id}")
    public String delete(@PathVariable int id){
        serviceCustomer.remote(id);
        return "redirect:/customers";
    }
}