package integrations.slack.net.controllers;
import integrations.slack.net.utils.*;
import integrations.slack.results.*;
import integrations.slack.entities.*;
import integrations.slack.entities.enums.*;
import integrations.slack.net.*;
import static integrations.slack.JSONUtils.*;
public class ManagerOauth{
	/**
	* /api/oauth.access
	**/
	public static NetTask<org.json.JSONObject> access(String client_id, String client_secret, String redirect_uri, String code, On1SuccessListener<integrations.slack.results.OauthResponse> onSuccess, OnErrorListener onError){
		return new AbsDefaultManager.JSONObjectResp(onError){
			@Override protected String getUrl()throws java.io.UnsupportedEncodingException{
				String ruta = "/api/oauth.access";
				return ruta;
			}
			@Override
			public void onResponse(org.json.JSONObject result)throws Exception{
				onSuccess.onSuccess(integrations.slack.results.OauthResponse.fromJson(result));
			}
			@Override protected void makeBody(java.io.PrintWriter writer) throws java.io.IOException{
				if(client_id!= null){
					writer.println("-----------------------------" + boundary);
					writer.append("Content-Disposition: form-data; name=client_id\r\n");
					writer.append("\r\n");
					writer.print(java.net.URLEncoder.encode(client_id, "UTF-8"));
					writer.append("\r\n");
				}
				if(client_secret!= null){
					writer.println("-----------------------------" + boundary);
					writer.append("Content-Disposition: form-data; name=client_secret\r\n");
					writer.append("\r\n");
					writer.print(java.net.URLEncoder.encode(client_secret, "UTF-8"));
					writer.append("\r\n");
				}
				if(redirect_uri!= null){
					writer.println("-----------------------------" + boundary);
					writer.append("Content-Disposition: form-data; name=redirect_uri\r\n");
					writer.append("\r\n");
					writer.print(java.net.URLEncoder.encode(redirect_uri, "UTF-8"));
					writer.append("\r\n");
				}
				if(code!= null){
					writer.println("-----------------------------" + boundary);
					writer.append("Content-Disposition: form-data; name=code\r\n");
					writer.append("\r\n");
					writer.print(java.net.URLEncoder.encode(code, "UTF-8"));
					writer.append("\r\n");
				}
				writer.println("-----------------------------"+boundary + "--");
			}
		}.doFormData().doPost().exec();
	}
}
