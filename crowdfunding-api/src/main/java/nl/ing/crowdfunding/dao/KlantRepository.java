package nl.ing.crowdfunding.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import nl.ing.crowdfunding.domain.Klant;
import nl.ing.crowdfunding.util.ConnectionUtils;

import org.springframework.stereotype.Repository;

import com.mysql.jdbc.PreparedStatement;

@Repository
public class KlantRepository {

    public static final String INSERT = "insert into  crowdfunding.klant values (default, ?, ?, ?, ? , ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    public List<Klant> getAll() {
    	List<Klant> klantLijst = new ArrayList<Klant>();
        try {
            Connection connection = ConnectionUtils.getConnection();

            PreparedStatement preparedStatement = (PreparedStatement) connection
                    .prepareStatement("select * from crowdfunding.klant ; ");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
            	
            	Klant klant = new Klant();
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
                klant.setTelefoonnummer(resultSet.getString("telefoonnummer"));
                klant.setTelefoonnummermobiel(resultSet.getString("telefoonnummermobiel"));
                klant.setTelefoonnummersms(resultSet.getString("telefoonnummersms"));
                klant.setTussenvoegsels(resultSet.getString("tussenvoegsels"));
                klant.setVoornaam(resultSet.getString("voornaam"));
                klant.setPostcode(resultSet.getString("postcode"));
                klant.setAuthtoken(resultSet.getString("authtoken"));
                klant.setPassword(resultSet.getString("password"));
                klantLijst.add(klant);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return klantLijst;
    }
    
    
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
                klant.setTelefoonnummer(resultSet.getString("telefoonnummer"));
                klant.setTelefoonnummermobiel(resultSet.getString("telefoonnummermobiel"));
                klant.setTelefoonnummersms(resultSet.getString("telefoonnummersms"));
                klant.setTussenvoegsels(resultSet.getString("tussenvoegsels"));
                klant.setVoornaam(resultSet.getString("voornaam"));
                klant.setPostcode(resultSet.getString("postcode"));
                klant.setAuthtoken(resultSet.getString("authtoken"));
                klant.setPassword(resultSet.getString("password"));
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
                // telefoonnummer, telefoonnummersms, telefoonnummermobiel, geboortedag, ingklant, contract, email postcode authtoken password
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
                preparedStatement.setString(10, klant.getTelefoonnummer());
                preparedStatement.setString(11, klant.getTelefoonnummersms());
                preparedStatement.setString(12, klant.getTelefoonnummermobiel());
                preparedStatement.setDate(13, new java.sql.Date(klant.getGeboortedag().getTime()));
                preparedStatement.setBoolean(14, klant.getIngklant());
                preparedStatement.setString(15, klant.getContract());
                preparedStatement.setString(16, klant.getEmail());
                preparedStatement.setString(17, klant.getPostcode());
                preparedStatement.setString(18, klant.getAuthtoken());
                preparedStatement.setString(19, klant.getPassword());
                preparedStatement.executeUpdate();
                preparedStatement.close();
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
                buffer.append("telefoonnummermobiel = ?, ");
                buffer.append("geboortedag = ?, ");
                buffer.append("ingklant = ?, ");
                buffer.append("contract = ?, ");
                buffer.append("email = ?, ");
                buffer.append("postcode = ?, ");
                buffer.append("authtoken = ?, ");
                buffer.append("password = ? ");
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
                preparedStatement.setString(10, klant.getTelefoonnummer());
                preparedStatement.setString(11, klant.getTelefoonnummersms());
                preparedStatement.setString(12, klant.getTelefoonnummermobiel());
                preparedStatement.setDate(13, new java.sql.Date(klant.getGeboortedag().getTime()));
                preparedStatement.setBoolean(14, klant.getIngklant());
                preparedStatement.setString(15, klant.getContract());
                preparedStatement.setString(16, klant.getEmail());
                preparedStatement.setInt(17, klant.getKlantid());
                preparedStatement.setString(18, klant.getPostcode());
                preparedStatement.setString(19, klant.getAuthtoken());
                preparedStatement.setString(20, klant.getPassword());
                preparedStatement.executeUpdate();
                preparedStatement.close();
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
            preparedStatement.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
