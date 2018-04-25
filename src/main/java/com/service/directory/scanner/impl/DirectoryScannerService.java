package com.service.directory.scanner.impl;

import com.service.directory.scanner.FileInfo;
import org.apache.commons.io.FilenameUtils;

import javax.activation.MimetypesFileTypeMap;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DirectoryScannerService {

    /**
     * Returns the file information metadata of all the files matching the @param fileTypes in the given directory path
     * @param directory
     * @param fileTypes
     * @return
     */

    public List<FileInfo> getFilesInfoOfDirectory(String directory,String... fileTypes){

        File dir = new File(directory);

        //get all the files from a directory
        File[] filesList = dir.listFiles();

        return getFileInfoWithExtn(filesList,fileTypes);

        }
    /**
     * Returns the file information metadata of all the files in the given directory path
     * @param directory
     * @return
     */
    public List<FileInfo> getFilesInfoOfDirectory(String directory){

        File dir = new File(directory);

        //get all the files from a directory
        File[] filesList = dir.listFiles();
        return getFileInfoOfAllFiles(filesList);

    }



    private List<FileInfo> getFileInfoOfAllFiles(File[] filesList){

        List<FileInfo>  fileInfoList = new ArrayList<FileInfo>();
        Arrays.asList(filesList).forEach(file-> {
                    FileInfo fileInfo = new FileInfo(file.getName(), file.length(), getFileExtn(file), getMimeType(file));
                    fileInfoList.add(fileInfo);
                }
        );
        return fileInfoList;
    }

    /**
     * Returns FileInformation of all the files in the given directory with selected fileTypes
     * @param filesList
     * @param fileTypes
     * @return
     */

    private List<FileInfo> getFileInfoWithExtn(File[] filesList,String... fileTypes){
        List<FileInfo>  fileInfoList = new ArrayList<FileInfo>();
        Arrays.stream(filesList)
                .filter(file->Arrays.asList(fileTypes).contains(getFileExtn(file)))
                .forEach(file->{FileInfo fileInfo = new FileInfo(file.getName(), file.length(), getFileExtn(file), getMimeType(file));
                fileInfoList.add(fileInfo);});

        return fileInfoList;
    }

    private String getFileExtn(File file){
        return FilenameUtils.getExtension(file.getName());
    }

    private String getMimeType(File file){
       return new MimetypesFileTypeMap().getContentType(file);
    }

}
