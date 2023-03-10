<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import=" com.mtcom.myboard.dto.*" %>
<%
    String contextPath = request.getContextPath();
	String staticPath = contextPath + "/resources/static/";
	UserDto userDto = (UserDto) session.getAttribute("userDto");
%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Document</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous" />
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"
        integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p"
        crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"
        integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF"
        crossorigin="anonymous"></script>

    <!-- JavaScript -->
    <script src="//cdn.jsdelivr.net/npm/alertifyjs@1.13.1/build/alertify.min.js"></script>

    <!-- CSS -->
    <link rel="stylesheet" href="//cdn.jsdelivr.net/npm/alertifyjs@1.13.1/build/css/alertify.min.css" />
    <!-- Default theme -->
    <link rel="stylesheet" href="//cdn.jsdelivr.net/npm/alertifyjs@1.13.1/build/css/themes/default.min.css" />
    <!-- Semantic UI theme -->
    <link rel="stylesheet" href="//cdn.jsdelivr.net/npm/alertifyjs@1.13.1/build/css/themes/semantic.min.css" />
    <!-- Bootstrap theme -->
    <link rel="stylesheet" href="//cdn.jsdelivr.net/npm/alertifyjs@1.13.1/build/css/themes/bootstrap.min.css" />

	
	<!-- CKEditor -->
	<script src="https://cdn.ckeditor.com/ckeditor5/35.2.1/classic/ckeditor.js"></script>
	<link rel="stylesheet" href="<%= staticPath %>css/common.css" />
</head>

<body>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="container">
            <a class="navbar-brand" href="#"><img src="<%= staticPath + userDto.getUserProfileImageUrl()%>" 
            	style="width: 24px; height: 24px; border-radius: 50%;"></a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false"
                aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="#">Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Link</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Link</a>
                    </li>
                </ul>
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <a class="nav-link" id="btnLogout" href="#">Logout</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>

    <div class="container">
        <h4 class="text-center mt-3">?????????</h4>

        <div class="input-group mb-3  mt-3">
            <input type="text" class="form-control" id="inputSearchWord" placeholder="Search"/>
            <button class="btn btn-success" type="button" id="btnSearchWord">Search</button>
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

        <div id="paginationWrapper"></div>

        <button class="btn btn-primary" type="button" id="btnInsertPage">?????????</button>
    </div>

    <!-- Modal Insert-->
    <div class="modal fade" id="boardInsertModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg">
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title" id="exampleModalLabel">??? ??????</h5>
          <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
        </div>
        <div class="modal-body">            
            <div class="mb-3">
                <label for="titleInsert" class="form-label">??????</label>
                <input type="text" class="form-control" id="titleInsert">
              </div>
              <div class="mb-3">
                <label for="contentInsert" class="form-label">??????</label>
                <!-- CKEditor insert -->
                <div id="divEditorInsert"></div>
              </div>
              <div class="mb-3">
                <div class="form-check">
				  <input class="form-check-input" type="checkbox" value="" id="chkFileUploadInsert">
				  <label class="form-check-label" for="chkFileUploadInsert">?????? ??????</label>
				</div>
              </div>
              <div class="mb-3" style="display: none;" id="imgFileUploadInsertWrapper">
                <input type="file" id="inputFileUploadInsert" multiple>
                <div id="imgFileUploadInsertThumbnail" class="thumbnail-wrapper"></div>
              </div>
              <button id="btnBoardInsert" type="button" class="btn btn-sm btn-primary float-end" data-bs-dismiss="modal">??????</button>
        </div>            
      </div>
    </div>
  </div>

    <!-- Modal Detail-->
    <div class="modal fade" id="boardDetailModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg">
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title" id="exampleModalLabel">??? ??????</h5>
          <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
        </div>
        <div class="modal-body">            
      <table class="table table-hover">
            	<tbody>
            		<tr><td>??? ??????</td><td id="boardIdDetail">#</td></tr>
            		<tr><td>??????</td><td id="titleDetail">#</td></tr>
            		<tr><td>??????</td><td id="contentDetail">#</td></tr>
            		<tr><td>?????????</td><td id="userNameDetail">#</td></tr>
            		<tr><td>????????????</td><td id="regDtDetail">#</td></tr>
            		<tr><td>?????????</td><td id="readCountDetail">#</td></tr>                    
            		<!-- ???????????? ?????? -->
            		<tr><td colspan="2">????????????</td></tr>
            		<tr><td colspan="2" id="fileListDetail">#</td></tr>
            	</tbody>
        	</table>
        	
        		
        	<button id="btnBoardUpdateForm" type="button" class="btn btn-sm btn-primary">??????</button>
        	<button id="btnBoardDeleteConfirm" type="button" class="btn btn-sm btn-warning" data-bs-dismiss="modal">??????</button>
        </div>

      </div>
    </div>
  </div>  
  
  <!-- Modal Update-->
    <div class="modal fade" id="boardUpdateModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg">
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title" id="exampleModalLabel">??? ????????????</h5>
          <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
        </div>
        <div class="modal-body">            
            <div class="mb-3">
                <label for="titleUpdate" class="form-label">??????</label>
                <input type="text" class="form-control" id="titleUpdate">
              </div>
              <div class="mb-3">
                <label for="contentUpdate" class="form-label">??????</label>
                <!-- CKEditor update -->
                <div id="divEditorUpdate"></div>
              </div>
              <div class="mb-3">
                <div class="form-check">
				  <input class="form-check-input" type="checkbox" value="" id="chkFileUploadUpdate">
				  <label class="form-check-label" for="chkFileUploadUpdate">?????? ??????</label>
				</div>
              </div>
              <div class="mb-3" style="display: none;" id="imgFileUploadUpdateWrapper">
                <input type="file" id="inputFileUploadUpdate" multiple>
                <div id="imgFileUploadUpdateThumbnail" class="thumbnail-wrapper"></div>
              </div>
              <button id="btnBoardUpdate" type="button" class="btn btn-sm btn-primary float-end" data-bs-dismiss="modal">??????</button>
        </div>            
      </div>
    </div>
  </div>
    
