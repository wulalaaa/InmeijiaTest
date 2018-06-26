package com.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Users;
import com.service.UsersService;

@RestController
@RequestMapping("/users")
public class Controller {
	
	private static final Logger logger = LoggerFactory.getLogger(Controller.class);
	
	@Autowired
	private UsersService usersService;

	@RequestMapping(value = "/getAll", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> getAll() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("success", true);
		List<Users> list = usersService.getAll();
		map.put("list", list);
		return map;
	}

	@RequestMapping(value = "/getById", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> getById(@RequestParam("user_id") String user_id) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("success", true);
		Users user = usersService.getById(user_id);
		map.put("user", user);
		return map;
	}

	/**
	 * 保存或修改用户
	 * 
	 * @param user_id
	 *            用户ID
	 * @param user_name
	 *            用户名称
	 * @param user_sex
	 *            用户性别
	 * @param user_password
	 *            用户密码
	 * @return error 0:保存新用户时名称重复 1:修改用户时名称重复
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> save(@RequestParam("user_id") String user_id,
			@RequestParam("user_name") String user_name, @RequestParam("user_sex") String user_sex,
			@RequestParam("user_password") String user_password) {
		Map<String, Object> map = new HashMap<String, Object>();
		Users users = new Users(user_id, user_name, user_password, user_sex);
		if (users.getUser_id() == "") {
			List<Users> list = usersService.getByName(users.getUser_name());
			if (list.size() > 0) {
				map.put("success", false);
				map.put("error", "0");
				logger.error("保存新用户时名称重复  ： " + users.getUser_name());
				return map;
			}
			users.setUser_id(UUID.randomUUID().toString());
			usersService.save(users);
			map.put("success", true);
			return map;
		} else {
			List<Users> list = usersService.getByName(users.getUser_name());
			if (list.size() > 0 && !list.get(0).getUser_id().equals(users.getUser_id())) {
				map.put("success", false);
				map.put("error", "1");
				logger.error("修改ID:" + users.getUser_id() + "用户时名称重复  ： " + users.getUser_name());
				return map;
			}
			usersService.update(users);
			map.put("success", true);
			return map;
		}
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> delete(@RequestParam("user_id") String user_id) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("success", true);
		Users users = new Users();
		users.setUser_id(user_id);
		usersService.delete(users);
		return map;
	}

}
