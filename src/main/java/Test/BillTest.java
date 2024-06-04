package Test;

import com.soft.park.WyfBlogApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.SpringBootVersion;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.SpringVersion;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @version 1.0
 * @Author WenYaFei
 * @date 2024/6/4 14:29
 * @description
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = WyfBlogApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BillTest {

	@Test
	public void test(){

		//6.1.8
		String version = SpringVersion.getVersion();

		//3.3.0
		String version1 = SpringBootVersion.getVersion();

		System.out.println(version);

		System.out.println(version1);
	}
}
