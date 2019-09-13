package integrations.slack.results;
import java.io.*;
import static integrations.slack.JSONUtils.*;
import integrations.slack.entities.enums.*;
@SuppressWarnings("unused")
public class DirectMessageResponse implements Serializable{
	private integrations.slack.results.Channel channel;
	public integrations.slack.results.Channel channel(){return this.channel;}
	public void channel(integrations.slack.results.Channel val){channel = val;}
	private boolean no_op;
	public boolean no_op(){return this.no_op;}
	public void no_op(boolean val){no_op = val;}
	private boolean already_open;
	public boolean already_open(){return this.already_open;}
	public void already_open(boolean val){already_open = val;}
	public DirectMessageResponse(){
	}
	protected DirectMessageResponse(org.json.JSONObject json)throws org.json.JSONException{
		if(json.has("channel")  && !json.isNull("channel")){
			this.channel = new integrations.slack.results.Channel(json.optJSONObject("channel"));
		}
		this.no_op = json.optBoolean("no_op");
		this.already_open = json.optBoolean("already_open");
	}
	public static DirectMessageResponse fromJson(org.json.JSONObject json)throws org.json.JSONException{
		return new DirectMessageResponse(json);
	}
	public static java.util.ArrayList<DirectMessageResponse> listFromJson(org.json.JSONArray json)throws org.json.JSONException{
		java.util.ArrayList<DirectMessageResponse> ret = new java.util.ArrayList<DirectMessageResponse>(json.length());
		for(int e = 0, i = json.length(); e < i; e++){
			ret.add(new DirectMessageResponse(json.getJSONObject(e)));
		}
		return ret;
	}
	//Serializable things
	private void writeObject(ObjectOutputStream aOutputStream) throws IOException{
		aOutputStream.writeObject(channel);
		aOutputStream.writeBoolean(no_op);
		aOutputStream.writeBoolean(already_open);
	}
	private void readObject(ObjectInputStream aInputStream) throws ClassNotFoundException, IOException{
		this.channel = (Channel)aInputStream.readObject();
		this.no_op = aInputStream.readBoolean();
		this.already_open = aInputStream.readBoolean();
	}
}
