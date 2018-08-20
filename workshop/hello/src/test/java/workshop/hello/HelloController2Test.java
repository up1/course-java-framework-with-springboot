package workshop.hello;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = HelloController.class)
public class HelloController2Test {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void success_with_statuscode_200() throws Exception {
        MockHttpServletResponse response
                = mockMvc.perform(get("/hello/somkiat"))
                         .andReturn().getResponse();

        assertEquals(HttpStatus.OK.value(), response.getStatus());
    }

    private JacksonTester<Hello> jsonHello;

    @Test
    public void success_with_correct_json_data() throws Exception {
        JacksonTester.initFields(this, new ObjectMapper());

        MockHttpServletResponse response = mockMvc.perform(get("/hello/somkiat"))
                .andReturn().getResponse();

        String expected = jsonHello.write(new Hello("somkiat")).getJson();
        assertEquals(expected, response.getContentAsString());

    }

}