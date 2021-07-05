package com.springlec.air4men;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springlec.air4men.boardcommand.UserQnaDeleteCommand;
import com.springlec.air4men.boardcommand.UserQnaListCommand;
import com.springlec.air4men.boardcommand.UserQnaModifyCommand;
import com.springlec.air4men.boardcommand.UserQnaSelectedCommand;
import com.springlec.air4men.boardcommand.UserQnaWriteCommand;
import com.springlec.air4men.command.BCommand;
import com.springlec.air4men.noticecommand.UserNoticeListCommand;
import com.springlec.air4men.noticecommand.UserNoticeSelectedCommand;
import com.springlec.air4men.reservationcommand.UserPayCancelCommand;
import com.springlec.air4men.reservationcommand.UserPaymentActionCommand;
import com.springlec.air4men.reservationcommand.UserPaymentCommand;
import com.springlec.air4men.reservationcommand.UserPaymentInfoCommand;
import com.springlec.air4men.usercommand.Flights_List_Command;
import com.springlec.air4men.usercommand.Flights_Passengers_Command;
import com.springlec.air4men.usercommand.UserLoginCommand;
import com.springlec.air4men.usercommand.UserMyPageCommand;
import com.springlec.air4men.usercommand.UserPwfindCommand;

@Controller
public class UserController {
	
	@Autowired
	private SqlSession sqlSession;
	BCommand command=null;
	
	
	@RequestMapping("/user_myPage_view")// 마이페이지 화면
	public String user_myPage_view(HttpServletRequest request,Model model) {
		command=new UserMyPageCommand();
		return "user_myPage";
	}
	
	@RequestMapping("/userReservationList_view")// 예약정보 화면
	public String userReservationList_view(HttpServletRequest request,Model model) {
		
		return "user_myPage";
	}
	
	@RequestMapping("/userPaymentInfo_view")// 결제정보 화면
	public String userPaymentInfo_view(HttpServletRequest request,Model model) {
		command=new UserPaymentInfoCommand();
		command.execute(sqlSession,model);
		return "Reservation/userPaymentInfo";
	}
	
	@RequestMapping("/userPayment_view")// 결제하기 화면
	public String userPayment_view(HttpServletRequest request,Model model) {
		command=new UserPaymentCommand();
		command.execute(sqlSession,model);
		return "Reservation/userPayment";
	}
	
	@RequestMapping("/userQnaList_view")// Q&A 리스트 화면
	public String userQnaList_view(HttpServletRequest request,Model model) {
		command=new UserQnaListCommand();
		command.execute(sqlSession,model);
		return "Qna/userQnaList";
	}
	
	@RequestMapping("/userQnaWrite_view")// Q&A 작성화면
	public String userQnaWrite_view() {
		return "Qna/userQnaWrite";
	}
	
	@RequestMapping("/userQna_view")// 선택한 Q&A 화면
	public String userQna_view(HttpServletRequest request,Model model) {
		command=new UserQnaSelectedCommand();
		command.execute(sqlSession,model);
		return "Qna/userQna";
	}
	
	@RequestMapping("/Notice_List")// 공지사항 리스트 화면
	public String Notice_List(HttpServletRequest request,Model model) {
		command=new UserNoticeListCommand();
		command.execute(sqlSession,model);
		return "Notice/NoticeList";
	}
	
	@RequestMapping("/Notice_Selected")// 선택한 공지사항 화면
	public String Notice_Selected(HttpServletRequest request,Model model) {
		command=new UserNoticeSelectedCommand();
		command.execute(sqlSession,model);
		return "Notice/NoticeSelected";
	}
	
	@RequestMapping("/userQnaModify")// Q&A 수정 후 리스트로
	public String userQnaModify(HttpServletRequest request,Model model) {
		command=new UserQnaModifyCommand();
		command.execute(sqlSession,model);
		return "redirect:Qna/userQnaList";
	}
	
	@RequestMapping("/userQnaDelete")// Q&A 삭제 후 리스트로
	public String userQnaDelete(HttpServletRequest request,Model model) {
		command=new UserQnaDeleteCommand();
		command.execute(sqlSession,model);
		return "redirect:Qna/userQnaList";
	}
	
	@RequestMapping("/userQnaWrite")// Q&A 작성 후 리스트로
	public String userQnaWrite(HttpServletRequest request,Model model) {
		command=new UserQnaWriteCommand();
		command.execute(sqlSession,model);
		return "redirect:Qna/userQnaList";
	}
	
	@RequestMapping("/userPayment")// 결제 후 결제 정보 화면으로
	public String userPayment(HttpServletRequest request,Model model) {
		command=new UserPaymentActionCommand();
		command.execute(sqlSession,model);
		return "redirect:Reservation/userPaymentInfo";
	}
	
	@RequestMapping("/userPayCancel")// 결제취소 후 결제하기 화면으로
	public String userPayCancel(HttpServletRequest request,Model model) {
		command=new UserPayCancelCommand();
		command.execute(sqlSession,model);
		return "redirect:Reservation/userPayment";
	}
	
	@RequestMapping("/userPayCancel2")// 결제취소 후 예약 내역으로
	public String userPayCancel2(HttpServletRequest request,Model model) {
		command=new UserPayCancelCommand();
		command.execute(sqlSession,model);
		return "redirect:Reservation/userReservationList";
	}
	
	@RequestMapping("/userFlightFind_view")// 운항정보 확인페이지로
	public String userFlightFind_view(){
		return "userFlightFind";
	}
	
	@RequestMapping("/flights_List")// 운항정보 리스트 출력
	public String flights_List(HttpServletRequest request,Model model) {
		command=new Flights_List_Command();
		command.execute(sqlSession,model);
		return "flights_List/flights_List";
	}
	
	@RequestMapping("/flights_passengers")// 운항정보 리스트 출력
	public String flights_passengers(HttpServletRequest request,Model model) {
		command=new Flights_Passengers_Command();
		command.execute(sqlSession,model);
		return "flights_List/flights_Passengers";
	}
	
	
}
