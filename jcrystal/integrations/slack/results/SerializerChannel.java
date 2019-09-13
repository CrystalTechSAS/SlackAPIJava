package integrations.slack.results;
import java.io.*;
import integrations.slack.PrintWriterUtils;
import static integrations.slack.JSONUtils.*;
import integrations.slack.entities.enums.*;
@SuppressWarnings("unused")
public class SerializerChannel{
	public static void toJson(java.io.PrintWriter _pw, Channel objeto){
		_pw.print("{");
		PrintWriterUtils.print(_pw, "\"is_im\":", objeto.is_im());
		PrintWriterUtils.print(_pw, ",\"is_org_shared\":", objeto.is_org_shared());
		PrintWriterUtils.print(_pw, ",\"unread_count\":", objeto.unread_count());
		PrintWriterUtils.print(_pw, ",\"unread_count_display\":", objeto.unread_count_display());
		PrintWriterUtils.print(_pw, ",\"is_open\":", objeto.is_open());
		PrintWriterUtils.print(_pw, ",\"priority\":", objeto.priority());
		String val6 = objeto.id();
		if(val6 != null){
			PrintWriterUtils.print(_pw, ",\"id\":", jsonQuote(val6));
		}
		String val7 = objeto.user();
		if(val7 != null){
			PrintWriterUtils.print(_pw, ",\"user\":", jsonQuote(val7));
		}
		_pw.print("}");
	}
	public static void toJsonChannel(java.io.PrintWriter _pw, java.lang.Iterable<Channel> lista){
		PrintWriterUtils.toJson(_pw, lista, valor->toJson(_pw, valor));
	}
	public static void toJsonChannel(java.io.PrintWriter _pw, java.util.Map<Long, Channel> mapa){
		PrintWriterUtils.toJson(_pw, mapa, valor-> toJson(_pw, valor));
	}
}
