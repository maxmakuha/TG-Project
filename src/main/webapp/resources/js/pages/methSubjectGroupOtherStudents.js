$(function () {
    $("#groupOtherStudentsGrid").jsGrid({
        height: "50%",
        width: "100%",

        filtering: true,
        editing: true,
        sorting: true,
        paging: false,
        autoload: true,

        rowClick: function(student) {
        	var item = {
                    student : student.item.student_id,
                    group : groupId
                };
            $.ajax({
                url: "/TG-Project/methodist/subject/" + subjectId + "/group/" + groupId + "/student/" + student.item.student_id,
                method: 'POST',
                data: JSON.stringify(item),
                contentType: "application/json; charset=utf-8",
                dataType: 'json'
            }).done(function (data) {
            	$("#groupOtherStudentsGrid").jsGrid("loadData");
            	$("#groupStudentsGrid").jsGrid("loadData");
            }).fail(function () {
                WebUtils.show("Failed to create data!");
            });
		},
        
        controller: {
            loadData: function (filter) {
                var deferred = $.Deferred();
                $.ajax({
                    url: '/TG-Project/methodist/subject/' + subjectId + '/group/' + groupId + '/students/other',
                    dataType: 'json',
                    data: filter
                }).done(function (data) {
                	data = $.grep(data, function(stud) {
                        return (!filter.user.name || stud.user.name.indexOf(filter.user.name) > -1)
                        && (!filter.user.email || stud.user.email.indexOf(filter.user.email) > -1);
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
                    url: "/TG-Project/methodist/subject/" + subjectId + "/group/" + groupId + "/student/other",
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

        },
        fields: [
            {name: "user.name", type: "text", title: "Name", align: "left", width: 70, validate: "required"},
            {name: "user.email", type: "text",  title: "E-mail", align: "left", width: 100, validate: "required"},
            {name: "course", source: 'student-course', title: "Course", align: "center", width: 40, type: 'dictionary'},
            {name: "program", source: 'student-program', title: "Program", align: "center", width: 70, type: 'dictionary'},
            {type: "control", editButton: true, deleteButton: false, modeSwitchButton: false, clearFilterButton: true, width: 20}
        ]
    });
});

document.getElementById("groupOtherStudentsGrid").style.visibility = "hidden";

$('#accordion')
.on('shown.bs.collapse',
  function(e) {
    if (e.target.id == "collapse") {
      $('#groupOtherStudentsGrid').jsGrid('refresh');
      document.getElementById("groupOtherStudentsGrid").style.visibility = "visible";
    };
  });

$('#accordion')
.on('hidden.bs.collapse',
  function(e) {
    if (e.target.id == "collapse") {
      document.getElementById("groupOtherStudentsGrid").style.visibility = "hidden";
    };
  });