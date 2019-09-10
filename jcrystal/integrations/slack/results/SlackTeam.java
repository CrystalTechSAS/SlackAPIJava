package integrations.slack.results;
import java.io.*;
import static integrations.slack.JSONUtils.*;
import integrations.slack.entities.enums.*;
@SuppressWarnings("unused")
public class SlackTeam implements Serializable{
	private String id;
	public String id(){return this.id;}
	public void id(String val){id = val;}
	private String name;
	public String name(){return this.name;}
	public void name(String val){name = val;}
	private String domain;
	public String domain(){return this.domain;}
	public void domain(String val){domain = val;}
	public SlackTeam(){
	}
	protected SlackTeam(org.json.JSONObject json)throws org.json.JSONException{
		this.id = json.has("id")&&!json.isNull("id")?json.getString("id"):null;
		this.name = json.has("name")&&!json.isNull("name")?json.getString("name"):null;
		this.domain = json.has("domain")&&!json.isNull("domain")?json.getString("domain"):null;
	}
	public static SlackTeam fromJson(org.json.JSONObject json)throws org.json.JSONException{
		return new SlackTeam(json);
	}
	public static java.util.ArrayList<SlackTeam> listFromJson(org.json.JSONArray json)throws org.json.JSONException{
		java.util.ArrayList<SlackTeam> ret = new java.util.ArrayList<SlackTeam>(json.length());
		for(int e = 0, i = json.length(); e < i; e++){
			ret.add(new SlackTeam(json.getJSONObject(e)));
		}
		return ret;
	}
	//Serializable things
	private void writeObject(ObjectOutputStream aOutputStream) throws IOException{
		aOutputStream.writeUTF(id);
		aOutputStream.writeUTF(name);
		aOutputStream.writeUTF(domain);
	}
	private void readObject(ObjectInputStream aInputStream) throws ClassNotFoundException, IOException{
		this.id = aInputStream.readUTF();
		this.name = aInputStream.readUTF();
		this.domain = aInputStream.readUTF();
	}
}
