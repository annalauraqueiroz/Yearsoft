package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import model.ModeloMySql;

public class FabricaDeConexao {


	public static Connection getConnection(ModeloMySql dados) {
		//padrão de conexão do mysql
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}


		try {
			return DriverManager.getConnection(dados.toString(), dados.getUser(), dados.getPassword());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}     

	public static void closeConnection(Connection c){
		try {
			c.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


}