<script src="<%=staticPath %>/js/util.js"></script>
<script>
	
	var OFFSET = 0;
	var SEARCH_WORD = '';
	
	// pagination
	var LIST_ROW_COUNT = 10; // limit
	var PAGE_LINK_COUNT = 10; // pagination link ??????    	
	var CURRENT_PAGE_INDEX = 1;
	var TOTAL_LIST_ITEM_COUNT = 0; // ??? ??????
	
	const SUCCESS = 1; // response ??????
	
	/*
	CKEditor ????????????
	*/
	var CKEditorInsert;
	var CKEditorUpdate;
	
	window.onload = function(){

		initCKEditor(); // CKEditor ?????????
		
		boardList();
		
		document.querySelector("#btnSearchWord").onclick = function(){
			SEARCH_WORD = document.querySelector("#inputSearchWord").value;
			// ?????????
			OFFSET = 0;
			CURRENT_PAGE_INDEX = 1;
			
			boardList();
		}
		
		
		// insert page
		// javascript ??? bootstrap modal ??????
		document.querySelector("#btnInsertPage").onclick = function(){
			
			document.querySelector("#titleInsert").value = "";
			CKEditorInsert.setData("");
			
			// ?????? ????????? ?????? ui ?????????
			document.querySelector("#chkFileUploadInsert").checked = false;
			document.querySelector("#inputFileUploadInsert").value = "";
			document.querySelector("#imgFileUploadInsertThumbnail").innerHTML = "";
			document.querySelector("#imgFileUploadInsertWrapper").style.display = "none";
			
			let modal = new bootstrap.Modal(
					document.querySelector("#boardInsertModal")
			);
			
			modal.show();
		}
		
		// insert
		document.querySelector("#btnBoardInsert").onclick = function(){
			if( validateInsert() ){
				boardInsert();
			}else{
				alertify.error("????????? ????????? ?????????.")
			}
		}
		
		// update
		document.querySelector("#btnBoardUpdateForm").onclick = function(){
		// detail => update ??? ?????? ????????? ?????? ( key ??? boardId ??? ?????? ??????)
		// detail modal ?????? update modal ??? ?????????.
		let boardId = document.querySelector("#boardDetailModal").getAttribute("data-boardId");
		document.querySelector("#boardUpdateModal").setAttribute("data-boardId", boardId);
		document.querySelector("#titleUpdate").value = document.querySelector("#titleDetail").innerHTML;
		CKEditorUpdate.setData(document.querySelector("#contentDetail").innerHTML);
		
		
		
		let modalDetail = new bootstrap.Modal(
							document.querySelector("#boardDetailModal")
					);
					console.dir( modalDetail );
					
		modalDetail.hide();
		
		// ?????? ????????? ?????? ui ?????????
		document.querySelector("#chkFileUploadUpdate").checked = false;
		document.querySelector("#inputFileUploadUpdate").value = "";
		document.querySelector("#imgFileUploadUpdateThumbnail").innerHTML = "";
		document.querySelector("#imgFileUploadUpdateWrapper").style.display = "none";
		
			let modalUpdate = new bootstrap.Modal(
					document.querySelector("#boardUpdateModal")
			);
			
			modalUpdate.show();
		}
		
		document.querySelector("#btnBoardUpdate").onclick = function(){
			if( validateUpdate() ){
				boardUpdate();
			}else{
				alertify.error("????????? ????????? ?????????.")
			}
		}
		
		// delete
		document.querySelector("#btnBoardDeleteConfirm").onclick = function(){
			alertify.confirm("?????? ??????", "?????? ?????????????????????????", 
					function(){
						boardDelete();
					}, 
					function(){
						console.log('user cancel');
					});
		}
		
		// logout
		document.querySelector("#btnLogout").onclick = function(){
			logout();
		}
      	
		// ??????????????? CheckBox
		document.querySelector("#chkFileUploadInsert").onchange = function() {
			if (this.checked) {
				document.querySelector("#imgFileUploadInsertWrapper").style.display = "block";
			} else {
				document.querySelector("#inputFileUploadInsert").value = "";
				document.querySelector("#imgFileUploadInsertThumbnail").innerHTML = "";
				document.querySelector("#imgFileUploadInsertWrapper").style.display = "none";
			}
		}
		
		document.querySelector("#chkFileUploadUpdate").onchange = function() {
			if (this.checked) {
				document.querySelector("#imgFileUploadUpdateWrapper").style.display = "block";
			} else {
				document.querySelector("#inputFileUploadUpdate").value = "";
				document.querySelector("#imgFileUploadUpdateThumbnail").innerHTML = "";
				document.querySelector("#imgFileUploadUpdateWrapper").style.display = "none";
			}
		}
		
		// thumbnail image ??????
		document.querySelector("#inputFileUploadInsert").onchange = function() {
			const fileArray = Array.from(this.files); // ???????????? ???????????? javaScript ????????? ????????? ??????
			fileArray.forEach(file => {
				let reader = new FileReader();
				reader.readAsDataURL(file); // ????????? ???????????????.
				reader.onload = function(e) { // ????????? ??? ?????????
					let thumbnailHTML = `<img src = "\${e.target.result}">`;
					document.querySelector("#imgFileUploadInsertThumbnail").insertAdjacentHTML("beforeend", thumbnailHTML);
				}
			});
		}
		
		document.querySelector("#inputFileUploadUpdate").onchange = function() {
			const fileArray = Array.from(this.files); // ???????????? ???????????? javaScript ????????? ????????? ??????
			fileArray.forEach(file => {
				let reader = new FileReader();
				reader.readAsDataURL(file); // ????????? ???????????????.
				reader.onload = function(e) { // ????????? ??? ?????????
					let thumbnailHTML = `<img src = "\${e.target.result}">`;
					document.querySelector("#imgFileUploadUpdateThumbnail").insertAdjacentHTML("beforeend", thumbnailHTML);
				}
			})
		}
	}
	
	// CKEditor ?????????
	async function initCKEditor() {
		try {
			CKEditorInsert = await ClassicEditor.create(document.querySelector( '#divEditorInsert' ));
			CKEditorUpdate = await ClassicEditor.create(document.querySelector( '#divEditorUpdate' ));
			
		} catch (error) {
			console.error(error);
		}
	}
	// GET
	async function boardList(){
		let url = '<%= contextPath %>/boards';
		let urlParams = '?limit=' + LIST_ROW_COUNT + '&offset=' + OFFSET + '&searchWord=' + SEARCH_WORD;
		//let urlParams = `?limit=${LIST_ROW_COUNT}&offset=${OFFSET}`; // jsp el ???????????? javascript es6 literal template ??? ??????
		let fetchOptions = {
			method: 'GET',
			headers:{
				'async':'true'
			}
		}
		
		try{
			let response = await fetch( url + urlParams, fetchOptions);
			let data = await response.json();
			console.log( data );
			
			if(data.result=="login"){
				window.location.href="<%=contextPath%>/login"
				
			}else if (data.result == SUCCESS) {
				makeListHtml(data.list);
				// ??? ????????? ?????? ?????????????????? ?????? ??????
    			TOTAL_LIST_ITEM_COUNT = data.count;
    			makePaginationHtml( LIST_ROW_COUNT, PAGE_LINK_COUNT, CURRENT_PAGE_INDEX, TOTAL_LIST_ITEM_COUNT, "paginationWrapper" );
			}
			
			
		}catch( error ){
			console.log(error);
			alertify.error('??? ?????? ???????????? ????????? ???????????????.')
		}
	}
	
	// javascript array ??? ???????????? ????????? <tr> ??? ??????????????? ???????????? ????????? ??????
	function makeListHtml( list ){
		let listHtml = ``;
		
		list.forEach( el => {
			let boardId = el.boardId;
			let userName = el.userName;
			let title = el.title;
			let regDt = el.regDt;
			let regDtStr = makeDateStr( regDt.date.year, regDt.date.month, regDt.date.day, '/');
			let readCount = el.readCount;
			
			listHtml +=
				`<tr style="cursor:pointer" data-boardId=\${boardId}><td>\${boardId}</td><td>\${userName}</td><td>\${title}</td><td>\${regDtStr}</td><td>\${readCount}</td></tr>`;
		});
		
		document.querySelector("#boardTbody").innerHTML = listHtml;
		
		makeListHtmlEventHandler();
		
		// boardListTotalCnt(); - ?????? boardList()?????? ?????????
	}
	
	function makeListHtmlEventHandler(){
		document.querySelectorAll("#boardTbody tr").forEach( el => {
			el.onclick = function(){
				let boardId = this.getAttribute("data-boardId");
				boardDetail(boardId);
			}
		})
	}
	
	// GET
