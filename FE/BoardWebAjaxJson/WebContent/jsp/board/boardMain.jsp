<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="board.dto.*"%>
<%
	String contextPath = request.getContextPath();
	UserDto userDto = (UserDto) session.getAttribute("userDto");
%>
<!DOCTYPE html>

<html lang="en">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Document</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous" />
<script
	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"
	integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"
	integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF"
	crossorigin="anonymous"></script>

<!-- JavaScript -->
<script
	src="//cdn.jsdelivr.net/npm/alertifyjs@1.13.1/build/alertify.min.js"></script>

<!-- CSS -->
<link rel="stylesheet"
	href="//cdn.jsdelivr.net/npm/alertifyjs@1.13.1/build/css/alertify.min.css" />
<!-- Default theme -->
<link rel="stylesheet"
	href="//cdn.jsdelivr.net/npm/alertifyjs@1.13.1/build/css/themes/default.min.css" />
<!-- Semantic UI theme -->
<link rel="stylesheet"
	href="//cdn.jsdelivr.net/npm/alertifyjs@1.13.1/build/css/themes/semantic.min.css" />
<!-- Bootstrap theme -->
<link rel="stylesheet"
	href="//cdn.jsdelivr.net/npm/alertifyjs@1.13.1/build/css/themes/bootstrap.min.css" />
</head>

<body>
	<nav class="navbar navbar-expand-lg bg-light">
		<div class="container">
			<a class="navbar-brand" href="#"></a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="#">Home</a></li>
					<li class="nav-item"><a class="nav-link" href="#">Link</a></li>
				</ul>
			</div>
		</div>
	</nav>

	<div class="container">
		<h4 class="text-center mt-3">?????????</h4>
		<div class="input-group mt-3 mb-3">
			<input type="text" class="form-control" id="inputSearchWord"
				placeholder="Search" />
			<button class="btn btn-success" type="button" id="btnSearchWord">
				??????</button>
		</div>
		<table class="table table-hover">
			<thead>
				<tr>
					<th scope="col">#</th>
					<th scope="col">?????????</th>
					<th scope="col">??????</th>
					<th scope="col">????????????</th>
					<th scope="col">?????????</th>
				</tr>
			</thead>
			<tbody id="boardTbody">
			</tbody>
		</table>

		<div id="paginationWrapper">
			<
			<button class="btn btn-primary" type="button" id="btnInsertPage">
				?????????</button>
		</div>
		<!-- Modal -->
		<div class="modal fade" id="boardInsertModal" tabindex="-1"
			aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog modal-lg">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLabel">??? ??????</h5>
						<button type="button" class="btn-close" data-bs-dismiss="modal"
							aria-label="Close"></button>
					</div>
					<div class="modal-body">
						<div class="mb-3">
							<label for="exampleFormControlInput1" class="form-label">??????</label>
							<input type="text" class="form-control" id="titleInsert" />
						</div>
						<div class="mb-3">
							<label for="exampleFormControlTextarea1" class="form-label">??????</label>
							<textarea class="form-control" id="contentInsert" rows="10"></textarea>
						</div>
					</div>
					<div class="modal-footer">
						<button id="btnBoardInsert" type="button"
							class="btn btn-outline-primary">??????</button>
					</div>
				</div>
			</div>
		</div>

		<!-- Modal detail-->
		<div class="modal fade" id="boardDetailModal" tabindex="-1"
			aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog modal-lg">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLabel">??? ??????</h5>
						<button type="button" class="btn-close" data-bs-dismiss="modal"
							aria-label="Close"></button>
					</div>
					<div class="modal-body">
						<table class="table table-hover">

							<tr>
								<th>??? ??????</th>
								<th id="boardIdDetail">#</th>
							</tr>
							<tr>
								<th>??????</th>
								<th id="titleDetail">#</th>
							</tr>
							<tr>
								<th>??????</th>
								<th id="contentDetail">#</th>
							</tr>
							<tr>
								<th>?????????</th>
								<th id="userNameDetail">#</th>
							</tr>
							<tr>
								<th>????????????</th>
								<th id="regDtDetail">#</th>
							</tr>
							<tr>
								<th>?????????</th>
								<th id="readCountDetail">#</th>
							</tr>
							<button id="btnBoardUpdateForm" type="button"
								class="btn btn-outline-primary ">??????</button>
							<button id="btnBoardDeleteConfirm" type="button"
								class="btn btn-outline-warning ">??????</button>
							</tbody>
						</table>
					</div>

				</div>
			</div>
		</div>
