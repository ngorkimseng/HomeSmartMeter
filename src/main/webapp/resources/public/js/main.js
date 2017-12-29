// Add String format function to String objectß
if (!String.prototype.format) {
	String.prototype.format = function() {
		var args = arguments;
		return this.replace(/{(\d+)}/g, function(match, number) {
			return typeof args[number] != 'undefined' ? args[number] : match;
		});
	};
}

(function($) {
	var loadSourceFlag = false;
	var loadLocationFlag = false;
	var dashboard_card_template = '<div class="card-box">'
			+ '<div class="card-box__container">'
			+ '<div class="accommodation_name">'
			+ '<h3 class="title">'
			+ '<img class="icon accomm-icon" src="/SpringMVC_TilesGOGO11/resources/public/img/icons/svg/003-house.svg" alt=""> {0}'
			+ '</h3>' + '</div>' + '<div class="data_info">'
			+ '<div class="usage_item">' + '<span class="usage_title">'
			+ 'Electricity :' + '</span>' + '<span class="usage_total">'
			+ '{1} <i class="unit">kwh</i>' + '</span>' + '</div>'
			+ '<div class="usage_item">' + '<span class="usage_title">'
			+ 'Water : ' + '</span>' + '<span class="usage_total">'
			+ '{2} <i class="unit">m<sup>3</sup></i>' + '</span>' + '</div>'
			+ '</div>' + '</div>' + '</div>';

	var source_card_template = '<div class="card-box">'
			+ '<div class="card-box__container">'
			+ '<div class="action-box slideTop">'
			+ '<li class="action-item">'
			+ '<button class="action-btn delete-btn">'
			+ '<img src="/SpringMVC_TilesGOGO11/resources/public/img/icons/svg/001-delete-button.svg" class="action-icon"/>'
			+ '</button>'
			+ '</li>'
			+ '<li class="action-item">'
			+ '<button class="action-btn edit-btn">'
			+ '<img src="/SpringMVC_TilesGOGO11/resources/public/img/icons/svg/002-edit.svg" class="action-icon"/>'
			+ '</button>'
			+ '</li>'
			+ '</div>'
			+ '<div class="accommodation_name">'
			+ '<h3 class="title">'
			+ '<img class="icon accomm-icon" src="/SpringMVC_TilesGOGO11/resources/public/img/icons/svg/003-house.svg" alt="">'
			+ 'Room : {0}' + '</h3>' + '</div>' + '<div class="data_info">'
			+ '<div class="usage_item">' + '<span class="usage_title">'
			+ 'Electricity :' + '</span>' + '<span class="usage_total">'
			+ '{1} <i class="unit">kwh</i>' + '</span>' + '</div>'
			+ '<div class="usage_item">' + '<span class="usage_title">'
			+ 'Water : ' + '</span>' + '<span class="usage_total">'
			+ '{1} <i class="unit">m<sup>3</sup></i>' + '</span>' + '</div>'
			+ '</div>' + '</div>' + '</div>';

	var region_div_template = '<div class="card-box__outter uk-flex uk-flex-wrap uk-flex-wrap-around" id="{0}"></div>';

	$(window).on(
			'load',
			function() {
				$('.loading-spinner').addClass('active');
				$.ajax({
					url : 'dash',
					type : 'POST',
					method : 'POST',
					success : function(response) {
						$('.loading-spinner').removeClass('active');
						var data = response.data;
						console.log(data);
						for (var i = 0; i < data.length; i++) {
							var rendered_card = dashboard_card_template.format(
									data[i].region_name, data[i].power,
									data[i].water);
							$('#dashboardDiv').append(rendered_card);
						}
					},
					error : function(error) {
						console.log(error);
						alert('Error loading dashboard data.');
						$('.loading-spinner').removeClass('active');
					}
				});
			});

	var loadSourceData = function() {
		if (!loadSourceFlag) {
			$('.loading-spinner').addClass('active');
			$
					.ajax({
						url : 'sourceload',
						type : 'POST',
						method : 'POST',
						success : function(response) {
							$('.loading-spinner').removeClass('active');
							$('.accommodation_list').html('');
							$('#regionDiv').html('');
							var data = response.data;
							var uniqueRegion = {};
							console.log(response);
							for (var i = 0; i < data.length; i++) {
								var region_id = data[i].region_id, region_name = data[i].region_name, room = data[i].room, power = data[i].power, water = data[i].water;
								var regionDivID = "region-" + region_id;
								var regionLink = '<li><a href="#">'
										+ region_name + '</a></li>';
								if (!uniqueRegion.hasOwnProperty(region_id)) {
									uniqueRegion[region_id] = region_name;
									var regionDiv = region_div_template
											.format(regionDivID);

									$('.accommodation_list').append(regionLink);
									$('#regionDiv').append(regionDiv);
								}
								var rendered_card = source_card_template
										.format(room, power, water);
								$('#' + regionDivID).append(rendered_card);
							}

							loadSourceFlag = true;
						},
						error : function(error) {
							console.log(error);
							alert('Error loading source data.');
							$('.loading-spinner').removeClass('active');
						}
					});
		}
	}
	
	var getLocation = function() {
		if (!loadLocationFlag) {
			$.ajax({
				url : 'exportloc',
				type : 'POST',
				success : function(response) {
					data = response.data;
					console.log(data);
					var selected_val;
					$('.select_location').html('');
					var option_template = '<option value="{0}">{1}</option>';
					for (i = 0; i < data.length; i++) {
						$('.select_location').append(
								option_template.format(data[i].id, data[i].name));
						if (i == 0) {
							selected_val = data[i].id;
						}
					}
					$('.select_location').val(selected_val).change();
					loadLocationFlag = true;
				},
				error : function(error) {
					console.log('error loading location');
					alert("error loading location");
				}
			});
		}

	}

	$('#clearCacheSource').on('click', function(e) {
		loadSourceFlag = false;
		loadSourceData();
	});

	$('#sourceMenu').on('click', function(e) {
		e.preventDefault();
		loadSourceData();
	});

	$('#exportMenu, #eventMenu').on('click', function(e) {
		e.preventDefault();
		getLocation();
	});

	$('.select_location').on('change', function(e) {
		var location_id = $(this).val();
		$.ajax({
			url : 'exportreg',
			tranditional : true,
			type : 'GET',
			data : {
				"id" : location_id
			},
			success : function(response) {
				var data = response.data;
				var selected_val;
				console.log(data);
				$('.select_region').html('');
				$('.select_room').html('');
				var option_template = '<option value="{0}">{1}</option>';
				for (i = 0; i < data.length; i++) {
					$('.select_region').append(option_template.format(data[i].id, data[i].name));
					if (i == 0) {
						selected_val = data[i].id;
					}
				}

				$('.select_region').val(selected_val).change();
			}
		});
	});

	$('.select_region').on('change', function(e) {
		var region_id = $(this).val();
		$.ajax({
			url : 'exportroom',
			tranditional : true,
			type : 'GET',
			data : {
				"id" : region_id
			},
			success : function(response) {
				data = response.data;
				console.log(data);
				$('.select_room').html('');
				var option_template = '<option value="{0}">{1}</option>';
				for (i = 0; i < response.data.length; i++) {
					$('.select_room').append(
							option_template.format(
									data[i].id,
									data[i].id));
				}
			}
		});
	});

	$('#export_form').on(
			'submit',
			function(e) {
				e.preventDefault();
				var room_id = $('#export_room').val();
				console.log(room_id);

				var row_template = '<tr>' + '<td>{0}</td>' + '<td>{1}</td>'
						+ '<td>{2}</td>' + '<td>{3}</td>' + '</tr>';

				$.ajax({
					url : 'exportoutput',
					tranditional : true,
					type : 'POST',
					data : {
						"id" : room_id
					},
					success : function(response) {
						console.log(response);
						var data = response.data;
						console.log(data);
						$('#export_table').html('');
						$('#export_table').append(
								row_template.format(data.id, data.name,
										data.power, data.water));
					}
				})

			});

	$('.source #sidebarTrigger').on('click', function(e) {
		e.preventDefault();
		$('.source .sidebar').toggleClass('active');
	});

	$('.event #sidebarTrigger').on('click', function(e) {
		e.preventDefault();
		$('.event .sidebar').toggleClass('active');
	});

	$('#roomExportBtn').on('click', function(e) {
		e.preventDefault();
		$('#room_export_table').tableExport({
			type : 'pdf',
			jspdf : {
				orientation : 'l',
				format : 'a3',
				margins : {
					left : 10,
					right : 10,
					top : 20,
					bottom : 20
				},
				autotable : {
					styles : {
						fillColor : 'inherit',
						textColor : 'inherit'
					},
					tableWidth : 'auto'
				}
			}
		});
	});

})(jQuery);
