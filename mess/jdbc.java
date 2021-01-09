public class JdbcDemo(){
	public static void main(String[] args) {
		//1、导入jar包
		//2、注册驱动
		Class.forName("com.mysql.cj.jdbc.Driver");
		//3、获取数据库连接对象
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/database","root","password");
		//4、定义sql
		String sql = "select * from user";
		//5、获取执行sql的对象Statement
		Statement stmt = conn.createStatement();
		//6、执行sql
		ResultSet rs = stmt.executeQuery(sql);
		//7、释放资源
		rs.close();
		stmt.close();
		conn.close();
	}

	public static void main(String[] args){
		//1、注册驱动
		DriverManager.registerDriver(new com.mysql.jdbc.driver());
		//2、获取连接
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/database","root","password");
		//3、获取操作数据库的与处理对象
		PreparedStatement pstmt = conn.prepareStatement("select * from user");
		//4、执行sql
		ResultSet rs = pstmt.executeQuery();
		//5、遍历结果集
		while(rs.next){
			sout(rs);
		//6、释放资源
		rs.close();
		pstmt.close();
		conn.close();
		}
	}
}

//int executeUpdate(String sql):执行DML(insert,update,delete)语句和DDL(create,alter,drop)语句
//ResultSet executeQuery(String sql):执行DQL(select)语句