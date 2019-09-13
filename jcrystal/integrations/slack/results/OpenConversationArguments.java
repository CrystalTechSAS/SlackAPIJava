package integrations.slack.results;
import java.io.*;
import static integrations.slack.JSONUtils.*;
import integrations.slack.entities.enums.*;
@SuppressWarnings("unused")
public class OpenConversationArguments implements Serializable{
	private String channel;
	public String channel(){return this.channel;}
	public void channel(String val){channel = val;}
	private String users;
	public String users(){return this.users;}
	public void users(String val){users = val;}
	public OpenConversationArguments(){
	}
	protected OpenConversationArguments(org.json.JSONObject json)throws org.json.JSONException{
		this.channel = json.has("channel")&&!json.isNull("channel")?json.getString("channel"):null;
		this.users = json.has("users")&&!json.isNull("users")?json.getString("users"):null;
	}
	public static OpenConversationArguments fromJson(org.json.JSONObject json)throws org.json.JSONException{
		return new OpenConversationArguments(json);
	}
	public static java.util.ArrayList<OpenConversationArguments> listFromJson(org.json.JSONArray json)throws org.json.JSONException{
		java.util.ArrayList<OpenConversationArguments> ret = new java.util.ArrayList<OpenConversationArguments>(json.length());
		for(int e = 0, i = json.length(); e < i; e++){
			ret.add(new OpenConversationArguments(json.getJSONObject(e)));
		}
		return ret;
	}
	//Serializable things
	private void writeObject(ObjectOutputStream aOutputStream) throws IOException{
		aOutputStream.writeUTF(channel);
		aOutputStream.writeUTF(users);
	}
	private void readObject(ObjectInputStream aInputStream) throws ClassNotFoundException, IOException{
		this.channel = aInputStream.readUTF();
		this.users = aInputStream.readUTF();
	}
}
