package nl.ing.crowdfunding.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import nl.ing.crowdfunding.domain.Project;
import nl.ing.crowdfunding.domain.ProjectStatus;
import nl.ing.crowdfunding.util.ConnectionUtils;

import org.springframework.stereotype.Repository;

import com.mysql.jdbc.PreparedStatement;

@Repository
public class ProjectRepository {

	public List<Project> getAll() {
		List<Project> projectList = new ArrayList<Project>();
		try {
			Connection connection = ConnectionUtils.getConnection();

			PreparedStatement preparedStatement = (PreparedStatement) connection
					.prepareStatement("select * from crowdfunding.project;");
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
                Project project = resultSetToProject(resultSet);
				projectList.add(project);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return projectList;
	}



    public Project find(String id) {
		Project project = null;
		try {
			Connection connection = ConnectionUtils.getConnection();

			PreparedStatement preparedStatement = (PreparedStatement) connection
					.prepareStatement("select * from crowdfunding.project where projectid= ? ; ");
			preparedStatement.setString(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
                project = resultSetToProject(resultSet);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return project;
	}

	public void save(Project project) {
		try {
			Connection connection = ConnectionUtils.getConnection();
			
			if (project.getProjectid() == 0) {
				// insert
				PreparedStatement preparedStatement = (PreparedStatement) connection
						.prepareStatement("insert into crowdfunding.project values (default,?,?,?,?,?,?,?,?,?,?)");
				preparedStatement.setString(1, project.getTitel());
				preparedStatement.setDate(2, new java.sql.Date(new Date().getTime()));
				preparedStatement.setString(3, project.getBeschrijving());
				preparedStatement.setBigDecimal(4, project.getDoelbedrag());
				preparedStatement.setInt(5, project.getOpentijd());
				preparedStatement.setBigDecimal(6, project.getRentepercentage());
				preparedStatement.setInt(7, project.getRisicoprofiel());
				preparedStatement.setInt(8, project.getEigenaar());
				preparedStatement.setInt(9, project.getEigenaarrisicoprofiel());
				preparedStatement.setString(10, project.getStatus().name());
				preparedStatement.executeUpdate();
			} else {
				// update existing
				StringBuffer buff = new StringBuffer("UPDATE crowdfunding.project set ");
				
				buff.append("titel=?");
				buff.append(", aangemeld=?");
				buff.append(", beschrijving=?");
				buff.append(", doelbedrag=?");
				buff.append(", opentijd=?");
				buff.append(", rentepercentage=?");
				buff.append(", eigenaar=?");
				buff.append(", status=?");
				buff.append("WHERE projectid=?");
				
				PreparedStatement preparedStatement = (PreparedStatement) connection
                        .prepareStatement(buff.toString());

                preparedStatement.setString(1, project.getTitel());
                preparedStatement.setDate(2, new java.sql.Date(project.getAangemeld().getTime()));
                preparedStatement.setString(3, project.getBeschrijving());
                preparedStatement.setBigDecimal(4, project.getDoelbedrag());
                preparedStatement.setInt(5, project.getOpentijd());
                preparedStatement.setBigDecimal(6, project.getRentepercentage());
                preparedStatement.setInt(7, project.getEigenaar());
                preparedStatement.setString(8, project.getStatus().name());
                preparedStatement.setInt(9, project.getProjectid());
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
					.prepareStatement("delete from crowdfunding.project where projectid= ? ; ");
			preparedStatement.setBigDecimal(1, decId);
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
    }

    private Project resultSetToProject(ResultSet resultSet) throws SQLException {
        Project project = new Project();
        project.setProjectid(resultSet.getInt("projectid"));
        project.setTitel(resultSet.getString("titel"));
        project.setAangemeld(resultSet.getDate("aangemeld"));
        project.setBeschrijving(resultSet.getString("beschrijving"));
        project.setDoelbedrag(resultSet.getBigDecimal("doelbedrag"));
        project.setOpentijd(resultSet.getInt("opentijd"));
        project.setRentepercentage(resultSet.getBigDecimal("rentepercentage"));
        project.setRisicoprofiel(resultSet.getInt("risicoprofiel"));
        project.setEigenaar(resultSet.getInt("eigenaar"));
        project.setStatus(ProjectStatus.fromValue(resultSet.getString("status")));
        project.setEigenaarrisicoprofiel(resultSet.getInt("eigenaarrisicoprofiel"));
        return project;
    }

}
