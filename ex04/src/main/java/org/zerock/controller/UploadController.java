package org.zerock.controller;

import org.slf4j.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@Controller
public class UploadController {
	private static final Logger logger = LoggerFactory.getLogger(UploadController.class);
	
	@RequestMapping(value="/uploadForm", method=RequestMethod.GET)
	public void uploadForm() {
		
	}
}
