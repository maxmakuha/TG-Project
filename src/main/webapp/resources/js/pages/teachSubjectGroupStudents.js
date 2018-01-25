$(function () {
    $("#groupStudentsGrid").jsGrid({
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
                    url: '/TG-Project/teacher/subject/' + subjectId + '/group/' + groupId + '/students',
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
        },
        fields: [
            {name: "student.user.name", type: "text", title: "Name", align: "left", width: 70, validate: "required"},
            {name: "student.user.email", type: "text",  title: "E-mail", align: "left", width: 100, validate: "required"},
            {name: "student.course", source: 'student-course', title: "Course", align: "center", width: 40, type: 'dictionary'},
            {name: "student.program", source: 'student-program', title: "Program", align: "center", width: 70, type: 'dictionary'},
            {type: "control", editButton: false, deleteButton: false, modeSwitchButton: false, clearFilterButton: true, width: 10}
        ]
    });
});

$("#tabs").tabs({
	  activate: function( event, ui ) {
		  $("#groupStudentsGrid").jsGrid("loadData");
	}
});