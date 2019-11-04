<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html >
<html>
<head>
<meta charset=UTF-8">
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/4.0.11/handlebars.js"></script>
<script type="text/javascript">
	var vrno = '';
	var fileList='';
	var userfile = '';

	$(document).ready(function() {
		//댓글 수정 모달 숨기기
		$('#modifyModal').addClass('modifyHide');
		
		//댓글수정 창 숨기기
		$('#btnClose').on('click' ,function(){
			$('#modifyModal').addClass('modifyHide');
			$('#modifyModal').removeClass('modifyShow');
			$(document).on('click', '.timeline button' , reply_update_dalete);
			urno='';
		});	
		
		//댓글 추가
		$('#replyAddBtn').on('click', function() {
			reply_list();
		});
		//모달창에 수정버튼
		$('#btnModify').on('click' , reply_update_send);
		
		//댓글 삭제
		$(document).on('click', '.timeline button', reply_update_dalete);
		
		//내 pc 첨부파일 시작----------------------------------------------
		
		$('#userpc').on('click' , function(){
			userfile =$('<input type="file" id="userfile" />');
			userfile.click();
			userfile.change(function(){
				//console.log($(userfile[0]).val());
				var partname=$(userfile[0]).val().substring($(userfile[0]).val().lastIndexOf("\\")+1);
				//console.log("partname",partname);
				var str = '<p><input type="checkbox" />'+partname+'</p>';
				$('.fileDrop').empty(); //초기화
				$('.fileDrop').append(str);
				var dataList=userfile[0].files[0];
				fileList=dataList;
				
			});
		});
		
		//내pc 첨부파일 끝------------------------------------------------
		
		//첨부파일 드래그 시작====================================
		var obj = $('.fileDrop')
		var win = $('body');
		
		//dragover : Drag중 mouse가 현재 위치한 Element
		win.on('dragover' , function(e){
			e.preventDefault();
			$(this).css('border','2px solid #0B85A1');
		});
		
		win.on('drop', function(e){
			e.preventDefault();
			$(obj).empty();
			var files = e.originalEvent.dataTransfer.files;
			obj.append('<p><input type="checkbox" / >'+files[0].name+'</p>');
			fileList = files[0];
			
			
		});
		
		//첨부파일 드래그 끝========================================
			//첨부파일 삭제 시작==================================
				
			$(document).on('click', 'fileDrop input', function(){
				$(this).parent().remove();
				userfile='';
				fileList='';
			});//////////////////////////////////////////////////=====
		
		
	}); //end  ready()//////////////
	
	
	function reply_update_send(){
		$.ajax({
			type:'GET',
			dataType:'json',
			url : 'replyUpdate.do?bno=${boardDTO.bno}&rno='
					+urno+'&replytext='+$('#updateReplyText').val(),
			success: reply_list_result
		});
		$('#updateReplyText').val('');
		$('#modifyModal').addClass('modifyHide');
		$('#modifyModal').removeClass('modifyShow');
		$(document).on('click', '.timeline button' , reply_update_dalete);
		urno='';
	}/////////////////////////////////////////////////////////

	function reply_update_dalete() {
		if ($(this).text() == 'delete') {
			var brno = $(this).prop("id");
			$.ajax({
				type : 'GET',
				dataType : 'json',
				url : 'replyDelete.do?bno=${boardDTO.bno}&rno=' + brno,
				success : reply_list_result
			});

		} else if ($(this).text() == 'update') {
			urno = $(this).prop("id");
				var stop=$(window).scrollTop();
				$('#modifyModal').css('top',50+stop);
				$('#modifyModal').removeClass('modifyHide');
				$('#modifyModal').addClass('modifyShow');
				//$('#modifyModal').removeClass('modifyHide').addClass('modifyShow');
				$(document).off('click', '.timeline button');
				
		}
	}////////////////////////////////////////

	function reply_list() {
		if ($('#newReplyWriter').val() == '') {
			alert('wirter을 작성하세요');
			return false;
		}
		if ($('#newReplyText').val() == '') {
			alert('text를 작성하시오.');
			return false;
		}
		
		var form_data = new FormData();
		form_data.append('bno', '${boardDTO.bno}');
		form_data.append('replyer' ,$('#newReplyWriter').val());
		form_data.append('replytext' , $('#newReplyText').val());
		/* if($('#filename')[0].files[0]!=undefined){
			form_data.append('filename' , $('#filename')[0].files[0]);
		} */
		if(fileList!=''){
			form_data.append('filename',fileList);
		}
		
		
		$.ajax({
			type : 'POST',
			dataType : 'json',
			url : 'replyInsertList.do',
			data: form_data,
			contentType: false,
			enctype: 'multipart/form-data',
			processData: false,
			success : reply_list_result
		});
		$('#newReplyWriter').val('');
		 $('#newReplyText').val('');
		 $('.fileDrop').empty();
		 userfile='';
		 fileList='';
		
	}//end reply_list/////////////////////////////////////

	Handlebars.registerHelper("newDate", function(timeValue) {
		var dateObj = new Date(timeValue);
		var year = dateObj.getFullYear();
		var month = dateObj.getMonth() + 1;
		var date = dateObj.getDate();
		return year + "/" + month + "/ " + date;
	});////////////////////////////////////////////////1
	
	Handlebars.registerHelper("newUpload", function(uploadFile){
		if(uploadFile != null)
			return uploadFile.substring(uploadFile.indexOf("_")+1);
		else
			return uploadFile;
		
	});
	
	

	function reply_list_result(res) {
		//console.log(res);
		$('.timeline .time_sub').remove(); //empty()=자식의 요소만 삭제 remove()=자신도 삭제
		$('#replycntSmall').text('[' + res.length + ']');
		$.each(res, function(index, value) {
			/* $('.timeline').append('<li class="time_sub" id="'
					+value.tno+'"><p>'+value.replyer
					+'</p><p>'+ value.replytext
					+'</p><p>'+new Date(value.regdate)
					+'</p><p><button id="'+value.rno
					+'">delete</button> <button id="'
					+value.rno+'">update</button</p></li>'); */
			var soruce = '<li class="time_sub" id="{{rno}}>"'
					+ '<p>{{replyer}}</p>' + '<p>{{replytext}}</p>'
					+ '<p>{{newDate regdate}}</p>'
					+'<p>{{newUpload rupload}}</p>'
					+ '<p><button id="{{rno}}">delete</button>'
					+ '<button id="{{rno}}">update</button></p></li>';
			var template = Handlebars.compile(soruce);
			$('.timeline').append(template(value));
		});
	}/////////////////////////////////////////////////////////
	
