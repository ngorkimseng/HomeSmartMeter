<body onload="load();">
 <div class="row">
  <div class="col-md-4 text-center">
     <div class="well" id="abra"> </div>
      <br />
     </div>
    </div>
 <script type="text/javascript">
  //<button type="button" data-toggle="collapse" data-target=".navbar-collapse" class="navbar-toggle navbar-btn">Menu</button>
  load = function() {
   $.ajax({
    url : 'sourceload',
    type : 'POST',
    success : function(response) {

     data = response.data;
     console.log(data);
     for (i = 0; i < response.data.length; i++) {
      $("#abra").append(
        response.data[i].region_name
          + "<br> <h2> Room ID: "
          + response.data[i].room + "</h2>"
          + "<h3> Electricity: "
          + response.data[i].power + "</h3>"
          + "<h3> Water: "
          + response.data[i].water
          + " </h3> </div> <br>");
     }
    }
   });

  }
 </script>