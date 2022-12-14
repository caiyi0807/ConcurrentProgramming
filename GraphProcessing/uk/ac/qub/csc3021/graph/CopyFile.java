package uk.ac.qub.csc3021.graph;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;

//public class CopyFile implements Callable<Queue<String>> {
//
//    private final String fileName;
//    private final int threadSize;
//    private final int currentBlock;
//    private Queue<String> queue=new LinkedBlockingQueue<String>();
////    private Queue<String> queue=new LinkedList<>();
//
//
//    public CopyFile(String fileName, int threadSize, int currentBlock) {
//        this.fileName = fileName;
//        this.threadSize = threadSize;
//        this.currentBlock = currentBlock;
//    }
//
//    @Override
//    public Queue<String> call() throws IOException {
//        BufferedRandomAccessFile fileAccess = null;
//        try {
//            fileAccess = new BufferedRandomAccessFile(fileName, "r");
//            long len = fileAccess.length();
//            long step = len / threadSize + 1;
//            long currentPosition = step * (currentBlock - 1);
//            long nextPosition = currentPosition + step;
//            if (nextPosition >= len) {
//                nextPosition = len - 1;
//            }
//            fileAccess.seek(nextPosition);
//            char lastChar = (char) fileAccess.read();
//            if (lastChar == '\n') {
//                nextPosition += 1;
//            }
//            fileAccess.seek(currentPosition);
//            if (currentPosition > 0) {
//                currentPosition += 1;
//                long offset = 1;
//                fileAccess.seek(currentPosition - offset);
//                int beforeChar = fileAccess.read();
//                while (beforeChar != '\n' && beforeChar != '\r') {
//                    offset += 1;
//                    fileAccess.seek(currentPosition - offset);
//                    beforeChar = fileAccess.read();
//                }
//            }
////            int i=0;
////            int num = 0;
//            String lineValue;
//            long filePointer;
//            while ((lineValue = fileAccess.readLine()) != null) {
//                filePointer = fileAccess.getFilePointer();
//                if (filePointer != len && filePointer > nextPosition) {
//                    break;
//                } else {
////                    if(currentBlock==1){
////                        if(i==1) matrixCSR.num_vertices= Integer.parseInt(lineValue);
////                        else if (i == 2) matrixCSR.num_edges= Integer.parseInt(lineValue);
////                        else{
////                            num = matrixCSR.multiThread(lineValue, num);
////                        }
////                        i++;
////                    }
////                    else {
//                        queue.add(lineValue);
////                    }
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//                fileAccess.close();
//        }
//        return queue;
//    }
//
//
//}




