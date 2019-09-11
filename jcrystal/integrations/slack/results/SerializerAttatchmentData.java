package integrations.slack.results;
import java.io.*;
import integrations.slack.PrintWriterUtils;
import static integrations.slack.JSONUtils.*;
import integrations.slack.entities.enums.*;
@SuppressWarnings("unused")
public class SerializerAttatchmentData{
	public static void toJson(java.io.PrintWriter _pw, AttatchmentData objeto){
		_pw.print("{");
		PrintWriterUtils.print(_pw, "\"id\":", objeto.id());
		String val1 = objeto.text();
		if(val1 != null){
			PrintWriterUtils.print(_pw, ",\"text\":", jsonQuote(val1));
		}
		String val2 = objeto.fallback();
		if(val2 != null){
			PrintWriterUtils.print(_pw, ",\"fallback\":", jsonQuote(val2));
		}
		_pw.print("}");
	}
	public static void toJsonAttatchmentData(java.io.PrintWriter _pw, java.lang.Iterable<AttatchmentData> lista){
		PrintWriterUtils.toJson(_pw, lista, valor->toJson(_pw, valor));
	}
	public static void toJsonAttatchmentData(java.io.PrintWriter _pw, java.util.Map<Long, AttatchmentData> mapa){
		PrintWriterUtils.toJson(_pw, mapa, valor-> toJson(_pw, valor));
	}
}
