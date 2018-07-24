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

package local.example.draft.adt;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author paolo mococci
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class StackTests {
    
    private final String[] strings = {
        "first", 
        "second", 
        "third", 
        "fourth"
    };
    
    Stack<String> stack;
    
    @Before
    public void set() 
            throws Exception {
        stack = new Stack<>();
    }
    
    @Test
    public void beforeTest() 
            throws Exception {
        Assert.assertEquals(0, this.stack.getElements());
    }
    
    @Test
    public void isEmptyTest() 
            throws Exception {
        Assert.assertTrue(this.stack.isEmpty());
    }
    
    @Test
    public void isNotEmptyTest() 
            throws Exception {
        this.stack.push("first");
        this.stack.push("second");
        this.stack.push("third");
        Assert.assertFalse(this.stack.isEmpty());
    }
    
    @Test
    public void pushTest() 
            throws Exception {
        this.stack.push("first");
        this.stack.push("second");
        this.stack.push("third");
        this.stack.push("fourth");
        Assert.assertEquals(4, this.stack.getElements());
    }
    
    @Test
    public void peepTest() 
            throws Exception {
        this.stack.push("first");
        this.stack.push("second");
        this.stack.push("third");
        this.stack.push("fourth");
        Assert.assertEquals("fourth", this.stack.peep());
    }
    
    @Test
    public void popTest1() 
            throws Exception {
        this.stack.push("first");
        this.stack.push("second");
        this.stack.push("third");
        this.stack.push("fourth");
        String out = this.stack.pop();
        Assert.assertEquals("fourth", out);
    }
    
    @Test
    public void popTest2() 
            throws Exception {
        this.stack.push("first");
        this.stack.push("second");
        this.stack.push("third");
        this.stack.push("fourth");
        this.stack.pop();
        Assert.assertEquals("third", this.stack.peep());
    }
    
    @Test
    public void iteratorTest() 
            throws Exception {
        int index = 3;
        this.stack.push("first");
        this.stack.push("second");
        this.stack.push("third");
        this.stack.push("fourth");
        for (String string : this.stack) {
            this.stack.pop();
            Assert.assertEquals(strings[index], string);
            index--;
        }
        Assert.assertTrue(this.stack.isEmpty());
    }
}
