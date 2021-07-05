package com.springlec.air4men;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springlec.air4men.command.BCommand;


@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private SqlSession sqlSession;
	
	BCommand command=null;
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "Login/userLogin";
	}
	
	
	@RequestMapping("/main_view")// 메인 화면
	public String main_view(HttpServletRequest request, Model model) {
		model.addAttribute("userId",request.getParameter("userId"));
		return "main";
	}
	
	
}
