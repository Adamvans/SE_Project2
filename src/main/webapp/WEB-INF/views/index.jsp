<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>JavaSpringWebApp</title>
    <meta name="description" content="" />

    <spring:url value="/resources/gradients.css" var="gradientsCss" />
    <spring:url value="/resources/styles.css" var="stylesCss" />
    <spring:url value="/resources/set-background.js" var="setBackgroundJs" />
    <spring:url value="/resources/tweet.svg" var="tweetSvg" />

    <link href="${stylesCss}" rel="stylesheet">
    <link href="${gradientsCss}" rel="stylesheet">
    
    <script>
        var source = new EventSource("Count.java");
        source.onmessage = function(event) {
        document.getElementById("answer").innerHTML += event.data;
};
        
    </script>
  </head>
  <body class="">
          
          <h1>Congratulations!</h1>
          <h2>You just created a Java Spring web application.</h2>
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
