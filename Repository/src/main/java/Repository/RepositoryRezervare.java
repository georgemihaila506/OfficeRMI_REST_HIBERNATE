package Repository;

import Domain.Cursa;
import Domain.Rezervare;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class RepositoryRezervare implements RepositoryRezervareInterface {
    private RepoUtils repoUtils;
    public RepositoryRezervare(Properties properties) {
        repoUtils = new RepoUtils(properties);
    }
    public void rezerva(int codCursa,Cursa cursa, Rezervare rezervare)
    {
        Connection con=repoUtils.getConnection();
        try (PreparedStatement preparedStatement = con.prepareStatement("insert into Rezervari(Nume, NrLocuri, CodCursa) VALUES(?,?,?)")) {
                preparedStatement.setString(1,rezervare.getNume());
                preparedStatement.setInt(2,rezervare.getNrLocuri());
                preparedStatement.setInt(3,codCursa);
                preparedStatement.execute();
                } catch (SQLException e) {
                e.printStackTrace(); }
        }
    public List<Rezervare> cautaRezervari(int codCursa)
    {
        List<Rezervare> rezervares=new ArrayList<>();
        Connection con=repoUtils.getConnection();
        try(PreparedStatement preparedStatement=con.prepareStatement("select Nume,NrLocuri from Rezervari where CodCursa=?"))
        {
            preparedStatement.setInt(1,codCursa);
            try(ResultSet resultSet=preparedStatement.executeQuery())
            {
                while(resultSet.next())
                {
                    rezervares.add(new Rezervare(resultSet.getString(1),resultSet.getInt(2)));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rezervares;
    }

    @Override
    public void addEntity(Rezervare entity) {

    }

    @Override
    public void deleteEntity(Rezervare entity) {

    }

    @Override
    public List<Rezervare> getAll() {
        return null;
    }

    @Override
    public void findOne(Rezervare entity) {

    }
}
