package test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lovlos.apple.mapper.UserMapper;
import com.lovlos.util.SpringUtil;

public class MyBatisTest {

	private static ExecutorService pool = Executors.newFixedThreadPool(20);
	
	@SuppressWarnings({ "resource" })
	public static void main(String[] args) {
		try {
			ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/spring-context.xml");
			context.start();
			
			UserMapper userMapper = (UserMapper) SpringUtil.getBean("userMapper");	
			
			for(int i=0;i<5000;i++){
				pool.submit(new Runnable() {				
					@Override
					public void run() {
						try {
							Thread.sleep(50);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						System.out.println(userMapper.select());
						System.out.println(userMapper.selectTwo());
					}
				});
			}	
		} catch (Exception e) {
			System.out.println(e);
		}
		
//		synchronized (MyBatisTest.class) {
//			while (true) {
//				try {
//					MyBatisTest.class.wait();
//				} catch (InterruptedException e) {
//				}
//			}
//		}
	}
	
}
