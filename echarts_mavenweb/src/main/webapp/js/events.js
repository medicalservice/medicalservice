var ip = "10.1.73.43";
var port = "8088";
var projectId = "echarts_mavenweb";
var serverUrl = "http://" + ip + ":" + port + "/" + projectId;

$(document).ready(function() {
	function ajaxtest() {
		$.ajax({
			type : "POST",
			url : serverUrl + "/login.do",
			data : JSON.stringify([{id:"1",name:"cehshi1"},{id:"2",name:"ceshi2"}]),	
			contentType : "application/json;charset=UTF-8",

			dataType : 'json',					
		});
	}

	//ajaxtest();

	function helloCallback(data) {
		alert(data);
	}

	$("#signUp").click(function() {
		var username = 'zcc21';//$('#name').text();	
		$.ajax({	
			type : "GET",		
			url : serverUrl + "/signin.jsonp",
			// url : serverUrl + "/signin.do?name=zcc21&callback=helloCallback",
			//                                           %jsonp%=%jsonpCallback%
			data : "name=" + username,					

			dataType : 'jsonp',
			//jsonp : 'callback', // 默认为：callback
			//jsonpCallback : 'helloCallback',  // 不配置，jQuery会随机分配一个名称
			success	: function(json) {
				$("#welcome").html(JSON.stringify(json.user));				
			}
		});
	});	
		
	$("#signIn").click(function() {
		var username = $('#name').text();	
		$.ajax({	
			type : "GET",		
			url : serverUrl + "/signin.do",
			data : "name=" + username,					

			success	: function(data) {
				$("#welcome").html(data);				
			}
		});
	});	

	$("#signInByJson").click(function() {
		var username ='zcc21';// $('#name').text();		
		$.ajax({
			type : "POST",
			url : serverUrl + "/signinbyjosn.jsonp",
			data : JSON.stringify({"id" : "1", "name" : username}),
			//data : "{\"id\" : \"1\", \"name\" : \"zcc21\"}",
			contentType : "application/json",

			dataType : 'jsonp',
			success	: function(data) {
				$("#welcome").html(JSON.stringify(data));
				displayedData = data;
			}
		});		
		
		//loadData();
	});	

	$("#loadData").click(function() {
		//var data = $.ajax({url:"./data.txt", async:false}).responseText;
		$.ajax({
			type : "POST",
			url : serverUrl + "/loaddata.jsonp",
			//data : JSON.stringify({"id" : "1", "name" : "zcc21"}),
			//data : "{\"id\" : \"1\", \"name\" : \"zcc21\"}",
			//contentType : "application/json",

			dataType : 'jsonp',
			success	: function(jsonArray) {
				var data = jsonArray[0];
				$("#data").html(JSON.stringify(data));
				displayedData = data;
			}
		});		
		
		//loadData();
	});

	$("#draw").click(function() {
		draw();
	});

	$("#selectA").click(function() {
		select('A');
	});

	$("#selectB").click(function() {
		select('B');
	});

	$("#selectC").click(function() {
		select('C');
	});
});


