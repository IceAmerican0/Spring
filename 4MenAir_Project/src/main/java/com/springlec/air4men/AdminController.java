package com.springlec.air4men;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springlec.air4men.admincommand.AdminClientDropCommand;
import com.springlec.air4men.admincommand.AdminClientListCommand;
import com.springlec.air4men.admincommand.AdminLoginCommand;
import com.springlec.air4men.admincommand.AdminQnAListCommand;
import com.springlec.air4men.admincommand.AdminQnAReplyCommand;
import com.springlec.air4men.admincommand.AdminQnAViewCommand;
import com.springlec.air4men.admincommand.ClientRecoveryCommand;
import com.springlec.air4men.admincommand.ClientViewCommand;
import com.springlec.air4men.admincommand.DeleteClientViewCommand;
import com.springlec.air4men.command.BCommand;
import com.springlec.air4men.noticecommand.AdminNoticeDeleteCommand;
import com.springlec.air4men.noticecommand.AdminNoticeListCommand;
import com.springlec.air4men.noticecommand.AdminNoticeModifyCommand;
import com.springlec.air4men.noticecommand.AdminNoticeSelectedCommand;
import com.springlec.air4men.noticecommand.AdminNoticeWriteCommand;
import com.springlec.air4men.usercommand.UserLoginCommand;

@Controller
public class AdminController {
	
	@Autowired
	private SqlSession sqlSession;
	BCommand command=null;
	
	@RequestMapping("/Admin_Login")// 로그인 화면
	public String Admin_Login(HttpServletRequest request,Model model) {
		model.addAttribute("request",request);
//		command=new AdminLoginCommand();
//		command.execute(sqlSession,model);
		return "Admin_Login";
	}
	
	@RequestMapping("/Client_List")// 회원 리스트
	public String Client_List(HttpServletRequest request,Model model) {
		model.addAttribute("request",request);
		command=new AdminClientListCommand();
		command.execute(sqlSession,model);
		return "MemberList";
	}
	
	@RequestMapping("/Client_View")// 회원 정보 보기
	public String Client_View(HttpServletRequest request,Model model) {
		model.addAttribute("request",request);
		command=new ClientViewCommand();
		command.execute(sqlSession,model);
		return "MemberInfo";
	}
	
	@RequestMapping("/Delete_Member")// 회원 탈퇴
	public String Delete_Member(HttpServletRequest request,Model model) {
		model.addAttribute("request",request);
		command=new AdminClientDropCommand();
		command.execute(sqlSession,model);
		return "redirect:MemberList";
	}
	
	@RequestMapping("/DeleteClient_List")// 탈퇴한 회원 리스트
	public String DeleteClient_List(HttpServletRequest request,Model model) {
		model.addAttribute("request",request);
		command=new UserLoginCommand();
		command.execute(sqlSession,model);
		return "DeleteMemberList";
	}
	
	@RequestMapping("/DeleteClient_View")// 탈퇴 회원 정보 보기
	public String DeleteClient_View(HttpServletRequest request,Model model) {
		model.addAttribute("request",request);
		command=new DeleteClientViewCommand();
		command.execute(sqlSession,model);
		return "DeleteMemberInfo";
	}
	
	@RequestMapping("/Recovery_Member")// 탈퇴 회원 복구하기
	public String Recovery_Member(HttpServletRequest request,Model model) {
		model.addAttribute("request",request);
		command=new ClientRecoveryCommand();
		command.execute(sqlSession,model);
		return "redirect:DeleteMemberList";
	}
	
	@RequestMapping("/QnA_List")// 1:1 문의 리스트
	public String QnA_List(HttpServletRequest request,Model model) {
		model.addAttribute("request",request);
		command=new AdminQnAListCommand();
		command.execute(sqlSession,model);
		return "QnaList";
	}
	
	@RequestMapping("/QnA_View")// 1:1 문의 내역 보기
	public String QnA_View(HttpServletRequest request,Model model) {
		model.addAttribute("request",request);
		command=new AdminQnAViewCommand();
		command.execute(sqlSession,model);
		return "QnaInfo";
	}
	
	@RequestMapping("/QnA_Reply")// 1:1 답변하기
	public String QnA_Reply(HttpServletRequest request,Model model) {
		model.addAttribute("request",request);
		command=new AdminQnAReplyCommand();
		command.execute(sqlSession,model);
		return "redirect:QnaList";
	}
	
	@RequestMapping("/Notice_Write_View")// 공지 작성 페이지보기
	public String Notice_Write_View() {
		return "NoticeWrite";
	}
	
	@RequestMapping("/Notice_Write")// 공지 작성하기
	public String Notice_Write(HttpServletRequest request,Model model) {
		model.addAttribute("request",request);
		command=new AdminNoticeWriteCommand();
		command.execute(sqlSession,model);
		return "redirect:NoticeList";
	}
	
	@RequestMapping("/Notice_Modify")// 공지 수정하기
	public String Notice_Modify(HttpServletRequest request,Model model) {
		model.addAttribute("request",request);
		command=new AdminNoticeModifyCommand();
		command.execute(sqlSession,model);
		return "redirect:NoticeList";
	}
	
	@RequestMapping("/Notice_Delete")// 공지 삭제하기
	public String Notice_Delete(HttpServletRequest request,Model model) {
		model.addAttribute("request",request);
		command=new AdminNoticeDeleteCommand();
		command.execute(sqlSession,model);
		return "redirect:NoticeList";
	}
	
	@RequestMapping("/AdminNotice_List")// 공지 리스트보기
	public String AdminNotice_List(HttpServletRequest request,Model model) {
		model.addAttribute("request",request);
		command=new AdminNoticeListCommand();
		command.execute(sqlSession,model);
		return "NoticeList";
	}
	
	@RequestMapping("/AdminNotice_Selected")// 선택한 공지보기
	public String AdminNotice_Selected(HttpServletRequest request,Model model) {
		model.addAttribute("request",request);
		command=new AdminNoticeSelectedCommand();
		command.execute(sqlSession,model);
		return "NoticeSelected";
	}
	
}
