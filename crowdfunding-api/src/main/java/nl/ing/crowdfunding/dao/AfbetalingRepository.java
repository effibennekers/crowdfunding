package nl.ing.crowdfunding.dao;

import com.mysql.jdbc.PreparedStatement;
import nl.ing.crowdfunding.domain.*;
import nl.ing.crowdfunding.util.ConnectionUtils;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class AfbetalingRepository {

    public List<Afbetaling> getAll() {
        List<Afbetaling> afbetalingen = new ArrayList<Afbetaling>();
        try {
            Connection connection = ConnectionUtils.getConnection();

            PreparedStatement preparedStatement = (PreparedStatement) connection
                    .prepareStatement("select * from crowdfunding.afbetaling;");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                afbetalingen.add(resultSetToAfbetaling(resultSet));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return afbetalingen;
    }

    public Afbetaling find(String id) {
        Afbetaling afbetaling = null;
        try {
            Connection connection = ConnectionUtils.getConnection();

            PreparedStatement preparedStatement = (PreparedStatement) connection
                    .prepareStatement("select * from crowdfunding.investering where id= ? ; ");
            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                afbetaling = resultSetToAfbetaling(resultSet);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return afbetaling;
    }

    public void save(Afbetaling afbetaling) {
        try {
            Connection connection = ConnectionUtils.getConnection();
            // afbetalingid, investering, bedrag, datumtijd
            if (afbetaling.getId() == 0) {
                // insert
                PreparedStatement preparedStatement = (PreparedStatement) connection
                        .prepareStatement("insert into crowdfunding.afbetaling values (default,?,?,?)");
                preparedStatement.setInt(1, afbetaling.getInvestering());
                preparedStatement.setBigDecimal(2, afbetaling.getBedrag());
                preparedStatement.setDate(3, new java.sql.Date(new Date().getTime()));
                preparedStatement.executeUpdate();
            } else {
                // update existing
                StringBuffer buff = new StringBuffer("UPDATE crowdfunding.project set ");

                buff.append("investering=?");
                buff.append(", bedrag=?");
                buff.append("WHERE afbetalingid=?");

                PreparedStatement preparedStatement = (PreparedStatement) connection
                        .prepareStatement(buff.toString());

                preparedStatement.setInt(1, afbetaling.getInvestering());
                preparedStatement.setBigDecimal(2, afbetaling.getBedrag());
                preparedStatement.setInt(3, afbetaling.getId());
                preparedStatement.executeUpdate();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void delete(String id) {
        try {
            Connection connection = ConnectionUtils.getConnection();

            PreparedStatement preparedStatement = (PreparedStatement) connection
                    .prepareStatement("delete from crowdfunding.project where projectid= ? ; ");
            preparedStatement.setBigDecimal(1, new BigDecimal(id));
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private Afbetaling resultSetToAfbetaling(ResultSet resultSet) throws SQLException {
        Afbetaling afbetaling = new Afbetaling();
        afbetaling.setDatumtijd(resultSet.getDate("datumtijd"));
        afbetaling.setBedrag(resultSet.getBigDecimal("bedrag"));
        afbetaling.setInvestering(resultSet.getInt("investering"));
        afbetaling.setId(resultSet.getInt("afbetalingid"));
        return afbetaling;
    }

}
