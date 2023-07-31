package model;

public class ModeloMySql {
	
	public String user;
	public String password;
	public String server;
	public String port;
	public String database;
	
	public ModeloMySql() {
		super();
	}

	public ModeloMySql(String user, String password, String server, String port, String database) {
		super();
		this.user = user;
		this.password = password;
		this.server = server;
		this.port = port;
		this.database = database;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getServer() {
		return server;
	}

	public void setServer(String server) {
		this.server = server;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public String getDatabase() {
		return database;
	}

	public void setDatabase(String database) {
		this.database = database;
	}
	
	
	public String toString(){
		return "jdbc:mysql://"+server+"/"+database;
	}

}

