package com.service.directory.scanner;

public class FileInfo {

    private String fileName;
    private long size;
    private String extn;
    private String mimeType;

    //Constructor
    public FileInfo(String fileName, long size, String extn, String mimeType) {
        this.fileName = fileName;
        this.size = size;
        this.extn = extn;
        this.mimeType = mimeType;
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

    public String getExtn() {
        return extn;
    }

    public void setExtn(String extn) {
        this.extn = extn;
    }

    public String getMimeType() {
        return mimeType;
    }

    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }




}
