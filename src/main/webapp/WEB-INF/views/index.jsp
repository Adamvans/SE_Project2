
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>SE_A2</title>
    <meta name="description" content="" />
    <script>
      

        var socket = new WebSocket("ws://localhost:8080/SE_Project2/WebSoc");
        
        socket.onmessage = function (event)  
        {
            
            var board = JSON.parse(event.data);
            var c = document.getElementById("myCanvas");
            var ctx = c.getContext("2d");
            
             if(board[0] === "update")
             {
                 for(var i = 0; i < 20; i++)
                {
                    for(var j = 0; j < 20; j++)
                    {
                        row = i * 10;
                        col = j * 10;
                        ctx.fillStyle= board[(i*20)+j+1];
                        ctx.fillRect(row, col, row + 10, row + 10);
                        ctx.rect(row, col, row + 10, col + 10);
                        ctx.stroke();
                    }
                }
            }
        };

        function send(xin,yin,scolor)
        {
            var corrds = {
                    action: "click",
                    x: xin,
                    y: yin,
                    color: scolor
                };
            socket.send(JSON.stringify(corrds)); //JSON.stringify(corrds)
        }
        
        function start() 
        {
            var toSend = {action: "start"};
            socket.send(JSON.stringify(toSend));
        }
        function stop() 
        {
            var toSend = {action: "stop"};
            socket.send(JSON.stringify(toSend));
        }
    </script>  
  </head>
  <body class="">
       
          

           <h1>Welcome to our software engineering project 2</h1>
          <button onclick="start()">start</button>
          <button onclick="stop()">stop</button>

          <h2><span id = "answer"></span><h2>
          
                 
          <select id="color">
              <option value="red">Red</option>
              <option value="yellow">Yellow</option>
              <option value="blue">Blue</option>

          </select>
              
                  </p>

        
         <br/>         
        <canvas id="myCanvas" width="200" height="200" style="border:1px solid #000000;">Your browser does not support the HTML5 canvas tag.</canvas>
<script>

       
        var l = document.getElementById("myCanvas");
        
        //var c = cp.value;
        
        
    
        
        l.addEventListener('click', function(e) 
        {
             var cp = document.getElementById("color").value;
            send(e.offsetX, e.offsetY, cp);
        }, false); 
    </script>
</body>
</html>
