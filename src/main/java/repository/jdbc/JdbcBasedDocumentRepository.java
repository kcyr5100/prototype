package repository.jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.text.SimpleDateFormat;
import java.text.DateFormat;

import domain.Documents;
import repository.DataSource;
import repository.IDocumentRepository;

public class JdbcBasedDocumentRepository implements IDocumentRepository {
    private DataSource dataSource;
    DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
    public JdbcBasedDocumentRepository(DataSource dataSource){
        this.dataSource = dataSource;
    }
    public Documents[] getAll(){
        String query = "SELECT * FROM documents";
        List<Documents> documents = new ArrayList<Documents>();

        try {
            Connection connection = dataSource.createConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query) ;

            while (rs.next()) {
                int id = rs.getInt("id");
                String title = rs.getString("title");
                String fileName = rs.getString("fileName");
                String productionDate = rs.getString("productionDate");
                int format = rs.getInt("format");
                int documentType = rs.getInt("documentType");
                int faculty = rs.getInt("faculty");
                Documents document = new Documents( id, title, fileName, productionDate, format, documentType, faculty);

                documents.add(document);
            }
            return documents.toArray(new Documents[0]);

        }
        catch (SQLException e) {
            return new Documents[0];
        }
        catch (Exception ex){
            return new Documents[0];
        }
    };

    public int create(Documents document){
        int status = 0;
        String query = "INSERT INTO documents (title,fileName,productionDate,createdAt,format,documentType,faculty) VALUES(?,?,?,?,?,?,?)";
        try{
            Connection connection = dataSource.createConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1,document.getTitle());
            statement.setString(2, document.getFileName());
            statement.setString(3, document.getProductionDate());
            statement.setString(4, dateFormat.format(document.getCreatedAt()));
            statement.setInt(5, document.getFormat());
            statement.setInt(6, document.getDocumentType());
            statement.setInt(7, document.getFaculty());
            status = statement.executeUpdate();

            if (status > 0) {
                System.out.println("Document added successfully");
            }
            return status;
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    };

    public int update(Documents document){
        String query = "UPDATE documents SET title=?, fileName=?, productionDate=?, createdAt=?, format=?, documentType=?, faculty=? where id=?";
        int status = 0;
        try {

            Connection connection = dataSource.createConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1,document.getTitle());
            statement.setString(2, document.getFileName());
            statement.setString(3, document.getProductionDate());
            statement.setString(4, dateFormat.format(document.getCreatedAt()));
            statement.setInt(5, document.getFormat());
            statement.setInt(6, document.getDocumentType());
            statement.setInt(7, document.getFaculty());
            statement.setInt(8, document.getId());
            System.out.println(statement);
            status = statement.executeUpdate();
            if (status > 0) {
                System.out.println("Document altered successfully!");
            }
            return status;
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return 0;
    };

    public int delete(int id){
        String query = "DELETE FROM documents where id=?";
        int status =0;
        try {
            Connection connection = dataSource.createConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            status = statement.executeUpdate();
            if (status > 0) {
                System.out.println("Document deleted successfully");
            }
            return status;
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return 0;
    };
}
