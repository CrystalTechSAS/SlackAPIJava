package integrations.slack.net.controllers;
import integrations.slack.net.utils.*;
import integrations.slack.results.*;
import integrations.slack.entities.*;
import integrations.slack.entities.enums.*;
import integrations.slack.net.*;
import static integrations.slack.JSONUtils.*;
public class ManagerConversations{
	/**
	* /api/conversations.members
	**/
	public static NetTask<org.json.JSONObject> members(String authorization, String channel, On1SuccessListener<integrations.slack.results.MemberConversationResponse> onSuccess, OnErrorListener onError){
		return new AbsDefaultManager.JSONObjectResp(onError){
			@Override protected String getUrl()throws java.io.UnsupportedEncodingException{
				String ruta = "/api/conversations.members";
				String params = null;
				if(channel != null)
					params = (params==null?"?":(params + "&")) + "channel=" + java.net.URLEncoder.encode(channel, "UTF-8");
				if(params != null)ruta+=params;
				return ruta;
			}
			@Override
			public void onResponse(org.json.JSONObject result)throws Exception{
				onSuccess.onSuccess(integrations.slack.results.MemberConversationResponse.fromJson(result));
			}
			@Override protected void makeBody(java.io.PrintWriter writer) throws java.io.IOException{
				writer.println("-----------------------------"+boundary + "--");
			}
		}.doFormData().authorization(authorization).doPost().exec();
	}
}
