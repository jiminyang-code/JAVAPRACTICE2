import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DB {

	public static void main(String[] args) {
		 //getConnection(); //MySql과연결
		 createTable(); //테이블생성
	}
	public static Connection getConnection() {
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/sampledb?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false";
		String user = "root";
		String pass = "1234";

		try {
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url, user, pass);
			System.out.println("DB 연결 완료!");
			return conn;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}
	public static void createTable() {
		try {
			Connection conn = getConnection(); // DB연결 conn객체
			PreparedStatement create = conn.prepareStatement(
					"CREATE TABLE IF NOT EXISTS " 
			+ "customer(customer_id int NOT NULL AUTO_INCREMENT,"
		    + "id varChar(255)," 
			+ "pass varChar(255)," 
		    + "gender varChar(255)," 
			+ "phone varChar(255),"
			+ "note varChar(255)," 
			+ "PRIMARY KEY(customer_id))");
			create.execute();
			System.out.println("테이블을 만들었습니다.");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

//	public static void createPermanent(String name, String number, String position) {
//		try {
//			Connection conn = getConnection(); //DB연결 conn객체
//			PreparedStatement insert = conn.prepareStatement(
//					"INSERT INTO student( name, dept, id) "
//					+ "VALUES ('"+name+"','"+number+"','"+position+"')");
//			insert.execute();
//			System.out.println("저장했습니다.");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		}
}