// 	async function boardListTotalCnt(){
<%-- 		let url = '<%= contextPath %>/board/boardListTotalCnt'; --%>
// 		let urlParams = '?searchWord=' + SEARCH_WORD;
// 		//let urlParams = `?limit=${LIST_ROW_COUNT}&offset=${OFFSET}`; // jsp el ???????????? javascript es6 literal template ??? ??????
// 		let fetchOptions = {
// 			method: 'GET',
// 			headers:{
// 				'async':'true'
// 			}
// 		}
		
// 		try{
// 			let response = await fetch( url + urlParams, fetchOptions);
// 			let data = await response.json();
// 			console.log( data );
// 			TOTAL_LIST_ITEM_COUNT = data.totalCnt;
// 			makePaginationHtml( LIST_ROW_COUNT, PAGE_LINK_COUNT, CURRENT_PAGE_INDEX, TOTAL_LIST_ITEM_COUNT, "paginationWrapper" );
			
// 		}catch( error ){
// 			console.log(error);
// 			alertify.error('??? ?????? ???????????? ????????? ???????????????.')
// 		}
// 	}
	
// 	function movePage(pageIndex){
// 		OFFSET = (pageIndex - 1) * LIST_ROW_COUNT;
// 		CURRENT_PAGE_INDEX = pageIndex;
// 		boardList();
// 	}
	
	
	// GET
	async function boardDetail(boardId){
		let url = '<%= contextPath %>/boards/' + boardId; // path variable

 		let fetchOptions = {
 			method: 'GET',
 			headers:{
				'async':'true'
			}
 		}
 		
 		try{
 			let response = await fetch( url, fetchOptions);
 			let data = await response.json();
 			console.log( data );
 			if(data.result=="login"){
				window.location.href="<%=contextPath%>/login"
				
			}else if (data.result == SUCCESS) {
 				console.log(data.dto);
 				makeDetailHtml( data.dto );
 			} else {
 				alertify.error('??? ?????? ???????????? ????????? ???????????????.');
 			}
 		}catch( error ){
 			console.log(error);
 			alertify.error('??? ?????? ???????????? ????????? ???????????????.')
 		}
 	}
 	
 	function makeDetailHtml( detail ){
		let boardId = detail.boardId;
		let userName = detail.userName;
		let title = detail.title;
		let content = detail.content;
		let regDt = detail.regDt;
		let regDtStr = 
			makeDateStr( regDt.date.year, regDt.date.month, regDt.date.day, '/') + ' ' +
			makeTimeStr( regDt.time.hour, regDt.time.minute, regDt.time.second, ':');
		let readCount = detail.readCount;
		let sameUser = detail.sameUser;
		
		//????????????
		let fileList=detail.fileList;
		
		//?????? ??????
		document.querySelector("#boardDetailModal").setAttribute("data-boardId", boardId );
		 		document.querySelector("#boardIdDetail").innerHTML = boardId;
		 		document.querySelector("#titleDetail").innerHTML = title;
		 		document.querySelector("#contentDetail").innerHTML = content;
		 		document.querySelector("#userNameDetail").innerHTML = userName;
		 		document.querySelector("#regDtDetail").innerHTML = regDtStr;
		 		document.querySelector("#readCountDetail").innerHTML = readCount;
		 		
		 		//?????? ?????? ?????? ??????
		 		let fileListDetailHtml=``;
		 		if(fileList.length>0){//?????? ?????? ?????????
		 			fileList.forEach(el=>{
		 				let fileId=el.fileId;
		 				let fileName=el.fileName;
		 				let fileUrl=el.fileUrl;
		 				
		 				fileListDetailHtml+=
		 				`
		 				<div>
		 					<span class="fileName">\${fileName}</span>
		 					&nbsp;&nbsp;
		 					<a type="button" 
		 						class="btn btn-outline btn-default btn-xs" 
		 						data-fileId="\${fileId}"
		 						href="<%=staticPath%>\${fileUrl}"
		 						download="\${fileName}"
		 					>????????????</a>
		 				</div>
		 				`
		 			});
		 			
		 		}
		 		
		 		document.querySelector("#fileListDetail").innerHTML=fileListDetailHtml;
	
		 		
		 		if( sameUser ){
		 			document.querySelector("#btnBoardUpdateForm").style.display = "inline-block";
		 			document.querySelector("#btnBoardDeleteConfirm").style.display = "inline-block";
		 		}else{
		 			document.querySelector("#btnBoardUpdateForm").style.display = "none";
		 			document.querySelector("#btnBoardDeleteConfirm").style.display = "none";
		 		}
		 		
		 		let modal = new bootstrap.Modal(
				document.querySelector("#boardDetailModal")
		);
		
		modal.show();
 	}
 	
 	///////////////////////////////////
     function validateInsert(){
         // return true / false
         let isTitleInsertValid = false;
         let isContentInsertValid = false;

         let titleInsertValue = document.querySelector("#titleInsert").value;
         if( titleInsertValue.length > 0 ){
         	isTitleInsertValid = true;
         }

         let contentInsertValue = CKEditorInsert.getData();
         if( contentInsertValue.length > 0 ){
         	isContentInsertValid = true;
         }

         if( isTitleInsertValid && isContentInsertValid ){
           return true;
         }
         return false;
       }
     
