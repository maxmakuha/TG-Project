package ua.kiev.ukma.tg.controller.rest;

import java.security.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ua.kiev.ukma.tg.model.User;
import ua.kiev.ukma.tg.service.UserService;

@RestController
public class ProfileController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/profile", method = RequestMethod.GET, produces = "application/json")
	public User getProfileInfo(Principal user) {
		return userService.getById(userService.getUserAuth(user.getName()).getId());
	}
	
	@RequestMapping(value = {"/methodist/teacher/{id}", "/methodist/student/{id}", "/methodist/subject/{subjectId}/group/{groupId}/student/{id}"}, method = RequestMethod.GET, produces = "application/json")
	public User methodistGetProfileInfo(@PathVariable int id) {
		return userService.getById(id);
	}

	@RequestMapping(value = "/profile", method = RequestMethod.PUT)
	public User updateProfile(@RequestBody User user, Principal principal) {
		userService.updateProfile(user, principal.getName());
		return user;
	}
	
	@RequestMapping(value = {"/methodist/teacher/{id}", "/methodist/student/{id}", "/methodist/subject/{subjectId}/group/{groupId}/student/{id}"}, method = RequestMethod.PUT)
	public User methodistUpdateProfile(@RequestBody User user, @PathVariable int id) {
		userService.updateProfile(user, userService.getById(id).getEmail());
		return user;
	}
}
