package ua.kiev.ukma.tg.controller.rest;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ua.kiev.ukma.tg.model.Bug;
import ua.kiev.ukma.tg.service.SendBugService;

@RestController
public class SendBugController {

	@Autowired
	private SendBugService sendBugService;

	@RequestMapping(value = "/bug", method = RequestMethod.POST, produces = "application/json")
	public void sendBug(@RequestBody Bug bug, Principal user) {
		sendBugService.sendBug(bug, user);
	}
}
