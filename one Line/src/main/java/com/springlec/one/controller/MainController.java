package com.springlec.one.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springlec.one.command.Command;
import com.springlec.one.command.DeleteCommand;
import com.springlec.one.command.ListCommand;
import com.springlec.one.command.WriteCommand;
import com.springlec.one.util.Constant;

@Controller
public class MainController {
	Command command=null;
	private Command listCommand=null;
	private Command writeCommand=null;
	private Command deleteCommand=null;
	
	@Autowired
	public void auto(Command list,Command write,Command delete) {
		this.listCommand=list;
		this.writeCommand=write;
		this.deleteCommand=delete;
	}
	
	private JdbcTemplate template;
	
	@Autowired
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
		Constant.template = this.template;
	}
	
	@RequestMapping("/list")
	public String list(Model model) {
		System.out.println("list()");
		listCommand.execute(model);
		
		return "list";
	}
	
	@RequestMapping("/write_view")
	public String write_view(Model model) {
		System.out.println("write_view()");
		return "write_view";
	}
	
	@RequestMapping("/write")
	public String write(HttpServletRequest httpServletRequest, Model model) {
		System.out.println("write()");
		
		model.addAttribute("request", httpServletRequest);
		writeCommand.execute(model);
		
		return "redirect:list";
	}
	
	@RequestMapping("/delete")
	public String content(HttpServletRequest httpServletRequest, Model model) {
		System.out.println("delete()");
		
		model.addAttribute("request", httpServletRequest);
		deleteCommand.execute(model);
		
		return "redirect:list";
	}
}
