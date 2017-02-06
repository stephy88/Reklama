<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="com.reklama.connection.DatabaseUtil"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" >

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
 .addBtn {
   margin-bottom: 20px;
    margin-top: 10px; 
 }
</style>

<script>
//$(document).ready(function() {
	/*$("button").click(function(){
	    $.get("index.jsp", function(data, status){
	        alert(data);
	    });
	});*/
	
	function getData()
	{
		$('#loading-image').show();
		$.ajax({
			  url: "MyServlet",
			  type: "GET",
			  dataType: "html",
			  success: function(data){
			    //var data_array = $.parseJSON(data);
			   
			    $("#responsecontainer").html(data);
			    $('#loading-image').hide();
			  },
			  error: function() {
			    alert("BAD");
			  }
			});

	}
	
	
	function updateData(id)
	{
		 var name = $("#name").val();
		 var str = $("#id").val(id);
		 $.ajax({
			  url: "MyServlet",
			  type: "PUT",
			  data: 'name=' + name + '&id=' + str, 
			  success: function(data){
			    //var data_array = $.parseJSON(data);
			   $('#myModal').modal('hide');
			   getData();
			   alert(data);
			 },
			  error: function() {
			    alert("BAD");
			  }
			});
	}
	    	
	
//});
</script>
</head>
<body onload="getData()">
<div class="container">
<a href="add.jsp"><button type="button" class="btn btn-primary pull-right addBtn">Add New</button></a>
</div>

<img id="loading-image" src="images/ajax-loader.gif">  
<div class="container"  id='responsecontainer'>

</div>


<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">Modal title</h4>
      </div>
      <form>
      <div class="modal-body">
      <input type="hidden" id="user_id" name="user_id" value="1"/>
         Enter name :<input type="text" class="form-control" name="name" id="name" placeholder="Name">
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        <button type="submit" class="btn btn-primary">Save changes</button>
      </div>
      </form>
    </div>

  </div>
</div>
</body>
</html>