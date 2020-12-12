package com.wnzhong.ajavasebasic.iconcurrency.cthreadlocal.ahowtouse1;

/**
 * ThreadLocal 的使用方式1：在关联数据类中创建 private static ThreadLocal
 *
 * @author wayne
 */
public class ThreadContext {

    private String userId;
    private Long transactionId;

    private static ThreadLocal threadLocal =
            ThreadLocal.withInitial(() -> new ThreadContext());

    public static ThreadContext get() {
        return (ThreadContext) threadLocal.get();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public static ThreadLocal getThreadLocal() {
        return threadLocal;
    }

    public static void setThreadLocal(ThreadLocal threadLocal) {
        ThreadContext.threadLocal = threadLocal;
    }
}
