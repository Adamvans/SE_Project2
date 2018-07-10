
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>SE_A2</title>
    <meta name="description" content="" />
    <script>
        var socket = new WebSocket("ws://localhost:8080/SE_Project2/Count");


        socket.onmessage = function (event) 
        {
             document.getElementById("answer").innerHTML += "Count: " + event.data;
        };

        function test() 
        {
            document.getElementById("answer").innerHTML += "<br>" + "sending data";
            socket.send("test");
        }


        document.getElementById("answer").innerHTML += "<br> onload";
        
    </script>  
  </head>
  <body class="">
       
          
          <h1>Congratulations! It's Alive</h1>
          <h2>Current date is: <%= new java.util.Date().toString() %></h2>
          <h2><span id = "answer"></span><h2>
                  
        </div>
      </div>
    </div>
        
        <canvas id="myCanvas" width="200" height="200" style="border:1px solid #000000;">
Your browser does not support the HTML5 canvas tag.</canvas>
    <script>
            var c = document.getElementById("myCanvas");
            var ctx = c.getContext("2d");
            var rects = [];

            for(var i = 0; i < 20; i++)
            {
                    for(var j = 0; j < 20; j++)
                {
                    row = i * 10;
                    col = j * 10;
                    ctx.rect(row, col, row + 10, col + 10);
                    ctx.stroke();
                    rects.push({x: row, y: col, w: 10, h: 10});
                }
            }
            
            // get canvas element.

            function collides(rects, x, y) 
            {
                var isCollision = false;
                for (var i = 0, len = rects.length; i < len; i++) 
                {
                    var left = rects[i].x, right = rects[i].x+rects[i].w;
                    var top = rects[i].y, bottom = rects[i].y+rects[i].h;
                    
                    if (right >= x && left <= x && bottom >= y && top <= y) 
                    {
                        isCollision = rects[i];
                    }
                }
                return isCollision;
            } 
            
            // listener, using W3C style for example    
            c.addEventListener('click', function(e) 
            {
                document.getElementById("answer").innerHTML += '<br>' + 'click: ' + e.offsetX + '/' + e.offsetY;
                var rect = collides(rects, e.offsetX, e.offsetY);
                if (rect) 
                {
                    //document.getElementById("answer").innerHTML += '<br>' + 'collision: ' + rect.x + '/' + rect.y;
                    ctx.fillRect(rect.x, rect.y, rect.w, rect.h);
                    
                } 
                else 
                {
                    //document.getElementById("answer").innerHTML += '<br>' + 'no collision';
                }
            }, false);    
     </script>
</body>
</html>
