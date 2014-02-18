package com.he.jinbin;

import java.util.Date;
/**
 * 用于排序逻辑实体类
 * 
 * @author 何锦彬    QQ 277803242
 *
 */
public class FileItem implements Comparable {
	private String fileName;
	private long size;
	private Date creatTime;

	public FileItem(String fileName, long size, Date creaDate) {
		// TODO Auto-generated constructor stub
		this.fileName = fileName;
		this.size = size;
		this.creatTime = creaDate;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public long getSize() {
		return size;
	}

	public void setSize(long size) {
		this.size = size;
	}

	public Date getCreatTime() {
		return creatTime;
	}

	public void setCreatTime(Date creatTime) {
		this.creatTime = creatTime;
	}

	@Override
	public int compareTo(Object o) {
		if (this.size > ((FileItem) o).getSize())
			return 1;
		return -1;
	}

}
