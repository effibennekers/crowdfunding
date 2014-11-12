package nl.ing.crowdfunding.dao;

import java.sql.Connection;
import java.sql.ResultSet;

import nl.ing.crowdfunding.domain.Project;
import nl.ing.crowdfunding.domain.ProjectStatus;

import nl.ing.crowdfunding.util.ConnectionUtils;
import org.springframework.stereotype.Repository;

import com.mysql.jdbc.PreparedStatement;

@Repository
public class ProjectRepository {

	public Project find(String id) {
		Project project = new Project();
		try {
			Connection connection = ConnectionUtils.getConnection();

			PreparedStatement preparedStatement = (PreparedStatement) connection
					.prepareStatement("select * from crowdfunding.project where projectid= ? ; ");
			preparedStatement.setString(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
                project.setProjectid(resultSet.getInt("projectid"));
				project.setTitel(resultSet.getString("titel"));
				project.setAangemeld(resultSet.getDate("aangemeld"));
				project.setBeschrijving(resultSet.getString("beschrijving"));
				project.setDoelbedrag(resultSet.getBigDecimal("doelbedrag"));
				project.setOpentijd(resultSet.getInt("opentijd"));
				project.setRentepercentage(resultSet
						.getBigDecimal("rentepercentage"));
				project.setRisicoprofiel(resultSet.getInt("risicoprofiel"));
				project.setEigenaar(null);
				project.setStatus(ProjectStatus.fromValue(resultSet
						.getString("status")));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return project;
	}

    public void save(Project project) {
        //TODO
    }

    public void delete(String id) {
        //TODO
    }

}
