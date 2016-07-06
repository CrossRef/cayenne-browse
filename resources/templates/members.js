var timer = null;

$(document).ready(function() {
    $('#member-search-input').on('input', function(e) {
	clearTimeout(timer);
	setTimeout(function() {
	    var terms = $('#member-search-input').val();
	    $('#member-search-results').load('/members/search/' + terms);
	}, 1000);
    });
});
