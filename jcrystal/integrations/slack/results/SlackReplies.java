package integrations.slack.results;
import java.io.*;
import static integrations.slack.JSONUtils.*;
import integrations.slack.entities.enums.*;
@SuppressWarnings("unused")
public class SlackReplies implements Serializable{
	private String user;
	public String user(){return this.user;}
	public void user(String val){user = val;}
	private String ts;
	public String ts(){return this.ts;}
	public void ts(String val){ts = val;}
	public SlackReplies(){
	}
	protected SlackReplies(org.json.JSONObject json)throws org.json.JSONException{
		this.user = json.has("user")&&!json.isNull("user")?json.getString("user"):null;
		this.ts = json.has("ts")&&!json.isNull("ts")?json.getString("ts"):null;
	}
	public static SlackReplies fromJson(org.json.JSONObject json)throws org.json.JSONException{
		return new SlackReplies(json);
	}
	public static java.util.ArrayList<SlackReplies> listFromJson(org.json.JSONArray json)throws org.json.JSONException{
		java.util.ArrayList<SlackReplies> ret = new java.util.ArrayList<SlackReplies>(json.length());
		for(int e = 0, i = json.length(); e < i; e++){
			ret.add(new SlackReplies(json.getJSONObject(e)));
		}
		return ret;
	}
	//Serializable things
	private void writeObject(ObjectOutputStream aOutputStream) throws IOException{
		aOutputStream.writeUTF(user);
		aOutputStream.writeUTF(ts);
	}
	private void readObject(ObjectInputStream aInputStream) throws ClassNotFoundException, IOException{
		this.user = aInputStream.readUTF();
		this.ts = aInputStream.readUTF();
	}
}
