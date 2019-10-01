package integrations.slack.results;
import java.io.*;
import static integrations.slack.JSONUtils.*;
import integrations.slack.entities.enums.*;
@SuppressWarnings("unused")
public class SlackMessage implements Serializable{
	private String client_msg_id;
	public String client_msg_id(){return this.client_msg_id;}
	public void client_msg_id(String val){client_msg_id = val;}
	private String type;
	public String type(){return this.type;}
	public void type(String val){type = val;}
	private String text;
	public String text(){return this.text;}
	public void text(String val){text = val;}
	private String user;
	public String user(){return this.user;}
	public void user(String val){user = val;}
	private String ts;
	public String ts(){return this.ts;}
	public void ts(String val){ts = val;}
	private String team;
	public String team(){return this.team;}
	public void team(String val){team = val;}
	private String thread_ts;
	public String thread_ts(){return this.thread_ts;}
	public void thread_ts(String val){thread_ts = val;}
	private String parent_user_id;
	public String parent_user_id(){return this.parent_user_id;}
	public void parent_user_id(String val){parent_user_id = val;}
	private String subtype;
	public String subtype(){return this.subtype;}
	public void subtype(String val){subtype = val;}
	private boolean hidden;
	public boolean hidden(){return this.hidden;}
	public void hidden(boolean val){hidden = val;}
	private int reply_count;
	public int reply_count(){return this.reply_count;}
	public void reply_count(int val){reply_count = val;}
	private int reply_users_count;
	public int reply_users_count(){return this.reply_users_count;}
	public void reply_users_count(int val){reply_users_count = val;}
	private String latest_reply;
	public String latest_reply(){return this.latest_reply;}
	public void latest_reply(String val){latest_reply = val;}
	private java.util.List<String> reply_users;
	public java.util.List<String> reply_users(){return this.reply_users;}
	public void reply_users(java.util.List<String> val){reply_users = val;}
	private java.util.List<integrations.slack.results.SlackReplies> replies;
	public java.util.List<integrations.slack.results.SlackReplies> replies(){return this.replies;}
	public void replies(java.util.List<integrations.slack.results.SlackReplies> val){replies = val;}
	public SlackMessage(){
	}
	protected SlackMessage(org.json.JSONObject json)throws org.json.JSONException{
		this.client_msg_id = json.has("client_msg_id")&&!json.isNull("client_msg_id")?json.getString("client_msg_id"):null;
		this.type = json.has("type")&&!json.isNull("type")?json.getString("type"):null;
		this.text = json.has("text")&&!json.isNull("text")?json.getString("text"):null;
		this.user = json.has("user")&&!json.isNull("user")?json.getString("user"):null;
		this.ts = json.has("ts")&&!json.isNull("ts")?json.getString("ts"):null;
		this.team = json.has("team")&&!json.isNull("team")?json.getString("team"):null;
		this.thread_ts = json.has("thread_ts")&&!json.isNull("thread_ts")?json.getString("thread_ts"):null;
		this.parent_user_id = json.has("parent_user_id")&&!json.isNull("parent_user_id")?json.getString("parent_user_id"):null;
		this.subtype = json.has("subtype")&&!json.isNull("subtype")?json.getString("subtype"):null;
		this.hidden = json.optBoolean("hidden");
		this.reply_count = json.optInt("reply_count");
		this.reply_users_count = json.optInt("reply_users_count");
		this.latest_reply = json.has("latest_reply")&&!json.isNull("latest_reply")?json.getString("latest_reply"):null;
		{
			org.json.JSONArray $Arrayreply_users = json.optJSONArray("reply_users");
			if($Arrayreply_users != null){
				this.reply_users = new java.util.ArrayList<>();
				for(int i = 0; i < $Arrayreply_users.length(); i++){
					this.reply_users.add($Arrayreply_users.getString(i));
				}
			}
		}
		{
			org.json.JSONArray $Arrayreplies = json.optJSONArray("replies");
			if($Arrayreplies != null){
				this.replies = integrations.slack.results.SlackReplies.listFromJson($Arrayreplies);
			}
		}
	}
	public static SlackMessage fromJson(org.json.JSONObject json)throws org.json.JSONException{
		return new SlackMessage(json);
	}
	public static java.util.ArrayList<SlackMessage> listFromJson(org.json.JSONArray json)throws org.json.JSONException{
		java.util.ArrayList<SlackMessage> ret = new java.util.ArrayList<SlackMessage>(json.length());
		for(int e = 0, i = json.length(); e < i; e++){
			ret.add(new SlackMessage(json.getJSONObject(e)));
		}
		return ret;
	}
	//Serializable things
	private void writeObject(ObjectOutputStream aOutputStream) throws IOException{
		aOutputStream.writeUTF(client_msg_id);
		aOutputStream.writeUTF(type);
		aOutputStream.writeUTF(text);
		aOutputStream.writeUTF(user);
		aOutputStream.writeUTF(ts);
		aOutputStream.writeUTF(team);
		aOutputStream.writeUTF(thread_ts);
		aOutputStream.writeUTF(parent_user_id);
		aOutputStream.writeUTF(subtype);
		aOutputStream.writeBoolean(hidden);
		aOutputStream.writeInt(reply_count);
		aOutputStream.writeInt(reply_users_count);
		aOutputStream.writeUTF(latest_reply);
		aOutputStream.writeObject(reply_users);
		aOutputStream.writeObject(replies);
	}
	private void readObject(ObjectInputStream aInputStream) throws ClassNotFoundException, IOException{
		this.client_msg_id = aInputStream.readUTF();
		this.type = aInputStream.readUTF();
		this.text = aInputStream.readUTF();
		this.user = aInputStream.readUTF();
		this.ts = aInputStream.readUTF();
		this.team = aInputStream.readUTF();
		this.thread_ts = aInputStream.readUTF();
		this.parent_user_id = aInputStream.readUTF();
		this.subtype = aInputStream.readUTF();
		this.hidden = aInputStream.readBoolean();
		this.reply_count = aInputStream.readInt();
		this.reply_users_count = aInputStream.readInt();
		this.latest_reply = aInputStream.readUTF();
		this.reply_users = (java.util.List<String>)aInputStream.readObject();
		this.replies = (java.util.List<integrations.slack.results.SlackReplies>)aInputStream.readObject();
	}
}
