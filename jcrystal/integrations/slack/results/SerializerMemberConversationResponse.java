package integrations.slack.results;
import java.io.*;
import integrations.slack.PrintWriterUtils;
import static integrations.slack.JSONUtils.*;
import integrations.slack.entities.enums.*;
@SuppressWarnings("unused")
public class SerializerMemberConversationResponse{
	public static void toJson(java.io.PrintWriter _pw, MemberConversationResponse objeto){
		_pw.print("{");
		PrintWriterUtils.print(_pw, "\"ok\":", objeto.ok());
		java.util.List<String> val1 = objeto.members();
		if(val1 != null){
			_pw.print(",\"members\":");
			jsonQuoteString(_pw, val1);
		}
		integrations.slack.results.MetadataResponse val2 = objeto.response_metadata();
		if(val2 != null){
			_pw.print(",\"response_metadata\":");
			SerializerMetadataResponse.toJson(_pw, val2);
		}
		String val3 = objeto.error();
		if(val3 != null){
			PrintWriterUtils.print(_pw, ",\"error\":", jsonQuote(val3));
		}
		_pw.print("}");
	}
	public static void toJsonMemberConversationResponse(java.io.PrintWriter _pw, java.lang.Iterable<MemberConversationResponse> lista){
		PrintWriterUtils.toJson(_pw, lista, valor->toJson(_pw, valor));
	}
	public static void toJsonMemberConversationResponse(java.io.PrintWriter _pw, java.util.Map<Long, MemberConversationResponse> mapa){
		PrintWriterUtils.toJson(_pw, mapa, valor-> toJson(_pw, valor));
	}
}
