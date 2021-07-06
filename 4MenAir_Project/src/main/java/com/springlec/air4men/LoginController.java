package com.springlec.air4men;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springlec.air4men.command.BCommand;
import com.springlec.air4men.usercommand.UserIdfindCommand;
import com.springlec.air4men.usercommand.UserLoginCommand;
import com.springlec.air4men.usercommand.UserPwfindCommand;
import com.springlec.air4men.usercommand.UserRegisterCommand;

@Controller
public class LoginController {
	
	@Autowired
	private SqlSession sqlSession;
	BCommand command=null;
	
	@RequestMapping("/userLogin_view")// 로그인 화면
	public String userLogin_view() {
		return "Login/userLogin.jsp";
	}
	
	@RequestMapping("/userRegister_view")// 유저 회원가입 화면
	public String userRegister_view() {
		return "Login/userRegister";
	}
	
	@RequestMapping("/userIdfind_view")// 아이디찾기 화면
	public String userIdfind_view() {
		return "Login/userIdfind";
	}
	
	@RequestMapping("/userIdfind")// 아이디찾기 후 결과화면으로
	public String userIdfind(HttpServletRequest request,Model model) {
		model.addAttribute("request",request);
		command=new UserIdfindCommand();
		command.execute(sqlSession,model);
		return "Login/userIdfindResult";
	}
	
	@RequestMapping("/userPwfind_view")// 비밀번호찾기 화면
	public String userPwfind_view() {
		return "Login/userPwfind";
	}
	
	@RequestMapping("/userPwfind")// 비밀번호찾기 후 결과화면으로
	public String userPwfind(HttpServletRequest request,Model model) {
		model.addAttribute("request",request);
		command=new UserPwfindCommand();
		command.execute(sqlSession,model);
		return "Login/userPwfindResult";
	}
	
	@RequestMapping("/userRegister")// 회원가입 후 로그인화면으로
	public String userRegister(HttpServletRequest request,Model model) {
		model.addAttribute("request",request);
		command=new UserRegisterCommand();
		command.execute(sqlSession,model);
		return "Login/userLogin";
	}
	
	@RequestMapping("/userLogin")// 로그인 후 메인화면으로
	public String userLogin(HttpServletRequest request,Model model) {
		model.addAttribute("request",request);
		command=new UserLoginCommand();
		command.execute(sqlSession,model);
		return "main";
	}
	
	@RequestMapping("/userLogout")// 로그아웃 후 로그인화면으로
	public String userLogout() {
		return "Login/user_Logout";
	}
	
}
