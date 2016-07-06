$(document).ready(function () {
    var doisByYearData = {
	labels: {{member.breakdowns.dois-by-issued-year|mapnth:0|json|safe}},
	datasets: [
	    {
		data: {{member.breakdowns.dois-by-issued-year|mapnth:1|json|safe}}
	    }
	]
    }

    var doisByYearBarChart = new Chart($('#dois-by-year-bar-chart'), {
	type: 'bar',
	data: doisByYearData,
    });
    
    var doisByTypeData = {
	labels: {{types|keys|json|safe}},
	datasets: [
	    {
		data: {{types|vals|json|safe}}
	    }
	]
    }
    
    var doisByTypeData = new Chart($('#dois-by-type-bar-chart'), {
	type: 'bar',
	data: doisByTypeData
    });
});
