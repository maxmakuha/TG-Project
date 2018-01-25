$(function () {
    $("#occupationGrid").jsGrid({
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
                    url: '/TG-Project/methodist/audience/' + audienceId + '/occupations',
                    dataType: 'json',
                    data: filter
                }).done(function (data) {
                	data = $.grep(data, function(occupation) {
                        return (!filter.comment || occupation.comment.indexOf(filter.comment) > -1);
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
                    url: "/TG-Project/methodist/audience/" + audienceId + "/occupation",
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
                    url: "/TG-Project/methodist/audience/" + audienceId + "/occupation/" + item.id
                }).fail(function () {
                    WebUtils.show('Failed to delete!');
                });
            }

        },
        deleteConfirm: "Do you really want to delete this occupation?",
        fields: [
            {name: "day", source: 'occupation-day', title: "Day", align: "center", width: 40, type: 'dictionary'},
            {name: "lesson", source: 'occupation-lesson', title: "Lesson", align: "center", width: 60, type: 'dictionary'},
            {name: "comment", type: "text", title: "Comment", align: "left", width: 100},
            {type: "control", editButton: false, deleteButton: true, modeSwitchButton: false, clearFilterButton: true, width: 20}
        ]
    });
});

function onCreateVerify() {
    $('#new-occupation').validate({
        submitHandler: function(form) {
            onCreateAction();
        }
    });
    $('#new-occupation').submit();
}

//this is called in case of creating a new item
function onCreateAction() {
    var item = {
        id: 0,
        day: WebUtils.getItemByDomainAndId('occupation-day', $("#occupation-day").val()),
        lesson: WebUtils.getItemByDomainAndId('occupation-lesson', $("#occupation-lesson").val()),
        comment: $("#occupation-comment").val(),
        audience: audienceId
    };
    $.ajax({
        url: "/TG-Project/methodist/audience/" + audienceId + "/occupation",
        method: 'POST',
        data: JSON.stringify(item),
        contentType: "application/json; charset=utf-8",
        dataType: 'json'
    }).done(function (data) {
        $("#occupationGrid").jsGrid("insertItem", data);
        $("#addDialog").modal("hide");
    }).fail(function () {
        WebUtils.show("Failed to create data!");
    });
}