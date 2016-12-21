package lorrywork.emall.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import lorrywork.emall.base.CUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * properties文件读取
 */
public class ConfigProperties {

	private final static Logger logger = LoggerFactory.getLogger(ConfigProperties.class);
	private volatile static ConfigProperties instance = null;

	private Properties prop = null;

	public static ConfigProperties getInstance() {
		if (instance == null) {
			logger.debug("不存在config实例");
			synchronized (ConfigProperties.class) {
				if (instance == null) {
					instance = new ConfigProperties();
				}
			}
		}
		return instance;
	}

	private ConfigProperties() {
		prop = new Properties();
		initConfig();
	}

	/**
	 * 初始化配置文件和日志信息.
	 * 
	 * @return
	 */
	private boolean initConfig() {
		try {
			initProp();
			logger.info("1、初始化系统配置、日志配置成功。");
			return true;
		} catch (Exception e) {
			CUtils.HandleEx(logger, e);
		}

		return false;
	}

	/**
	 * 初始化配置文件.
	 * 
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	private void initProp() throws FileNotFoundException, IOException {
		InputStream fis = null;
		try {
			String path = getPropertiesFilePath();
			fis = new FileInputStream(path);
			prop.load(fis);
		} catch (Exception e) {
			CUtils.HandleEx(logger, e);
		} finally {
			if (fis != null) {
				fis.close();
			}
		}

		fis.close();
	}

	private String getPropertiesFilePath() throws Exception {
		String config = "config.properties";
		String path = System.getProperty("user.dir") + File.separator + config;
		logger.debug("config文件路径: " + path);
		// 应该是debug/run模式下，通过classLoader获取properties文件流
		if (!FileManager.exists(path)) {
			path = this.getClass().getClassLoader().getResource(config).getPath();
			if (!FileManager.exists(path)) {
				throw new Exception("没有找到Properties：" + path);
			}
		}

		return path;
	}

	/**
	 * 获取属性值.
	 * 
	 * @param key
	 * @return
	 */
	public String getPropValue(String key) {
		return prop.getProperty(key);
	}

	/**
	 * 设置属性值
	 * 
	 * @param key
	 * @param value
	 */
	public void setPropValue(String key, String value) {
		prop.setProperty(key, value);
		OutputStream fos = null;
		try {
			String path = getPropertiesFilePath();
			fos = new FileOutputStream(path);
			prop.store(fos, "save");
		} catch (Exception e) {
			CUtils.HandleEx(logger, e);
		} finally {
			try {
				fos.close();
			} catch (IOException e) {
				CUtils.HandleEx(logger, e);
			}
		}
	}
}
