package uk.ac.qub.csc3021.graph;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

public class ParallelContextSimple extends ParallelContext {

    //final AtomicBoolean terminate = new AtomicBoolean(false);
    ArrayList<ThreadSimple> threads = new ArrayList();

    public ParallelContextSimple(int num_threads_) {
        super(num_threads_);
    }

    public void terminate() {
    }

    // The edgemap method for Q3 should create threads, which each process
    // one graph partition, then wait for them to complete.
    // use matrix.ranged_edgemap( relax, from, to ); in each thread
    public void edgemap(SparseMatrix matrix, Relax relax) {
        int numVertices = matrix.getNumVertices();
        int numThreads = getNumThreads();
        int blockSize = numVertices / numThreads + 1;
        for (int i = 1; i <= numThreads; i++) {
            int from = (i - 1) * blockSize;
            int to = from + blockSize - 1;
            if (i == numThreads) {
                to = numVertices;
            }
            ThreadSimple threadSimple = new ThreadSimple(from, to, matrix, relax);
            this.threads.add(threadSimple);
            threadSimple.start();
        }
        for (int j = 0; j < threads.size(); j++) {
            try {
                threads.get(j).join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private class ThreadSimple extends Thread {
        private int from;
        private int to;
        private SparseMatrix matrix;
        private Relax relax;

        public ThreadSimple(int from_, int to_, SparseMatrix matrix_, Relax relax_) {
            this.from = from_;
            this.to = to_;
            this.matrix = matrix_;
            this.relax = relax_;
        }

        public void run() {
            matrix.ranged_edgemap(relax, from, to);

        }

    }
}
// && num_threads != 1