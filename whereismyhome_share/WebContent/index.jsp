<%@page import="Dto.DongCodeDto"%>
<%@page import="Dto.GugunCodeDto"%>
<%@page import="Dto.SidoCodeDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Dto.MainDto"%>
<%@page import="Dto.UserDto"%>

<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
	String contextPath = request.getContextPath();
	UserDto userDto = (UserDto) session.getAttribute("userDto");
	List<GugunCodeDto> gugunList = (List<GugunCodeDto>) request.getAttribute("gugunList");
	List<DongCodeDto> dongList = (List<DongCodeDto>) request.getAttribute("dongList");
	List<MainDto> mainList = (List<MainDto>) request.getAttribute("mainList");
%>
<c:set var="root" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="TemplateMo">
<link
	href="https://fonts.googleapis.com/css?family=Poppins:100,200,300,400,500,600,700,800,900"
	rel="stylesheet">

<title>Education Meeting HTML5 Template</title>

<!-- Bootstrap core CSS -->

<link href="./vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
	crossorigin="anonymous"></script>


<!-- Additional CSS Files -->
<link rel="stylesheet" href="./assets/css/fontawesome.css">
<link rel="stylesheet" href="./assets/css/templatemo-edu-meeting.css">
<link rel="stylesheet" href="./assets/css/owl.css">
<link rel="stylesheet" href="index.jsp">
<!--
 
TemplateMo 569 Edu Meeting
 
https://templatemo.com/tm-569-edu-meeting
 
-->
</head>

