package com.design.composite.version1.code;

import com.google.common.collect.Lists;

import java.io.File;
import java.util.List;

/**
 * @ClassName:FileSystenNode
 * @Describe:
 *  遍历文件目录 获取文件数量.
 * @Data:2020/3/510:20
 * @Author:Ago
 * @Version 1.0
 */
public class FileSystemNode {

    private String path;

    private boolean isFile;

    private List<FileSystemNode> subNodes = Lists.newArrayList();

    public FileSystemNode(String path, boolean isFile) {
        this.path = path;
        this.isFile = isFile;
    }

    public int countNumOfFiles() {
        int num = 0;
        if (isFile) {
            return 1;
        }
        for (FileSystemNode fileOrDir : subNodes) {
            num += fileOrDir.countNumOfFiles();
        }
        return num;
    }

    public int countSizeOfFile() {
        if (isFile) {
            File file = new File(path);
            if (!file.exists()) {
                return 0;
            }
        }
        int sizeNum = 0;
        for (FileSystemNode fileOrDir : subNodes) {
            sizeNum += fileOrDir.countSizeOfFile();
        }
        return sizeNum;
    }

    public String getPath() {
        return this.path;
    }

    public void addSubNode(FileSystemNode fileOrDir) {
        subNodes.add(fileOrDir);
    }

    public void removeSubNode(FileSystemNode fileOrDir) {
        int size = subNodes.size();
        int i = 0;
        for (; i < size; i++) {
            if (subNodes.get(i).getPath().equalsIgnoreCase(fileOrDir.getPath())){
                break;
            }

        }
        if (i < size) {
            subNodes.remove(i);
        }

    }
}
