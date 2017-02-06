package com.reklama;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.reklama.connection.DatabaseUtil;

/**
 * Servlet implementation class MyServlet
 */
@WebServlet("/MyServlet")
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter(); 
		PreparedStatement statement = DatabaseUtil.getStatement("SELECT * FROM bzvz");
		  ResultSet result;
		  out.print("<table class='table'>");
		  out.print("<tr class='success'>");
		  out.print("<td>");
		  out.print("ID");
		  out.print("</td>");
		  out.print("<td>");
		  out.print("NAME");
		  out.print("</td>");
		  out.print("<td>");
		  out.print("OPERATION");
		  out.print("</td>");
		  out.print("</tr>");
		try {
			result = statement.executeQuery();
			 while(result.next())
			  {
				/* String modal = "<div class='modal fade' id='myModal' tabindex='-1' role='dialog' aria-labelledby='myModalLabel'>" + 
  "<div class='modal-dialog' role='document'>" + 
    "<div class='modal-content'>" + 
      "<div class='modal-header'>" + 
        "<button type='button' class='close' data-dismiss='modal' aria-label='Close'><span aria-hidden='true'>&times;</span></button>" + 
        "<h4 class='modal-title' id='myModalLabel'>Modal title</h4>" + 
      "</div>" + 
      "<div class='modal-body'>" + 
         "Enter name :<input type='text' class='form-control' name='name' id='name' placeholder='Name'>" + 
     "</div>" + 
      "<div class='modal-footer'>" + 
        "<button type='button' class='btn btn-default' data-dismiss='modal'>Close</button>" + 
        "<button type='button' class='btn btn-primary' onclick='updateData(1)'>Save changes</button>" +
      "</div>" + 
    "</div>" +
  "</div>" + 
"</div>";*/
				  int id = result.getInt("id");
				  String name = result.getString("name");
				  out.print("<tr class='danger'>");
				  out.print("<td>");
				  out.print(id);
				  out.print("</td>");
				  out.print("<td>");
				  out.print(name);
				  out.print("</td>");
				  out.print("<td>");
				  out.print("<button type='button' class='glyphicon glyphicon-pencil' data-toggle='modal' data-target='#myModal'></button>");
				  out.print("</td>");
				  out.print("</tr>");
				  
				  out.print("");
			 
			  }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		out.print("</table>"); 
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter writer = response.getWriter();
		String name = request.getParameter("name");
		String sql = "INSERT INTO bzvz"
				+ "(name) VALUES"
				+ "(?)";
		PreparedStatement preparedStatement = DatabaseUtil.getInsertStatement(sql, Statement.RETURN_GENERATED_KEYS);
		try {
			preparedStatement.setString(1, name);
			preparedStatement.executeUpdate();
			writer.print("<div class='alert alert-success'> <strong>Success!</strong> Indicates a successful or positive action.</div>");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//writer.print("<div class='alert alert-success'> <strong>Success!</strong> Indicates a successful or positive action.</div>");
		}
	}
	
	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter writer = response.getWriter();
	
		
		BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));

		String data = br.readLine();
		
		/*String sql = "update bzvz set name = ? where id = ?";
		PreparedStatement preparedStmt = DatabaseUtil.getStatement(sql);
		try
	    {
	      // create a java mysql database connection
	    
	      // create the java mysql update preparedstatement
	     
	      preparedStmt.setString(1, name);
	      preparedStmt.setInt (2, id);
	      

	      // execute the java preparedstatement
	      preparedStmt.executeUpdate();
	      writer.print("Success call");
	      
	    }
	    catch (Exception e)
	    {
	      System.err.println("Got an exception! ");
	      System.err.println(e.getMessage());
	      
	    }
		*/
		writer.print(data.length());
		
		
	}

}
