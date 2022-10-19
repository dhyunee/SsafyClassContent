<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>DB Test (using Json)</h1>
	<button id="btnEmpDetail">Emp ��</button>
	<button id="btnEmpList">Emp ���</button>
	<br>
	<button id="btnEmpInsert">Emp ���</button>
	<button id="btnEmpDelete">Emp ����</button>
	<button id="btnEmpUpdate">Emp ����</button>

	<script>
        window.onload=function(){
        	document.querySelector("#btnEmpDetail").onclick=async function(){
        		
        		try{
        			let response=await fetch('/mydb/empDetail/1500');
        			let data=await response.json();
        			console.log(data);
        		}catch(error){
        			console.error(error);
        		}
        	}
        	
document.querySelector("#btnEmpList").onclick=async function(){
        		
        		try{
        			let response=await fetch('/mydb/empList');
        			let data=await response.json();
        			console.log(data);
        		}catch(error){
        			console.error(error);
        		}
        	}
        	//�ڹ� ��ũ��Ʈ ��ü
        	var empInsertData={
        			employeeId:1600,
        			firstName:'��',
        			lastName: '�浿',
        			email:'you@gildong.com',
        			hireDate:'2022-10-29'
        	}
document.querySelector("#btnEmpInsert").onclick=async function(){
	let urlParams=new URLSearchParams(empInsertData);
	let fetchOptions={
			method:'POST',
			body:urlParams
	}
	
	try{
		let response=await fetch('/mydb/empInsert',fetchOptions);
		let data=await response.json();
		console.log(data);
	}catch(error){
		console.error(error);
	}
}
        	
        	document.querySelector("#btnEmpDelete").onclick=async function(){
        		
        		try{
        			let response=await fetch('/mydb/empDelete/1501');
        			let data=await response.json();
        			console.log(data);
        		}catch(error){
        			console.error(error);
        		}
        	} 	
        	
document.querySelector("#btnEmpUpdate").onclick=async function(){
        		
        		try{
        			let response=await fetch('/mydb/empUpdate/1502');
        			let data=await response.json();
        			console.log(data);
        		}catch(error){
        			console.error(error);
        		}
        	} 	
        }
    </script>
</body>
</html>