package lorrywork.emall.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileManager {
	private static Logger logger = LoggerFactory.getLogger(FileManager.class); 
	public static String getFilePath(String folderName, String simpleFileName) {
		File d = new File(folderName);
		File f = new File(d, simpleFileName);

		return f.getAbsolutePath();
	}

	public static String createFile(String saveFolder, String fileName) throws IOException {
		File directory = new File(saveFolder);
		File f = new File(directory, fileName);
		logger.debug("创建文件，文件夹路径: " + saveFolder +"; 文件名称: " + fileName);
		f.createNewFile();

		return f.getAbsolutePath();
	}

	public static String createFile(String filePath) throws IOException {
		File f = new File(filePath);
		logger.debug("创建文件，文件路径: {}", filePath);
		f.createNewFile();
		return f.getAbsolutePath();
	}

	public static String getFileExtendName(String fileName) {
		String ret = "";
		int pos = fileName.lastIndexOf(".");
		if (pos > 0) {
			ret = "." + fileName.substring(pos + 1);
		}

		return ret;
	}

	/**
	 * 追加到文件尾
	 * 
	 * @param filePath
	 * @param databytes
	 * @throws IOException
	 */
	public static void append(String filePath, byte[] databytes) throws IOException {
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(filePath, true);
			fos.write(databytes);
		} catch (IOException ex) {
			throw ex;
		} finally {
			if (fos != null) {
				fos.close();
			}
		}
	}

	public static void write(String filePath, byte[] databytes) throws IOException {
		write(filePath, databytes, false);
	}

	/**
	 * 从0位置写入文件</br>
	 * 主要用于任务文件的写入</br>
	 * 
	 * @param filePath文件路径
	 * @param databytes写入的byte数组
	 * @throws IOException
	 */
	public static void write(String filePath, byte[] databytes, boolean tryLock) throws IOException {
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(filePath);
			if (tryLock) {
				FileLock locker = fos.getChannel().lock();
				fos.write(databytes);
				locker.release();
			} else {
				fos.write(databytes);
			}
		} catch (IOException ex) {
			throw ex;
		} finally {
			if (fos != null) {
				fos.close();
			}
		}
	}

	/**
	 * 写入文件的指定位置</br>
	 * 应用场景：对于重传以及续传情况下，调用此方法
	 * 
	 * @param filePath文件路径
	 * @param startPos起始位置
	 * @param fileSlice文件片内容
	 * @return 成功true；异常false
	 * @throws Exception
	 */
	public static boolean write(String filePath, long startPos, byte[] fileSlice) throws Exception {
		boolean ret = false;
		RandomAccessFile fos = null;
		try {
			fos = new RandomAccessFile(filePath, "rw");
			FileChannel fc = fos.getChannel();
			fc.position(startPos);
			ByteBuffer bb = ByteBuffer.allocate(fileSlice.length);
			bb.put(fileSlice);
			bb.flip();
			fc.write(bb);
			fc.force(false);
			ret = true;
		} catch (Exception ex) {
			String stackErrorStr = CUtils.getTrace(ex);
			logger.error(stackErrorStr);
		} finally {
			if (fos != null) {
				fos.close();
			}
		}

		return ret;
	}

	/**
	 * 获取指定文件的MD5数组
	 * 
	 * @param filePath
	 * @return
	 */
	public static byte[] getMd5bytes(String filePath) {
		FileInputStream fileInputStream = null;
		try {
			MessageDigest MD5 = MessageDigest.getInstance("MD5");
			fileInputStream = new FileInputStream(filePath);
			byte[] buffer = new byte[8192];
			int length;
			while ((length = fileInputStream.read(buffer)) != -1) {
				MD5.update(buffer, 0, length);
			}

			return MD5.digest();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fileInputStream != null)
					fileInputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return null;
	}
	
	public static boolean exists(String filePath){
		File f = new File(filePath);
		return f.exists();
	}
}
