package sjmszm.pattern.strategy;

import java.io.File;

public class Sorter {

    private static final long GB = 1000 * 1000 * 1000;

    public void sortFile(String filePath) {
        // 省略校验逻辑
        File file = new File(filePath);
        long fileSize = file.length();
        if(fileSize < 6 * GB) {

        }

    }

    private void quickSort(String filePath) {
        // 快速排序
    }

    private void externalSort(String filePath) {
        // 外部排序
    }

    private void concurrentExternalSort(String filePath) {
        // 多线程外部排序
    }

    private void mapreduceSort(String filePath) {
        // 利用MapReduce多机排序
    }


}
