package integrations.slack.results;
import java.io.*;
import integrations.slack.PrintWriterUtils;
import static integrations.slack.JSONUtils.*;
import integrations.slack.entities.enums.*;
@SuppressWarnings("unused")
public class SerializerMessageResponse{
	public static void toJson(java.io.PrintWriter _pw, MessageResponse objeto){
		boolean __first = true;
		_pw.print("{");
		String val0 = objeto.text();
		if(val0 != null){
			PrintWriterUtils.print(_pw, "\"text\":", jsonQuote(val0));
			__first = false;
		}
		String val1 = objeto.username();
		if(val1 != null){
			if(__first){
				PrintWriterUtils.print(_pw, "\"username\":", jsonQuote(val1));
				__first = false;
			}
			else{
				PrintWriterUtils.print(_pw, ",\"username\":", jsonQuote(val1));
			}
		}
		String val2 = objeto.bot_id();
		if(val2 != null){
			if(__first){
				PrintWriterUtils.print(_pw, "\"bot_id\":", jsonQuote(val2));
				__first = false;
			}
			else{
				PrintWriterUtils.print(_pw, ",\"bot_id\":", jsonQuote(val2));
			}
		}
		java.util.List<integrations.slack.results.AttatchmentData> val3 = objeto.attachments();
		if(val3 != null){
			if(__first){
				_pw.print("\"attachments\":");
				SerializerAttatchmentData.toJsonAttatchmentData(_pw, val3);
				__first = false;
			}
			else{
				_pw.print(",\"attachments\":");
				SerializerAttatchmentData.toJsonAttatchmentData(_pw, val3);
			}
		}
		String val4 = objeto.type();
		if(val4 != null){
			if(__first){
				PrintWriterUtils.print(_pw, "\"type\":", jsonQuote(val4));
				__first = false;
			}
			else{
				PrintWriterUtils.print(_pw, ",\"type\":", jsonQuote(val4));
			}
		}
		String val5 = objeto.subtype();
		if(val5 != null){
			if(__first){
				PrintWriterUtils.print(_pw, "\"subtype\":", jsonQuote(val5));
				__first = false;
			}
			else{
				PrintWriterUtils.print(_pw, ",\"subtype\":", jsonQuote(val5));
			}
		}
		_pw.print("}");
	}
	public static void toJsonMessageResponse(java.io.PrintWriter _pw, java.lang.Iterable<MessageResponse> lista){
		PrintWriterUtils.toJson(_pw, lista, valor->toJson(_pw, valor));
	}
	public static void toJsonMessageResponse(java.io.PrintWriter _pw, java.util.Map<Long, MessageResponse> mapa){
		PrintWriterUtils.toJson(_pw, mapa, valor-> toJson(_pw, valor));
	}
}
