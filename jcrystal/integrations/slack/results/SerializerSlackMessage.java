package integrations.slack.results;
import java.io.*;
import integrations.slack.PrintWriterUtils;
import static integrations.slack.JSONUtils.*;
import integrations.slack.entities.enums.*;
@SuppressWarnings("unused")
public class SerializerSlackMessage{
	public static void toJson(java.io.PrintWriter _pw, SlackMessage objeto){
		_pw.print("{");
		PrintWriterUtils.print(_pw, "\"hidden\":", objeto.hidden());
		PrintWriterUtils.print(_pw, ",\"reply_count\":", objeto.reply_count());
		PrintWriterUtils.print(_pw, ",\"reply_users_count\":", objeto.reply_users_count());
		String val3 = objeto.client_msg_id();
		if(val3 != null){
			PrintWriterUtils.print(_pw, ",\"client_msg_id\":", jsonQuote(val3));
		}
		String val4 = objeto.type();
		if(val4 != null){
			PrintWriterUtils.print(_pw, ",\"type\":", jsonQuote(val4));
		}
		String val5 = objeto.text();
		if(val5 != null){
			PrintWriterUtils.print(_pw, ",\"text\":", jsonQuote(val5));
		}
		String val6 = objeto.user();
		if(val6 != null){
			PrintWriterUtils.print(_pw, ",\"user\":", jsonQuote(val6));
		}
		String val7 = objeto.ts();
		if(val7 != null){
			PrintWriterUtils.print(_pw, ",\"ts\":", jsonQuote(val7));
		}
		String val8 = objeto.team();
		if(val8 != null){
			PrintWriterUtils.print(_pw, ",\"team\":", jsonQuote(val8));
		}
		String val9 = objeto.thread_ts();
		if(val9 != null){
			PrintWriterUtils.print(_pw, ",\"thread_ts\":", jsonQuote(val9));
		}
		String val10 = objeto.parent_user_id();
		if(val10 != null){
			PrintWriterUtils.print(_pw, ",\"parent_user_id\":", jsonQuote(val10));
		}
		String val11 = objeto.subtype();
		if(val11 != null){
			PrintWriterUtils.print(_pw, ",\"subtype\":", jsonQuote(val11));
		}
		String val12 = objeto.latest_reply();
		if(val12 != null){
			PrintWriterUtils.print(_pw, ",\"latest_reply\":", jsonQuote(val12));
		}
		java.util.List<String> val13 = objeto.reply_users();
		if(val13 != null){
			_pw.print(",\"reply_users\":");
			jsonQuoteString(_pw, val13);
		}
		java.util.List<integrations.slack.results.SlackReplies> val14 = objeto.replies();
		if(val14 != null){
			_pw.print(",\"replies\":");
			SerializerSlackReplies.toJsonSlackReplies(_pw, val14);
		}
		_pw.print("}");
	}
	public static void toJsonSlackMessage(java.io.PrintWriter _pw, java.lang.Iterable<SlackMessage> lista){
		PrintWriterUtils.toJson(_pw, lista, valor->toJson(_pw, valor));
	}
	public static void toJsonSlackMessage(java.io.PrintWriter _pw, java.util.Map<Long, SlackMessage> mapa){
		PrintWriterUtils.toJson(_pw, mapa, valor-> toJson(_pw, valor));
	}
}
