package integrations.slack.results;
import java.io.*;
import static integrations.slack.JSONUtils.*;
import integrations.slack.entities.enums.*;
@SuppressWarnings("unused")
public class MetadataResponse implements Serializable{
	private String next_cursor;
	public String next_cursor(){return this.next_cursor;}
	public void next_cursor(String val){next_cursor = val;}
	public MetadataResponse(){
	}
	protected MetadataResponse(org.json.JSONObject json)throws org.json.JSONException{
		this.next_cursor = json.has("next_cursor")&&!json.isNull("next_cursor")?json.getString("next_cursor"):null;
	}
	public static MetadataResponse fromJson(org.json.JSONObject json)throws org.json.JSONException{
		return new MetadataResponse(json);
	}
	public static java.util.ArrayList<MetadataResponse> listFromJson(org.json.JSONArray json)throws org.json.JSONException{
		java.util.ArrayList<MetadataResponse> ret = new java.util.ArrayList<MetadataResponse>(json.length());
		for(int e = 0, i = json.length(); e < i; e++){
			ret.add(new MetadataResponse(json.getJSONObject(e)));
		}
		return ret;
	}
	//Serializable things
	private void writeObject(ObjectOutputStream aOutputStream) throws IOException{
		aOutputStream.writeUTF(next_cursor);
	}
	private void readObject(ObjectInputStream aInputStream) throws ClassNotFoundException, IOException{
		this.next_cursor = aInputStream.readUTF();
	}
}
