/**
 * 
 */
function post(){
	var postId = $("#postid").val();
	var content = $("#comment").val();
	if(!content){
		alert("不能回复空内容");
		return;
	}
	$.ajax({
		type:"POST",
		url:"/comment",
		contentType:'application/json',
		data:JSON.stringify({
			"parentId":postId,
			"content":content,
			"type":1
		}),
		success: function(response){
			if(response.code == 200){
				window.location.reload();
			}else{
				if(response.code == 2200){
					var isAccepted = confirm(response.message);
					if(isAccepted){
						window.location.href = 'http://localhost:8060/loginPage';
						window.localStorage.setItem("closeable","true");
					}
				}else {
					alert(response.message)
				}
			}	
		},
		dataType:"json"
	})
	console.log(postId);
	console.log(content);
}