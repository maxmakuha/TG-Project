function sendReport() {
    var report = {
        title: $("#report-title").val(),
        body: $("#report-description").val(),
   };
    $.ajax({
        url: "/TG-Project/bug",
        method: 'POST',
        data: JSON.stringify(report),
        contentType: "application/json; charset=utf-8"
       
    }).done(function (data) {
        $("#reportBugDialog").modal("hide");
    }).fail(function () {
        WebUtils.show("Failed to create report");
    });
}