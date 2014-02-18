package com.he.jinbin;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
/**
 * ���������߼�����
 * 
 * @author �ν���    QQ 277803242
 *
 */
public class Sort {
	public static List<FileItem> fileItems = new ArrayList<FileItem>();
	public static FileItem maxFileItem;
	public final static long M_1 = 1024 * 1024;
	public static long temp = M_1; // Ĭ�ϴ���1M���ļ�

	public static void addFileItem(File file) {
		File[] fileList = file.listFiles();
		for (int i = 0; i < fileList.length; i++) {
			file = fileList[i];
			if (file.isDirectory()) {
				addFileItem(file);
			} else {
				if (file.length() > temp) {
					fileItems.add(new FileItem(file.getPath(), file.length(),
							new Date(file.lastModified())));
				}

			}
		}

	}

	public static void main(String[] args) throws IOException {
		String filePath = null;
		System.out.print("������Ҫ�����ļ���ַ:");
		BufferedReader inRd = new BufferedReader(new InputStreamReader(
				System.in));
		filePath = inRd.readLine();
		System.out.print("������Ҫ�����ļ���С(��λM):");
		inRd = new BufferedReader(new InputStreamReader(System.in));
		temp = Long.parseLong(inRd.readLine())*M_1;
		inRd.close();
		System.out.println("�����У����Ե�...");
		File file = new File(filePath);
		addFileItem(file);
		SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMdd");
		Collections.sort(fileItems);
		System.out.println("�Ӵ�С�ļ�����Ϊ:");
		for (int i = fileItems.size() - 1; i >= 0; i--) {
			FileItem item = fileItems.get(i);
			System.out.println(item.getFileName() + "-------" + item.getSize()
					+ " KB" + "--------" + fmt.format(item.getCreatTime()));
		}

	}
}
