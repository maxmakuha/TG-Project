$(function () {
    $("#timetableGrid").jsGrid({
        height: "90%",
        width: "100%",

        filtering: true,
        editing: false,
        sorting: true,
        paging: false,
        autoload: true,
        
        rowClick: function(subject) {
		    window.location.href = '/TG-Project/teacher/timetable/' + subject.item.id;
		},

        controller: {
            loadData: function (filter) {
                var deferred = $.Deferred();
                $.ajax({
                    url: '/TG-Project/teacher/timetables',
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
        },
        
        fields: [
            {name: "title", type: "text", title: "Title", align: "left", width: 100, validate: "required"},
            {name: "year", source: 'timetable-year', title: "Year", align: "center", width: 40, type: 'dictionary'},
            {name: "program", source: 'timetable-program', title: "Program", align: "center", width: 90, type: 'dictionary'},
            {name: "course", source: 'timetable-course', title: "Course", align: "center", width: 60, type: 'dictionary'},
            {name: "semester", source: 'timetable-semester', title: "Semester", align: "center", width: 40, type: 'dictionary'},
            {type: "control", editButton: false, deleteButton: false, modeSwitchButton: false, clearFilterButton: true, width: 10}
        ]
    });
});