package com.zout.util;

import java.net.URLEncoder;
import com.alibaba.fastjson.JSONObject;
import com.zout.common.Config;
import com.zout.common.HttpUtil;

/**
 * 
 *@class_name：GetMessageCode
 *@comments:调用手机短信API
 *@param:phone
 *@return: String
 *@author:邹涛/Zoutao
 *@createtime:2019年2月22日
 */
public class GetMessageCode {
	
	private static String operation = "/distributor/sendSMS";//对应的API地址
	private static String accountSid = Config.ACCOUNT_SID;
	//private static String to = "17121192629"; //改由前台传入
	private static String rod=smsCode();   //生成一个随机验证码
	private static String smsContent = "【北京国承瑞泰科技有限公司】亲爱的用户,您的短信验证码为"+rod+",2分钟内有效，若非本人操作请忽略。退订回T";

	//创建验证码
	public static String smsCode(){
		String random=(int)((Math.random()*9+1)*100000)+"";	
		System.out.print("random验证码:"+random);
		return random;
	}
	
	//根据相应的手机号发送验证码
	public static String getCode(String phone){
		String tmpSmsContent = null;
	    try{
	      tmpSmsContent = URLEncoder.encode(smsContent, "UTF-8");
	    }catch(Exception e){
	    	e.getMessage();
	    }
	    
	    String url = Config.BASE_URL + operation;
	    String body = "accountSid=" + accountSid + "&to=" + phone + "&smsContent=" + tmpSmsContent
	        + HttpUtil.createCommonParam(Config.ACCOUNT_SID, Config.AUTH_TOKEN);
	    
	    // 提交请求
	    String result = HttpUtil.post(url, body);
	    
	    //(换行符) 剔除了平台无关性
	    System.out.println("result:" + System.lineSeparator() + result);
	    System.out.println(result.getClass());
	    
	    //字符串转json对象
	    JSONObject jsonObject = JSONObject.parseObject(result); 
	    String respCode = jsonObject.getString("respCode");
	    System.out.println(respCode);
	    
		//反馈-00000状态码标识请求成功，
		String defaultRespCode="00000";
		if(defaultRespCode.equals(respCode)){
			 return rod;
		}else{
			return defaultRespCode;		
		}
	}
	public static void main(String[] args) {
		
		System.out.println(getCode("17680508994"));
	}
	
}

