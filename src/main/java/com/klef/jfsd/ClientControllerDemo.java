package com.klef.jfsd;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ClientControllerDemo
{
	
	    @GetMapping("about")
	    public ModelAndView about()
	    {
	    	ModelAndView mv = new ModelAndView();
	    	mv.setViewName("about");
	    	return mv;
	    }
	    
	    @GetMapping("/greet")
	    public String greet(@RequestParam("username") String username, Model model) {
	        model.addAttribute("message", "Hello, " + username + "!");
	        return "greet";
	    }
	    
	    @GetMapping("/demo1")
	    public String displayParams(@RequestParam("age") int age, @RequestParam("country") String country, Model model) {
	        model.addAttribute("age", age);
	        model.addAttribute("country", country);
	        return "displayParams";
	    }

	    @GetMapping("/demo2/{a}/{b}")
	    public String demo2(@PathVariable("a") int a, @PathVariable("b") int b, Model model) {
	        model.addAttribute("subtraction", a - b);
	        model.addAttribute("division", b != 0 ? a / b : "Division by zero is not allowed");
	        return "arithmetic";
	    }

	    @GetMapping("/productform")
	    public String productForm() {
	        return "productForm";
	    }
	    
	    @GetMapping("multiplyNumbers/{num1}/{num2}")
	    @ResponseBody
	    public String mul(@PathVariable("num1") int x,@PathVariable("num2") int y)
	    {
	    	return  Integer.toString(x*y);
	    }
	    
	    @GetMapping("/reverse")
	    public String reverseStrings(@RequestParam("str1") String str1, @RequestParam("str2") String str2, Model model) {
	        model.addAttribute("reversedStr1", new StringBuilder(str1).reverse().toString());
	        model.addAttribute("reversedStr2", new StringBuilder(str2).reverse().toString());
	        return "reverse";
	    }
	    
	    
	    @GetMapping("calculate1")
	    public ModelAndView calculate1(@RequestParam("a") int x,@RequestParam("b") int y)
	    {
	    	int output=x-y;
	    	ModelAndView mv=new ModelAndView();
	    	mv.setViewName("output");
	    	mv.addObject("result", output);
	    	return mv;
	    }
	    @GetMapping("calculate2")
	    public ModelAndView calculate2(@RequestParam("a") int x,@RequestParam("b") int y)
	    {
	    	int output=x-y;
	    	ModelAndView mv=new ModelAndView();
	    	mv.setViewName("output");
	    	mv.addObject("result", output);
	    	return mv;
	    }

	 

	    }

	   
