package integrations.slack.results;
import java.io.*;
import static integrations.slack.JSONUtils.*;
import integrations.slack.entities.enums.*;
@SuppressWarnings("unused")
public class MemberConversationResponse implements Serializable{
	private boolean ok;
	public boolean ok(){return this.ok;}
	public void ok(boolean val){ok = val;}
	private java.util.List<String> members;
	public java.util.List<String> members(){return this.members;}
	public void members(java.util.List<String> val){members = val;}
	private integrations.slack.results.MetadataResponse response_metadata;
	public integrations.slack.results.MetadataResponse response_metadata(){return this.response_metadata;}
	public void response_metadata(integrations.slack.results.MetadataResponse val){response_metadata = val;}
	private String error;
	public String error(){return this.error;}
	public void error(String val){error = val;}
	public MemberConversationResponse(){
	}
	protected MemberConversationResponse(org.json.JSONObject json)throws org.json.JSONException{
		this.ok = json.optBoolean("ok");
		{
			org.json.JSONArray $Arraymembers = json.optJSONArray("members");
			if($Arraymembers != null){
				this.members = new java.util.ArrayList<>();
				for(int i = 0; i < $Arraymembers.length(); i++){
					this.members.add($Arraymembers.getString(i));
				}
			}
		}
		if(json.has("response_metadata")  && !json.isNull("response_metadata")){
			this.response_metadata = new integrations.slack.results.MetadataResponse(json.optJSONObject("response_metadata"));
		}
		this.error = json.has("error")&&!json.isNull("error")?json.getString("error"):null;
	}
	public static MemberConversationResponse fromJson(org.json.JSONObject json)throws org.json.JSONException{
		return new MemberConversationResponse(json);
	}
	public static java.util.ArrayList<MemberConversationResponse> listFromJson(org.json.JSONArray json)throws org.json.JSONException{
		java.util.ArrayList<MemberConversationResponse> ret = new java.util.ArrayList<MemberConversationResponse>(json.length());
		for(int e = 0, i = json.length(); e < i; e++){
			ret.add(new MemberConversationResponse(json.getJSONObject(e)));
		}
		return ret;
	}
	//Serializable things
	private void writeObject(ObjectOutputStream aOutputStream) throws IOException{
		aOutputStream.writeBoolean(ok);
		aOutputStream.writeObject(members);
		aOutputStream.writeObject(response_metadata);
		aOutputStream.writeUTF(error);
	}
	private void readObject(ObjectInputStream aInputStream) throws ClassNotFoundException, IOException{
		this.ok = aInputStream.readBoolean();
		this.members = (java.util.List<String>)aInputStream.readObject();
		this.response_metadata = (MetadataResponse)aInputStream.readObject();
		this.error = aInputStream.readUTF();
	}
}
