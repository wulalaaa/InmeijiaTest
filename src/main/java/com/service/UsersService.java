package com.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Users;

import io.ebean.EbeanServer;

@Service
public class UsersService {

	@Autowired
	private EbeanServer ebeanServer;

	private static final Logger logger = LoggerFactory.getLogger(UsersService.class);

	public List<Users> getAll() {
		List<Users> list = ebeanServer.find(Users.class).findList();
		logger.debug("获取的用户数据为:");
		if (list.size() > 0) {
			Users user = null;
			for (int i = 0; i < list.size(); i++) {
				user = list.get(i);
				logger.debug("user_id : {},user_name : {},user_password : {},user_sex : {}", user.getUser_id(),
						user.getUser_name(), user.getUser_password(), user.getUser_sex());
			}
		}else {
			logger.debug("null");
		}
		return list;

	}

	public Users getById(String user_id) {
		Users user = ebeanServer.find(Users.class).where().eq("user_id", user_id).findOne();
		logger.debug("获取的用户数据为:");
		if (user == null) {
			logger.debug("null");
			return user;
		}
		logger.debug("user_id : {},user_name : {},user_password : {},user_sex : {}", user.getUser_id(),
				user.getUser_name(), user.getUser_password(), user.getUser_sex());
		return user;
	}

	public void save(Users users) {
		ebeanServer.save(users);
		logger.debug("保存了新的用户对象：     user_id : {},user_name : {},user_password : {},user_sex : {}", users.getUser_id(),
				users.getUser_name(), users.getUser_password(), users.getUser_sex());
	}

	public void delete(Users users) {
		ebeanServer.delete(users);
		logger.debug("删除了用户对象：     user_id : {}", users.getUser_id());
	}

	public void update(Users users) {
		ebeanServer.update(users);
		logger.debug("修改了用户对象：     user_id : {},user_name : {},user_password : {},user_sex : {}", users.getUser_id(),
				users.getUser_name(), users.getUser_password(), users.getUser_sex());
	}

	public List<Users> getByName(String user_name) {
		List<Users> list = ebeanServer.find(Users.class).where().eq("user_name", user_name).findList();
		logger.debug("获取的用户数据为:");
		if (list.size() > 0) {
			Users user = null;
			for (int i = 0; i < list.size(); i++) {
				user = list.get(i);
				logger.debug("user_id : {},user_name : {},user_password : {},user_sex : {}", user.getUser_id(),
						user.getUser_name(), user.getUser_password(), user.getUser_sex());
			}
			return list;
		}
		logger.debug("null");
		return list;
	}

}
