<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/flights_Passengers.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<html>
<head>
<meta charset="UTF-8">
<title>고객 정보</title>
</head>
<body>
    <%@ include file="flights_top.jsp"%>
    <div class="container mt-3">
        <div class="row btn-group procedure">
            <input type="button" class="btn col-lg-3 button1" value="검색" onclick="location.href='userLogin?userId=${param.userId }'">
            <input type="button" class="btn col-lg-3 button2" id="select" value="항공편 검색" onclick="location.href='flights_List?userId=${param.userId }&fromDate=${flights_passengers.select_departures_Date }&from=${flights_passengers.select_departures }'">
            <input type="button" class="btn col-lg-3 button3" value="탑승객">
            <input type="button" class="btn col-lg-3 button4" value="결재">
        </div>
    </div>
    <div class="container margin_auto_1000 ">
        <div class="row">
            <div class=" col-xl-6 userInfo">
                <div class="middleTitle">고객 정보</div>
                <div class="form-group">
                    <label for="userId">이름 </label>
                    <input type="text" name="userName" class="form-control" value="${user_Info.userName }" readonly="readonly">
                </div>
                <div class="form-group">
                    <label for="userId">전화번호 </label>
                    <input type="text" name="userTel" class="form-control" value=" ${user_Info.userTel }" readonly="readonly">
                </div>
                <div class="form-group">
                    <label for="userId">이메일 </label>
                    <input type="text" name="userEmail" class="form-control" value="${user_Info.userEmail }" readonly="readonly">
                </div>
                <div class="form-group">
                    <label for="userId">집주소 </label>
                    <input type="text" name="userAdd" class="form-control" value="${user_Info.userAdd }" readonly="readonly">
                </div>
                <div class="form-group">
                    <label for="userId">생년월일 </label>
                    <input type="text" name="userBirthday" class="form-control" value="${user_Info.userBirthday }" readonly="readonly">
                </div>
                <div>&nbsp;</div>
                <div>&nbsp;</div>
                <div>&nbsp;</div>
                <div>
                    <div data-v-adcb67a4="" class="panel">
                        <div data-v-1b0b84c5="" data-v-adcb67a4="" class="agreements passenger-agreements">
                            <div data-v-1b0b84c5="" class="agreements__header no-typography-margin">
                                <p>항공편 예약 약관</p>
                            </div>
                            <div data-v-1b0b84c5="" class="agreements__subheader no-typography-margin">
                                <p>
                                    <strong> 회원 약관 </strong> 전체 항공편은 회원으로 예약됩니다.
                                </p>
                                <p>
                                    <strong>·</strong> 아래의 약관을 반드시 읽어 주세요.
                                </p>
                                <p>
                                    <strong>·</strong> 입력하신 이메일 및 예약번호를 알고 계셔야 예약변경 및 조회, 환불이 가능합니다.
                                </p>
                                <p>
                                    <strong> * 약관 보기 페이지 맨 밑에 결제하기 버튼이 있습니다 * </strong>
                                </p>
                            </div>
                            <div class="container">
                                <button type="button" class="btn btn-primary" data-toggle="collapse" data-target="#demo">약관 보기</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-xl-6 flightsInfo">
                <div class="middleTitle">운항 정보</div>
                <div class="form-group">
                    <label for="userId">항공편 코드 </label>
                    <input type="text" name="select_flights_Code" class="form-control" value="${flights_passengers.flights_Code }" readonly="readonly">
                </div>
                <div class="form-group">
                    <label for="userId">출발지 </label>
                    <input type="text" name="select_departures" class="form-control" value="${flights_passengers.departures } " readonly="readonly">
                </div>
                <div class="form-group">
                    <label for="userId">출발일 </label>
                    <input type="text" name="select_departures_Date" class="form-control" value="${flights_passengers.departures_Date }" readonly="readonly">
                </div>
                <div class="form-group">
                    <label for="userId">출발시간 </label>
                    <input type="text" name="select_departures_Time" class="form-control" value="${flights_passengers.departures_Time }" readonly="readonly">
                </div>
                <div class="form-group">
                    <label for="userId">도착지 </label>
                    <input type="text" name="select_arrivals" class="form-control" value="${flights_passengers.arrivals }" readonly="readonly">
                </div>
                <div class="form-group">
                    <label for="userId">도착일 </label>
                    <input type="text" name="select_arrivals_Date" class="form-control" value="${flights_passengers.arrivals_Date } " readonly="readonly">
                </div>
                <div class="form-group">
                    <label for="userId">도착시간 </label>
                    <input type="text" name="select_arrivals_Time" class="form-control" value="${flights_passengers.arrivals_Time } " readonly="readonly">
                </div>
                <div class="form-group">
                    <label for="userId">탑승가능인원 </label>
                    <input type="text" name="select_passengers" class="form-control" value="${flights_passengers.passengers }" readonly="readonly">
                </div>
                <div class="form-group">
                    <label for="userId">운임비 </label>
                    <input type="text" name="select_payments" class="form-control" value="${flights_passengers.payments }" readonly="readonly">
                </div>
            </div>
            <div id="demo" class="collapse">
                <div>
                    <div>
                        <div>
                            <div>
                                <p>
                                    (필수) <strong>개인정보 수집에 대한 동의 및 이용 목적</strong>
                                </p>
                            </div>
                        </div>
                    </div>
                    <div>
                        <p>에어로케이항공은 정보통신망 이용촉진 및 정보보호 등에 관한 법률에 따라 다음과 같은 최소한의 개인정보를 수집하고 있습니다. 이를 위해 아래와 같은 사항을 고지하고 동의를 받습니다. 또한 서비스 이용과정이나 정보처리과정에서 자동으로 정보가 생성되어 수집될 수 있습니다. 개인정보 수집 및 이용에 대한 동의를 거부할 권리가 있으며, 필수 항목의 수집 및 이용에 거부 시 서비스 이용이 제한됩니다.</p>
                        <p>가. 개인정보의 수집∙이용 목적 및 항목</p>
                        <p>에어로케이항공은 항공권 예매 서비스 제공을 위해 필요한 최소한의 범위 내에서 다음과 같은 개인정보를 수집하고 있습니다.</p>
                        <p>1) 국내선 예약 시</p>
                        <p>
                            <strong>· </strong>필수: 탑승자 성명 (국문 또는 영문), 성별, 연락처, 이메일 주소, 여정정보 (편명, 출발시간) <strong>· </strong>선택: 생년월일, 할인 선택 시 해당 인적사항
                        </p>
                        <p>2) 국제선 예약 시</p>
                        <p>
                            <strong>· </strong>필수: 탑승자 성명 (국문 및 영문), 성별, 연락처, 이메일 주소, 생년월일, 여정정보 (편명, 출발시간) <strong>· </strong>선택: 국적, 여권번호, 여권발행일, 여권만료일, 여권 발급처, 할인 선택 시 해당 인적사항
                        </p>
                        <p>3) 항공권 결제 시</p>
                        <p>
                            <strong>· </strong>필수: 카드번호, 유효기간, 승인번호 (인증정보)
                        </p>
                        <p>4) 국제선 항공편 체크인 및 탑승 시</p>
                        <p>
                            <strong>· </strong>필수: 국적, 여권번호, 여권발행일, 여권만료일, 여권 발급처
                        </p>
                        <p>5) 모바일 탑승권 로그인 시</p>
                        <p>
                            <strong>· </strong>필수: 이메일 또는 전화번호
                        </p>
                        <p>6) 모바일 탑승권 발행 시</p>
                        <p>
                            <strong>· </strong>선택: 탑승자 성명, 생년월일, 국적, 여권번호, 여권발행일, 여권만료일, 여권 발급처
                        </p>
                        <p>7) 고객서비스센터 이용 시</p>
                        <p>
                            <strong>· </strong>필수: 탑승자 성명 (국문 또는 영문), 연락처, 이메일, 성별, 생년월일, 여정정보 (편명, 출발시간), 상담녹취, 결제정보 (예약 시 또는 예약 변경 시 필요한 경우)
                        </p>
                        <p>
                            <strong>· </strong>선택: 국적, 여권번호, 여권발행일, 여권만료일, 여권발급처
                        </p>
                        <p>8) 자동으로 생성되는 개인정보</p>
                        <p>
                            <strong>· </strong>서비스 이용 기록, 접속 로그, 쿠키, 접속 IP 정보, 결제 기록, 디바이스 토큰, 위치기반서비스 제공을 위한 사용시각 및 장소 등
                        </p>
                        <p>나. 개인정보 보유 및 이용기간</p>
                        <p>이용자의 동의 하에 수집된 개인정보는 이용자가 회사의 서비스를 이용하는 동안 보유 및 이용됩니다. 회사에서 이용자 정보를 보관하는 기간은 해당 정보를 수집하고 사용하는 목적에 따라 달라질 수 있습니다. 회사에서는 법률상 지정된 기간 또는 비즈니스 목적으로 필요한 기간 이상으로 개인 정보를 보관하지 않으며 이는 아래와 같이 개인정보의 수집 및 이용 목적이 달성된 때 모두 파기하는 것을 원칙으로 합니다. 다만 법적 의무 또는 법적 권한을 집행하거나 보호하기 위해 필요한 경우에는 사용자의 계약이 끝나거나 정보 삭제를 요청한 후에도 일부 정보를 보관할 수 있습니다. 또한 사전에 보유기간을 이용자에게 고지하거나 명시한 경우 등은 그에 따라 개인정보를 보관할 수 있습니다.</p>
                        <p>1) 계약 또는 청약철회 등에 관한 기록은 전자상거래 등에서의 소비자 보호에 관한 법률에 의거하여 5년간 보존됩니다.</p>
                        <p>2) 대금결제 및 재화등의 공급에 관한 기록은 전자상거래 등에서의 소비자 보호에 관한 법률에 의거하여 5년간 보존됩니다.</p>
                        <p>3) 소비자 불만 및 분쟁처리에 관한 기록은 전자상거래 등에서의 소비자 보호에 관련한 법률에 의거하여 3년간 보존됩니다.</p>
                        <p>4) 전자 금융 거래에 관한 기록은 전자금융거래법에 의거하여 5년간 보존됩니다.</p>
                        <p>5) 웹사이트 방문에 관한 기록은 통신비밀보호법에 의거하여 3개월간 보존됩니다.</p>
                        <p>6) 위치 정보에 관한 기록은 위치정보의 보호 및 이용 등에 관한 법률에 의거하여 6개월간 보존됩니다.</p>
                        <p>7) 회사가 사업을 중단할 경우 수집된 개인 정보는 즉시 파기됩니다.</p>
                        <p>8) 기타 관련 법률에 따라 정해진 경우, 관련 법률에 명시된 보존 기간을 준수합니다.</p>
                    </div>
                </div>
                <div>
                    <div>
                        <label>
                            <div>
                                <p>(필수) 개인정보 국외 이전에 대한 사항 동의</p>
                            </div>
                            <div>
                                <p>필수 이용약관에 동의해 주세요.</p>
                            </div>
                    </div>
                    </span></label>
                </div>
                <div>
                    <p>에어로케이항공에서는 항공여행정보시스템 제공 업체인 Radixx Solutions International, Inc.에 당사의 예약 및 운송 시스템 운영을 위탁하고 있으며, 예약에 필요한 개인정보 국외 이전 사항은 다음과 같습니다.</p>
                    <p>1) 개인정보를 이전받는 자: Radixx Solutions International, Inc</p>
                    <p>2) 이전하는 개인정보 항목: 탑승자 성명, 생년월일, 성별, 연락처, 이메일, 카드 정보(번호, 유효기간), 거래 인증번호, 은행 계좌 정보, 거래 인증번호, 거래번호, 여권정보(번호, 만료일, 발급처, 국적), 이벤트 정보 수신 여부</p>
                    <p>3) 이전되는 국가, 이전 일시 및 이전 방법: 미국 / 예약 및 결제 완료 시 / 공용 네트워크 이용 전송(보안 프로토콜 처리)</p>
                    <p>4) 이전 받는 자의 개인정보 이용 목적 및 보유, 이용기간: 예약 시스템 상의 예약 기록 유지, 개인정보 이전 후 5년간</p>
                </div>
                <form action="userPayment_view" method="post">
                    <input type="hidden" name="userId" value="${param.userId}">
                    <input type="hidden" name="flight" value="${flights_passengers.flights_Code }">
                    <input type="submit" value="결제하기">
                </form>
            </div>
        </div>
    </div>
    </div>
    </div>
    <br>
</body>
</html>