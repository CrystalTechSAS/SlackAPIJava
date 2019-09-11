package integrations.slack.results;
import java.io.*;
import static integrations.slack.JSONUtils.*;
import integrations.slack.entities.enums.*;
@SuppressWarnings("unused")
public class MessageResponse implements Serializable{
	private String text;
	public String text(){return this.text;}
	public void text(String val){text = val;}
	private String username;
	public String username(){return this.username;}
	public void username(String val){username = val;}
	private String bot_id;
	public String bot_id(){return this.bot_id;}
	public void bot_id(String val){bot_id = val;}
	private java.util.List<integrations.slack.results.AttatchmentData> attachments;
	public java.util.List<integrations.slack.results.AttatchmentData> attachments(){return this.attachments;}
	public void attachments(java.util.List<integrations.slack.results.AttatchmentData> val){attachments = val;}
	private String type;
	public String type(){return this.type;}
	public void type(String val){type = val;}
	private String subtype;
	public String subtype(){return this.subtype;}
	public void subtype(String val){subtype = val;}
	public MessageResponse(){
	}
	protected MessageResponse(org.json.JSONObject json)throws org.json.JSONException{
		this.text = json.has("text")&&!json.isNull("text")?json.getString("text"):null;
		this.username = json.has("username")&&!json.isNull("username")?json.getString("username"):null;
		this.bot_id = json.has("bot_id")&&!json.isNull("bot_id")?json.getString("bot_id"):null;
		{
			org.json.JSONArray $Arrayattachments = json.optJSONArray("attachments");
			if($Arrayattachments != null){
				this.attachments = integrations.slack.results.AttatchmentData.listFromJson($Arrayattachments);
			}
		}
		this.type = json.has("type")&&!json.isNull("type")?json.getString("type"):null;
		this.subtype = json.has("subtype")&&!json.isNull("subtype")?json.getString("subtype"):null;
	}
	public static MessageResponse fromJson(org.json.JSONObject json)throws org.json.JSONException{
		return new MessageResponse(json);
	}
	public static java.util.ArrayList<MessageResponse> listFromJson(org.json.JSONArray json)throws org.json.JSONException{
		java.util.ArrayList<MessageResponse> ret = new java.util.ArrayList<MessageResponse>(json.length());
		for(int e = 0, i = json.length(); e < i; e++){
			ret.add(new MessageResponse(json.getJSONObject(e)));
		}
		return ret;
	}
	//Serializable things
	private void writeObject(ObjectOutputStream aOutputStream) throws IOException{
		aOutputStream.writeUTF(text);
		aOutputStream.writeUTF(username);
		aOutputStream.writeUTF(bot_id);
		aOutputStream.writeObject(attachments);
		aOutputStream.writeUTF(type);
		aOutputStream.writeUTF(subtype);
	}
	private void readObject(ObjectInputStream aInputStream) throws ClassNotFoundException, IOException{
		this.text = aInputStream.readUTF();
		this.username = aInputStream.readUTF();
		this.bot_id = aInputStream.readUTF();
		this.attachments = (java.util.List<integrations.slack.results.AttatchmentData>)aInputStream.readObject();
		this.type = aInputStream.readUTF();
		this.subtype = aInputStream.readUTF();
	}
}
