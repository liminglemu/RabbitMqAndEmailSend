# RabbitMqAndEmailSend
使用springboot整合邮件发送和rabbitMq消息分发

# 使用方法
点开ConsumerTest测试类，允许test3测试即可，可以在yml文件中修改mail下的username,password修改成自己的账号，可以自定义接收人信息(receiver)，邮件主题(messageSubject)，邮件内容(messageContent)

# 说说其中遇到的bug或者新发现
在写EmailServiceImpl使用Autowired自动注入的时候因为，此包下并没有启动类，所以编写的yml文件，就无法被启动类识别，并注入属性，导致javaMailSender一直提示无法自动注入bean，一直报错。
解决办法是：
1.修改该模块下的yml文件的名字，改成例如：application-email.yml
2.在主启动类下的yml文件使用spring: profiles: active： email
![引入yml文件](https://user-images.githubusercontent.com/113691532/217028163-0dd80c87-620d-4f1f-b291-00a0a226226b.png)