<body>
	<!-- Sub Header -->

	<div class="sub-header">
		<div class="container">
			<div class="row">
				<div class="col-lg-8 col-sm-8">
					<div class="left-content"></div>
				</div>
				<div class="col-lg-4 col-sm-4">
					<div class="right-icons">
						<ul>
							<c:if test="${empty userDto }">
								<li><a href="./register.jsp"
									style="font-size: 15px; font-family: 'IBM Plex Sans KR', sans-serif; display: block">회원가입</a></li>
								<li><a href="./login.jsp"
									style="font-size: 15px; font-family: 'IBM Plex Sans KR', sans-serif; display: block">로그인</a></li>
								<li><a href="./index.jsp"
									style="font-size: 15px; font-family: 'IBM Plex Sans KR', sans-serif; display: none">로그아웃</a></li>
							</c:if>
							<c:if test="${not empty userDto }">
								<li><a href="./register.jsp"
									style="font-size: 15px; font-family: 'IBM Plex Sans KR', sans-serif; display: none;">회원가입</a></li>
								<li><a href="./login.jsp"
									style="font-size: 15px; font-family: 'IBM Plex Sans KR', sans-serif; display: none">로그인</a></li>
								<li><a href="./index.jsp" id="logout"
									style="font-size: 15px; font-family: 'IBM Plex Sans KR', sans-serif; display: block">로그아웃</a></li>
							</c:if>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- ***** Header Area Start ***** -->
	<header class="header-area header-sticky">
		<div class="container">
			<div class="row">
				<div class="col-12">
					<nav class="main-nav">
						<!-- ***** Logo Start ***** -->

						<a href="index.jsp" class="logo"> <i class="logo"> <img
								src="./assets/images/homesicon.png" class="logohome"
								style="width: 60px; margin-right: 15px;"></i> 구해줘 HOME!
						</a>
						<!-- ***** Logo End ***** -->
						<!-- ***** Menu Start ***** -->
						<ul class="nav">
							<li><a href="board.jsp"
								style="font-size: 25px; font-family: 'IBM Plex Sans KR', sans-serif;">공지사항</a></li>
							<li><a href="news.jsp"
								style="font-size: 25px; font-family: 'IBM Plex Sans KR', sans-serif;">오늘의
									뉴스</a></li>
							<li class="scroll-to-section"><a href="#contact"
								style="font-size: 30px;" class="active">Contact Us</a></li>
						</ul>
						<a class='menu-trigger'> <span>Menu</span>
						</a>
						<!-- ***** Menu End ***** -->
					</nav>
				</div>
			</div>
		</div>
	</header>
	<!-- ***** Header Area End ***** -->

	<!-- ***** Main Banner Area Start ***** -->
	<section class="section main-banner" id="top" data-section="section1">
		<video autoplay muted loop id="bg-video">
			<source src="./assets/images/Apartments - 61193.mp4" type="video/mp4" />
		</video>

		<div class="video-overlay header-text">
			<div class="container">
				<div class="row">
					<div class="col-lg-12">
						<div class="caption" style="left: 35%;">
							<h6 style="text-align: center; font-size: 25px;">2차 관통 프로젝트</h6>
							<h2 style="text-align: center; font-size: 70px;">구해줘 HOME!</h2>
							<hr style="text-align: center; color: whitesmoke; height: 4px;">
							<p style="text-align: center; font-size: 20px;">월세는 더는 싫어.
								우리만의 집을 구해주세요</p>
							<div class="container-fluid">
								<div class="btn-group" style="margin-top: 30px;">
									<form method="get" action=root+"/main">

										<select name="sidoselect" id="sidoselect"
											class="form-select bg-secondary btn-lg text-light"
											style="margin: 10px;" action=root+
											"/main/gugunlist" onchange="changesido()">

											<!-- <ul class="dropdown-menu"> -->


											<option>도/광역시</option>
											<option value="11">서울특별시</option>
											<option value="26">부산광역시</option>
											<option value="27">대구광역시</option>
											<option value="28">인천광역시</option>
											<option value="29">광주광역시</option>
											<option value="30">대전광역시</option>
											<option value="31">울산광역시</option>
											<option value="36">세종특별자치시</option>
											<option value="41">경기도</option>
											<option value="42">강원도</option>
											<option value="43">충청북도</option>
											<option value="44">충청남도</option>
											<option value="45">전라북도</option>
											<option value="46">전라남도</option>
											<option value="47">경상북도</option>
											<option value="48">경상남도</option>
											<option value="50">제주특별자치도</option> ;
										</select>
									</form>



									<form method="get" action=root+"/main">

										<select name="gugunselect" id="gugunselect"
											class="form-select bg-secondary btn-lg text-light"
											style="margin: 10px;" action=root+
											"/main/donglist" onchange="changegugun()">
											<option id="gugunoption">구/군</option>

										</select>
									</form>



									<form method="post" action=root+"/main">
										<select name="dongselect" id="dongselect"
											class="form-select bg-secondary btn-lg text-light"
											style="margin: 10px;" action=root+
											"/main/mainlist" onchange="changedong()">
											<option id="gugunoption">읍/면/동</option>

										</select>
									</form>



								</div>
							</div>
							<button type="button" class="btn btn-outline-secondary"
								onclick="fnMove()" id="go">해당 위치로 이동</button>
						</div>
					</div>
				</div>
			</div>
		</div>

	</section>
	<!-- ***** Main Banner Area End ***** -->

	<section class="upcoming-meetings">
		<div class="container text-center">
			<div class="row">
				<div class="col">
					<h2
						style="color: white; margin-bottom: 70px; border-style: solid; border-width: 2px; border-color: white; padding: 20px;">부산
						-> 강서구 -> 녹산 기준으로 선택된 실거래 정보입니다.</h2>
				</div>
				<div class="row">
					<div class="col" style="align-items: center;">
						<div class="card"
							style="width: 60%; overflow-y: scroll; height: 555px; display: block; position: relative; left: 70px;">
							<!--카드 안에 넣을 내용-->
							<!-- mainlist -->

							<div class="card mb-3"
								style="max-width: 600px; margin-right: 10px; margin-top: 15px; margin-left: 15px; margin-bottom: 2px; padding-top: 15px; padding-bottom: 5px;">
								<div class="row g-0" style="padding-left: 10px;">


									<div class="col-md-4">
										<img src="" class="img-fluid rounded-start" alt="..."
											style="height: 130px; padding-top: 20px; padding-left: 5px;">
									</div>
									<div class="col-md-8" id="Aptdealinfo"></div>
									</form>

								</div>
							</div>
							</form>
						</div>
					</div>
				</div>
				<!--카드 안에 넣을 내용(end)-->
				<div class="col">
					<div id="map"
						style="width: 130%; height: 555px; display: block; position: relative; right: 200px;"></div>
				</div>
			</div>
			<div class="row">
				<div class="col">
					<details
						style="color: white; margin-top: 150px; font-size: 30px; border-style: solid; border-width: 2px; border-color: white; padding: 20px; width: 100%; margin-left: 20px;">
						<summary onclick="fnMove2()">구해줘 홈! 서비스 설명보기</summary>
						<div id="carouselExampleDark" class="carousel carousel-dark slide"
							data-bs-ride="carousel"
							style="margin-top: 50px; height: 800px; opacity: 0.8;">
							<div class="carousel-indicators">
								<button type="button" data-bs-target="#carouselExampleDark"
									data-bs-slide-to="0" class="active" aria-current="true"
									aria-label="Slide 1"></button>
								<button type="button" data-bs-target="#carouselExampleDark"
									data-bs-slide-to="1" aria-label="Slide 2"></button>
								<button type="button" data-bs-target="#carouselExampleDark"
									data-bs-slide-to="2" aria-label="Slide 3"></button>
							</div>
							<div class="carousel-inner">
								<div class="carousel-item active" data-bs-interval="10000">
									<img
										src="https://img.etoday.co.kr/pto_db/2022/03/600/20220302133228_1723814_1181_787.jpg"
										class="d-block w-100" alt="..."
										style="height: 800px; opacity: 0.8;">
									<div class="carousel-caption d-none d-md-block">
										<h2
											style="color: white; margin-bottom: 280px; font-size: 80px;">
											더 생생한 <br> 실시간 아파트 매매 정보
										</h2>
										<p style="color: white; font-size: 20px;">사이트를 통해 월별 아파트
											실거래 정보를 제공합니다</p>
									</div>
								</div>
								<div class="carousel-item" data-bs-interval="2000">
									<img
										src="https://cdn.imweb.me/thumbnail/20191030/b1e9397e45b1b.png"
										class="d-block w-100" alt="..."
										style="height: 800px; opacity: 0.8;">
									<div class="carousel-caption d-none d-md-block">
										<h2
											style="color: white; margin-bottom: 280px; font-size: 80px;">
											더 생생한 <br> 실시간 주택 매매 정보
										</h2>
										<p style="color: white; font-size: 20px;">사이트를 통해 월별 주택
											실거래 정보를 제공합니다</p>
									</div>
								</div>
								<div class="carousel-item" id="detail_deal">
									<img
										src="https://img.hankyung.com/photo/202109/01.27478312.1.jpg"
										class="d-block w-100" alt="..."
										style="height: 800px; opacity: 0.8;">
									<div class="carousel-caption d-none d-md-block">
										<h2
											style="color: white; margin-bottom: 280px; font-size: 80px;">
											더 생생한 <br> 다세대주택 매매 정보
										</h2>
										<p style="color: white; font-size: 20px;">사이트를 통해 월별 다세대주택
											실거래 정보를 제공합니다</p>
									</div>
								</div>
							</div>
							<button class="carousel-control-prev" type="button"
								data-bs-target="#carouselExampleDark" data-bs-slide="prev">
								<span class="carousel-control-prev-icon" aria-hidden="true"></span>
								<span class="visually-hidden">Previous</span>
							</button>
							<button class="carousel-control-next" type="button"
								data-bs-target="#carouselExampleDark" data-bs-slide="next">
								<span class="carousel-control-next-icon" aria-hidden="true"></span>
								<span class="visually-hidden">Next</span>
							</button>
						</div>
					</details>
				</div>
			</div>
		</div>
	</section>

	<script>
	async function changesido(){
		 let listHtml = `<option id="gugunoption">구/군</option>`;
		console.log(document.querySelector("#sidoselect").value);
		
		
		let url='<%=contextPath%>/main/gugunlist?sidoselect='+document.querySelector("#sidoselect").value;
			let fetchOptions={
	    			method:'GET'	
	    	};
			try{
		
				console.log("sido-gugun");
		
				let response=await fetch(url,fetchOptions);
				let data=await response.json();
	    		console.log(data);
	    		
	    		data.forEach(el=>{
	    			let guguncode=el.code;
	    			let gugunname=el.name;
	    			
	    			listHtml+=`<option value=\${guguncode}>\${gugunname}</option>`;
	    		})
	    		 document.querySelector("#gugunselect").innerHTML = listHtml;
			}catch(error){
	    		console.log(error);
	    		alert("구군 조회 과정에서 문제 발생");
	    	}
	
	}

	async function changegugun(){
		let listHtml = `<option id="dongoption">읍/면/동</option>`;
			
			console.log(document.querySelector("#gugunselect").value); 
			let url='<%=contextPath%>/main/donglist?gugunselect='+document.querySelector("#gugunselect").value;
			let fetchOptions={
			method:'GET' 
			}; 
			
			try{
			 let response=await fetch(url,fetchOptions); 
			 let data=await response.json();
	    		console.log(data);
	    		data.forEach(el=>{
	    			let dongcode=el.code;
	    			let dongname=el.name;
	    			
	    			listHtml+=`<option value=\${dongcode}>\${dongname}</option>`;
	    		})
	    		 document.querySelector("#dongselect").innerHTML = listHtml;
       
			}catch(error){
	    		console.log(error);
	    		alert("동 조회 과정에서 문제 발생");
	    	}
	}
		
	async function changedong(){
		let listHtml = ``;

		let url='<%=contextPath%>/main/mainlist?dongselect='+document.querySelector("#dongselect").value+'&gugunselect='+document.querySelector("#gugunselect").value;
			let fetchOptions={
	    			method:'GET'	
	    	};
			try{
				let response=await fetch(url,fetchOptions);
				let data=await response.json();
	    		console.log(data);
	    		data.forEach(el=>{
	    			let aptname=el.aptname;
	    			let dong=el.dong;
	    			let dealamount=el.dealamount;
	    			let buildyear=el.buildyear;
	    			
	    			listHtml+=`<h6 class="card-title">
					<strong>\${aptname}</strong>
					</h6>
					<p class="card-text">
						<b>\${dong}</b>
					</p>
					<p class="card-text">
						<small class="text-muted">거래금액:
							\${dealamount}</small>
					</p>
					<p class="card-text">
						<small class="text-muted">건설연도: \${buildyear}</small>
					</p>`;
	    		})
	    		document.querySelector("#Aptdealinfo").innerHTML = listHtml;
            
			}catch(error){
	    		console.log(error);
	    		alert("동 조회 과정에서 문제 발생");
	    	}
		
		
	}

	
	
	</script>






	<script>
	
	
      function fnMove2(){
        window.scrollTo({ top: 8000, behavior: 'smooth' })
      }
    </script>

	<script type="text/javascript"
		src="//dapi.kakao.com/v2/maps/sdk.js?appkey=16e0d8ceb2126cf30b8ea170f334ff7b"></script>
	<script>
      var mapContainer = document.getElementById('map'), // 지도를 표시할 div
      mapOption = {
          center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
          level: 3 // 지도의 확대 레벨
      };
 
  // 지도를 표시할 div와  지도 옵션으로  지도를 생성합니다
  var map = new kakao.maps.Map(mapContainer, mapOption);
    </script>

	<script>
      var ssafPos = new kakao.maps.LatLng(35.09555412597407, 128.8556383305408);
      var mapContainer = document.getElementById("map"); //지도를 담을 영역의 DOM 레퍼런스
      var mapOption = {
        //지도를 생성할 때 필요한 기본 옵션
        center: ssafPos, //지도의 중심좌표.
        level: 3, //지도의 레벨(확대, 축소 정도)
      };
 
      var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다
 
      // const points = [
      //   { name: "송정-삼정그린코아-더시티", lat: 35.08943544029129, 128.85321361378905 },
      //   { name: "명지오션시티 삼정그린코아", lat: 35.08566919171801, 128.9086441450526 },
      //   { name: "명지삼정그린코아 웨스트오피스텔", lat: 35.088285392116944, 128.90242142048587 },
      //   { name: "명지 삼정그린 코아더베스트", lat: 35.09720442454372, 128.91113323510842 },
      // ];

      // 버튼을 클릭하면 아래 배열의 좌표들이 모두 보이게 지도 범위를 재설정합니다 
    var points = [
      
        new kakao.maps.LatLng(35.08943544029129,128.85321361378905),
        new kakao.maps.LatLng(35.08566919171801, 128.9086441450526),
        new kakao.maps.LatLng(35.088285392116944, 128.90242142048587),
        new kakao.maps.LatLng(35.09720442454372, 128.91113323510842),
    ];

    // 지도를 재설정할 범위정보를 가지고 있을 LatLngBounds 객체를 생성합니다
    var bounds = new kakao.maps.LatLngBounds();    

    var i, marker;
    for (i = 0; i < points.length; i++) {
        // 배열의 좌표들이 잘 보이게 마커를 지도에 추가합니다
        marker =     new kakao.maps.Marker({ position : points[i] });
        marker.setMap(map);
        
        // LatLngBounds 객체에 좌표를 추가합니다
        bounds.extend(points[i]);
    }


    map.setBounds(bounds);


