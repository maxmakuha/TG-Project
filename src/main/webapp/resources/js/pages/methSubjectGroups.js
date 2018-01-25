$(function () {
    $("#groupGrid").jsGrid({
        height: "90%",
        width: "100%",

        filtering: true,
        editing: true,
        sorting: true,
        paging: false,
        autoload: true,
        
        rowClick: function(group) {
		    window.location.href = '/TG-Project/methodist/subject/' + subjectId + '/group/' + group.item.id + '/students';
		},

        controller: {
            loadData: function (filter) {
                var deferred = $.Deferred();
                $.ajax({
                    url: '/TG-Project/methodist/subject/' + subjectId + '/groups',
                    dataType: 'json',
                    data: filter
                }).done(function (data) {
                	data = $.grep(data, function(group) {
                        return (!filter.number || group.number.indexOf(filter.number) > -1)
                        && (!filter.size || group.size === filter.size);
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
                    url: "/TG-Project/methodist/subject/" + subjectId + "/group",
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
                    url: "/TG-Project/methodist/subject/" + subjectId + "/group/" + item.id
                }).fail(function () {
                    WebUtils.show('Failed to delete!');
                });
            }

        },
        deleteConfirm: "Do you really want to delete this group?",
        fields: [
            {name: "number", type: "text", title: "Number", align: "left", width: 80, validate: "required"},
            {name: "size", type: "number",  title: "Size", align: "center", width: 40, validate: "required"},
            {name: "type", source: 'group-type', title: "Type", align: "center", width: 50, type: "dictionary"},
            {name: "teacher", source: 'group-teacher', title: "Teacher", align: "center", width: 80, type: "dictionary",  textField: "name"},
            {name: "audienceType", source: 'group-audience', title: "Audience Type", align: "center", width: 80, type: "dictionary"},
            {type: "control", editButton: true, deleteButton: true, modeSwitchButton: false, clearFilterButton: true}
        ]
    });
});

function onCreateVerify() {
    $('#new-group').validate({
        rules: {
            'group-number': 'required',
            'group-size': 'required'
        },
        messages: {
            'group-number': 'Please enter group number!',
            'group-size': 'Please enter group size!'
        },
        submitHandler: function(form) {
            onCreateAction();
        }
    });
    $('#new-group').submit();
}

//this is called in case of creating a new item
function onCreateAction() {
    var item = {
        id: 0,
        number: $("#group-number").val(),
        size: $("#group-size").val(),
        type: WebUtils.getItemByDomainAndId('group-type', $("#group-type").val()),
        teacher: WebUtils.getItemByDomainAndId('group-teacher', $("#group-teacher").val()),
        audienceType: WebUtils.getItemByDomainAndId('group-audience', $("#group-audience").val()),
        subject: subjectId
    };
    $.ajax({
        url: "/TG-Project/methodist/subject/" + subjectId + "/group",
        method: 'POST',
        data: JSON.stringify(item),
        contentType: "application/json; charset=utf-8",
        dataType: 'json'
    }).done(function (data) {
        $("#groupGrid").jsGrid("insertItem", data);
        $("#addDialog").modal("hide");
    }).fail(function () {
        WebUtils.show("Failed to create data!");
    });
}