package com.jsplec.Air4men.homecontroller;

import java.io.IOException;			

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsplec.Air4men.boardcommand.UserQnaDeleteCommand;
import com.jsplec.Air4men.boardcommand.UserQnaListCommand;
import com.jsplec.Air4men.boardcommand.UserQnaModifyCommand;
import com.jsplec.Air4men.boardcommand.UserQnaSelectedCommand;
import com.jsplec.Air4men.boardcommand.UserQnaWriteCommand;
import com.jsplec.Air4men.command.AdminClientDropCommand;
import com.jsplec.Air4men.command.AdminClientListCommand;
import com.jsplec.Air4men.command.AdminLoginCommand;
import com.jsplec.Air4men.command.AdminQnAListCommand;
import com.jsplec.Air4men.command.AdminQnAReplyCommand;
import com.jsplec.Air4men.command.AdminQnAViewCommand;
import com.jsplec.Air4men.command.BCommand;
import com.jsplec.Air4men.command.ClientRecoveryCommand;
import com.jsplec.Air4men.command.ClientViewCommand;
import com.jsplec.Air4men.command.DeleteClientListCommand;
import com.jsplec.Air4men.command.DeleteClientViewCommand;
import com.jsplec.Air4men.noticecommand.AdminNoticeDeleteCommand;
import com.jsplec.Air4men.noticecommand.AdminNoticeListCommand;
import com.jsplec.Air4men.noticecommand.AdminNoticeModifyCommand;
import com.jsplec.Air4men.noticecommand.AdminNoticeSelectedCommand;
import com.jsplec.Air4men.noticecommand.AdminNoticeWriteCommand;
import com.jsplec.Air4men.noticecommand.UserNoticeListCommand;
import com.jsplec.Air4men.noticecommand.UserNoticeSelectedCommand;
import com.jsplec.Air4men.reservationcommand.UserPayCancelCommand;
import com.jsplec.Air4men.reservationcommand.UserPaymentActionCommand;
import com.jsplec.Air4men.reservationcommand.UserPaymentCommand;
import com.jsplec.Air4men.reservationcommand.UserPaymentInfoCommand;
import com.jsplec.Air4men.reservationcommand.UserReservationListCommand;
import com.jsplec.Air4men.usercommand.Flights_List_Command;
import com.jsplec.Air4men.usercommand.Flights_Passengers_Command;
import com.jsplec.Air4men.usercommand.UserIdfindCommand;
import com.jsplec.Air4men.usercommand.UserLoginCommand;
import com.jsplec.Air4men.usercommand.UserMyPageCommand;
import com.jsplec.Air4men.usercommand.UserPwfindCommand;
import com.jsplec.Air4men.usercommand.UserRegisterCommand;


@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FrontController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request,response);
	}

	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.setCharacterEncoding("UTF-8");
		
		String uri=request.getRequestURI();
		String conPath=request.getContextPath();
		String com=uri.substring(conPath.length()); // 앞의 길이만큼 자름
		
		String viewPage=null;
		BCommand command=null;
