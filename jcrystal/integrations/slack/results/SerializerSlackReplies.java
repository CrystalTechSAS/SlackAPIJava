package integrations.slack.results;
import java.io.*;
import integrations.slack.PrintWriterUtils;
import static integrations.slack.JSONUtils.*;
import integrations.slack.entities.enums.*;
@SuppressWarnings("unused")
public class SerializerSlackReplies{
	public static void toJson(java.io.PrintWriter _pw, SlackReplies objeto){
		boolean __first = true;
		_pw.print("{");
		String val0 = objeto.user();
		if(val0 != null){
			PrintWriterUtils.print(_pw, "\"user\":", jsonQuote(val0));
			__first = false;
		}
		String val1 = objeto.ts();
		if(val1 != null){
			if(__first){
				PrintWriterUtils.print(_pw, "\"ts\":", jsonQuote(val1));
				__first = false;
			}
			else{
				PrintWriterUtils.print(_pw, ",\"ts\":", jsonQuote(val1));
			}
		}
		_pw.print("}");
	}
	public static void toJsonSlackReplies(java.io.PrintWriter _pw, java.lang.Iterable<SlackReplies> lista){
		PrintWriterUtils.toJson(_pw, lista, valor->toJson(_pw, valor));
	}
	public static void toJsonSlackReplies(java.io.PrintWriter _pw, java.util.Map<Long, SlackReplies> mapa){
		PrintWriterUtils.toJson(_pw, mapa, valor-> toJson(_pw, valor));
	}
}
