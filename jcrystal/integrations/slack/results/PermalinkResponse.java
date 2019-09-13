package integrations.slack.results;
import java.io.*;
import static integrations.slack.JSONUtils.*;
import integrations.slack.entities.enums.*;
@SuppressWarnings("unused")
public class PermalinkResponse implements Serializable{
	private String permalink;
	public String permalink(){return this.permalink;}
	public void permalink(String val){permalink = val;}
	private String channel;
	public String channel(){return this.channel;}
	public void channel(String val){channel = val;}
	public PermalinkResponse(){
	}
	protected PermalinkResponse(org.json.JSONObject json)throws org.json.JSONException{
		this.permalink = json.has("permalink")&&!json.isNull("permalink")?json.getString("permalink"):null;
		this.channel = json.has("channel")&&!json.isNull("channel")?json.getString("channel"):null;
	}
	public static PermalinkResponse fromJson(org.json.JSONObject json)throws org.json.JSONException{
		return new PermalinkResponse(json);
	}
	public static java.util.ArrayList<PermalinkResponse> listFromJson(org.json.JSONArray json)throws org.json.JSONException{
		java.util.ArrayList<PermalinkResponse> ret = new java.util.ArrayList<PermalinkResponse>(json.length());
		for(int e = 0, i = json.length(); e < i; e++){
			ret.add(new PermalinkResponse(json.getJSONObject(e)));
		}
		return ret;
	}
	//Serializable things
	private void writeObject(ObjectOutputStream aOutputStream) throws IOException{
		aOutputStream.writeUTF(permalink);
		aOutputStream.writeUTF(channel);
	}
	private void readObject(ObjectInputStream aInputStream) throws ClassNotFoundException, IOException{
		this.permalink = aInputStream.readUTF();
		this.channel = aInputStream.readUTF();
	}
}