//		System.out.println(uri);
//		System.out.println(conPath);
//		System.out.println(com);
		
		switch(com) {
			
		//======================= 화면 이동========================
		
			case("/main_view.do"): // 메인 화면
				viewPage="main.jsp";
				break;
			
			case("/userLogin_view.do"): // 로그인 화면
				viewPage="Login/userLogin.jsp";
				break;
				
			case("/userRegister_view.do"): //유저 회원가입 화면
				viewPage="Login/userRegister.jsp";
				break;
				
			case("/userIdfind_view.do"): //아이디찾기 화면
				viewPage="Login/userIdfind.jsp";
				break;
				
			case("/userIdfindResult_view.do"): //아이디찾기 결과화면
				viewPage="Login/userIdfindResult.jsp";
				break;
				
			case("/userPwfind_view.do"): //비밀번호찾기 화면
				viewPage="Login/userPwfind.jsp";
				break;
				
			case("/userPwfindResult_view.do"): //비밀번호찾기 결과화면
				viewPage="Login/userPwfindResult.jsp";
				break;
				
			case("/user_myPage_view.do")://마이페이지 화면
				command=new UserMyPageCommand();
				command.execute(request,response);
				viewPage="user_myPage.jsp";
				break;
				
			case("/userReservationList_view.do")://예약정보 화면
				command=new UserReservationListCommand();
				command.execute(request, response);
				viewPage="Reservation/userReservationList.jsp";
				break;
			
			case("/userPaymentInfo_view.do")://결제정보 화면
				command=new UserPaymentInfoCommand();
				command.execute(request, response);
				viewPage="Reservation/userPaymentInfo.jsp";
				break;
				
			case("/userPayment_view.do")://결제하기 화면
				command=new UserPaymentCommand();
				command.execute(request, response);
				viewPage="Reservation/userPayment.jsp";
				break;
				
			case("/userQnaList_view.do")://Q&A 리스트 화면
				command=new UserQnaListCommand();
				command.execute(request, response);
				viewPage="Qna/userQnaList.jsp";
				break;
				
			case("/userQnaWrite_view.do")://Q&A 작성화면
				viewPage="Qna/userQnaWrite.jsp";
				break;		
				
			case("/userQna_view.do")://선택한 Q&A 화면
				command=new UserQnaSelectedCommand();
				command.execute(request, response);
				viewPage="Qna/userQna.jsp";
				break;
				
			case("/Notice_List.do")://공지사항 리스트 화면
				command=new UserNoticeListCommand();
				command.execute(request, response);
				viewPage="Notice/NoticeList.jsp";
				break;
				
			case("/Notice_Selected.do")://선택한 공지사항 화면
				command=new UserNoticeSelectedCommand();
				command.execute(request, response);
				viewPage="Notice/NoticeSelected.jsp";
				break;
				
		//=======================기능=========================
				
			case("/userRegister.do"): //회원가입 후 로그인 화면으로
				command=new UserRegisterCommand();
				command.execute(request, response);
				viewPage="userLogin_view.do";
				break;
				
			case("/userIdfind.do"): //아이디찾기 후 결과화면으로
				command=new UserIdfindCommand();
				command.execute(request, response);
				viewPage="userIdfindResult_view.do";
				break;
				
			case("/userPwfind.do"): //비밀번호찾기 후 결과화면으로
				command=new UserPwfindCommand();
				command.execute(request, response);
				viewPage="userPwfindResult_view.do";
				break;
				
			case("/userLogin.do"): //로그인 후 메인화면으로
				command=new UserLoginCommand();
				command.execute(request, response);
				viewPage="main_view.do";
				break;
				
			case("/user_Logout.do")://로그아웃 액션
				viewPage="Login/user_Logout.jsp";
				break;
			
			case("/userQnaModify.do"): //Q&A 수정 후 리스트로
				command=new UserQnaModifyCommand();
				command.execute(request, response);
				viewPage="userQnaList_view.do";
				break;
			
			case("/userQnaDelete.do"): //Q&A 삭제 후 리스트로
				command=new UserQnaDeleteCommand();
				command.execute(request, response);
				viewPage="userQnaList_view.do";
				break;
				
			case("/userQnaWrite.do")://Q&A 작성 후 리스트로
				command=new UserQnaWriteCommand();
				command.execute(request, response);
				viewPage="userQnaList_view.do";
				break;
				
			case("/userPayment.do")://결제 후 결제 정보 화면으로
				command=new UserPaymentActionCommand();
				command.execute(request, response);
				viewPage="userPaymentInfo_view.do";
				break;

			case("/userPayCancel.do")://결제취소 후 예약 내역으로
				command=new UserPayCancelCommand();
				command.execute(request, response);
				viewPage="userPayment_view.do";
				break;
			case("/userPayCancel2.do")://결제취소 후 예약 내역으로
				command=new UserPayCancelCommand();
				command.execute(request, response);
				viewPage="userReservationList_view.do";
				break;
				
			case("/userFlightFind_view.do")://운항 정보 확인 페이지로
				viewPage="userFlightFind.jsp";
				break;
				
			case("/flights_List.do"): //김민재 - 플라이트 리스트 출력
				command=new Flights_List_Command();
				command.execute(request, response);
				viewPage="flights_List/flights_List.jsp";
				break;
				
			case("/flights_passengers.do"): //김민재 - 플라이트 리스트 출력
				command=new Flights_Passengers_Command();
				command.execute(request, response);
				viewPage="flights_List/flights_Passengers.jsp";
				break;	
				
				
				
		//======================관리자 화면==========================		
			case("/Admin_Login.do"): // 로그인 화면
				command=new AdminLoginCommand();
				command.execute(request, response);
				viewPage="Admin_Login.jsp";
				break;
			case("/Client_List.do"): // 회원 리스트
				command=new AdminClientListCommand();
				command.execute(request, response);
				viewPage="MemberList.jsp";
				break;
			case("/Client_View.do"): // 회원 정보 보기
				command=new ClientViewCommand();
				command.execute(request, response);
				viewPage="MemberInfo.jsp";
				break;
			case("/Delete_Member.do"): // 회원 탈퇴
				command=new AdminClientDropCommand();
				command.execute(request, response);
				viewPage="/Client_List.do";
				break;
			case("/DeleteClient_List.do"): //탈퇴한 회원 리스트
				command=new DeleteClientListCommand();
				command.execute(request, response);
				viewPage="DeleteMemberList.jsp";
				break;
			case("/DeleteClient_View.do"): // 탈퇴 회원 정보 보기
				command=new DeleteClientViewCommand();
				command.execute(request, response);
				viewPage="DeleteMemberInfo.jsp";
				break;
			case("/Recovery_Member.do"): // 탈퇴 회원 복구 하기
				command=new ClientRecoveryCommand();
				command.execute(request, response);
				viewPage="/DeleteClient_List.do";
				break;
			case("/QnA_List.do"): // 1:1 문의 리스트
				command=new AdminQnAListCommand();
				command.execute(request, response);
				viewPage="QnaList.jsp";
				break;
			case("/QnA_View.do"): // 1:1 문의 내역 보기
				command=new AdminQnAViewCommand();
				command.execute(request, response);
				viewPage="QnaInfo.jsp";
				break;
			case("/QnA_Reply.do"): // 1:1 답변하기
				command=new AdminQnAReplyCommand();
				command.execute(request, response);
				viewPage="/QnA_List.do";
				break;
			case("/Notice_Write_View.do"): // 공지 작성 페이지보기
				viewPage="NoticeWrite.jsp";
				break;
			case("/Notice_Write.do"): // 공지 작성하기
				command=new AdminNoticeWriteCommand();
				command.execute(request, response);
				viewPage="/AdminNotice_List.do";
				break;
			case("/Notice_Modify.do"): // 공지 수정하기
				command=new AdminNoticeModifyCommand();
				command.execute(request, response);
				viewPage="/AdminNotice_List.do";
				break;
			case("/Notice_Delete.do"): // 공지 삭제하기
				command=new AdminNoticeDeleteCommand();
				command.execute(request, response);
				viewPage="/AdminNotice_List.do";
				break;
			case("/AdminNotice_List.do"): // 공지 리스트보기
				command=new AdminNoticeListCommand();
				command.execute(request, response);
				viewPage="NoticeList.jsp";
				break;
			case("/AdminNotice_Selected.do")://선택한 공지보기
				command=new AdminNoticeSelectedCommand();
				command.execute(request, response);
				viewPage="NoticeSelected.jsp";
				break;
		}
		
		RequestDispatcher dispatcher=request.getRequestDispatcher(viewPage);
		dispatcher.forward(request,response);
	}
}
