package com.springlec.base0701.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.springlec.base0701.dao.BDao;
import com.springlec.base0701.dto.BDto;

public class BContentCommand implements BCommand {
	
	public void execute(Model model) {
		Map<String, Object> map=model.asMap();
		HttpServletRequest request=(HttpServletRequest) map.get("request");
		
		int bId=Integer.parseInt(request.getParameter("bId"));
		
		BDao dao=new BDao();
		BDto dto=dao.content(bId);
		model.addAttribute("content",dto);
	}
}
