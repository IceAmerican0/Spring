package com.springlec.one.command;

import java.util.ArrayList;

import org.springframework.ui.Model;

import com.springlec.one.dao.dao;
import com.springlec.one.dto.dto;


public class ListCommand implements Command{
	
	@Override
	public void execute(Model model) {
		// TODO Auto-generated method stub
		dao dao = new dao();
		ArrayList<dto> dtos = dao.list();
		
		model.addAttribute("list", dtos);

	}
}
