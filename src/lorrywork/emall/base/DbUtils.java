package lorrywork.emall.base;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 数据库操作相关方法
 *
 */
public class DbUtils {

	private final static Logger logger = LoggerFactory.getLogger(DbUtils.class);
	// static Connection con = null;
	static Connection sendcon = null;
	static PreparedStatement preparedStatement;
	static ResultSet resultSet;

	/**
	 * 连接数据库
	 * 
	 * @param url
	 * @param name
	 * @param pass
	 * @return
	 */
	public static Connection getConnect(String url, String name, String pass) {
		Connection con = null;

		if (null == con) {
			try {
				Class.forName("org.mariadb.jdbc.Driver");
				logger.info("数据库连接--url:" + url + " && name:" + name + " && pass:" + pass);
				con = DriverManager.getConnection(url, name, pass);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return con;
	}

	public static void execSql(Connection conn, String sql) throws Exception {
		logger.info("execute sql：" + sql);
		String[] sqlSegs = sql.split(";");
		for (String sqlSeg : sqlSegs) {
			try {
				// 空行跳过
				if (sqlSeg.equals("\r\n\r")) {
					continue;
				}
				PreparedStatement statement = conn.prepareStatement(sqlSeg);
				statement.execute();
			} catch (Exception e) {
				logger.error("执行sql语句: " + sqlSeg + " 发生异常");
				CUtils.HandleEx(logger, e);
				throw e;
			}
		}
	}

	public static ResultSet execSqlForList(Connection conn, String sql) throws Exception {
		logger.info("execute sql：" + sql);
		ResultSet ret = null;
		String[] sqlSegs = sql.split(";");
		for (String sqlSeg : sqlSegs) {
			try {
				// 空行跳过
				if (sqlSeg.equals("\r\n\r")) {
					continue;
				}
				PreparedStatement statement = conn.prepareStatement(sqlSeg);
				ret = statement.executeQuery(sqlSeg);
			} catch (Exception e) {
				logger.error("执行sql语句: " + sqlSeg + " 发生异常");
				CUtils.HandleEx(logger, e);
				throw e;
			}
		}

		return ret;
	}
}
