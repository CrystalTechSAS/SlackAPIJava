package integrations.slack.net.utils;
public class RequestError extends Exception{
    public static final int UNAUTHORIZED_CODE = 3;
    public static final int UPGRADE_REQUIRED_CODE = 426;

    public final TipoError tipoError;
    public final String mensaje;
    public final int codigo;

    public RequestError(TipoError tipoError, String mensaje) {
    	super(tipoError + ": " + mensaje);
        this.tipoError = tipoError;
        this.mensaje = mensaje;
        this.codigo = -1;
    }
    public RequestError(int codigo, String mensaje) {
    	super("Error: " + mensaje);
        this.tipoError = TipoError.ERROR;
        this.mensaje = mensaje;
        this.codigo = codigo;
    }
}
