package integrations.slack.net.utils;
public enum TipoError {
    /**
     * Representa un error de la aplicacion, InternalErrpr
     */
    ERROR,
    /**
     * Representa un error de la conexión al servidor, json mal formados, errores HTTP, etc
     */
    SERVER_ERROR,
    UNAUTHORIZED,
    NO_INTERNET
}
