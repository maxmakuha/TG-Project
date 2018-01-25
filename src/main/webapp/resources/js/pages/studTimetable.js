$(document).ready(function() {
	$('#calendar').fullCalendar({
		header : {
			left : 'prev,next today',
			center : 'title',
			right : 'agendaWeek,agendaDay'
		},
		defaultView: 'agendaWeek',
		allDaySlot : false,
		slotDuration : '00:30:00',
		slotLabelInterval : 15,
		slotLabelFormat : [ ' ' ],
		columnFormat : [ 'dddd D/M', ],
		height : 'auto',
		minTime : '08:30',
		hiddenDays : [ 0 ],
		validRange: function() {
			var start;
			var end;
			if(timetableSemester == 1){
				start = timetableYear + '-09-01',
				end = timetableYear + '-12-31'
			}else if (timetableSemester == 2){
				start = timetableYear + '-01-15',
				end = timetableYear + '-05-15'
			}else if (timetableSemester == 3){
				start = timetableYear + '-05-15',
				end = timetableYear + '-07-01'
			}
			return{
	        start,
	        end
			};
	    },
	    events: function getPeriods(start, end, timezone, callback) {
	    	$.ajax({
	    		type:'GET',
	    		url : '/TG-Project/student/timetable/' + timetableId,
	    		dataType : 'json'
	    	}).done(function(data) {
	    		var events = [];
	    		data.forEach(function(item, i, data){
	    			var period = {
	    					id: data[i].id,
		    				title : data[i].group.number,
		    				start  : getStart(data[i]),
		    				end    : getEnd(data[i]),
		    	            color : getColor(data[i]),
		    	            audience_teacher: '(' + data[i].audience.number + ') ' + data[i].group.teacher.name,
		    	            audience: data[i].audience.number,
		    	            teacher: data[i].group.teacher.name,
		    	            className: 'test'
		    		};
	    			events.push(period);
	    		});
	    		callback(events);
	    	}).fail(function() {
	    		WebUtils.show('Error to load data!');
	    	});
	    },
	    eventRender: function(event, element) { 
            element.find('.fc-title').append("<br/>" + event.audience_teacher);
        }, 
	    eventAfterRender: function( event, element, view ) { 
	        var row = $(".fc-slats tr:contains('"+ moment(event.start).format('ha') + "')");
	        if (moment(event.start).format('mm') != '00')
	        {
	            row = row.next();
	        }
	        row.height(element.height()+row.height());
	    },
	    eventClick:  function(event, jsEvent, view) {
            $('#modalTitle').html(event.title);
            $("#startTime").html(moment(event.start).format('HH:mm MMM Do'));
            $("#endTime").html(moment(event.end).format('HH:mm MMM Do'));
            $("#audience").html(event.audience);
            $("#teacher").html(event.teacher);
            $('#periodId').html(event.id);
            $('#eventUrl').attr('href',event.url);
            $('#fullCalModal').modal();
        }
	})
});

function getStart(period) {
	var year = timetableYear;
	var month = period.month;
	var daytime = period.daytime;
	var periodBegin;
	if (period.lesson.id == 2){
		periodBegin = 'T08:30:00';
	} else if (period.lesson.id == 3){
		periodBegin = 'T10:00:00'
	} else if (period.lesson.id == 4){
		periodBegin = 'T11:40:00'
	} else if (period.lesson.id == 5){
		periodBegin = 'T13:30:00'
	} else if (period.lesson.id == 6){
		periodBegin = 'T15:00:00'
	} else if (period.lesson.id == 7){
		periodBegin = 'T16:30:00'
	}
	return year + '-' + month + '-' + daytime + periodBegin; 
};

function getEnd(period) {
	var year = timetableYear;
	var month = period.month;
	var daytime = period.daytime;
	var periodEnd;
	if (period.lesson.id == 2){
		periodEnd = 'T09:50:00';
	} else if (period.lesson.id == 3){
		periodEnd = 'T11:20:00'
	} else if (period.lesson.id == 4){
		periodEnd = 'T13:00:00'
	} else if (period.lesson.id == 5){
		periodEnd = 'T14:50:00'
	} else if (period.lesson.id == 6){
		periodEnd = 'T16:20:00'
	} else if (period.lesson.id == 7){
		periodEnd = 'T17:50:00'
	}
	return year + '-' + month + '-' + daytime + periodEnd; 
};

function getColor(period) {
	if (period.group.type.title === 'Лекція'){
		return 'blue';
	} else {
		return 'green';
	}
}