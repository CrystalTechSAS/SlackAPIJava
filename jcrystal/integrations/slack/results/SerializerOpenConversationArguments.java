package integrations.slack.results;
import java.io.*;
import integrations.slack.PrintWriterUtils;
import static integrations.slack.JSONUtils.*;
import integrations.slack.entities.enums.*;
@SuppressWarnings("unused")
public class SerializerOpenConversationArguments{
	public static void toJson(java.io.PrintWriter _pw, OpenConversationArguments objeto){
		boolean __first = true;
		_pw.print("{");
		String val0 = objeto.channel();
		if(val0 != null){
			PrintWriterUtils.print(_pw, "\"channel\":", jsonQuote(val0));
			__first = false;
		}
		String val1 = objeto.users();
		if(val1 != null){
			if(__first){
				PrintWriterUtils.print(_pw, "\"users\":", jsonQuote(val1));
				__first = false;
			}
			else{
				PrintWriterUtils.print(_pw, ",\"users\":", jsonQuote(val1));
			}
		}
		_pw.print("}");
	}
	public static void toJsonOpenConversationArguments(java.io.PrintWriter _pw, java.lang.Iterable<OpenConversationArguments> lista){
		PrintWriterUtils.toJson(_pw, lista, valor->toJson(_pw, valor));
	}
	public static void toJsonOpenConversationArguments(java.io.PrintWriter _pw, java.util.Map<Long, OpenConversationArguments> mapa){
		PrintWriterUtils.toJson(_pw, mapa, valor-> toJson(_pw, valor));
	}
}
