 <body onload="load();">
	<form action="exportoutput?room=rroom" method="POST">   <!--   -->
		Location: <select id="locate">
			<option></option>
		</select> <br> Region: <select id="reg">
			<option></option>
		</select> <br> Room ID: <select id="room" name="rroom">
			<option></option>
		</select> <br> From: <input type="date" name="from"> Until: <input
			type="date" name="until"> <br>
		<button onclick="submit()">Submit</button> <!-- name="submit" value="Submit" -->
	</form>
	<script type="text/javascript">
		load = function() {
			$.ajax({
				url : 'exportloc',
				type : 'POST',
				success : function(response) {
					data = response.data;
					console.log(data);
					var option ='';
					for (i = 0; i < response.data.length; i++) {
						
								option = option + "<option value="+data[i].id+">" + data[i].name
										+ "</option>";
					}
					document.getElementById('locate').innerHTML = option;
				}
			});

			$('#locate').change(
					function() {
						console.log($(this).data());
						var id = $(this).val();
						console.log(id);
						$.ajax({
							url : 'exportreg',
							tranditional : true,
							type : 'GET',
							data : {"id":id},
							success : function(response) {
								data = response.data;
								console.log(data);
 								 $('#reg')
								.find('option')
								.remove()
								.end();  
								var option = '';
								for (i = 0; i < response.data.length; i++) {
										option = option + "<option value="+data[i].id+">"
													+ data[i].name
													+ "</option>";
								}
								document.getElementById('reg').innerHTML = option;
							}
						});
					});
			
			$('#reg').change(
					function() {
						console.log($(this).data());
						var id = $(this).val();
						console.log(id);
						$.ajax({
							url : 'exportroom',
							tranditional : true,
							type : 'GET',
							data : {"id":id},
							success : function(response) {
								data = response.data;
								console.log(data);
 								 $('#room')
								.find('option')
								.remove()
								.end(); 
								var option = '';
								for (i = 0; i < response.data.length; i++) {
										option = option + "<option value="+data[i].id+">"
													+ data[i].id
													+ "</option>";
								}
								document.getElementById('room').innerHTML = option;
							}
						});
					});
			/* submit = function() {
				$.ajax({
					url : 'exportoutput',
					data : {"id":id},
					type : 'POST',
					success : function(response) {
						data = response.data;
						console.log(data);
						for (i = 0; i < response.data.length; i++) {				
								$("#result").append(response.data[i].id+"<tr> <td>"+response.data[i].power+"</td>"+"<td>"+response.data[i].water+" </td> <tr>");
							}
					}
				});
			} */
		}


	</script> 