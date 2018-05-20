package Repository;

import Domain.Rezervare;
import Domain.Users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class RepoUser implements RepoUserInterface {
    private RepoUtils repoUtils;
    public RepoUser(Properties properties)
    {
        repoUtils = new RepoUtils(properties);
    }
    @Override
    public boolean checkUser(Users users) {
        List<Rezervare> rezervares=new ArrayList<>();
        Connection con=repoUtils.getConnection();
        try(PreparedStatement preparedStatement=con.prepareStatement("select Username,Password from Users where Username=? and Password=?"))
        {
            preparedStatement.setString(1,users.getUsername());
            preparedStatement.setString(2,users.getPassword());
            try(ResultSet resultSet=preparedStatement.executeQuery())
            {
                while(resultSet.next())
                {
                    return  true;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public void addEntity(Users entity) {

    }

    @Override
    public void deleteEntity(Users entity) {

    }

    @Override
    public List<Users> getAll() {
        return null;
    }

    @Override
    public void findOne(Users entity) {

    }
}
