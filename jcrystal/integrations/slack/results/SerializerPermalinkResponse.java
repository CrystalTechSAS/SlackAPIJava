package integrations.slack.results;
import java.io.*;
import integrations.slack.PrintWriterUtils;
import static integrations.slack.JSONUtils.*;
import integrations.slack.entities.enums.*;
@SuppressWarnings("unused")
public class SerializerPermalinkResponse{
	public static void toJson(java.io.PrintWriter _pw, PermalinkResponse objeto){
		boolean __first = true;
		_pw.print("{");
		String val0 = objeto.permalink();
		if(val0 != null){
			PrintWriterUtils.print(_pw, "\"permalink\":", jsonQuote(val0));
			__first = false;
		}
		String val1 = objeto.channel();
		if(val1 != null){
			if(__first){
				PrintWriterUtils.print(_pw, "\"channel\":", jsonQuote(val1));
				__first = false;
			}
			else{
				PrintWriterUtils.print(_pw, ",\"channel\":", jsonQuote(val1));
			}
		}
		_pw.print("}");
	}
	public static void toJsonPermalinkResponse(java.io.PrintWriter _pw, java.lang.Iterable<PermalinkResponse> lista){
		PrintWriterUtils.toJson(_pw, lista, valor->toJson(_pw, valor));
	}
	public static void toJsonPermalinkResponse(java.io.PrintWriter _pw, java.util.Map<Long, PermalinkResponse> mapa){
		PrintWriterUtils.toJson(_pw, mapa, valor-> toJson(_pw, valor));
	}
}
