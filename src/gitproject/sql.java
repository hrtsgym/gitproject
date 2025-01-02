package gitproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class sql {

	public static void main(String[] args) {

		// 変数の準備
		Connection con = null;
		Statement stmt = null;

		try {
			// JDBCドライバのロード
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new IllegalStateException("ドライバのロードに失敗しました");
		}

		try {
			// データベース接続
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shop", "root", "Merenn1ninaru");
			con.setAutoCommit(false);
			// SQL実行準備
			stmt = con.createStatement();
			
			int inscnt = 0;
			// 実行結果取得
			inscnt = stmt.executeUpdate("INSERT INTO shohin VALUES('0009','Tシャツ','衣服',1000,500,'2009-09-20')");
			System.out.println(inscnt+"行挿入されました");
			inscnt = stmt.executeUpdate("INSERT INTO shohin VALUES('0010','穴あけパンチ','事務用品',500,320,'2009-09-11')");
			System.out.println(inscnt+"行挿入されました");
			inscnt = stmt.executeUpdate("INSERT INTO shohin VALUES('0011','カッターシャツ','衣類',4000,2800,'2009-09-11')");
			System.out.println(inscnt+"行挿入されました");
			inscnt = stmt.executeUpdate("INSERT INTO shohin VALUES('0012','包丁','キッチン用品',3000,2800,'2009-09-11')");
			System.out.println(inscnt+"行挿入されました");
			inscnt = stmt.executeUpdate("INSERT INTO shohin VALUES('0013','圧力鍋','キッチン用品',6800,5000,'2009-06-11')");
			System.out.println(inscnt+"行挿入されました");
			inscnt = stmt.executeUpdate("INSERT INTO shohin VALUES('0014','フォーク','キッチン用品',500,null,'2009-04-11')");
			System.out.println(inscnt+"行挿入されました");
			inscnt = stmt.executeUpdate("INSERT INTO shohin VALUES('0015','おろしがね','キッチン用品',880,790,'2009-12-11')");
			System.out.println(inscnt+"行挿入されました");
			inscnt = stmt.executeUpdate("INSERT INTO shohin VALUES('0016','ボールペン','事務用品',100,null,'2009-11-11')");
			System.out.println(inscnt+"行挿入されました");

			con.commit();
		} catch (SQLException e) {
			System.out.println("データベースへのアクセスでエラーが発生しました。");
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					System.out.println("データベースへのアクセスでエラーが発生しました。");
				}
			}
		}
	}

}