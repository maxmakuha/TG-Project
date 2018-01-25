$(function () {
    $("#subjectGrid").jsGrid({
        height: "90%",
        width: "100%",

        filtering: true,
        editing: true,
        sorting: true,
        paging: false,
        autoload: true,
        
        rowClick: function(subject) {
		    window.location.href = '/TG-Project/methodist/subject/' + subject.item.id + '/groups';
		},

        controller: {
            loadData: function (filter) {
                var deferred = $.Deferred();
                $.ajax({
                    url: '/TG-Project/methodist/subjects',
                    dataType: 'json',
                    data: filter
                }).done(function (data) {
                	data = $.grep(data, function(subject) {
                        return (!filter.title || subject.title.indexOf(filter.title) > -1)
                        && (!filter.lectures || subject.lectures === filter.lectures)
                        && (!filter.practices || subject.practices === filter.practices);
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
                    url: "/TG-Project/methodist/subject",
                    data: JSON.stringify(item),
                    contentType: "application/json; charset=utf-8"
                }).done(function(){
                    deferred.resolve(item);
                    $("#subjectGrid").jsGrid("loadData");
                }).fail(function () {
                    WebUtils.show('Failed to update!');
                    deferred.reject("Loading error!");
                });
                return deferred.promise();
            },

            deleteItem: function (item) {
                return $.ajax({
                    method: "DELETE",
                    url: "/TG-Project/methodist/subject/" + item.id
                }).fail(function () {
                    WebUtils.show('Failed to delete!');
                });
            }

        },
        deleteConfirm: "Do you really want to delete this subject?",
        fields: [
            {name: "title", type: "text", title: "Title", align: "left", width: 100, validate: "required"},
            {name: "lectures", type: "number",  title: "Lectures Hours", align: "center", width: 40, validate: "required"},
            {name: "practices", type: "number",  title: "Practices Hours", align: "center", width: 40, validate: "required"},
            {name: "year", source: 'subject-year', title: "Year", align: "center", width: 40, type: 'dictionary'},
            {name: "program", source: 'subject-program', title: "Program", align: "center", width: 90, type: 'dictionary'},
            {name: "course", source: 'subject-course', title: "Course", align: "center", width: 60, type: 'dictionary'},
            {name: "semester", source: 'subject-semester', title: "Semester", align: "center", width: 40, type: 'dictionary'},
            {type: "control", editButton: true, deleteButton: true, modeSwitchButton: false, clearFilterButton: true}
        ]
    });
});

function onCreateVerify() {
    $('#new-subject').validate({
        rules: {
            'subject-title': 'required',
            'subject-lectures': 'required',
            'subject-practices': 'required'
        },
        messages: {
            'subject-title': 'Please enter subject title!',
            'subject-lectures': 'Please enter amount of lectures hours!',
            'subject-practices': 'Please enter amount of practices hours!'
        },
        submitHandler: function(form) {
            onCreateAction();
        }
    });
    $('#new-subject').submit();
}

//this is called in case of creating a new item
function onCreateAction() {
    var item = {
        id: 0,
        title: $("#subject-title").val(),
        lectures: $("#subject-lectures").val(),
        practices: $("#subject-practices").val(),
        year: WebUtils.getItemByDomainAndId('subject-year', $("#subject-year").val()),
        program: WebUtils.getItemByDomainAndId('subject-program', $("#subject-program").val()),
        course: WebUtils.getItemByDomainAndId('subject-course', $("#subject-course").val()),
        semester: WebUtils.getItemByDomainAndId('subject-semester', $("#subject-semester").val())
    };
    $.ajax({
        url: "/TG-Project/methodist/subject",
        method: 'POST',
        data: JSON.stringify(item),
        contentType: "application/json; charset=utf-8",
        dataType: 'json'
    }).done(function (data) {
        $("#subjectGrid").jsGrid("insertItem", data);
        $("#addDialog").modal("hide");
        $("#subjectGrid").jsGrid("loadData");
    }).fail(function () {
        WebUtils.show("Failed to create data!");
    });
}