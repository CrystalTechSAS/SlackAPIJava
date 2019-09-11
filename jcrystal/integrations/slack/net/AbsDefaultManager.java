package integrations.slack.net;
import integrations.slack.net.utils.*;
public abstract class AbsDefaultManager<T> extends NetTask<T>{
	public static boolean DEBUG = false;
	public static final String BASE_URL = "https://slack.com";
	private boolean formData;
	protected String boundary;
	public AbsDefaultManager(OnErrorListener onError){
		super(onError);
	}
	@Override protected final T doRequest()throws Exception{
		String $url = BASE_URL + getUrl();
		java.net.HttpURLConnection connection = (java.net.HttpURLConnection) new java.net.URL($url).openConnection();
		if(DEBUG){
			System.out.println($url);
		}
		connection.setConnectTimeout(NetConfig.TIMEOUT);
		connection.setRequestMethod(type.name());
		connection.setRequestProperty("Accept", "application/json");
		if(authorization != null){
			connection.setRequestProperty("Authorization", authorization);
		}
		if(type.isPost){
			if(formData){
				connection.setRequestProperty("Content-Type", "multipart/form-data; boundary=---------------------------"+boundary);
			}
			else{
				connection.setRequestProperty("Content-Type", "application/json");
			}
		}
		if(type.isPost){
			connection.setDoOutput(true);
		}
		connection.connect();
		if(type.isPost){
			java.io.PrintWriter _pw = new java.io.PrintWriter(new java.io.OutputStreamWriter(connection.getOutputStream(), "UTF-8"), false);
			makeBody(_pw);
			_pw.flush();
			_pw.close();
		}
		final int responseCode = connection.getResponseCode();
		if(DEBUG){
			System.out.println("responseCode " + responseCode);
		}
		if(responseCode >= 200 && responseCode <= 299){
			final StringBuilder resp = HTTPUtils.readResponse(connection.getInputStream());
			connection.disconnect();
			onPostExecute(getResponse(resp));
		}
		else{
			if(onError != null){
				final java.io.InputStream errorStream = connection.getErrorStream();
				final StringBuilder resp;
				if(errorStream != null){
					resp = HTTPUtils.readResponse(errorStream);
				}
				else{
					resp = new StringBuilder("");
				}
				connection.disconnect();
				String $error = resp.toString();
				if(DEBUG){
					System.out.println("error " + $error);
				}
				error = new RequestError(responseCode, $error);
				onPostExecute(null);
			}
			else{
				connection.disconnect();
			}
		}
		return null;
	}
	public AbsDefaultManager<T> doFormData(){
		formData = true;
		boundary = Long.toString(System.currentTimeMillis());
		return this;
	}
	protected void onPostExecute(T result){
		if(result != null){
			try{
				onResponse(result);
			}
			catch(Exception ex){
				if(onError!=null)onError.onError(new RequestError(TipoError.SERVER_ERROR, "Ocurrió un error con el servidor"));
			}
		}
		else if(onError != null){
			onError.onError(error);
		}
	}
	protected void makeBody(java.io.PrintWriter _pw) throws java.io.UnsupportedEncodingException, java.io.IOException{
	}
	protected abstract void onResponse(T result) throws Exception;
	abstract T getResponse(StringBuilder resp) throws Exception;
	public abstract static class StringResp extends AbsDefaultManager<java.lang.String>{
		public StringResp(OnErrorListener onError){
			super(onError);
		}
		@Override protected java.lang.String getResponse(StringBuilder resp)throws Exception{
			return resp.toString();
		}
	}
	public abstract static class JSONObjectResp extends AbsDefaultManager<org.json.JSONObject>{
		public JSONObjectResp(OnErrorListener onError){
			super(onError);
		}
		@Override protected org.json.JSONObject getResponse(StringBuilder resp)throws Exception{
			org.json.JSONObject json = new org.json.JSONObject(resp.toString());
			final boolean success = json.optBoolean("ok", false);
			if(success){return json;}
			if(!success){
				error = new RequestError(json.optInt("code",0), json.getString("error"));
				return null;
			}
			error = new RequestError(TipoError.SERVER_ERROR, json.getString("error"));
			return null;
		}
	}
	public abstract static class JSONArrayResp extends AbsDefaultManager<org.json.JSONArray>{
		public JSONArrayResp(OnErrorListener onError){
			super(onError);
		}
		@Override protected org.json.JSONArray getResponse(StringBuilder resp)throws Exception{
			org.json.JSONArray json = new org.json.JSONArray(resp.toString());
			final boolean success = false;
			if(success){return json;}
			if(!success){
				error = new RequestError(0, "SERVER ERROR");
				return null;
			}
			error = new RequestError(0, "SERVER ERROR");
			return null;
		}
	}
}
