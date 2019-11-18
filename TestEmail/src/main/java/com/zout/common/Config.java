package com.zout.common;

/**
 * 
 *@class_name：Config
 *@comments:系统常量
 *@param:自主填写API的授权码等信息
 *@return: String
 *@author:邹涛/Zoutao
 *@createtime:2019年2月23日
 */
public class Config
{
	
	/**
	 * url前半部分
	 */
	public static final String BASE_URL = "https://openapi.miaodiyun.com";
	

	/**
	 * 开发者注册后系统自动生成的账号，可在官网登录后查看-修改为自己的。
	 */
	public static final String ACCOUNT_SID = "39a8e4cd642d7b5ac0eeb4b8656b5c4e";

	/**
	 * 开发者注册后系统自动生成的TOKEN，可在官网登录后查看-修改为自己的。
	 */
	public static final String AUTH_TOKEN = "693fc1319f7abd046d62b929ba724cb8";

	/**
	 * 响应数据类型, JSON或XML
	 */
	public static final String RESP_DATA_TYPE = "json";
}
