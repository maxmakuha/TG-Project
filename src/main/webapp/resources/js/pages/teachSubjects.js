$(function () {
    $("#subjectGrid").jsGrid({
        height: "90%",
        width: "100%",

        filtering: true,
        editing: false,
        sorting: true,
        paging: false,
        autoload: true,
        
        rowClick: function(subject) {
		    window.location.href = '/TG-Project/teacher/subject/' + subject.item.id + '/groups';
		},

        controller: {
            loadData: function (filter) {
                var deferred = $.Deferred();
                $.ajax({
                    url: '/TG-Project/teacher/subjects',
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

        },
        fields: [
            {name: "title", type: "text", title: "Title", align: "left", width: 100, validate: "required"},
            {name: "lectures", type: "number",  title: "Lectures Hours", align: "center", width: 40, validate: "required"},
            {name: "practices", type: "number",  title: "Practices Hours", align: "center", width: 40, validate: "required"},
            {name: "year", source: 'subject-year', title: "Year", align: "center", width: 40, type: 'dictionary'},
            {name: "program", source: 'subject-program', title: "Program", align: "center", width: 90, type: 'dictionary'},
            {name: "course", source: 'subject-course', title: "Course", align: "center", width: 60, type: 'dictionary'},
            {name: "semester", source: 'subject-semester', title: "Semester", align: "center", width: 40, type: 'dictionary'},
            {type: "control", editButton: false, deleteButton: false, modeSwitchButton: false, clearFilterButton: true, width: 30}
        ]
    });
});