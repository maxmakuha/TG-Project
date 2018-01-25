package ua.kiev.ukma.tg.service;

import java.security.Principal;

import ua.kiev.ukma.tg.model.Bug;

public interface SendBugService {
	
	void sendBug(Bug bug, Principal user);
	
}