</body>
<script src="<%=contextPath%>/js/util.js"></script>
<script>

var OFFSET=0;
var SEARCH_WORD='';

var LIST_ROW_COUNT=10;//???????????? ??? ????????? ??? limit
var PAGE_LINK_COUNT=10;//pageination link ??????
var CURRENT_PAGE_INDEX=1;//?????? ?????????
var TOTAL_LIST_ITEM_COUNT=0;//??? ??????

    window.onload = function () {
    	
    	boardList();
    	
    	document.querySelector("#btnSearchWord").onclick=function(){
    		SEARCH_WORD=document.querySelector("#inputSearchWord").value;
    		
    		OFFSET=0;//?????????
    		CURRENT_PAGE_INDEX=1;
    		boardList();
    	}
    	
      //insert page
      // javascript ??? bootstrap modal ??????
      document.querySelector("#btnInsertPage").onclick = function () {
        let modal = new bootstrap.Modal(
          document.querySelector("#boardInsertModal")
        );

        modal.show();
      };

      //Insert
      document.querySelector("#btnBoardInsert").onclick = function () {
        if (validateInsert()) {
          boardInsert();
        } else {
          alertify.error("????????? ????????? ?????????");
        }
      };
    };

    //get??????
    async function boardList(){
    	let url='<%=contextPath%>/board/boardList';
    	let urlParams="?limit="+LIST_ROW_COUNT+"&offset="+OFFSET+"&searchWord="+SEARCH_WORD;
    	//let urlParams=`?limit=${LIST_ROW_COUNT}&offset=${OFFSET}`;//jsp el ???????????? js es6literal temlate??? ??????-> ???????????? ?????? ???
    	let fetchOptions={
    			method:'GET'	
    	}
    	try{
    		let response=await fetch(url+urlParams,fetchOptions);
    		let data=await response.json();
    		console.log(data);
    		makeListHtml(data);
    	}catch(error){
    		console.log(error);
    		alertify.error('??? ?????? ???????????? ????????? ??????????????????.');
    	}
    }
    //js array???????????? ????????? tr??? ??????????????? ???????????? ?????? ??????
    function makeListHtml( list ){
            let listHtml = ``;

            list.forEach( el => {
                let boardId = el.boardId;
                let userName = el.userName;
                let title = el.Title;
                let regDt = el.regDt;
                let regDtStr = makeDateStr( regDt.date.year, regDt.date.month, regDt.date.day, '/');
                let readCount = el.readCount;

                listHtml +=
                    `<tr style="cursorLpointer"data-boardId=\${boardId}><td>\${boardId}</td><td>\${userName}</td><td>\${title}</td><td>\${regDtStr}</td><td>\${readCount}</td></tr>`;
            });

            document.querySelector("#boardTbody").innerHTML = listHtml;

            makeListHtmlEventHandler();
            boardListTotalCnt();
        }
    
    function makeListHtmlEventHandler(){
    	 document.querySelectorAll("#boardTbody tr").forEach(el=>{
    		 el.onclick=function(){
    			 let boardId=this.getAttribute("data-boardId");
    			 alert(boardId);
    			 boardDetail(boardId);
    		 }
    	 })
    }
    
    async function boardListTotalCnt(){
    	let url='<%=contextPath%>/board/boardListTotalCnt';
    	let urlParams="?searchWord="+SEARCH_WORD;
    	//let urlParams=`?limit=${LIST_ROW_COUNT}&offset=${OFFSET}`;//jsp el ???????????? js es6literal temlate??? ??????-> ???????????? ?????? ???
    	let fetchOptions={
    			method:'GET'	
    	}
    	try{
    		let response = await fetch( url + urlParams, fetchOptions);
            let data = await response.json();
            console.log( data );
            TOTAL_LIST_ITEM_COUNT = data.totalCnt;
            makePaginationHtml( LIST_ROW_COUNT, PAGE_LINK_COUNT, CURRENT_PAGE_INDEX, TOTAL_LIST_ITEM_COUNT, "paginationWrapper" );

    		
    	}catch(error){
    		console.log(error);
    		alertify.error('??? ?????? ???????????? ????????? ??????????????????.');
    	}
    }
    
    function movePage(pageIndex){
        OFFSET = (pageIndex - 1) * LIST_ROW_COUNT;
        CURRENT_PAGE_INDEX = pageIndex;
        boardList();
    }
    
    
    async function boardDetail(boardId){
    	let url='<%=contextPath%>/board/boardDetail';
    	let urlParams="?boardId="+boardId;
    	
    	let fetchOptions={
    			method:'GET'	
    	}
    	try{
    		let response=await fetch(url+urlParams,fetchOptions);
    		let data=await response.json();
    		console.log(data);
    		makeDetailHtml(data);
    	}catch(error){
    		console.log(error);
    		alertify.error('??? ?????? ???????????? ????????? ??????????????????.');
    	}
    }
    function makeDetailHtml(detail){
    	 let boardId = detail.boardId;
         let userName = detail.userName;
         let title = detail.Title;
         let content = detail.content;
         let regDt = detail.regDt;
         let regDtStr = makeDateStr( regDt.date.year, regDt.date.month, regDt.date.day, '/');
         let readCount = detail.readCount;
         let sameUser=detail.sameUser;
         
			document.querySelector("#boardIdDetail").innerHTML=boardId;
			document.querySelector("#titleDetail").innerHTML=titleDetail;
			document.querySelector("#contentDetail").innerHTML=contentDetail;
			document.querySelector("#userNameDetail").innerHTML=userNameDetail;
			document.querySelector("#regDtDetail").innerHTML=regDtStr;
			document.querySelector("#readCountDetail").innerHTML=readCount;
	if(sameUser){
		document.querySelector("#btnBoardUpdateForm").style.display="inline-block";
		document.querySelector("#btnBoardDeleteConfirm").style.display="inline-block";
	}else{
		document.querySelector("#btnBoardUpdateForm").style.display="none";
		document.querySelector("#btnBoardDeleteConfirm").style.display="none";
	}
	 let modal = new bootstrap.Modal(
	          document.querySelector("#boardDetailModal")
	        );

	        modal.show();
	      }
         
    }
    
    function validateInsert() {
      //return true/ false
      let isTitleInsertValid = false;
      let isContentInsertValid = false;

      let titleInsertValue = document.querySelector("#titleInsert").value;
      if (titleInsertValue.length > 0) {
        isTitleInsertValid = true;
      }

      let contentInsertValue = document.querySelector("#contentInsert").value;
      if (contentInsertValue.length > 0) {
          isContentInsertValid = true;
      }

      if (isTitleInsertValid && isContentInsertValid) {
        return true;
      }
      return false;
    }

    async function boardInsert() {
      let title = document.querySelector("#titleInsert").value;
      let content = document.querySelector("#contentInsert").value;

      // parameter
      let urlParams = new URLSearchParams({
        title: title,
        content: content,
      });

      let fetchOptions = {
        method: "POST",
        body: urlParams,
      };

      let response = await fetch(
        "<%=contextPath%>/board/boardInsert", fetchOptions);
		let data = await
		response.json(); // json => javascript object <= JSON.parse()
		if (data.result == "success") {
			alertify.success("?????? ?????????????????????.");
		} else if (data.result == "fail") {
			alertify.error("??? ?????? ???????????? ????????? ??????????????????");
		}
		// fetch(url,Option);
	}
</script>
</html>