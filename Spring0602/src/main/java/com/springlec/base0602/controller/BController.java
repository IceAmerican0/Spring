package com.springlec.base0602.controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springlec.base0602.command.BCommand;
import com.springlec.base0602.command.BContentCommand;
import com.springlec.base0602.command.BDeleteCommand;
import com.springlec.base0602.command.BEditCommand;
import com.springlec.base0602.command.BListCommand;
import com.springlec.base0602.command.BWriteCommand;

@Controller
public class BController {
	BCommand command=null;
	private BCommand listCommand=null;
	private BCommand writeCommand=null;
	private BCommand contentCommand=null;
	private BCommand editCommand=null;
	private BCommand deleteCommand=null;
	
	@Autowired
	public void auto(BCommand list,BCommand write,BCommand content,BCommand edit,BCommand delete) {
		this.listCommand=list;
		this.writeCommand=write;
		this.contentCommand=content;
		this.editCommand=edit;
		this.deleteCommand=delete;
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
	public String write(HttpServletRequest request,Model model) {
		System.out.println("write()");
		
		model.addAttribute("request",request);
		writeCommand.execute(model);
		
		return "redirect:list";
	}
	
	@RequestMapping("/edit")
	public String edit(HttpServletRequest request,Model model) {
		System.out.println("edit()");
		
		model.addAttribute("request",request);
		editCommand.execute(model);
		
		return "redirect:list";
	}
	
	@RequestMapping("/content_view")
	public String content(HttpServletRequest request,Model model) {
		System.out.println("content()");
		
		model.addAttribute("request",request);
		contentCommand.execute(model);
		
		return "content_view";
	}
	
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request,Model model) {
		System.out.println("delete()");
		
		model.addAttribute("request",request);
		deleteCommand.execute(model);
		
		return "redirect:list";
	}
	
}
