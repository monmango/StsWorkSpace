function init(chk){
	
	if(chk){
		console.log('aa');
		$('#logInPage').removeClass('hidePage').addClass('showPage');
		$('#logOutPage').removeClass('showPage').addClass('hidePage');
		
	}else{
		console.log('bb');
		$('#logInPage').removeClass('showPage').addClass('hidePage');
		$('#logOutPage').removeClass('hidePage').addClass('showPage');
		
	}
	
}

function loginchk(logchk){
	console.log(logchk);
	if(logchk){
		
		
	}else{
		alert('로그인 후 이용하세요.')
		
	}
	
	
}





