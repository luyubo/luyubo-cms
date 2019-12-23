package com.luyubo.cms.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.luyubo.cms.common.CmsConstant;
import com.luyubo.cms.common.JsonResult;
import com.luyubo.cms.pojo.Tousu;
import com.luyubo.cms.pojo.User;
import com.luyubo.cms.service.TousuService;
/**
 * 投诉控制器
 * @author 77028
 *
 */
@Controller
@RequestMapping("/tousu/")
public class TousuController {
	@Autowired
	private TousuService tousuService;
	
	@RequestMapping(value="add",method=RequestMethod.POST)
	@ResponseBody
	public JsonResult add(Tousu tousu,HttpSession session) {
		User userInfo = (User) session.getAttribute(CmsConstant.UserSessionKey);
		if(userInfo==null) {
			return JsonResult.fail(5000,"你还没有登录,请登录");
		}
		tousu.setUserId(userInfo.getId());
		System.out.println(tousu+"-----------------------");
		boolean flag=tousuService.add(tousu);
		if(flag) {
			return JsonResult.success();
		}
		return JsonResult.fail(5000, "未知错误");
	}
}
