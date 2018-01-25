$(function () {
    $("#studentGrid").jsGrid({
        height: "90%",
        width: "100%",

        filtering: true,
        editing: true,
        sorting: true,
        paging: false,
        autoload: true,

        rowClick: function(student) {
		    window.location.href = '/TG-Project/methodist/student/' + student.item.user.id
		},
        
        controller: {
            loadData: function (filter) {
                var deferred = $.Deferred();
                $.ajax({
                    url: '/TG-Project/methodist/students',
                    dataType: 'json',
                    data: filter
                }).done(function (data) {
                	data = $.grep(data, function(student) {
                        return (!filter.user.name || student.user.name.indexOf(filter.user.name) > -1)
                        && (!filter.user.email || student.user.email.indexOf(filter.user.email) > -1);
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
                    url: "/TG-Project/methodist/student",
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
                    url: "/TG-Project/methodist/student/" + item.student_id
                }).fail(function () {
                    WebUtils.show('Failed to delete!');
                });
            }

        },
        deleteConfirm: "Do you really want to delete this student?",
        fields: [
            {name: "user.name", type: "text", title: "Name", align: "left", width: 70, validate: "required"},
            {name: "user.email", type: "text",  title: "E-mail", align: "left", width: 100, validate: "required"},
            {name: "course", source: 'student-course', title: "Course", align: "center", width: 40, type: 'dictionary'},
            {name: "program", source: 'student-program', title: "Program", align: "center", width: 70, type: 'dictionary'},
            {type: "control", editButton: true, deleteButton: true, modeSwitchButton: false, clearFilterButton: true}
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
        id: 0,
        user: {
        		name: $("#student-name").val(),
        		email: $("#student-email").val() 
        },
        course: WebUtils.getItemByDomainAndId('student-course', $("#student-course").val()),
        program: WebUtils.getItemByDomainAndId('student-program', $("#student-program").val())
    };
    $.ajax({
        url: "/TG-Project/methodist/student",
        method: 'POST',
        data: JSON.stringify(item),
        contentType: "application/json; charset=utf-8",
        dataType: 'json'
    }).done(function (data) {
        $("#studentGrid").jsGrid("insertItem", data);
        $("#addDialog").modal("hide");
    }).fail(function () {
        WebUtils.show("Failed to create data!");
    });
}