package com.teak.core.config;

import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;

/**
 * The type Rabbit mq config.
 *
 * @author 柚mingle木
 * @version 1.0
 * @date 2023 /2/5
 */
@SpringBootConfiguration
public class RabbitMqConfig {
    /**
     * 消息转换器，用于转换实体类型的数据，如果不使用转换器，那么就会报错，记住实体类一定要有空参构造器，也可以在实体类继承序列化，但是会乱码。
     * 如果只是发送简单的字符串类型那么就不用转换器也可以转发<p>
     * Json message converter message converter.
     *
     * @return the message converter
     */
    @Bean
    public MessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }
}
