package com.yqz.webapp.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.Callable;
import java.util.function.Function;
import java.util.function.LongBinaryOperator;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.yqz.webapp.model.MyMessage;
import com.yqz.webapp.service.HelloService;

@RestController
@RequestMapping("/hello")
public class HelloController {
	private static Logger logger = LoggerFactory.getLogger(HelloController.class);
	@Resource
	private HelloService helloService;

	// @ExceptionHandler(Exception.class)
	@RequestMapping(value = "/sayHello", method = RequestMethod.GET)
	public MyMessage sayHello(@RequestParam(value = "message", defaultValue = "你好", required = false) String msg,
			Model model) {
		logger.info("** msg from requester is {} at {} ", msg, DateFormat.getInstance().format(new Date()));
		return helloService.sayHello(msg);

	}
	/*
	 * @RequestMapping("/msg") public MyMessage getMsg(){ return new
	 * MyMessage("no message." ); }
	 */

	@RequestMapping("date/{date}")
	public String date(@PathVariable Date date) {
		
		DateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return "input date is " + DateFormat.getDateInstance().format(date);
	}

	@RequestMapping("get")
	public String getById(@RequestParam int id) {
		return "input id is " + id;
	}

	@RequestMapping("/wait")
	public Callable<String> waits() {

		return new Callable<String>() {

			@Override
			public String call() throws Exception {
				Date d = Calendar.getInstance().getTime();
				Thread.sleep(5 * 1000); // 暂停两秒

				return String.format("wait for %s s",
						(Calendar.getInstance().getTime().getTime() - d.getTime()) / 1000);
			}
		};
	}

	/*
	 * @InitBinder // 必须有一个参数WebDataBinder public void
	 * initializeBinder(WebDataBinder binder) {
	 * binder.registerCustomEditor(Date.class, new CustomDateEditor(new
	 * SimpleDateFormat("yyyy-MM-dd"), false));
	 * binder.registerCustomEditor(int.class, new PropertyEditorSupport() {
	 * 
	 * @Override public String getAsText() { // TODO Auto-generated method stub
	 * return getValue().toString(); }
	 * 
	 * @Override public void setAsText(String text) throws
	 * IllegalArgumentException { System.out.println(text +
	 * "...........................................");
	 * setValue(Integer.parseInt(text)); }
	 * 
	 * }); }
	 */

	/*
	 * @ExceptionHandler(CustomGenericException.class) public ModelAndView
	 * handleCustomException(CustomGenericException ex) {
	 * 
	 * ModelAndView model = new ModelAndView("error/generic_error");
	 * model.addObject("errCode", ex.getErrCode()); model.addObject("errMsg",
	 * ex.getErrMsg());
	 * 
	 * return model;
	 * 
	 * }
	 */

	/*
	 * @ExceptionHandler(Exception.class) public ModelAndView
	 * handleAllException(Exception ex) {
	 * 
	 * ModelAndView model = new ModelAndView("error/generic_error");
	 * model.addObject("errMsg", "this is Exception.class");
	 * 
	 * return model;
	 * 
	 * }
	 */

}