// 지도를 재설정할 범위정보를 가지고 있을 LatLngBounds 객체를 생성합니다
var bounds = new kakao.maps.LatLngBounds();    

var i, marker;
for (i = 0; i < points.length; i++) {
    // 배열의 좌표들이 잘 보이게 마커를 지도에 추가합니다
    marker =     new kakao.maps.Marker({ position : points[i] });
    marker.setMap(map);
    
    // LatLngBounds 객체에 좌표를 추가합니다
    bounds.extend(points[i]);
}

function setBounds() {
    // LatLngBounds 객체에 추가된 좌표들을 기준으로 지도의 범위를 재설정합니다
    // 이때 지도의 중심좌표와 레벨이 변경될 수 있습니다
    map.setBounds(bounds);
}
    </script>


	<section class="contact-us" id="contact">

		<div class="footer">
			<h1 style="color: white; font-size: 25px;">FIND US</h1>
			<p>
				<br> <a href="https://www.ssafy.com/"
					style="color: white; margin-right: 10px;">(SSAFY)삼성청년SW아카데미
					부울경캠퍼스</a> <a id="LinkForCall" href="javascript:ContactCall();"
					target="_parent" title="free css templates"> 문의하기</a> <br>
				1544-9001 <br> admin@ssafy.com
			</p>
		</div>
		<div class="modal fade" id="ContactModal" tabindex="-1"
			aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLabel">문의하기</h5>
						<button type="button" class="btn-close" data-bs-dismiss="modal"
							aria-label="Close"></button>
					</div>
					<div class="modal-body">
						<form>
							<div class="mb-3">
								<label for="recipient-name" class="col-form-label">문의
									사항:</label> <input type="text" class="form-control" id="recipient-name">
							</div>
							<div class="mb-3">
								<label for="message-text" class="col-form-label">문의 내용:</label>
								<textarea class="form-control" id="message-text"></textarea>
							</div>
						</form>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-bs-dismiss="modal">닫기</button>
						<button type="button" class="btn btn-primary">전송하기</button>
					</div>
				</div>
			</div>
		</div>
	</section>
	<script>
   function ContactCall(){
        let modal = new bootstrap.Modal(
    					document.querySelector("#ContactModal")
    			);
          modal.show();
      }
    
  </script>
	</section>

	<!-- Scripts -->
	<!-- Bootstrap core JavaScript -->
	<script src="vendor/jquery/jquery.min.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

	<script src="./assets/js/isotope.min.js"></script>
	<script src="./assets/js/owl-carousel.js"></script>
	<script src="./assets/js/lightbox.js"></script>
	<script src="./assets/js/tabs.js"></script>
	<script src="./assets/js/video.js"></script>
	<script src="./assets/js/slick-slider.js"></script>
	<script src="./assets/js/custom.js"></script>
	<script>
        //according to loftblog tut
        $('.nav li:first').addClass('active');
 
        var showSection = function showSection(section, isAnimate) {
          var
          direction = section.replace(/#/, ''),
          reqSection = $('.section').filter('[data-section="' + direction + '"]'),
          reqSectionPos = reqSection.offset().top - 0;
 
          if (isAnimate) {
            $('body, html').animate({
              scrollTop: reqSectionPos },
            800);
          } else {
            $('body, html').scrollTop(reqSectionPos);
          }
 
        };
 
        var checkSection = function checkSection() {
          $('.section').each(function () {
            var
            $this = $(this),
            topEdge = $this.offset().top - 80,
            bottomEdge = topEdge + $this.height(),
            wScroll = $(window).scrollTop();
            if (topEdge < wScroll && bottomEdge > wScroll) {
              var
              currentId = $this.data('section'),
              reqLink = $('a').filter('[href*=\\#' + currentId + ']');
              reqLink.closest('li').addClass('active').
              siblings().removeClass('active');
            }
          });
        };
 
        $('.main-menu, .responsive-menu, .scroll-to-section').on('click', 'a', function (e) {
          e.preventDefault();
          showSection($(this).attr('href'), true);
        });
 
        $(window).scroll(function () {
          checkSection();
        });
    </script>

	}

</body>

</body>
</html>
