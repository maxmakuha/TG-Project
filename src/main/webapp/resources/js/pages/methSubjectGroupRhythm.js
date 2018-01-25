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
                    url: '/TG-Project/methodist/subject/' + subjectId + '/group/' + groupId + '/rhythms',
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
        },
        
        fields: [
        	{name: "week", source: 'rhythm-week', title: "", align: "center", width: 40, type: 'dictionary'}
        ]
    });
});

$("#tabs").tabs({
	  activate: function( event, ui ) {
		  $("#groupRhythmGrid").jsGrid("loadData");
	}
});