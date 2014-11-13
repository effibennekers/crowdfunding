package nl.ing.crowdfunding.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import nl.ing.crowdfunding.domain.Investering;
import nl.ing.crowdfunding.domain.InvesteringsStatus;
import nl.ing.crowdfunding.util.ConnectionUtils;

import org.springframework.stereotype.Repository;

import com.mysql.jdbc.PreparedStatement;

@Repository
public class InvesteringRepository {

	public List<Investering> getAll() {
		List<Investering> investeringtList = new ArrayList<Investering>();
		try {
			Connection connection = ConnectionUtils.getConnection();

			PreparedStatement preparedStatement = (PreparedStatement) connection
					.prepareStatement("select * from crowdfunding.investering;");
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Investering investering = new Investering();
				investering.setId(resultSet.getInt("investeringid"));
				investering.setInvesteerder(resultSet.getInt("investeerder"));
				investering.setBedrag(resultSet.getBigDecimal("bedrag"));
				investering.setProject(resultSet.getInt("project"));
				investering.setBeloning(resultSet.getString("beloning"));
				investering.setRentepercentage(resultSet.getBigDecimal("rentepercentage"));
				investering.setStatus(InvesteringsStatus.fromValue(resultSet.getString("status")));
				investering.setAfbetaalperiode(resultSet.getInt("afbetaalperiode"));
				investeringtList.add(investering);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return investeringtList;
	}
	
    public Investering find(String id) {
    	Investering investering = new Investering();
		try {
			Connection connection = ConnectionUtils.getConnection();

			PreparedStatement preparedStatement = (PreparedStatement) connection
					.prepareStatement("select * from crowdfunding.investering where investeringid= ? ; ");
			preparedStatement.setString(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
                investering.setId(resultSet.getInt("investeringid"));
				investering.setInvesteerder(resultSet.getInt("investeerder"));
				investering.setBedrag(resultSet.getBigDecimal("bedrag"));
				investering.setProject(resultSet.getInt("project"));
				investering.setBeloning(resultSet.getString("beloning"));
				investering.setRentepercentage(resultSet.getBigDecimal("rentepercentage"));
				investering.setStatus(InvesteringsStatus.fromValue(resultSet.getString("status")));
				investering.setAfbetaalperiode(resultSet.getInt("afbetaalperiode"));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return investering;
    }
    
    public List<Investering> findByProject(String projectId) {
    	List<Investering> investeringList = new ArrayList<Investering>();
    	try {
            Connection connection = ConnectionUtils.getConnection();

            PreparedStatement preparedStatement = (PreparedStatement) connection
                    .prepareStatement("select * from crowdfunding.investering WHERE project=? ; ");
            preparedStatement.setString(1, projectId);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
            	Investering investering = new Investering();
            	investering.setId(resultSet.getInt("investeringid"));
				investering.setInvesteerder(resultSet.getInt("investeerder"));
				investering.setBedrag(resultSet.getBigDecimal("bedrag"));
				investering.setProject(resultSet.getInt("project"));
				investering.setBeloning(resultSet.getString("beloning"));
				investering.setRentepercentage(resultSet.getBigDecimal("rentepercentage"));
				investering.setStatus(InvesteringsStatus.fromValue(resultSet.getString("status")));
				investering.setAfbetaalperiode(resultSet.getInt("afbetaalperiode"));
				investeringList.add(investering);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return investeringList;
    }

    public void save(Investering investering) {
    	try {
			Connection connection = ConnectionUtils.getConnection();
			
			if (investering.getId() == 0) {
				// insert
				PreparedStatement preparedStatement = (PreparedStatement) connection
						.prepareStatement("insert into crowdfunding.investering values (default,?,?,?,?,?,?,?)");
				preparedStatement.setInt(1, investering.getInvesteerder());
				preparedStatement.setBigDecimal(2, investering.getBedrag());
				preparedStatement.setInt(3, investering.getProject());
				preparedStatement.setString(4, investering.getBeloning());
				preparedStatement.setBigDecimal(5, investering.getRentepercentage());
				preparedStatement.setString(6, investering.getStatus().name());
				preparedStatement.setInt(7, investering.getAfbetaalperiode());
				preparedStatement.executeUpdate();
			} else {
				// update existing
				StringBuffer buff = new StringBuffer("UPDATE crowdfunding.investering set ");
				
				buff.append("investeerder=?");
				buff.append(", bedrag=?");
				buff.append(", project=?");
				buff.append(", beloning=?");
				buff.append(", rentepercentage=?");
				buff.append(", status=?");
				buff.append(", afbetaalperiode=?");
				buff.append("WHERE investeringid=?");
				
				PreparedStatement preparedStatement = (PreparedStatement) connection
                        .prepareStatement(buff.toString());

				preparedStatement.setInt(1, investering.getInvesteerder());
				preparedStatement.setBigDecimal(2, investering.getBedrag());
				preparedStatement.setInt(3, investering.getProject());
				preparedStatement.setString(4, investering.getBeloning());
				preparedStatement.setBigDecimal(5, investering.getRentepercentage());
				preparedStatement.setString(6, investering.getStatus().name());
				preparedStatement.setInt(7, investering.getAfbetaalperiode());
				preparedStatement.setInt(8, investering.getId());
                preparedStatement.executeUpdate();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
    }

    public void delete(String id) {
    	 try {
         	BigDecimal decId = new BigDecimal(id);
         	
 			Connection connection = ConnectionUtils.getConnection();

 			PreparedStatement preparedStatement = (PreparedStatement) connection
 					.prepareStatement("delete from crowdfunding.investering where id= ? ; ");
 			preparedStatement.setBigDecimal(1, decId);
 			preparedStatement.executeUpdate();
 		} catch (Exception e) {
 			System.out.println(e.getMessage());
 		}
    }

}