</script>
<style type="text/css">
.modifyShow {
	display: block;
	position: absolute;
	/*  top: 150px; */
	left: 200px;
	width: 400px;
	height: 150px;
	z-index: 1000;
	border: 1px solid black;
	background-color: yellow;
	text-align: center;
}

.modifyHide {
	visibility: hidden;
	width: 0px;
	height: 0px;
}

.fileDrop{
	width: 500px;
	height: 100px;
	border: 2px dotted blue;
	overflow: auto;
}
</style>
<title>Insert title here</title>
</head>
<body>

	<div class="wrap">
		<!-- class="box-body"시작 -->
		<div class="box-body">
			<div class="form-group">
				<label>Title</label> <input type="text" name="tutle"
					value="${boardDTO.title}" readonly="readonly" />
			</div>
			<div class="form-group">
				<label>Content</label>
				<textarea rows="3" name="content" readonly="readonly">${boardDTO.content} </textarea>
			</div>
			<div class="form-group">
				<label>Writer</label> <input type="text" name="writer"
					value="${boardDTO.writer}" readonly="readonly" />
			</div>
		</div>
		<!-- class="box-body"끝-->
		<!--class="box-footer" 시작  -->
		<div class="box-footer">
			<button type="submit" id="modifyBtn">Modify</button>
			<button type="submit" id="removeBtn">REMOVE</button>
			<button type="submit" id="goListBtn">GO LIST</button>
		</div>
		<!--class="box-footer" 끝  -->

		<hr />
		<div class="box-success">
			<!-- box-success 시작-->
			<div class="box-header">
				<h3 class="box-title">ADD NEW REPLY</h3>
			</div>

			<div class="box-body">
				<label for="newReplyWriter">Writer</label> 
				<input	class="form-control" type="text" placeholder="USER ID"
					id="newReplyWriter">
					 <label for="newReplyText">Replytext</label> 
					 <input class="form-control" type="text" placeholder="REPLY TEXT" id="newReplyText">
					<!-- <label for="filename" >Upload</label>
					<input type="file" id="filename" name="filename" /> -->
					<div>
						<span id="userpc" style="cursor: pointer">내PC</span>
					</div>
					<div class="fileDrop">
					
					</div>
			</div>
			<div class="box-footer">
				<button type="button" class="btn btn-primary" id="replyAddBtn">ADD
					REPLY</button>
			</div>
			<!-- box-success 끝-->
		</div>
		<hr />

		<ul class="timeline">
			<li class="time-label" id="repliesDiv"><span class="bg-green">Replies
					List <small id="replycntSmall">[${fn:length(boardDTO.replyList)}]</small>
			</span></li>
			<c:forEach items="${boardDTO.replyList}" var="replyDTO">
				<li class="time_sub" id="${replyDTO.rno}">
					<p>${replyDTO.replyer}</p>
					<p>${replyDTO.replytext}</p>
					<p>
						<fmt:formatDate value="${replyDTO.regdate}" pattern="yyyy/MM/dd"
							dateStyle="short" />
					</p>
					<p>	${fn:substringAfter(replyDTO.rupload,'_')}</p>
					<p>
						<button id="${replyDTO.rno}">delete</button>
						<button id="${replyDTO.rno}">update</button>
					</p>
				</li>
			</c:forEach>
		</ul>
	</div>
	
	<!-- Update Model -->
	<div id="modifyModal">
		<p>
			<label for="updateReplyText">Reply Text</label> 
			<input class="form-control" type="text" placeholder="REPLY TEXT"
				id="updateReplyText">
		</p>
		<p>
			<button id="btnModify">Modify</button>
			<button id="btnClose">Close</button>
		</p>
	</div>
</body>
</html>





















