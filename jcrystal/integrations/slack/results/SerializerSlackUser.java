package integrations.slack.results;
import java.io.*;
import integrations.slack.PrintWriterUtils;
import static integrations.slack.JSONUtils.*;
import integrations.slack.entities.enums.*;
@SuppressWarnings("unused")
public class SerializerSlackUser{
	public static void toJson(java.io.PrintWriter _pw, SlackUser objeto){
		boolean __first = true;
		_pw.print("{");
		String val0 = objeto.id();
		if(val0 != null){
			PrintWriterUtils.print(_pw, "\"id\":", jsonQuote(val0));
			__first = false;
		}
		String val1 = objeto.name();
		if(val1 != null){
			if(__first){
				PrintWriterUtils.print(_pw, "\"name\":", jsonQuote(val1));
				__first = false;
			}
			else{
				PrintWriterUtils.print(_pw, ",\"name\":", jsonQuote(val1));
			}
		}
		_pw.print("}");
	}
	public static void toJsonSlackUser(java.io.PrintWriter _pw, java.lang.Iterable<SlackUser> lista){
		PrintWriterUtils.toJson(_pw, lista, valor->toJson(_pw, valor));
	}
	public static void toJsonSlackUser(java.io.PrintWriter _pw, java.util.Map<Long, SlackUser> mapa){
		PrintWriterUtils.toJson(_pw, mapa, valor-> toJson(_pw, valor));
	}
}
