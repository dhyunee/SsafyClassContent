package com.mycom.myapp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mycom.myapp.dto.EmpDto;

@Controller
public class ViewController {

	@GetMapping(value = "/viewTest1")
	public String viewTest1() {
		System.out.println("viewTest1");
		return "viewTest1";
	}

	@GetMapping(value = "/viewTest2")
	public String viewTest2() {
		System.out.println("viewTest2");
		return "sub/viewTest2";
	}

	// Model
	// addAttribute 이름 주의!
	@GetMapping(value = "/viewTest3")
	public String viewTest3(Model model) {
		model.addAttribute("seq", "12345");
		model.addAttribute("empDto", new EmpDto(3000, "gildong5", "Hong", "gildong@hong.ac,kr", "2022-10-06"));
		System.out.println("viewTest3");
		return "viewTest3";
	}

	// ModelAndView
	// addObject 이름 주의!
	@GetMapping(value = "/viewTest4")
	public ModelAndView viewTest4() {
		ModelAndView mav=new ModelAndView("viewTest4");//jsp이름을 생성자를 통해서도 가능
		//데이터 저장
		mav.addObject("seq","12345");
		mav.addObject("empDto", new EmpDto(3000, "gildong5", "Hong", "gildong@hong.ac,kr", "2022-10-06"));
		System.out.println("viewTest4");
		//jsp 지정
		//mav.setViewName("viewTest4");

		return mav;
	}
	
	//위의 과정은 forward의 내용
	
	//redirect
	@GetMapping("/redirect")
	public String redirect() {
		System.out.println("redirect");
		//return "viewTest1";
		return "redirect:/viewTest1";
	}
}
