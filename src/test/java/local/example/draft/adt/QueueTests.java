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
public class QueueTests {
    
    private final String[] strings = {
        "first", 
        "second", 
        "third", 
        "fourth"
    };
    
    Queue<String> queue;
    
    @Before
    public void set() 
            throws Exception {
        queue = new Queue<>();
    }
    
    @Test
    public void beforeTest() 
            throws Exception {
        Assert.assertEquals(0, this.queue.getElements());
    }
    
    @Test
    public void isEmptyTest() 
            throws Exception {
        Assert.assertTrue(this.queue.isEmpty());
    }
    
    @Test
    public void isNotEmptyTest() 
            throws Exception {
        this.queue.enqueue("first");
        this.queue.enqueue("second");
        this.queue.enqueue("third");
        Assert.assertFalse(this.queue.isEmpty());
    }
    
    @Test
    public void enqueueTest() 
            throws Exception {
        this.queue.enqueue("first");
        this.queue.enqueue("second");
        this.queue.enqueue("third");
        this.queue.enqueue("fourth");
        Assert.assertEquals(4, this.queue.getElements());
    }
    
    @Test
    public void peepTest() 
            throws Exception {
        this.queue.enqueue("first");
        this.queue.enqueue("second");
        this.queue.enqueue("third");
        this.queue.enqueue("fourth");
        Assert.assertEquals("first", this.queue.peep());
    }
    
    @Test
    public void dequeueTest1() 
            throws Exception {
        this.queue.enqueue("first");
        this.queue.enqueue("second");
        this.queue.enqueue("third");
        this.queue.enqueue("fourth");
        String out = this.queue.dequeue();
        Assert.assertEquals("first", out);
    }
    
    @Test
    public void dequeueTest2() 
            throws Exception {
        this.queue.enqueue("first");
        this.queue.enqueue("second");
        this.queue.enqueue("third");
        this.queue.enqueue("fourth");
        this.queue.dequeue();
        Assert.assertEquals("second", this.queue.peep());
    }
    
    @Test
    public void iteratorTest() 
            throws Exception {
        int index = 0;
        this.queue.enqueue("first");
        this.queue.enqueue("second");
        this.queue.enqueue("third");
        this.queue.enqueue("fourth");
        for (String string : this.queue) {
            this.queue.dequeue();
            Assert.assertEquals(strings[index], string);
            index++;
        }
        Assert.assertTrue(this.queue.isEmpty());
    }
}
