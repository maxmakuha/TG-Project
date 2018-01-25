$.validator.addMethod("notEqualPasswords", function() {
	var newPassword = $("#profile-password").val();
	var confirmPassword = $("#profile-confirm").val();
	if (newPassword !== confirmPassword)
		return false;
	return true;
});

function updateVerify() {
	$('#profile').validate({
		rules : {
			'profile-email' : 'required',
			'profile-password' : {
				notEqualPasswords : true
			}
		},
		messages : {
			'profile-email' : 'Please enter your e-mail!',
			'profile-password' : 'Passwords do not match!'
		},
		submitHandler : function(form) {
			updateAction();
		}
	});
	$('#profile').submit();
}

// this is called in case of creating a new item
function updateAction() {
	var item = {
		id : id,
		role : roleId,
		name : $("#profile-name").val(),
		email : $("#profile-email").val(),
		mobile : $("#profile-mobile").val(),
		address : $("#profile-address").val(),
		comment : $("#profile-comment").val(),
		password : $("#profile-password").val()
	};
	$.ajax({
		url : "/TG-Project/methodist/teacher/" + id,
		method : 'PUT',
		data : JSON.stringify(item),
		contentType : "application/json; charset=utf-8",
		dataType : 'json'
	}).done(function(data) {
		WebUtils.show("Profile updated successfully!", "Success");
	}).fail(function() {
		WebUtils.show("Failed to create data!");
	});
}

function goBack() {
	window.history.back();
}

$(function () {
    $("#absenceGrid").jsGrid({
        height: "90%",
        width: "100%",

        filtering: true,
        editing: false,
        sorting: true,
        paging: false,
        autoload: true,

        controller: {
            loadData: function (filter) {
                var deferred = $.Deferred();
                $.ajax({
                    url: '/TG-Project/methodist/teacher/' + id + '/absences',
                    dataType: 'json',
                    data: filter
                }).done(function (data) {
                	data = $.grep(data, function(absence) {
                        return (!filter.comment || absence.comment.indexOf(filter.comment) > -1);
                    });
                    deferred.resolve(data);
                }).fail(function () {
                    WebUtils.show('Error to load data!');
                    deferred.reject("Loading error!");
                });
                return deferred.promise();
            },
        },
        fields: [
            {name: "day", source: 'absence-day', title: "Day", align: "center", width: 50, type: 'dictionary'},
            {name: "lesson", source: 'absence-lesson', title: "Lesson", align: "center", width: 70, type: 'dictionary'},
            {name: "comment", type: "text", title: "Comment", align: "left", width: 100},
            {type: "control", editButton: false, deleteButton: false, modeSwitchButton: false, clearFilterButton: true, width: 10}
        ]
    });
});

$("#tabs").tabs({
	  activate: function( event, ui ) {
		  $("#absenceGrid").jsGrid("loadData");
	}
});