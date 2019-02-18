package cn.xwl.demo.consulservice;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {HelloController.class, DbConfig.class, AppConfig.class})
@AutoConfigureMockMvc
public class ConsulServiceControllerTests {

	@Autowired
	private MockMvc mockMvc;
/*
	@Autowired
	private WebApplicationContext wac;

	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}

	@Test
	public void contextLoads() {
		System.out.println("");
	}
*/
	@Test
	public void sayHello() throws Exception {
		//plain/text
		//mockMvc.perform(get("/")).andExpect(content().contentType("text/html")).andExpect(status().isOk());
		mockMvc.perform(get("/hello")).andExpect(status().isOk()).andExpect(content().string("Hello nzdx"));
	}

}
