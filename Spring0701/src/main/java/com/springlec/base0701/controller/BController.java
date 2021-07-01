package com.springlec.base0701.controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springlec.base0701.command.BCommand;
import com.springlec.base0701.command.BContentCommand;
import com.springlec.base0701.command.BDeleteCommand;
import com.springlec.base0701.command.BEditCommand;
import com.springlec.base0701.command.BListCommand;
import com.springlec.base0701.command.BWriteCommand;
import com.springlec.base0701.util.Constant;

@Controller
public class BController {
	BCommand command=null;
	private JdbcTemplate template;
	
	@Autowired
	public void setTemplate(JdbcTemplate template) {
		this.template=template;
		Constant.template=this.template;
	}
	
	@RequestMapping("/list")
	public String list(Model model) {
		System.out.println("list()");
		command=new BListCommand();
		command.execute(model);
		
		return "list";
	}
	
	@RequestMapping("/write_view")
	public String write_view(Model model) {
		System.out.println("write_view()");
		return "write_view";
	}
	
	@RequestMapping("/write")
	public String write(HttpServletRequest request,Model model) {
		System.out.println("write()");
		
		model.addAttribute("request",request);
		command=new BWriteCommand();
		command.execute(model);
		
		return "redirect:list";
	}
	
	@RequestMapping("/edit")
	public String edit(HttpServletRequest request,Model model) {
		System.out.println("edit()");
		
		model.addAttribute("request",request);
		command=new BEditCommand();
		command.execute(model);
		
		return "redirect:list";
	}
	
	@RequestMapping("/content_view")
	public String content(HttpServletRequest request,Model model) {
		System.out.println("content()");
		
		model.addAttribute("request",request);
		command=new BContentCommand();
		command.execute(model);
		
		return "content_view";
	}
	
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request,Model model) {
		System.out.println("delete()");
		
		model.addAttribute("request",request);
		command=new BDeleteCommand();
		command.execute(model);
		
		return "redirect:list";
	}
	
}
