package com.mycom.myapp.Controller;

import java.util.*;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AptController {
	//매물 등록
	@PostMapping("/board")
	public void properShow(AptDto aptDto) {
		
	}
	//list
	@GetMapping("/board")
	public List<AptDto> boardList() {
		
	}
	//상세
	@GetMapping("/board/{aptNo}")
	public void List(@PathVariable int aptNo) {
		
	}
	//검색
	@PutMapping("/board/{str}")
	public void Search(@PathVariable String str) {
		
	}
}
