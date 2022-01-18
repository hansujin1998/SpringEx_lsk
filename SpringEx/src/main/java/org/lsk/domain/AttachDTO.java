package org.lsk.domain;

public class AttachDTO { 
	private String fileName;
	private String uploadPath;
	private String uuid;
	private boolean image;
	public String getFileName() {
		return fileName;
	}
	@Override
	public String toString() {
		return "AttackDTO [fileName=" + fileName + ", uploadPath=" + uploadPath + ", uuid=" + uuid + ", image=" + image
				+ "]";
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getUploadPath() {
		return uploadPath;
	}
	public void setUploadPath(String uploadPath) {
		this.uploadPath = uploadPath;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public boolean isImage() {
		return image;
	}
	public void setImage(boolean image) {
		this.image = image;
	}
	
	
}
