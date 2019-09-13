package integrations.slack.results;
import java.io.*;
import static integrations.slack.JSONUtils.*;
import integrations.slack.entities.enums.*;
@SuppressWarnings("unused")
public class Channel implements Serializable{
	private String id;
	public String id(){return this.id;}
	public void id(String val){id = val;}
	private boolean is_im;
	public boolean is_im(){return this.is_im;}
	public void is_im(boolean val){is_im = val;}
	private boolean is_org_shared;
	public boolean is_org_shared(){return this.is_org_shared;}
	public void is_org_shared(boolean val){is_org_shared = val;}
	private String user;
	public String user(){return this.user;}
	public void user(String val){user = val;}
	private int unread_count;
	public int unread_count(){return this.unread_count;}
	public void unread_count(int val){unread_count = val;}
	private int unread_count_display;
	public int unread_count_display(){return this.unread_count_display;}
	public void unread_count_display(int val){unread_count_display = val;}
	private boolean is_open;
	public boolean is_open(){return this.is_open;}
	public void is_open(boolean val){is_open = val;}
	private int priority;
	public int priority(){return this.priority;}
	public void priority(int val){priority = val;}
	public Channel(){
	}
	protected Channel(org.json.JSONObject json)throws org.json.JSONException{
		this.id = json.has("id")&&!json.isNull("id")?json.getString("id"):null;
		this.is_im = json.optBoolean("is_im");
		this.is_org_shared = json.optBoolean("is_org_shared");
		this.user = json.has("user")&&!json.isNull("user")?json.getString("user"):null;
		this.unread_count = json.optInt("unread_count");
		this.unread_count_display = json.optInt("unread_count_display");
		this.is_open = json.optBoolean("is_open");
		this.priority = json.optInt("priority");
	}
	public static Channel fromJson(org.json.JSONObject json)throws org.json.JSONException{
		return new Channel(json);
	}
	public static java.util.ArrayList<Channel> listFromJson(org.json.JSONArray json)throws org.json.JSONException{
		java.util.ArrayList<Channel> ret = new java.util.ArrayList<Channel>(json.length());
		for(int e = 0, i = json.length(); e < i; e++){
			ret.add(new Channel(json.getJSONObject(e)));
		}
		return ret;
	}
	//Serializable things
	private void writeObject(ObjectOutputStream aOutputStream) throws IOException{
		aOutputStream.writeUTF(id);
		aOutputStream.writeBoolean(is_im);
		aOutputStream.writeBoolean(is_org_shared);
		aOutputStream.writeUTF(user);
		aOutputStream.writeInt(unread_count);
		aOutputStream.writeInt(unread_count_display);
		aOutputStream.writeBoolean(is_open);
		aOutputStream.writeInt(priority);
	}
	private void readObject(ObjectInputStream aInputStream) throws ClassNotFoundException, IOException{
		this.id = aInputStream.readUTF();
		this.is_im = aInputStream.readBoolean();
		this.is_org_shared = aInputStream.readBoolean();
		this.user = aInputStream.readUTF();
		this.unread_count = aInputStream.readInt();
		this.unread_count_display = aInputStream.readInt();
		this.is_open = aInputStream.readBoolean();
		this.priority = aInputStream.readInt();
	}
}
