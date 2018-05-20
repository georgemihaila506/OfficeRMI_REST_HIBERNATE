package Repository;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class RepoUtils {
    private Properties properties;

    public RepoUtils(Properties properties)
    {
        this.properties=properties;
    }
    private Connection instance=null;
    private Connection getNewConnection()
    {
        String driver=properties.getProperty("office.jdbc.driver");
        String url=properties.getProperty("office.jdbc.url");
        Connection con=null;
        try
        {
            Class.forName(driver);
            con= DriverManager.getConnection(url);
        }
        catch(ClassNotFoundException e)
        {
            System.out.println("Error loading driver "+e);
        }
        catch (SQLException e)
        {
            System.out.println("Error getting connection "+e);
        }
        return con;
    }
    public Connection getConnection()
    {
        try
        {
            if(instance==null||instance.isClosed())
                instance=getNewConnection();
        }
        catch(SQLException e)
        {
            System.out.println("Error DB "+e);
        }
        return instance;
    }
}
