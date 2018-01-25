$(function () {
    $("#groupRhythmGrid").jsGrid({
        height: "90%",
        width: "60%",

        filtering: false,
        editing: false,
        sorting: false,
        paging: false,
        autoload: true,

        controller: {
            loadData: function (filter) {
                var deferred = $.Deferred();
                $.ajax({
                    url: '/TG-Project/teacher/subject/' + subjectId + '/group/' + groupId + '/rhythms',
                    dataType: 'json',
                    data: filter
                }).done(function (data){
                    deferred.resolve(data);
                }).fail(function () {
                    WebUtils.show('Error to load data!');
                    deferred.reject("Loading error!");
                });
                return deferred.promise();
            },
            
            deleteItem: function (item) {
                return $.ajax({
                    method: "DELETE",
                    url: "/TG-Project/teacher/subject/" + subjectId + "/group/" + groupId + "/rhythm/" + item.id
                }).fail(function () {
                    WebUtils.show('Failed to delete!');
                });
            }

        },
        deleteConfirm: "Do you really want to delete this rhythm?",
        fields: [
        	{name: "week", source: 'rhythm-week', title: "", align: "center", width: 40, type: 'dictionary'},
            {type: "control", editButton: false, deleteButton: true, modeSwitchButton: false, clearFilterButton: true, width: 20}
        ]
    });
});

function onCreateVerify() {
    $('#new-rhythm').validate({
        submitHandler: function(form) {
            onCreateAction();
        }
    });
    $('#new-rhythm').submit();
}

//this is called in case of creating a new item
function onCreateAction() {
    var item = {
        id: 0,
        week: WebUtils.getItemByDomainAndId('rhythm-week', $("#rhythm-week").val()),
        group: groupId
    };
    $.ajax({
        url: "/TG-Project/teacher/subject/" + subjectId + "/group/" + groupId + "/rhythm",
        method: 'POST',
        data: JSON.stringify(item),
        contentType: "application/json; charset=utf-8",
        dataType: 'json'
    }).done(function (data) {
        $("#groupRhythmGrid").jsGrid("insertItem", data);
        $("#addDialog").modal("hide");
        $("#groupRhythmGrid").jsGrid("loadData");
    }).fail(function () {
        WebUtils.show("Failed to create data!");
    });
}
$("#tabs").tabs({
	  activate: function( event, ui ) {
		  $("#groupRhythmGrid").jsGrid("loadData");
	}
});