//      async function boardInsert(){
//      	let title = document.querySelector("#titleInsert").value;
//          let content = CKEditorInsert.getData();

//          // parameter 
//          let urlParams = new URLSearchParams({
//            title: title,
//            content: content
//          });
//          // fetch options
//          let fetchOptions = {
//            method: "POST",
//            body: urlParams
//          }

<%--          let url = "<%= contextPath%>/boards"; --%>
//         try{
//             let response = await fetch( url, fetchOptions);
//             let data = await response.json(); // json => javascript object <= JSON.parse()
//             if( data.result == SUCCESS){ // login.jsp => boardMain.jsp ??? ????????? ?????? ( ????????? ?????????(html....) ??????)
//               alertify.success('?????? ?????????????????????.');
//               boardList();
//             } else {
//           	  alertify.error('??? ?????? ???????????? ????????? ??????????????????.');
//             }            	
//         }catch(error){
//         	alertify.error('??? ?????? ???????????? ????????? ??????????????????.');
//         }

//     }
	async function boardInsert() {
		// ????????? x-www..  ???????????? ?????? ?????? multipart/form-data
		let formData = new FormData();
		formData.append("title", document.querySelector("#titleInsert").value);
		formData.append("content", CKEditorInsert.getData());
		
		// file upload
		let files = document.querySelector("#inputFileUploadInsert").files;
		
// 		// #1
// 		for (let i = 0; i < files.length; i++) {
// 			formData.append("file", files[i]);
// 		}
		
		// #2
		const fileArray = Array.from(files);
		fileArray.forEach(file => formData.append("file", file));
		
		let url = "<%= contextPath%>/boards";
		
		// fetch options
		let fetchOptions = {
		  method: "POST",
		  body: formData,
		  headers:{
				'async':'true'
			}
		}
		
		try{
		    let response = await fetch( url, fetchOptions);
		    let data = await response.json(); // json => javascript object <= JSON.parse()
		    
		    if(data.result=="login"){
				window.location.href="<%=contextPath%>/login"
				
			}else if( data.result == SUCCESS){ // login.jsp => boardMain.jsp ??? ????????? ?????? ( ????????? ?????????(html....) ??????)
		      alertify.success('?????? ?????????????????????.');
		      boardList();
		    } else {
		  	  alertify.error('??? ?????? ???????????? ????????? ??????????????????.');
		    }            	
		}catch(error){
			alertify.error('??? ?????? ???????????? ????????? ??????????????????.');
		}
	}
    
    function validateUpdate(){
        // return true / false
        let isTitleUpdateValid = false;
        let isContentUpdateValid = false;

        let titleUpdateValue = document.querySelector("#titleUpdate").value;
        if( titleUpdateValue.length > 0 ){
        	isTitleUpdateValid = true;
        }

        let contentUpdateValue = CKEditorUpdate.getData();
        if( contentUpdateValue.length > 0 ){
        	isContentUpdateValid = true;
        }

        if( isTitleUpdateValid && isContentUpdateValid ){
          return true;
        }
        return false;
    }
    
