$(document).ready(function() {
	registerSearch();
});

function registerSearch() {
	$("#search").submit(function(ev){
		event.preventDefault();
		$.get($(this).attr('action'), {book: $("#q").val()}, function(data) {
			var template = $('#resultTpl').html();
			var rendered = Mustache.to_html(template, data)
			$("#resultsBlock").empty().append(rendered);
		});	
	});
}

