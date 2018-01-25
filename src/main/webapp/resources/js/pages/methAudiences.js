$(function () {
    $("#audienceGrid").jsGrid({
        height: "90%",
        width: "100%",

        filtering: true,
        editing: true,
        sorting: true,
        paging: false,
        autoload: true,
        
        rowClick: function(audience) {
		    window.location.href = '/TG-Project/methodist/audience/' + audience.item.id + '/occupations';
		},

        controller: {
            loadData: function (filter) {
                var deferred = $.Deferred();
                $.ajax({
                    url: '/TG-Project/methodist/audiences',
                    dataType: 'json',
                    data: filter
                }).done(function (data) {
                	data = $.grep(data, function(audience) {
                        return (!filter.number || audience.number.indexOf(filter.number) > -1)
                        && (!filter.size || audience.size === filter.size);
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
                    url: "/TG-Project/methodist/audience",
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
                    url: "/TG-Project/methodist/audience/" + item.id
                }).fail(function () {
                    WebUtils.show('Failed to delete!');
                });
            }

        },
        deleteConfirm: "Do you really want to delete this audience?",
        fields: [
            {name: "number", type: "text", title: "Number", align: "center", width: 40, validate: "required"},
            {name: "size", type: "number",  title: "Size", align: "center", width: 40, validate: "required"},
            {name: "type", source: 'audience-type', title: "Type", align: "center", width: 70, type: 'dictionary'},
            {type: "control", editButton: true, deleteButton: true, modeSwitchButton: false, clearFilterButton: true}
        ]
    });
});

function onCreateVerify() {
    $('#new-audience').validate({
        rules: {
            'audience-number': 'required',
            'audience-size': 'required'
        },
        messages: {
            'audience-number': 'Please enter audience number!',
            'audience-size': 'Please enter audience size!'
        },
        submitHandler: function(form) {
            onCreateAction();
        }
    });
    $('#new-audience').submit();
}

//this is called in case of creating a new item
function onCreateAction() {
    var item = {
        id: 0,
        number: $("#audience-number").val(),
        size: $("#audience-size").val(),
        type: WebUtils.getItemByDomainAndId('audience-type', $("#audience-type").val())
    };
    $.ajax({
        url: "/TG-Project/methodist/audience",
        method: 'POST',
        data: JSON.stringify(item),
        contentType: "application/json; charset=utf-8",
        dataType: 'json'
    }).done(function (data) {
        $("#audienceGrid").jsGrid("insertItem", data);
        $("#addDialog").modal("hide");
    }).fail(function () {
        WebUtils.show("Failed to create data!");
    });
}