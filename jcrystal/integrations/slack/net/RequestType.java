package integrations.slack.net;
public enum RequestType{
	GET(false), POST(true), PUT(true), DELETE(false), PATCH(true);
	public final boolean isPost;
	RequestType(boolean isPost){
		this.isPost = isPost;
	}
}
