package uk.ac.qub.csc3021.graph;

import java.util.concurrent.CountDownLatch;

public abstract class ParallelContext {
    private int num_threads;
    //private CountDownLatch latch;


    ParallelContext( int num_threads_ ) {
	num_threads = num_threads_;
    }
//    ParallelContext( int num_threads_ ,CountDownLatch latch) {
//        num_threads = num_threads_;
//        this.latch=latch;
//    }

    public int getNumThreads() { return num_threads; }

    // Terminate all threads
    public abstract void terminate() throws InterruptedException;

    // This is currently calling into the edgemap method in the matrix.
    // You will specialise this class to introduce concurrency in Question 2
    // and will update this class in subsequent questions.
    public abstract void edgemap( SparseMatrix matrix, Relax relax );
}
