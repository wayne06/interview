package com.wnzhong.ajavasebasic.iconcurrency.cthreadlocal.bhowtouse2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.hibernate.cfg.Configuration;
import org.jboss.logging.Logger;

/**
 * ThreadLocal 的使用方式2：在 Util 类中创建 ThreadLocal
 *
 * @author wayne
 */
public class HibernateUtil {

    private static Logger log = LoggerFactory.logger(HibernateUtil.class);

    private static SessionFactory sessionFactory;

    static {
        try {
            // 通过默认配置文件 hibernate.cfg.xml 创建 SessionFactory
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable th) {
            log.error("SessionFactory initialization failed.", th);
            throw new ExceptionInInitializerError(th);
        }
    }

    /**
     * 创建线程局部变量 session，用来保存 Hibernate 的 Session
     */
    public static final ThreadLocal THREAD_LOCAL = new ThreadLocal();

    /**
     * 获取当前线程中的 session
     *
     * @return
     */
    public static Session currentSession() {
        Session s = (Session) THREAD_LOCAL.get();
        // 如果 session 还没有打开，则新开一个 session
        if (s == null) {
            s = sessionFactory.openSession();
            // 将新开的 session 保存到线程局部变量中
            THREAD_LOCAL.set(s);
        }
        return s;
    }

    public static void closeSession() {
        // 获取线程局部变量，并强制转换为 Session 类型
        Session s = (Session) THREAD_LOCAL.get();
        THREAD_LOCAL.set(null);
        if (s != null) {
            s.close();
        }
    }


}
