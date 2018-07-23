/**
 * 
 * Copyright 2018 paolo mococci
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * 	   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 */

package local.example.draft.model.repository;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

/**
 *
 * @author paolo mococci
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ItemRepositoryMockMvcTests {
    
    @Autowired
    private MockMvc mock;
    
    @Autowired
    private ItemRepository item;
    
    @Before
    public void deleteAll() 
            throws Exception {
        item.deleteAll();
    }
    
    @Test
    public void returnItemRepositoryIndexTest() 
            throws Exception {
        mock.perform(get("/"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$._links.item").exists());
    }
    
    @Test
    public void createEntityTest() 
            throws Exception {
        mock.perform(post("/item").content(
                "{\"code\":\"126481\",\"name\":\"rusk\",\"quantity\":\"1200\"}"))
                .andExpect(status().isCreated())
                .andExpect(header().string("Location", containsString("item/")));
    }
    
    @Test
    public void retrieveEntityTest() 
            throws Exception {
        MvcResult mvcResult;
        mvcResult = mock.perform(post("/item").content(
                "{\"code\":\"126481\",\"name\":\"rusk\",\"quantity\":\"1200\"}"))
                .andExpect(status().isCreated())
                .andReturn();
        String location = mvcResult.getResponse().getHeader("Location");
        mock.perform(get(location))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value("126481"))
                .andExpect(jsonPath("$.name").value("rusk"))
                .andExpect(jsonPath("$.quantity").value("1200"));
    }
    
    @Test
    public void queryFindByCodeTest() 
            throws Exception {
        mock.perform(post("/item").content(
                "{\"code\":\"126481\",\"name\":\"rusk\",\"quantity\":\"1200\"}"))
                .andExpect(status().isCreated());
        mock.perform(get("/item/search/findByCode?code={code}", "126481"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$._embedded.item[0].name").value("rusk"));
    }
    
    @Test
    public void queryFindByNameTest() 
            throws Exception {
        mock.perform(post("/item").content(
                "{\"code\":\"126481\",\"name\":\"rusk\",\"quantity\":\"1200\"}"))
                .andExpect(status().isCreated());
        mock.perform(get("/item/search/findByName?name={name}", "rusk"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$._embedded.item[0].quantity").value("1200"));
    }
    
    @Test
    public void queryFindByQuantityTest() 
            throws Exception {
        mock.perform(post("/item").content(
                "{\"code\":\"126481\",\"name\":\"rusk\",\"quantity\":\"1200\"}"))
                .andExpect(status().isCreated());
        mock.perform(get("/item/search/findByQuantity?quantity={quantity}", "1200"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$._embedded.item[0].code").value("126481"));
    }
    
    @Test
    public void updateEntityTest() 
            throws Exception {
        MvcResult mvcResult;
        mvcResult = mock.perform(post("/item").content(
                "{\"code\":\"126481\",\"name\":\"rusk\",\"quantity\":\"1200\"}"))
                .andExpect(status().isCreated())
                .andReturn();
        String location = mvcResult.getResponse().getHeader("Location");
        mock.perform(put(location).content(
                "{\"code\":\"146481\",\"name\":\"rusk\",\"quantity\":\"1200\"}"))
                .andExpect(status().isNoContent());
        mock.perform(get(location))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.code").value("146481"));
    }
    
    @Test
    public void partialUpdateEntityTest() 
            throws Exception {
        MvcResult mvcResult;
        mvcResult = mock.perform(post("/item").content(
                "{\"code\":\"146481\",\"name\":\"rusk\",\"quantity\":\"1200\"}"))
                .andExpect(status().isCreated())
                .andReturn();
        String location = mvcResult.getResponse().getHeader("Location");
        mock.perform(patch(location).content("{\"name\":\"biscuit\"}"))
                .andExpect(status().isNoContent());
        mock.perform(get(location))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("biscuit"));
    }
    
    @Test
    public void deleteEntityTest() 
            throws Exception {
        MvcResult mvcResult;
        mvcResult = mock.perform(post("/item").content(
                "{\"code\":\"146481\",\"name\":\"biscuit\",\"quantity\":\"1200\"}"))
                .andExpect(status().isCreated())
                .andReturn();
        String location = mvcResult.getResponse().getHeader("Location");
        mock.perform(delete(location)).andExpect(status().isNoContent());
        mock.perform(get(location)).andExpect(status().isNotFound());
    }
}
