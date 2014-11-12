package nl.ing.crowdfunding.dao;

import com.mysql.jdbc.PreparedStatement;
import nl.ing.crowdfunding.domain.Investering;
import nl.ing.crowdfunding.domain.Klant;
import nl.ing.crowdfunding.domain.Project;
import nl.ing.crowdfunding.domain.ProjectStatus;
import nl.ing.crowdfunding.util.ConnectionUtils;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;

@Repository
public class KlantRepository {

    public static final String INSERT = "insert into  crowdfunding.klant values (default, ?, ?, ?, ? , ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    public Klant find(String id) {
        Klant klant = new Klant();
        try {
            Connection connection = ConnectionUtils.getConnection();

            PreparedStatement preparedStatement = (PreparedStatement) connection
                    .prepareStatement("select * from crowdfunding.klant where klantid= ? ; ");
            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                klant.setKlantid(resultSet.getInt("klantid"));
                klant.setAchternaam(resultSet.getString("achternaam"));
                klant.setContract(resultSet.getString("contract"));
                klant.setCreditoriban(resultSet.getString("creditoriban"));
                klant.setDebtoriban(resultSet.getString("debtoriban"));
                klant.setEmail(resultSet.getString("email"));
                klant.setGeboortedag(resultSet
                        .getDate("geboortedag"));
                klant.setHuisnummer(resultSet.getInt("huisnummer"));
                klant.setHuisnummerav(resultSet.getString("huisnummerav"));
                klant.setIngklant(resultSet.getBoolean("ingklant"));
                klant.setPlaats(resultSet.getString("plaats"));
                klant.setStraatnaam(resultSet.getString("straatnaam"));
                klant.setTelefoonnummer(resultSet.getBigDecimal("telefoonnummer").toBigInteger());
                klant.setTelefoonnummerrmobiel(resultSet.getBigDecimal("telefoonnummerrmobiel").toBigInteger());
                klant.setTelefoonnummersms(resultSet.getBigDecimal("telefoonnummersms").toBigInteger());
                klant.setTussenvoegsels(resultSet.getString("tussenvoegsels"));
                klant.setVoornaam(resultSet.getString("voornaam"));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return klant;
    }

    public void save(Klant klant) {
        try {
            Connection connection = ConnectionUtils.getConnection();
            if (klant.getKlantid() == 0) {

                PreparedStatement preparedStatement = (PreparedStatement) connection
                        .prepareStatement(INSERT);

                // klantid, voornaam, achternaam, tussenvoegsels, straatnaam, huisnummer, huisnummerav, plaats, debtoriban, creditoriban,
                // telefoonnummer, telefoonnummersms, telefoonnummerrmobiel, geboortedag, ingklant, contract, email
                // parameters start with 1
                preparedStatement.setString(1, klant.getVoornaam());
                preparedStatement.setString(2, klant.getAchternaam());
                preparedStatement.setString(3, klant.getTussenvoegsels());
                preparedStatement.setString(4, klant.getStraatnaam());
                preparedStatement.setInt(5, klant.getHuisnummer());
                preparedStatement.setString(6, klant.getHuisnummerav());
                preparedStatement.setString(7, klant.getPlaats());
                preparedStatement.setString(8, klant.getDebtoriban());
                preparedStatement.setString(9, klant.getCreditoriban());
                preparedStatement.setBigDecimal(10, BigDecimal.valueOf(klant.getTelefoonnummer().longValue()));
                preparedStatement.setBigDecimal(11, BigDecimal.valueOf(klant.getTelefoonnummersms().longValue()));
                preparedStatement.setBigDecimal(12, BigDecimal.valueOf(klant.getTelefoonnummerrmobiel().longValue()));
                preparedStatement.setDate(13, new java.sql.Date(klant.getGeboortedag().getTime()));
                preparedStatement.setBoolean(14, klant.getIngklant());
                preparedStatement.setString(15, klant.getContract());
                preparedStatement.setString(16, klant.getEmail());
                preparedStatement.executeUpdate();

            } else {
                StringBuffer buffer = new StringBuffer();
                buffer.append("UPDATE crowdfunding.klant SET ");
                buffer.append("voornaam = ?, ");
                buffer.append("achternaam = ?, ");
                buffer.append("tussenvoegsels = ?, ");
                buffer.append("straatnaam = ?, ");
                buffer.append("huisnummer = ?, ");
                buffer.append("huisnummerav = ?, ");
                buffer.append("plaats = ?, ");
                buffer.append("debtoriban = ?, ");
                buffer.append("creditoriban = ?, ");
                buffer.append("telefoonnummer = ?, ");
                buffer.append("telefoonnummersms = ?, ");
                buffer.append("telefoonnummerrmobiel = ?, ");
                buffer.append("geboortedag = ?, ");
                buffer.append("ingklant = ?, ");
                buffer.append("contract = ?, ");
                buffer.append("email = ? ");
                buffer.append("WHERE klantid = ?");

                PreparedStatement preparedStatement = (PreparedStatement) connection
                        .prepareStatement(buffer.toString());

                preparedStatement.setString(1, klant.getVoornaam());
                preparedStatement.setString(2, klant.getAchternaam());
                preparedStatement.setString(3, klant.getTussenvoegsels());
                preparedStatement.setString(4, klant.getStraatnaam());
                preparedStatement.setInt(5, klant.getHuisnummer());
                preparedStatement.setString(6, klant.getHuisnummerav());
                preparedStatement.setString(7, klant.getPlaats());
                preparedStatement.setString(8, klant.getDebtoriban());
                preparedStatement.setString(9, klant.getCreditoriban());
                preparedStatement.setBigDecimal(10, BigDecimal.valueOf(klant.getTelefoonnummer().longValue()));
                preparedStatement.setBigDecimal(11, BigDecimal.valueOf(klant.getTelefoonnummersms().longValue()));
                preparedStatement.setBigDecimal(12, BigDecimal.valueOf(klant.getTelefoonnummerrmobiel().longValue()));
                preparedStatement.setDate(13, new java.sql.Date(klant.getGeboortedag().getTime()));
                preparedStatement.setBoolean(14, klant.getIngklant());
                preparedStatement.setString(15, klant.getContract());
                preparedStatement.setString(16, klant.getEmail());
                preparedStatement.setInt(16, klant.getKlantid());
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
                    .prepareStatement("delete from crowdfunding.klant where klantid= ? ; ");
            preparedStatement.setString(1, id);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
