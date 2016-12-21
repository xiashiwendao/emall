package lorrywork.emall.base;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.net.ServerSocket;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;

import com.google.gson.Gson;

public class CUtils {

	public static String createUuid() {
		return UUID.randomUUID().toString().replace("-", "");
	}

	/**
	 * 空白字符.
	 */
	private final static String EMPTY = "";

	/**
	 * 字符串是否为空（null或""）.
	 * 
	 * @param str
	 * @return <tt>true</tt>为空; <tt>false</tt>不为空
	 */
	public static boolean isEmpty(String str) {
		if (str == null) {
			return true;
		}

		return str.trim().equals(EMPTY);
	}

	/**
	 * 将日期转换为日期字符串.
	 * 
	 * @param pattern
	 *            日期格式
	 * @param value
	 *            日期对象
	 * @return 日期字符串
	 */
	public static String formatDate(String pattern, Date value) {
		SimpleDateFormat df = new SimpleDateFormat(pattern);
		return df.format(value);
	}

	/**
	 * 将日期字符串转换为日期.
	 * 
	 * @param pattern
	 *            日期格式
	 * @param dateStr
	 *            日期字符串
	 * @return 日期对象
	 */
	public static Date string2Date(String pattern, String dateStr) {
		SimpleDateFormat df = new SimpleDateFormat(pattern);
		Date date = null;
		try {
			date = df.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return date;
	}

	/**
	 * 将日期字符串转换为long.
	 * 
	 * @param date
	 *            日期字符串
	 * @param pattern
	 *            日期格式
	 * @return
	 */
	public static long dateToLong(String date, String pattern) {
		Date d = CUtils.string2Date(pattern, date);
		return d.getTime();
	}

	/**
	 * @param parameter
	 *            (Y/N)
	 * @return <tt>true</tt>为'Y' <tt>false</tt>为'N'
	 */
	public static boolean valueOfYesNo(String parameter) {
		return ("Y".equals(parameter) ? true : false);
	}

	/**
	 * @param set
	 *            boolean
	 * @return <tt>true</tt>为'Y'; <tt>false</tt>为'N'
	 */
	public static String yesNo(boolean set) {
		return (set ? "Y" : "N");
	}

	/**
	 * 获取堆栈错误信息.
	 * 
	 * @param cause
	 *            Throwable
	 * @return 错误堆栈详情
	 */
	public static String getTrace(Throwable cause) {
		if (cause != null) {
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			cause.printStackTrace(pw);
			StringBuffer sb = sw.getBuffer();
			return sb.toString();
		}
		return "";
	}

	/**
	 * 获取当前文件夹所属磁盘分区的可用空间.
	 * 
	 * @param dirPath
	 *            文件夹路径
	 * @return 当前文件夹所属磁盘分区的字节大小
	 */
	public static long getDiskUsableSpace(String dirPath) {
		File dir = new File(dirPath);
		if (!dir.exists()) {
			dir.mkdirs();
		}
		return dir.getUsableSpace();
	}

	/**
	 * 获取当前文件夹所属磁盘分区的所有空间.
	 * 
	 * @param path
	 *            文件夹路径
	 * @return 当前文件夹所属磁盘分区的字节大小
	 */
	public static long getDiskTotalSpace(String path) {
		File file = new File(path);
		return file.getTotalSpace();
	}

	/**
	 * 端口格式校验.
	 * 
	 * @param port
	 *            端口（0-65535）
	 * @return <tt>true</tt>符合规则; <tt>false</tt>不符合规则
	 */
	public static boolean checkPort(String port) {
		Pattern p = Pattern.compile("^([0-9]{1,4}|[1-5][0-9]{4}|6[0-5]{2}[0-3][0-5])$");
		Matcher m = p.matcher(port);
		boolean res = m.matches();
		return res;
	}

	/**
	 * 判断端口是否被占用.
	 * 
	 * @param port
	 *            端口（0-65535）
	 * @return <tt>true</tt>端口被占用; <tt>false</tt>端口未被占用
	 */
	public static boolean checkPortBind(int port) {
		if (port < 0 || port > 65535) {
			throw new IllegalArgumentException("非法的端口号。端口取值[0-65535]");
		}
		ServerSocket ss = null;
		try {
			ss = new ServerSocket(port);
		} catch (IOException e) {
			return true;
		} finally {
			if (ss != null) {
				try {
					ss.close();
				} catch (IOException e) {
				}
			}
		}
		return false;
	}

	public static void HandleEx(Logger log, Throwable e) {
		String stackString = getTrace(e);
		log.error(stackString);
	}

	public static String getTodayDatetime() {
		return formatDate("yyyy-MM-dd HH:mm:ss", new Date());
	}

	public static String getJson(Map<String, String> map) {
		Gson gson = new Gson();
		return gson.toJson(map, HashMap.class);
	}

	public static Map<String, String> getMapFromJson(String json) {
		Gson gson = new Gson();
		return gson.fromJson(json, Map.class);
	}

	/**
	 * 返回long型；如果强转对象为null，则返回0
	 * 
	 * @param obj
	 * @return
	 */
	public static long toLong(Object obj) {
		long ret = 0;
		if (obj != null) {
			ret = Long.parseLong(obj.toString());
		}

		return ret;
	}

	public static double getRoundDownDouble(double value, int number) {
		BigDecimal b = new BigDecimal(value);
		double ret = b.setScale(number, BigDecimal.ROUND_DOWN).doubleValue();

		return ret;
	}
}