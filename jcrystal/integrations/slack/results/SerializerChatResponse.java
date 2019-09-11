package integrations.slack.results;
import java.io.*;
import integrations.slack.PrintWriterUtils;
import static integrations.slack.JSONUtils.*;
import integrations.slack.entities.enums.*;
@SuppressWarnings("unused")
public class SerializerChatResponse{
	public static void toJson(java.io.PrintWriter _pw, ChatResponse objeto){
		boolean __first = true;
		_pw.print("{");
		String val0 = objeto.channel();
		if(val0 != null){
			PrintWriterUtils.print(_pw, "\"channel\":", jsonQuote(val0));
			__first = false;
		}
		integrations.slack.results.MessageResponse val1 = objeto.message();
		if(val1 != null){
			if(__first){
				_pw.print("\"message\":");
				SerializerMessageResponse.toJson(_pw, val1);
				__first = false;
			}
			else{
				_pw.print(",\"message\":");
				SerializerMessageResponse.toJson(_pw, val1);
			}
		}
		_pw.print("}");
	}
	public static void toJsonChatResponse(java.io.PrintWriter _pw, java.lang.Iterable<ChatResponse> lista){
		PrintWriterUtils.toJson(_pw, lista, valor->toJson(_pw, valor));
	}
	public static void toJsonChatResponse(java.io.PrintWriter _pw, java.util.Map<Long, ChatResponse> mapa){
		PrintWriterUtils.toJson(_pw, mapa, valor-> toJson(_pw, valor));
	}
}
