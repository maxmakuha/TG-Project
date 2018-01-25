$.validator.addMethod("notEqualPasswords", function() {
	var newPassword = $("#profile-password").val();
	var confirmPassword = $("#profile-confirm").val();
	if (newPassword !== confirmPassword)
		return false;
	return true;
});

function updateVerify() {
	$('#profile').validate({
		rules : {
			'profile-email' : 'required',
			'profile-password' : {
				notEqualPasswords : true
			}
		},
		messages : {
			'profile-email' : 'Please enter your e-mail!',
			'profile-password' : 'Passwords do not match!'
		},
		submitHandler : function(form) {
			updateAction();
		}
	});
	$('#profile').submit();
}

// this is called in case of creating a new item
function updateAction() {
	var item = {
		id : id,
		role : roleId,
		name : $("#profile-name").val(),
		email : $("#profile-email").val(),
		mobile : $("#profile-mobile").val(),
		address : $("#profile-address").val(),
		comment : $("#profile-comment").val(),
		password : $("#profile-password").val()
	};
	$.ajax({
		url : "/TG-Project/profile",
		method : 'PUT',
		data : JSON.stringify(item),
		contentType : "application/json; charset=utf-8",
		dataType : 'json'
	}).done(function(data) {
		WebUtils.show("Profile updated successfully!", "Success");
		window.location.href = '/TG-Project/logout';
	}).fail(function() {
		WebUtils.show("Failed to create data!");
	});
}

function goBack() {
	window.history.back();
}