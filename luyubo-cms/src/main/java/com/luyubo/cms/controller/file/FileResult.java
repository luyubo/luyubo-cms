package com.luyubo.cms.controller.file;

public class FileResult {

	public FileResult(int error, String url) {
		super();
		this.error = error;
		this.url = url;
	}
	
	int error = 0;
	String url = "";
	
	public FileResult() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getError() {
		return error;
	}
	public void setError(int error) {
		this.error = error;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
}
