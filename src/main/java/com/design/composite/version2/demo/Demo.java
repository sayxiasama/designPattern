package com.design.composite.version2.demo;

import com.design.composite.version2.code.Directory;
import com.design.composite.version2.code.File;


/**
 * @ClassName:Demo
 * @Describe:
 *  参考设计模式之美中 组合模式一节.
 * @Data:2020/3/511:06
 * @Author:Ago
 * @Version 1.0
 */
public class Demo {
    public static void main(String[] args) {
        Directory fileSystemTree = new Directory("/");
        Directory node_wz = new Directory("/wz/");
        Directory node_xzg = new Directory("/xzg/");
        fileSystemTree.addSubNode(node_wz);
        fileSystemTree.addSubNode(node_xzg);
        File node_wz_a = new File("/wz/a.txt");
        File node_wz_b = new File("/wz/b.txt");
        Directory node_wz_movies = new Directory("/wz/movies/");
        node_wz.addSubNode(node_wz_a);
        node_wz.addSubNode(node_wz_b);
        node_wz.addSubNode(node_wz_movies);
        File node_wz_movies_c = new File("/wz/movies/c.avi");
    }
}