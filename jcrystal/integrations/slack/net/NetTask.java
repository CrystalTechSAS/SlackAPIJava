package integrations.slack.net;

import integrations.slack.net.utils.OnErrorListener;
import integrations.slack.net.utils.RequestError;
import integrations.slack.net.utils.TipoError;

public abstract class NetTask<T>{
    protected final OnErrorListener onError;
	protected RequestError error;
	protected RequestType type;
	protected String authorization;
	protected NetTask(OnErrorListener onError){
		this.onError = onError;
	}
	public NetTask<T> authorization(String authorization){
		this.authorization = authorization;
		return this;
	}
	public NetTask<T> doGet(){
		this.type = RequestType.GET;
		return this;
	}
	public NetTask<T> doPost(){
		this.type = RequestType.POST;
		return this;
	}
	public NetTask<T> doPut(){
		this.type = RequestType.PUT;
		return this;
	}
	public NetTask<T> doDelete(){
		this.type = RequestType.DELETE;
		return this;
	}
	public NetTask<T> doPatch(){
		this.type = RequestType.PATCH;
		return this;
	}
	public final NetTask<T> exec(){
		try{
			doRequest();
		}
		catch (java.net.UnknownHostException | javax.net.ssl.SSLException | java.net.ConnectException | java.io.FileNotFoundException | java.net.HttpRetryException | java.net.SocketTimeoutException ex){
			ex.printStackTrace();
			error = new RequestError(TipoError.NO_INTERNET, "Check your internet connection");
		}
		catch (java.io.IOException | org.json.JSONException ex){
			ex.printStackTrace();
			error = new RequestError(TipoError.SERVER_ERROR, "Error connecting to server");
		}
		catch (Exception ex){
			ex.printStackTrace();
			error = new RequestError(TipoError.SERVER_ERROR, "Error connecting to server");
		
		}
		return this;
	}
	protected abstract T doRequest()throws Exception;
	protected abstract String getUrl()throws java.io.UnsupportedEncodingException;
}
