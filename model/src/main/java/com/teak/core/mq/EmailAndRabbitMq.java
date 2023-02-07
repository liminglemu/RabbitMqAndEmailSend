package com.teak.core.mq;

/**
 * The type Email and rabbit mq.
 *
 * @author 柚mingle木
 * @version 1.0
 * @date 2023 /2/5
 */
public class EmailAndRabbitMq {
    /**
     * 交换机<p>
     * The constant EXCHANGE_EMAIL.
     */
    public static final String EXCHANGE_EMAIL = "mailSendingExchange";
    /**
     * 队列<p>
     * The constant QUEUE_EMAIL.
     */
    public static final String QUEUE_EMAIL = "mailSendingQueue";
    /**
     * 路由key<p>
     * The constant ROUTING_KEY_EMAIL.
     */
    public static final String ROUTING_KEY_EMAIL = "QQEmail";
}
