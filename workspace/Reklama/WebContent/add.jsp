<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
<script type="text/javascript">
function validate(val)
{
	if(val.length === 0)
	{
		return false;
	} else {
		return true;
	}
}
  function createData(name)
  {
	  $('#loading-image').show();
	  var name = $("#name").val();
	  if(validate(name))
	  {
		$.ajax({
				 url: "MyServlet",
				  type: "POST",
				  data: "name="+name,
				  success: function(data){
					 $("#errorField").html(data);
					 $("#name").val('');
					 
				  },
				  error: function() {
				    alert("BAD");
				  }
				});  
	  } else {
		  alert("Error");
	  }

  }
</script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" >

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container" id="errorField">

</div>
<div class="container">
<h1>Add page</h1>
</div>
<div class="container">
  <form action="MyServlet" method="post">
    <div class="form-group row">
      <label for="name" class="col-sm-2 col-form-label">Name</label>
      <div class="col-sm-10">
        <input type="text" class="form-control" name="name" id="name" placeholder="Name">
      </div>
    </div>
    <button type="button" class="btn btn-primary" onclick="createData()">Create</button>
  </form>
   
   <!-- onclick="createData()" -->
</div>
</body>
</html>