package integrations.slack.net.utils;
import org.json.JSONException;
import org.json.JSONObject;

public interface OnServerResponse {
    public void onSuccess(JSONObject data)throws JSONException;
}
