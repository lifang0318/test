package com.inhand.cn;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

/**
 * 数据结构-稀疏数组
 *
 * @author lifang
 * @date 2019/07/25
 */
public class SparseArray {

    public static void main(String[] args) throws FileNotFoundException {
        //创建二维数组
        int[][] cheese = new int[11][11];
        //赋值
        cheese[1][2] = 1;
        cheese[3][4] = 2;
        for (int i = 0; i < cheese.length; i++) {
            for (int j = 0; j < cheese[i].length; j++) {
                System.out.printf("%d\t", cheese[i][j]);
            }
            System.out.println();
        }
        //遍历二维数组，得到非零元素的个数
        int sum = 0;
        for (int i = 0; i < cheese.length; i++) {
            for (int j = 0; j < cheese[i].length; j++) {
                if (cheese[i][j] != 0) {
                    sum++;
                }
            }
        }
        //创建稀疏数组，行为sum+1，列为3
        int[][] sparseArray = new int[sum + 1][3];
        //为稀疏数组赋值
        sparseArray[0][0] = 11;//对应二维数组的总行数
        sparseArray[0][1] = 11;//对应二维数组的总列数
        sparseArray[0][2] = sum;

        int count = 0;
        for (int i = 0; i < cheese.length; i++) {
            for (int j = 0; j < cheese[i].length; j++) {
                if (cheese[i][j] != 0) {
                    count++;
                    sparseArray[count][0] = i;
                    sparseArray[count][1] = j;
                    sparseArray[count][2] = cheese[i][j];
                }
            }
        }
        //TODO 将稀疏数组存盘(map.data)
        OutputStream out = new FileOutputStream("");


        //打印稀疏数组
        for (int i = 0; i < sparseArray.length; i++) {
            System.out.printf("%d\t%d\t%d\n", sparseArray[i][0], sparseArray[i][1], sparseArray[i][2]);
        }
        //TODO 从磁盘中读取稀疏数组(map.data)

        //将稀疏数组恢复为二维数组
        int[][] cheeseRecover = new int[sparseArray[0][0]][sparseArray[0][1]];
        //将非零元素填充到二维数组中
        for (int i = 1; i < sparseArray.length; i++) {
            cheeseRecover[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
        }
        //打印恢复后的二维数组
        for (int i = 0; i < cheeseRecover.length; i++) {
            for (int j = 0; j < cheeseRecover[i].length; j++) {
                System.out.printf("%d\t",cheeseRecover[i][j]);
            }
            System.out.println();
        }
    }
}
