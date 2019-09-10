package integrations.slack.results;
import java.io.*;
import static integrations.slack.JSONUtils.*;
import integrations.slack.entities.enums.*;
@SuppressWarnings("unused")
public class SlackUser implements Serializable{
	private String id;
	public String id(){return this.id;}
	public void id(String val){id = val;}
	private String name;
	public String name(){return this.name;}
	public void name(String val){name = val;}
	public SlackUser(){
	}
	protected SlackUser(org.json.JSONObject json)throws org.json.JSONException{
		this.id = json.has("id")&&!json.isNull("id")?json.getString("id"):null;
		this.name = json.has("name")&&!json.isNull("name")?json.getString("name"):null;
	}
	public static SlackUser fromJson(org.json.JSONObject json)throws org.json.JSONException{
		return new SlackUser(json);
	}
	public static java.util.ArrayList<SlackUser> listFromJson(org.json.JSONArray json)throws org.json.JSONException{
		java.util.ArrayList<SlackUser> ret = new java.util.ArrayList<SlackUser>(json.length());
		for(int e = 0, i = json.length(); e < i; e++){
			ret.add(new SlackUser(json.getJSONObject(e)));
		}
		return ret;
	}
	//Serializable things
	private void writeObject(ObjectOutputStream aOutputStream) throws IOException{
		aOutputStream.writeUTF(id);
		aOutputStream.writeUTF(name);
	}
	private void readObject(ObjectInputStream aInputStream) throws ClassNotFoundException, IOException{
		this.id = aInputStream.readUTF();
		this.name = aInputStream.readUTF();
	}
}
