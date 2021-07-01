package com.springlec.base0602.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import com.springlec.base0602.dao.BDao;
import com.springlec.base0602.dto.BDto;

public class BContentCommand implements BCommand {
	private BDao dao=null;
	
	@Autowired
	public void setDao(BDao dao) {
		this.dao=dao;
	}
	
	public void execute(Model model) {
		Map<String, Object> map=model.asMap();
		HttpServletRequest request=(HttpServletRequest) map.get("request");
		
		int bId=Integer.parseInt(request.getParameter("bId"));
		
		BDto dto=dao.content(bId);
		model.addAttribute("content",dto);
	}
}
