package prj.util;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor.AbortPolicy;
import java.util.concurrent.TimeUnit;

/**
 * 线程池
 *
 * @author：wangXinYu
 * @date：2021/7/21 5:41 下午
 */
public class ExecutorUtil {
  private static final int AVAILABLE_PROCESSORS = Runtime.getRuntime().availableProcessors();


  public static ExecutorService getExecutorPool() {
    ThreadFactory threadFactory = Executors.defaultThreadFactory();

    return new ThreadPoolExecutor(AVAILABLE_PROCESSORS,
        AVAILABLE_PROCESSORS,
        2L,
        TimeUnit.SECONDS,
        new LinkedBlockingQueue<>(1024), threadFactory,
        new AbortPolicy());
  }
}