//     async function boardUpdate(){
//     	let boardId = document.querySelector("#boardUpdateModal").getAttribute("data-boardId");
//     	let title = document.querySelector("#titleUpdate").value;
//         let content = CKEditorUpdate.getData();

//         // parameter 
//         let urlParams = new URLSearchParams({
//           boardId: boardId,
//           title: title,
//           content: content
//         });
//         // fetch options
//         let fetchOptions = {
//           method: "POST",
//           body: urlParams
//         }

<%--         let url = "<%= contextPath%>/boards/" + boardId; --%>
//         try{
//             let response = await fetch( url, fetchOptions);
//             let data = await response.json(); // json => javascript object <= JSON.parse()
//             if( data.result == SUCCESS){ // login.jsp => boardMain.jsp ??? ????????? ?????? ( ????????? ?????????(html....) ??????)
//               alertify.success('?????? ?????????????????????.');
//               boardList();
//             } else {
//           	  alertify.error('??? ?????? ???????????? ????????? ??????????????????.');
//             }            	
//         }catch(error){
//         	alertify.error('??? ?????? ???????????? ????????? ??????????????????.');
//         }

//     }
	async function boardUpdate() {
		let boardId = document.querySelector("#boardUpdateModal").getAttribute("data-boardId");
		
		// ????????? x-www..  ???????????? ?????? ?????? multipart/form-data
		let formData = new FormData();
		formData.append("boardId", boardId);
		formData.append("title", document.querySelector("#titleUpdate").value);
		formData.append("content", CKEditorUpdate.getData());
		
		// file upload
		let files = document.querySelector("#inputFileUploadUpdate").files;
		
	//		// #1
	//		for (let i = 0; i < files.length; i++) {
	//			formData.append("file", files[i]);
	//		}
		
		// #2
		const fileArray = Array.from(files);
		fileArray.forEach(file => formData.append("file", file));
		
		let url = "<%= contextPath%>/boards/" + boardId;
		
		// fetch options
		let fetchOptions = {
		  method: "POST",
		  body: formData,
		  headers:{
				'async':'true'
			}
		}
		
		try{
		    let response = await fetch( url, fetchOptions);
		    let data = await response.json(); // json => javascript object <= JSON.parse()
		    if(data.result=="login"){
				window.location.href="<%=contextPath%>/login"
				
			}else if( data.result == SUCCESS){ // login.jsp => boardMain.jsp ??? ????????? ?????? ( ????????? ?????????(html....) ??????)
		      alertify.success('?????? ?????????????????????.');
		      boardList();
		    } else {
		  	  alertify.error('??? ?????? ???????????? ????????? ??????????????????.');
		    }            	
		}catch(error){
			alertify.error('??? ?????? ???????????? ????????? ??????????????????.');
		}
	}
	
    async function boardDelete(){
    	let boardId = document.querySelector("#boardDetailModal").getAttribute("data-boardId");

        let url = "<%= contextPath%>/boards/" + boardId;
        let fetchOptions = {
                method: "DELETE",
                headers:{
    				'async':'true'
    			}
              }
        try{
            let response = await fetch( url , fetchOptions); // default GET
            let data = await response.json(); // json => javascript object <= JSON.parse()
            if(data.result=="login"){
				window.location.href="<%=contextPath%>/login"
				
			}else if( data.result == SUCCESS){ // login.jsp => boardMain.jsp ??? ????????? ?????? ( ????????? ?????????(html....) ??????)
              alertify.success('?????? ?????????????????????.');
              boardList();
            } else {
          	  alertify.error('??? ?????? ???????????? ????????? ??????????????????.');
            }            	
        }catch(error){
        	alertify.error('??? ?????? ???????????? ????????? ??????????????????.');
        }

    }
    
    async function logout(){
    	// logout ?????? => ?????????????????? session.invalidate(); result:success
    	// result ??? success => login ????????? ?????? (ajax X , window.location.href ??? ??????)
    	let url = "<%= contextPath%>/logout";
    	
    	try{
            let response = await fetch( url ); // default GET
            let data = await response.json(); // json => javascript object <= JSON.parse()
            if( data.result == "success"){ // login.jsp => boardMain.jsp ??? ????????? ?????? ( ????????? ?????????(html....) ??????)
              window.location.href = "<%= contextPath%>/jsp/login.jsp";
            }else if( data.result == "fail"){
          	  alertify.error('????????????????????? ????????? ??????????????????.');
            }            	
        }catch(error){
        	alertify.error('????????? ???????????? ????????? ??????????????????.');
        }
    }
    
</script>
</body>

</html>
