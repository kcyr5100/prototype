package repository;
import java.sql.Connection;

public interface DataSource {
    Connection createConnection();
}