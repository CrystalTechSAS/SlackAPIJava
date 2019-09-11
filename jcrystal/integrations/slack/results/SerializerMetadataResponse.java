package integrations.slack.results;
import java.io.*;
import integrations.slack.PrintWriterUtils;
import static integrations.slack.JSONUtils.*;
import integrations.slack.entities.enums.*;
@SuppressWarnings("unused")
public class SerializerMetadataResponse{
	public static void toJson(java.io.PrintWriter _pw, MetadataResponse objeto){
		_pw.print("{");
		String val0 = objeto.next_cursor();
		if(val0 != null){
			PrintWriterUtils.print(_pw, "\"next_cursor\":", jsonQuote(val0));
		}
		_pw.print("}");
	}
	public static void toJsonMetadataResponse(java.io.PrintWriter _pw, java.lang.Iterable<MetadataResponse> lista){
		PrintWriterUtils.toJson(_pw, lista, valor->toJson(_pw, valor));
	}
	public static void toJsonMetadataResponse(java.io.PrintWriter _pw, java.util.Map<Long, MetadataResponse> mapa){
		PrintWriterUtils.toJson(_pw, mapa, valor-> toJson(_pw, valor));
	}
}
