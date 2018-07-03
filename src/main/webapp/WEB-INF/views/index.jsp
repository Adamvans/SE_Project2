<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@page import="com.aws.codestar.projecttemplates.Count"%>
<%@page import="com.aws.codestar.projecttemplates.Board"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>SE_A2</title>
    <meta name="description" content="" />
   
    
    <%
        Count display= new Count();//Creating class Object
        display.addC();//Calling add Method
        int num = display.getCount();
        
        //Board temp = new Board();
    %>  
  </head>
  <body class="">
       
          
          <h1>Congratulations!</h1>
          <h2>Current date is: <%= new java.util.Date().toString() %></h2>
           <h2>Count: <%= num %><h2>
          <h2><span id = "answer"></span><h2>
                  
        </div>
      </div>
    </div>
        
        <canvas id="myCanvas" width="200" height="200" style="border:1px solid #000000;">
Your browser does not support the HTML5 canvas tag.</canvas>
    <script>
            var c = document.getElementById("myCanvas");
            var ctx = c.getContext("2d");

            for(var i = 0; i < 20; i++)
            {
                    for(var j = 0; j < 20; j++)
                {
                    row = i * 10;
                    col = j * 10;
                    ctx.rect(row, col, row + 10, col + 10);
                            ctx.stroke();
                }
            }
     </script>
</body>
</html>
