package integrations.slack.results;
import java.io.*;
import static integrations.slack.JSONUtils.*;
import integrations.slack.entities.enums.*;
@SuppressWarnings("unused")
public class OauthResponse implements Serializable{
	private boolean ok;
	public boolean ok(){return this.ok;}
	public void ok(boolean val){ok = val;}
	private integrations.slack.results.SlackUser user;
	public integrations.slack.results.SlackUser user(){return this.user;}
	public void user(integrations.slack.results.SlackUser val){user = val;}
	private integrations.slack.results.SlackTeam team;
	public integrations.slack.results.SlackTeam team(){return this.team;}
	public void team(integrations.slack.results.SlackTeam val){team = val;}
	public OauthResponse(){
	}
	protected OauthResponse(org.json.JSONObject json)throws org.json.JSONException{
		this.ok = json.optBoolean("ok");
		if(json.has("user")  && !json.isNull("user")){
			this.user = new integrations.slack.results.SlackUser(json.optJSONObject("user"));
		}
		if(json.has("team")  && !json.isNull("team")){
			this.team = new integrations.slack.results.SlackTeam(json.optJSONObject("team"));
		}
	}
	public static OauthResponse fromJson(org.json.JSONObject json)throws org.json.JSONException{
		return new OauthResponse(json);
	}
	public static java.util.ArrayList<OauthResponse> listFromJson(org.json.JSONArray json)throws org.json.JSONException{
		java.util.ArrayList<OauthResponse> ret = new java.util.ArrayList<OauthResponse>(json.length());
		for(int e = 0, i = json.length(); e < i; e++){
			ret.add(new OauthResponse(json.getJSONObject(e)));
		}
		return ret;
	}
	//Serializable things
	private void writeObject(ObjectOutputStream aOutputStream) throws IOException{
		aOutputStream.writeBoolean(ok);
		aOutputStream.writeObject(user);
		aOutputStream.writeObject(team);
	}
	private void readObject(ObjectInputStream aInputStream) throws ClassNotFoundException, IOException{
		this.ok = aInputStream.readBoolean();
		this.user = (SlackUser)aInputStream.readObject();
		this.team = (SlackTeam)aInputStream.readObject();
	}
}
