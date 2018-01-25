$(function () {
    $("#teacherGrid").jsGrid({
        height: "90%",
        width: "100%",

        filtering: true,
        editing: true,
        sorting: true,
        paging: false,
        autoload: true,

        rowClick: function(teacher) {
		    window.location.href = '/TG-Project/methodist/teacher/' + teacher.item.id
		},
        
        controller: {
            loadData: function (filter) {
                var deferred = $.Deferred();
                $.ajax({
                    url: '/TG-Project/methodist/teachers',
                    dataType: 'json',
                    data: filter
                }).done(function (data) {
                	data = $.grep(data, function(teacher) {
                        return (!filter.name || teacher.name.indexOf(filter.name) > -1)
                        && (!filter.email || teacher.email.indexOf(filter.email) > -1) 
                        && (!filter.comment || teacher.comment.indexOf(filter.comment) > -1);
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
                    url: "/TG-Project/methodist/teacher",
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
                    url: "/TG-Project/methodist/teacher/" + item.id
                }).fail(function () {
                    WebUtils.show('Failed to delete!');
                });
            }

        },
        deleteConfirm: "Do you really want to delete this teacher?",
        fields: [
            {name: "name", type: "text", title: "Name", align: "left", width: 50, validate: "required"},
            {name: "email", type: "text",  title: "E-mail", align: "left", width: 60, validate: "required"},
            {name: "comment", type: "text",  title: "Comment", align: "left", width: 130, editing: false},
            {type: "control", editButton: true, deleteButton: true, modeSwitchButton: false, clearFilterButton: true}
        ]
    });
});

function onCreateVerify() {
    $('#new-teacher').validate({
        rules: {
            'teacher-name': 'required',
            'teacher-email': 'required'
        },
        messages: {
            'teacher-name': 'Please enter teacher name!',
            'teacher-email': 'Please enter teacher e-mail!'
        },
        submitHandler: function(form) {
            onCreateAction();
        }
    });
    $('#new-teacher').submit();
}

//this is called in case of creating a new item
function onCreateAction() {
    var item = {
        id: 0,
        name: $("#teacher-name").val(),
        email: $("#teacher-email").val()
    };
    $.ajax({
        url: "/TG-Project/methodist/teacher",
        method: 'POST',
        data: JSON.stringify(item),
        contentType: "application/json; charset=utf-8",
        dataType: 'json'
    }).done(function (data) {
        $("#teacherGrid").jsGrid("insertItem", data);
        $("#addDialog").modal("hide");
    }).fail(function () {
        WebUtils.show("Failed to create data!");
    });
}