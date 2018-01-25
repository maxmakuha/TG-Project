$(function () {
    $("#absenceGrid").jsGrid({
        height: "90%",
        width: "100%",

        filtering: true,
        editing: true,
        sorting: true,
        paging: false,
        autoload: true,

        controller: {
            loadData: function (filter) {
                var deferred = $.Deferred();
                $.ajax({
                    url: '/TG-Project/teacher/absences',
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

            updateItem: function (item) {
                var deferred = $.Deferred();
                return $.ajax({
                    method: "PUT",
                    url: "/TG-Project/teacher/absence",
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
                    url: "/TG-Project/teacher/absence/" + item.id
                }).fail(function () {
                    WebUtils.show('Failed to delete!');
                });
            }

        },
        deleteConfirm: "Do you really want to delete this absence?",
        fields: [
            {name: "day", source: 'absence-day', title: "Day", align: "center", width: 40, type: 'dictionary'},
            {name: "lesson", source: 'absence-lesson', title: "Lesson", align: "center", width: 60, type: 'dictionary'},
            {name: "comment", type: "text", title: "Comment", align: "left", width: 100},
            {type: "control", editButton: false, deleteButton: true, modeSwitchButton: false, clearFilterButton: true, width: 20}
        ]
    });
});

function onCreateVerify() {
    $('#new-absence').validate({
        submitHandler: function(form) {
            onCreateAction();
        }
    });
    $('#new-absence').submit();
}

//this is called in case of creating a new item
function onCreateAction() {
    var item = {
        id: 0,
        day: WebUtils.getItemByDomainAndId('absence-day', $("#absence-day").val()),
        lesson: WebUtils.getItemByDomainAndId('absence-lesson', $("#absence-lesson").val()),
        comment: $("#absence-comment").val(),
        teacher: teacherId
    };
    $.ajax({
        url: "/TG-Project/teacher/absence",
        method: 'POST',
        data: JSON.stringify(item),
        contentType: "application/json; charset=utf-8",
        dataType: 'json'
    }).done(function (data) {
        $("#absenceGrid").jsGrid("insertItem", data);
        $("#addDialog").modal("hide");
    }).fail(function () {
        WebUtils.show("Failed to create data!");
    });
}