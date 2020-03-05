package com.design.composite.version2.code;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @ClassName:Directory
 * @Describe:
 * @Data:2020/3/510:58
 * @Author:Ago
 * @Version 1.0
 */
public class Directory extends FileSystemNode {
    private List<FileSystemNode> subNodes = Lists.newArrayList();

    public Directory(String path) {
        super(path);
    }

    @Override
    public int countNumOfFiles() {
        int numOfFiles = 0;
        for (FileSystemNode fileOrDir : subNodes) {
            numOfFiles += fileOrDir.countNumOfFiles();
        }
        return numOfFiles;
    }

    @Override
    public long countSizeOfFiles() {
        long sizeofFiles = 0;
        for (FileSystemNode fileOrDir : subNodes) {
            sizeofFiles += fileOrDir.countSizeOfFiles();
        }
        return sizeofFiles;
    }


    public void addSubNode(FileSystemNode fileOrDir) {
        subNodes.add(fileOrDir);
    }

    public void removeSubNode(FileSystemNode fileOrDir) {
        int size = subNodes.size();
        int i = 0;
        for (; i < size; i++) {
            if (subNodes.get(i).getPath().equalsIgnoreCase(fileOrDir.getPath())) {
                break;
            }

        }
        if (i < size) {
            subNodes.remove(i);
        }

    }
}
