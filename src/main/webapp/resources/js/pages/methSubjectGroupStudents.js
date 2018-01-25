$(function () {
    $("#groupStudentsGrid").jsGrid({
        height: "50%",
        width: "100%",

        filtering: true,
        editing: true,
        sorting: true,
        paging: false,
        autoload: true,
        
        rowClick: function(stud) {
		    window.location.href = '/TG-Project/methodist/subject/' + subjectId + '/group/' + groupId + '/student/' + stud.item.student.user.id
		},

        controller: {
            loadData: function (filter) {
                var deferred = $.Deferred();
                $.ajax({
                    url: '/TG-Project/methodist/subject/' + subjectId + '/group/' + groupId + '/students',
                    dataType: 'json',
                    data: filter
                }).done(function (data) {
                	data = $.grep(data, function(stud) {
                        return (!filter.student.user.name || stud.student.user.name.indexOf(filter.student.user.name) > -1)
                        && (!filter.student.user.email || stud.student.user.email.indexOf(filter.student.user.email) > -1);
                    });
                    deferred.resolve(data);
                }).fail(function () {
                    WebUtils.show('Error to load data!');
                    deferred.reject("Loading error!");
                });
                return deferred.promise();
            },

            updateItem: function (item) {
                var deferred = $.Deferred();
                return $.ajax({
                    method: "PUT",
                    url: "/TG-Project/methodist/subject/" + subjectId + "/group/" + groupId + "/student",
                    data: JSON.stringify(item),
                    contentType: "application/json; charset=utf-8"
                }).done(function(){
                    deferred.resolve(item);
                }).fail(function () {
                    WebUtils.show('Failed to update!');
                    deferred.reject("Loading error!");
                });
                return deferred.promise();
            },

            deleteItem: function (item) {
                return $.ajax({
                    method: "DELETE",
                    url: "/TG-Project/methodist/subject/" + subjectId + "/group/" + groupId + "/student/" + item.student.student_id + "/" + groupId
                }).done(function(){
                	$("#groupOtherStudentsGrid").jsGrid("loadData");
                }).fail(function () {
                    WebUtils.show('Failed to delete!');
                });
            }

        },
        deleteConfirm: "Do you really want to delete this student from group?",
        fields: [
            {name: "student.user.name", type: "text", title: "Name", align: "left", width: 70, validate: "required"},
            {name: "student.user.email", type: "text",  title: "E-mail", align: "left", width: 100, validate: "required"},
            {name: "student.course", source: 'student-course', title: "Course", align: "center", width: 40, type: 'dictionary'},
            {name: "student.program", source: 'student-program', title: "Program", align: "center", width: 70, type: 'dictionary'},
            {type: "control", editButton: true, deleteButton: true, modeSwitchButton: false, clearFilterButton: true, width: 20}
        ]
    });
});

function onCreateVerify() {
    $('#new-student').validate({
        rules: {
            'student-name': 'required',
            'student-email': 'required'
        },
        messages: {
            'student-name': 'Please enter student name!',
            'student-email': 'Please enter student e-mail!'
        },
        submitHandler: function(form) {
            onCreateAction();
        }
    });
    $('#new-student').submit();
}

//this is called in case of creating a new item
function onCreateAction() {
    var item = {
        student : {
        	user : {
        		name: $("#student-name").val(),
        		email: $("#student-email").val()
        	},
        	course: WebUtils.getItemByDomainAndId('student-course', $("#student-course").val()),
            program: WebUtils.getItemByDomainAndId('student-program', $("#student-program").val())
        },
        group : groupId
    };
    $.ajax({
        url: "/TG-Project/methodist/subject/" + subjectId + "/group/" + groupId + "/student",
        method: 'POST',
        data: JSON.stringify(item),
        contentType: "application/json; charset=utf-8",
        dataType: 'json'
    }).done(function (data) {
        $("#groupStudentsGrid").jsGrid("insertItem", data);
        $("#addDialog").modal("hide");
    }).fail(function () {
        WebUtils.show("Failed to create data!");
    });
}

$("#tabs").tabs({
	  activate: function( event, ui ) {
		  $("#groupStudentsGrid").jsGrid("loadData");
	}
});