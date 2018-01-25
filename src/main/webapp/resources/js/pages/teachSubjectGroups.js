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
		    window.location.href = '/TG-Project/teacher/subject/' + subjectId + '/group/' + group.item.id + '/students';
		},
        
        controller: {
            loadData: function (filter) {
                var deferred = $.Deferred();
                $.ajax({
                    url: '/TG-Project/teacher/subject/' + subjectId + '/groups',
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
                    url: "/TG-Project/teacher/subject/" + subjectId + "/group",
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
            {name: "number", type: "text", title: "Number", align: "left", width: 80, validate: "required", editing: false},
            {name: "size", type: "number",  title: "Size", align: "center", width: 40, validate: "required", editing: false},
            {name: "type", source: 'group-type', title: "Type", align: "center", width: 50, type: "dictionary", editing: false},
            {name: "audienceType", source: 'group-audience', title: "Audience Type", align: "center", width: 80, type: "dictionary"},
            {type: "control", editButton: true, deleteButton: false, modeSwitchButton: false, clearFilterButton: true, width: 10}
        ]
    });
});