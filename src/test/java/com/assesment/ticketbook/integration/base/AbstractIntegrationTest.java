package com.assesment.ticketbook.integration.base;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.*;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@AutoConfigureMockMvc(addFilters = false)
@SpringBootTest(properties = "env_name=dev")
public abstract class AbstractIntegrationTest {

    @Autowired
    protected MockMvc mockMvc;
    protected final ObjectMapper mapper = new ObjectMapper().findAndRegisterModules().configure(
                    SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false)
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    protected <T> T performPostRequest(String path, Object object, Class<T> responseType, ResultMatcher expectedStatus)
            throws Exception {
        MvcResult mvcResult = getResultActions(path, object)
                .andExpect(expectedStatus)
                .andReturn();
        return convertStringToClass(mvcResult.getResponse().getContentAsString(), responseType);
    }

    protected <T> T performPutRequest(String path, Object object, Class<T> responseType, ResultMatcher expectedStatus)
            throws Exception {
        MvcResult mvcResult = getResultActionsPut(path, object)
                .andExpect(expectedStatus)
                .andReturn();
        return convertStringToClass(mvcResult.getResponse().getContentAsString(), responseType);
    }

    protected <T> T performPostRequestExpectedSuccess(String path, Object object, Class<T> responseType)
            throws Exception {
        return performPostRequest(path, object, responseType, status().is2xxSuccessful());
    }

    protected <T> T performPostRequestExpectedServerError(String path, Object object, Class<T> responseType)
            throws Exception {
        return performPostRequest(path, object, responseType, status().is5xxServerError());
    }

    protected <T> T performPutRequestExpectedSuccess(String path, Object object, Class<T> responseType)
            throws Exception {
        return performPutRequest(path, object, responseType, status().is2xxSuccessful());
    }

    protected void performPutRequestExpectedClientError(String path, Object object, ResultMatcher matcher)
            throws Exception {
        MvcResult mvcResult = getResultActionsPut(path, object)
                .andExpect(matcher)
                .andReturn();
        return;
    }

    protected <T> T performGetRequestExpectedSuccess(String path, Class<T> responseType) throws Exception {
        MvcResult mvcResult = getResultActionsGet(path)
                .andExpect(status().is2xxSuccessful())
                .andReturn();
        return convertStringToClass(mvcResult.getResponse().getContentAsString(), responseType);

    }

    protected void performGetRequestExpectedError(String path, ResultMatcher matcher) throws Exception {

        getResultActionsGet(path).andExpect(matcher).andReturn();

    }

    private ResultActions getResultActions(String path, Object object) throws Exception {
        return mockMvc.perform(MockMvcRequestBuilders.post(path)
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(object)));
    }

    private ResultActions getResultActionsPut(String path, Object object) throws Exception {
        RequestBuilder builder = MockMvcRequestBuilders.put(path)
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(object))
                .accept(MediaType.APPLICATION_JSON);
        return mockMvc.perform(builder);
    }

    private ResultActions getResultActionsGet(String path) throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(path);
        return mockMvc.perform(requestBuilder);
    }


    protected <T> T convertStringToClass(String jsonString, Class<T> responseType) throws JsonProcessingException {
        return mapper.readValue(jsonString, responseType);
    }
}