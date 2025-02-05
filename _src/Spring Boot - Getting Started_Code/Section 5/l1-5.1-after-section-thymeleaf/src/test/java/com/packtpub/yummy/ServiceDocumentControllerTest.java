package com.packtpub.yummy;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.hateoas.Resource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ServiceDocumentControllerTest {
    @Autowired
    MockMvc mvc;
    @Autowired
    ObjectMapper mapper;

    @Test
    public void getServiceDocument() throws Exception {
        String result = mvc.perform(
                MockMvcRequestBuilders.get("/")
                .accept("application/hal+json;charset=UTF-8")
        ).andDo(print())
                .andExpect(content()
                        .contentTypeCompatibleWith("application/hal+json;charset=UTF-8"))
                .andReturn().getResponse().getContentAsString();

        Resource<String> value = mapper.readValue(result, new TypeReference<Resource<String>>(){});

        assertTrue(value.hasLink("self"));
        assertEquals(value.getLink("self"),value.getId());

        assertTrue(value.hasLink("bookmarks"));
    }
}
