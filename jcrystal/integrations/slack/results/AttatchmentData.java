package integrations.slack.results;
import java.io.*;
import static integrations.slack.JSONUtils.*;
import integrations.slack.entities.enums.*;
@SuppressWarnings("unused")
public class AttatchmentData implements Serializable{
	private String text;
	public String text(){return this.text;}
	public void text(String val){text = val;}
	private int id;
	public int id(){return this.id;}
	public void id(int val){id = val;}
	private String fallback;
	public String fallback(){return this.fallback;}
	public void fallback(String val){fallback = val;}
	public AttatchmentData(){
	}
	protected AttatchmentData(org.json.JSONObject json)throws org.json.JSONException{
		this.text = json.has("text")&&!json.isNull("text")?json.getString("text"):null;
		this.id = json.optInt("id");
		this.fallback = json.has("fallback")&&!json.isNull("fallback")?json.getString("fallback"):null;
	}
	public static AttatchmentData fromJson(org.json.JSONObject json)throws org.json.JSONException{
		return new AttatchmentData(json);
	}
	public static java.util.ArrayList<AttatchmentData> listFromJson(org.json.JSONArray json)throws org.json.JSONException{
		java.util.ArrayList<AttatchmentData> ret = new java.util.ArrayList<AttatchmentData>(json.length());
		for(int e = 0, i = json.length(); e < i; e++){
			ret.add(new AttatchmentData(json.getJSONObject(e)));
		}
		return ret;
	}
	//Serializable things
	private void writeObject(ObjectOutputStream aOutputStream) throws IOException{
		aOutputStream.writeUTF(text);
		aOutputStream.writeInt(id);
		aOutputStream.writeUTF(fallback);
	}
	private void readObject(ObjectInputStream aInputStream) throws ClassNotFoundException, IOException{
		this.text = aInputStream.readUTF();
		this.id = aInputStream.readInt();
		this.fallback = aInputStream.readUTF();
	}
}
