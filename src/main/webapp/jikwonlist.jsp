<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>직원리스트(Ajax 처리)</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			$("#jikwonData").empty();
			
			$("body").on("click", "td[name='toGogek']", function() {
				$("#gogekData").empty();
				
				$.ajax({
					type : "get",
					url : "gogek?num="+$(this).attr("class"),
					dataType : "json",
					success : function(gogekData) {
						var str = "<table border='1'>";
						str += "<tr><th>고객번호</th><th>고객명</th><th>고객전화</th></tr>";
						
						var list = gogekData.gogekdatas;
						$(list).each(function(index, obj) {
							str += "<tr>";
							str += "<td>" + obj["gogek_no"] + "</td>";
							str += "<td>" + obj["gogek_name"] + "</td>";
							str += "<td>" + obj["gogek_tel"] + "</td>";
							str += "</tr>";
						});
						str += "<tr><td colspan='3'>고객 수 : " + $(list).length + "명</td></tr>"
						str += "</table>";
						
						$("#gogekData").append(str);
					},
					error : function() {
						$("#gogekData").html("<b>에러</b> 발생!");
					}
				});
			});
			
			$.ajax({
				type : "get",
				url : "jikwon",
				dataType : "json",
				success : function(jikwonData) {
					var str = "<table border='1'>";
					str += "<tr><th>사번</th><th>이름</th><th>부서전화</th><th>직급</th><th>관리 고객 수</th></tr>"
					
					var list = jikwonData.jikwondatas;
					$(list).each(function(index, obj) {
						str += "<tr>";
						str += "<td>" + obj["jikwon_no"] + "</td>";
						str += "<td name='toGogek' class='"+obj["jikwon_no"]+"''>" + obj["jikwon_name"] + "</td>";
						str += "<td>" + obj["buser_tel"] + "</td>";
						str += "<td>" + obj["jikwon_jik"] + "</td>";
						str += "<td>" + obj["gogek_su"] + "</td>";
						str += "</tr>";
					});
					
					str += "</table>";
					$("#jikwonData").append(str);
				},
				error : function() {
					$("#jikwonData").html("<b>에러</b> 발생!");
				}
			});
		});
	</script>
</head>
<body>
	+-- 직원 목록 --+<br>
	<div id="jikwonData"></div>
	<div id="gogekData" name="gogekData"></div>
</body>
</html>