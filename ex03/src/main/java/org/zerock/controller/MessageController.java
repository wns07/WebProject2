package org.zerock.controller;

import javax.inject.*;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.zerock.domain.*;
import org.zerock.service.*;

@RestController
@RequestMapping("/messages")
public class MessageController {
	@Inject
	private MessageService service;
	
	@RequestMapping(value="/", method=RequestMethod.POST)
	public ResponseEntity<String> addMessage(@RequestBody MessageVO vo) {
		ResponseEntity<String> entity = null;
		
		try {
			service.addMessage(vo);
			entity = new ResponseEntity<>("SUCCESS", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
}
