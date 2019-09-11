package integrations.slack.net.controllers;
import integrations.slack.net.utils.*;
import integrations.slack.results.*;
import integrations.slack.entities.*;
import integrations.slack.entities.enums.*;
import integrations.slack.net.*;
import static integrations.slack.JSONUtils.*;
public class ManagerChat{
	/**
	* /api/chat.postMessage
	**/
	public static NetTask<org.json.JSONObject> postMessage(String token, String channel, String text, boolean as_user, String attachments, On1SuccessListener<integrations.slack.results.ChatResponse> onSuccess, OnErrorListener onError){
		return new AbsDefaultManager.JSONObjectResp(onError){
			@Override protected String getUrl()throws java.io.UnsupportedEncodingException{
				String ruta = "/api/chat.postMessage";
				String params = null;
				if(token != null)
					params = (params==null?"?":(params + "&")) + "token=" + java.net.URLEncoder.encode(token, "UTF-8");
				if(channel != null)
					params = (params==null?"?":(params + "&")) + "channel=" + java.net.URLEncoder.encode(channel, "UTF-8");
				if(text != null)
					params = (params==null?"?":(params + "&")) + "text=" + java.net.URLEncoder.encode(text, "UTF-8");
				params = (params==null?"?":(params + "&")) + "as_user=" + java.lang.Boolean.toString(as_user);
				if(attachments != null)
					params = (params==null?"?":(params + "&")) + "attachments=" + java.net.URLEncoder.encode(attachments, "UTF-8");
				if(params != null)ruta+=params;
				return ruta;
			}
			@Override
			public void onResponse(org.json.JSONObject result)throws Exception{
				onSuccess.onSuccess(integrations.slack.results.ChatResponse.fromJson(result));
			}
		}.doGet().exec();
	}
}
