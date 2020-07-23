package sync;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

public class MultiThread {

    public static void main(String[] args) {
        // MXBean
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        //线程和线程堆栈信息
        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false, false);
        for (ThreadInfo threadInfo:threadInfos)
            System.out.println(threadInfo.getThreadId()+" "+threadInfo.getThreadName());
    }
}
