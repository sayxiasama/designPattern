package com.design.composite.version2.code;

/**
 * @ClassName:ManagerFileSystem
 * @Describe:
 * @Data:2020/3/510:42
 * @Author:Ago
 * @Version 1.0
 */
public abstract class FileSystemNode {
    private String path ;

    public FileSystemNode(String path) {
        this.path = path;
    }

    public abstract int countNumOfFiles();

    public abstract  long countSizeOfFiles();

    public String getPath(){
        return path;
    }
}
