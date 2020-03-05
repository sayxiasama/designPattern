package com.design.composite.version2.code;

/**
 * @ClassName:file
 * @Describe:
 * @Data:2020/3/510:53
 * @Author:Ago
 * @Version 1.0
 */
public class File extends FileSystemNode {

    public File(String path) {
        super(path);
    }

    @Override
    public int countNumOfFiles() {
        return 1;
    }

    @Override
    public long countSizeOfFiles() {
        java.io.File file = new java.io.File(super.getPath());
        if(!file.exists()){
            return 0 ;
        }
        return file.length();
    }
}
