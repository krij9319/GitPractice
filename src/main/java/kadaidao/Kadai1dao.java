package kadaidao;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kadaidto.Kadai1dto;
import util.GenerateHashedPw;
import util.GenerateSalt;
public class Kadai1dao {
	private static Connection getConnection() throws URISyntaxException, SQLException {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	    URI dbUri = new URI(System.getenv("DATABASE_URL"));

	    String username = dbUri.getUserInfo().split(":")[0];
	    String password = dbUri.getUserInfo().split(":")[1];
	    String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath();

	    return DriverManager.getConnection(dbUrl, username, password);
	}
	
	public static int register(Kadai1dto ka1) {
		String sql = "INSERT INTO member VALUES(?, ?, ?, ?, ?, ?, ?)";
		int result = 0;
		
		String salt = GenerateSalt.getSalt(64);
		
		String hashedPw = GenerateHashedPw.getSafetyPassword(ka1.getPw(), salt);
		
		try (
				Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				){
			pstmt.setString(1, ka1.getName());
			pstmt.setInt(2, ka1.getAge());
			pstmt.setString(3, ka1.getGender());
			pstmt.setString(4, ka1.getPhototel());
			pstmt.setString(5, ka1.getMail());
			pstmt.setString(6, hashedPw);
			pstmt.setString(7, salt);

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} finally {
			System.out.println(result + "件更新しました。");
		}
		return result;
	}
	public static List<Kadai1dto> selectAll(){
		List<Kadai1dto> result = new ArrayList<>();
		String sql = "SELECT * FROM member";
		try (
				Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				){
			try (ResultSet rs = pstmt.executeQuery()){
				while(rs.next()) {
					String name = rs.getString("name");
					int age = rs.getInt("age");
					String gender = rs.getString("gender");
					String tel = rs.getString("tel");
					String email = rs.getString("email");
					Kadai1dto ka1 = new Kadai1dto(name, age, gender, tel, email, null, null, null);
					
					result.add(ka1);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return result;
	}
	public static int DeleteKadai_1(String mail) {
		
		String sql = "DELETE FROM member WHERE email = ?";
		int result = 0;
		try (
				Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				){
			
			pstmt.setString(1,mail );
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} finally {
			System.out.println(result + "件削除しました。");
		}
		return  result;
	}	
	
	public static String getSalt(String mail) {
		String sql = "SELECT salt FROM member WHERE email = ?";
		
		try (
				Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				){
			pstmt.setString(1, mail);

			try (ResultSet rs = pstmt.executeQuery()){
				
				if(rs.next()) {
					String salt = rs.getString("salt");
					return salt;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static Kadai1dto login(String mail, String hashedPw) {
		String sql = "SELECT * FROM member WHERE email = ? AND pw = ?";
		
		try (
				Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				){
			pstmt.setString(1, mail);
			pstmt.setString(2, hashedPw);

			try (ResultSet rs = pstmt.executeQuery()){
				
				if(rs.next()) {
					String name = rs.getString("name");
					int age = rs.getInt("age");
					String gender = rs.getString("gender");
					String tel = rs.getString("tel");
					String salt = rs.getString("salt");
					
					return new Kadai1dto(name, age, gender, tel, mail, salt, null, null);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return null;
	}
}
