package com.company.hrm.service.impl;

import com.company.hrm.common.DaoConst;
import com.company.hrm.common.ServiceConst;
import com.company.hrm.dao.idao.IUserDao;
import com.company.hrm.dao.pojo.User;
import com.company.hrm.service.iService.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements IUserService{
	@Autowired
	IUserDao userDao;

	public UserServiceImpl() {
	}

	public UserServiceImpl(IUserDao userDao) {
		this.userDao = userDao;
	}

	public IUserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public String regist(User user) {
		String msg = ServiceConst.ERROR;
		try {
			if (userDao.regist(user).equals(ServiceConst.SUCCESS)) {
				msg = ServiceConst.SUCCESS;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
			
		return msg;
	}

	@Override
	public User login(String username, String password) {
		User user = null;
		try {
			user = userDao.login(username, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public boolean isExist(String username) {
		boolean isExist = false;
		try {
			if (userDao.isExist(username)) {
				isExist = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isExist;
	}

}
