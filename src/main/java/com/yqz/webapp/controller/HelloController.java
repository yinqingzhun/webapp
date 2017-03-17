package com.yqz.webapp.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.Callable;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yqz.webapp.model.MyMessage;
import com.yqz.webapp.service.HelloService;

@RestController
@RequestMapping("/hello")
public class HelloController {
	private static Logger logger = LoggerFactory.getLogger(HelloController.class);
	@Resource
	private HelloService helloService;

	@GetMapping
	public MyMessage sayHello(@RequestParam(value = "message", defaultValue = "你好", required = false) String msg,
			Model model) {
		logger.info("   msg from requester is {} at {} ", msg, DateFormat.getInstance().format(new Date()));
		return helloService.sayHello(msg);

	}

	@RequestMapping(value = "/addMessage", method = RequestMethod.POST)
	public MyMessage AddMessage(@RequestBody MyMessage msg) {
		// save message to database
		return msg;
	}

	@RequestMapping(value = { "/msg" },
			// headers = "Accept=application/xml, application/json",
			method = RequestMethod.GET)
	public ResponseEntity<String> getMsg(HttpEntity<String> entity) {
		/*
		 * HttpHeaders responseHeaders = new HttpHeaders();
		 * responseHeaders.setLocation(URI.create("http://www.baidu.com"));
		 * responseHeaders.set("tel", "1552-554-8448"); return new
		 * ResponseEntity<String>("Hello World", responseHeaders,
		 * HttpStatus.CREATED);
		 */

		// return ResponseEntity.noContent().build();

		return ResponseEntity.ok().header("content-type", "text/plain;charset=utf-8").body("你好,java");
	}

	@RequestMapping("date/{date}")
	public String date(@DateTimeFormat(iso = ISO.DATE) @PathVariable Date date, @RequestHeader("Accept") String accept,
			@RequestBody String body) {

		DateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return "input date is " + DateFormat.getDateInstance().format(date);
	}

	@RequestMapping("get")
	public String getById(@RequestParam int id) {
		return "input id is " + id;
	}

	@RequestMapping("/wait")
	public Callable<MyMessage> waits() {

		return new Callable<MyMessage>() {

			@Override
			public MyMessage call() throws Exception {
				Date d = Calendar.getInstance().getTime();
				Thread.sleep(2000); // 暂停两秒

				return new MyMessage(String.format("wait for %s s",
						(Calendar.getInstance().getTime().getTime() - d.getTime()) / 1000));
			}
		};
	}

	/*
	 * @InitBinder // 必须有一个参数 public void initializeBinder(WebDataBinder binder)
	 * { binder.registerCustomEditor(Date.class, new CustomDateEditor(new
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
