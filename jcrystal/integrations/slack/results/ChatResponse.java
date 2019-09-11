package integrations.slack.results;
import java.io.*;
import static integrations.slack.JSONUtils.*;
import integrations.slack.entities.enums.*;
@SuppressWarnings("unused")
public class ChatResponse implements Serializable{
	private String channel;
	public String channel(){return this.channel;}
	public void channel(String val){channel = val;}
	private integrations.slack.results.MessageResponse message;
	public integrations.slack.results.MessageResponse message(){return this.message;}
	public void message(integrations.slack.results.MessageResponse val){message = val;}
	public ChatResponse(){
	}
	protected ChatResponse(org.json.JSONObject json)throws org.json.JSONException{
		this.channel = json.has("channel")&&!json.isNull("channel")?json.getString("channel"):null;
		if(json.has("message")  && !json.isNull("message")){
			this.message = new integrations.slack.results.MessageResponse(json.optJSONObject("message"));
		}
	}
	public static ChatResponse fromJson(org.json.JSONObject json)throws org.json.JSONException{
		return new ChatResponse(json);
	}
	public static java.util.ArrayList<ChatResponse> listFromJson(org.json.JSONArray json)throws org.json.JSONException{
		java.util.ArrayList<ChatResponse> ret = new java.util.ArrayList<ChatResponse>(json.length());
		for(int e = 0, i = json.length(); e < i; e++){
			ret.add(new ChatResponse(json.getJSONObject(e)));
		}
		return ret;
	}
	//Serializable things
	private void writeObject(ObjectOutputStream aOutputStream) throws IOException{
		aOutputStream.writeUTF(channel);
		aOutputStream.writeObject(message);
	}
	private void readObject(ObjectInputStream aInputStream) throws ClassNotFoundException, IOException{
		this.channel = aInputStream.readUTF();
		this.message = (MessageResponse)aInputStream.readObject();
	}
}
