package integrations.slack.results;
import java.io.*;
import static integrations.slack.JSONUtils.*;
import integrations.slack.entities.enums.*;
@SuppressWarnings("unused")
public class RepliesMessagesResponse implements Serializable{
	private java.util.List<integrations.slack.results.SlackMessage> messages;
	public java.util.List<integrations.slack.results.SlackMessage> messages(){return this.messages;}
	public void messages(java.util.List<integrations.slack.results.SlackMessage> val){messages = val;}
	private boolean has_more;
	public boolean has_more(){return this.has_more;}
	public void has_more(boolean val){has_more = val;}
	public RepliesMessagesResponse(){
	}
	protected RepliesMessagesResponse(org.json.JSONObject json)throws org.json.JSONException{
		{
			org.json.JSONArray $Arraymessages = json.optJSONArray("messages");
			if($Arraymessages != null){
				this.messages = integrations.slack.results.SlackMessage.listFromJson($Arraymessages);
			}
		}
		this.has_more = json.optBoolean("has_more");
	}
	public static RepliesMessagesResponse fromJson(org.json.JSONObject json)throws org.json.JSONException{
		return new RepliesMessagesResponse(json);
	}
	public static java.util.ArrayList<RepliesMessagesResponse> listFromJson(org.json.JSONArray json)throws org.json.JSONException{
		java.util.ArrayList<RepliesMessagesResponse> ret = new java.util.ArrayList<RepliesMessagesResponse>(json.length());
		for(int e = 0, i = json.length(); e < i; e++){
			ret.add(new RepliesMessagesResponse(json.getJSONObject(e)));
		}
		return ret;
	}
	//Serializable things
	private void writeObject(ObjectOutputStream aOutputStream) throws IOException{
		aOutputStream.writeObject(messages);
		aOutputStream.writeBoolean(has_more);
	}
	private void readObject(ObjectInputStream aInputStream) throws ClassNotFoundException, IOException{
		this.messages = (java.util.List<integrations.slack.results.SlackMessage>)aInputStream.readObject();
		this.has_more = aInputStream.readBoolean();
	}
}
