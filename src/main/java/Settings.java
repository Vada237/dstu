import java.util.Map;

public class Settings {
    static final String HOST = System.getenv("DB_HOST");
    static final String PASSWORD = System.getenv("DB_PASSWORD");
    static final String USER = System.getenv("DB_USER");
    static final String PORT = System.getenv("DB_PORT");
    static final String DRIVER = System.getenv("DB_DRIVER");
}
