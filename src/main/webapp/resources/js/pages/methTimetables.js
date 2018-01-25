$(function () {
    $("#timetableGrid").jsGrid({
        height: "90%",
        width: "100%",

        filtering: true,
        editing: true,
        sorting: true,
        paging: false,
        autoload: true,
        
        rowClick: function(subject) {
		    window.location.href = '/TG-Project/methodist/timetable/' + subject.item.id;
		},

        controller: {
            loadData: function (filter) {
                var deferred = $.Deferred();
                $.ajax({
                    url: '/TG-Project/methodist/timetables',
                    dataType: 'json',
                    data: filter
                }).done(function (data) {
                	data = $.grep(data, function(timetable) {
                        return (!filter.title || timetable.title.indexOf(filter.title) > -1);
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
                    url: "/TG-Project/methodist/timetable",
                    data: JSON.stringify(item),
                    contentType: "application/json; charset=utf-8"
                }).done(function(){
                    deferred.resolve(item);
                    $("#timetableGrid").jsGrid("loadData");
                }).fail(function () {
                    WebUtils.show('Failed to update!');
                    deferred.reject("Loading error!");
                });
                return deferred.promise();
            },

            deleteItem: function (item) {
                return $.ajax({
                    method: "DELETE",
                    url: "/TG-Project/methodist/timetable/" + item.id
                }).fail(function () {
                    WebUtils.show('Failed to delete!');
                });
            }

        },
        deleteConfirm: "Do you really want to delete this timetable?",
        fields: [
            {name: "title", type: "text", title: "Title", align: "left", width: 100, validate: "required"},
            {name: "year", source: 'timetable-year', title: "Year", align: "center", width: 40, type: 'dictionary'},
            {name: "program", source: 'timetable-program', title: "Program", align: "center", width: 90, type: 'dictionary'},
            {name: "course", source: 'timetable-course', title: "Course", align: "center", width: 60, type: 'dictionary'},
            {name: "semester", source: 'timetable-semester', title: "Semester", align: "center", width: 40, type: 'dictionary'},
            {type: "control", editButton: true, deleteButton: true, modeSwitchButton: false, clearFilterButton: true}
        ]
    });
});

function onCreateVerify() {
    $('#new-timetable').validate({
        rules: {
            'timetable-title': 'required'
        },
        messages: {
            'timetable-title': 'Please enter timetable title!'
        },
        submitHandler: function(form) {
            onCreateAction();
        }
    });
    $('#new-timetable').submit();
}

//this is called in case of creating a new item
function onCreateAction() {
    var item = {
        id: 0,
        title: $("#timetable-title").val(),
        year: WebUtils.getItemByDomainAndId('timetable-year', $("#timetable-year").val()),
        program: WebUtils.getItemByDomainAndId('timetable-program', $("#timetable-program").val()),
        course: WebUtils.getItemByDomainAndId('timetable-course', $("#timetable-course").val()),
        semester: WebUtils.getItemByDomainAndId('timetable-semester', $("#timetable-semester").val())
    };
    $.ajax({
        url: "/TG-Project/methodist/timetable",
        method: 'POST',
        data: JSON.stringify(item),
        contentType: "application/json; charset=utf-8",
        dataType: 'json'
    }).done(function (data) {
        $("#timetableGrid").jsGrid("insertItem", data);
        $("#addDialog").modal("hide");
        $("#timetableGrid").jsGrid("loadData");
    }).fail(function () {
        WebUtils.show("Failed to create data!");
    });
}