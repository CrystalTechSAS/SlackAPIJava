package integrations.slack.net.controllers;
import integrations.slack.net.utils.*;
import integrations.slack.results.*;
import integrations.slack.entities.*;
import integrations.slack.entities.enums.*;
import integrations.slack.net.*;
import static integrations.slack.JSONUtils.*;
public class ManagerUsers{
	/**
	* /api/user.identity
	**/
	public static NetTask<org.json.JSONObject> identity(String authorization, OnVoidSuccessListener onSuccess, OnErrorListener onError){
		return new AbsDefaultManager.JSONObjectResp(onError){
			@Override protected String getUrl()throws java.io.UnsupportedEncodingException{
				String ruta = "/api/user.identity";
				return ruta;
			}
			@Override
			public void onResponse(org.json.JSONObject result)throws Exception{
				onSuccess.onSuccess();
			}
		}.authorization(authorization).doGet().exec();
	}
}
