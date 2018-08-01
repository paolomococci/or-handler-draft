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

package local.example.draft.or.algorithm.util.implement;

import junit.framework.Assert;
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
public class FlowPipeImplTests {
    
    FlowPipeImpl flowPipe;
    
    @Before
    public void init() 
            throws Exception {
        flowPipe = new FlowPipeImpl(1, 3, 12.9);
    }
    
    @Test
    public void getPreviousTest() 
            throws Exception {
        Assert.assertEquals(1, this.flowPipe.getPrevious());
    }
    
    @Test
    public void getFollowingTest() 
            throws Exception {
        Assert.assertEquals(3, this.flowPipe.getFollowing());
    }
    
    @Test
    public void getCapacityTest() 
            throws Exception {
        Assert.assertEquals(12.9, this.flowPipe.getCapacity(), 0.0);
    }
    
    @Test
    public void constructFromOtherFlowPipeTest() 
            throws Exception {
        FlowPipeImpl temp;
        temp = new FlowPipeImpl(flowPipe);
        Assert.assertEquals(12.9, temp.getCapacity(), 0.0);
    }
    
    @Test
    public void getFlowTest() 
            throws Exception {
        Assert.assertEquals(0.0, this.flowPipe.getFlow(), 0.0);
    }
    
    @Test
    public void constructWithValidValuesTest() 
            throws Exception {
        FlowPipeImpl temp;
        temp = new FlowPipeImpl(1, 2, 3.0, 3.0);
        Assert.assertEquals(3.0, temp.getCapacity(), 0.0);
    }
    
    @Test
    public void getResidualCapacityTest() 
            throws Exception {
        FlowPipeImpl temp;
        temp = new FlowPipeImpl(1, 2, 3.0, 2.5);
        Assert.assertEquals(0.5, temp.getResidualCapacity(2), 0);
    }
    
    @Test
    public void addResidualFlowTest() 
            throws Exception {
        FlowPipeImpl temp;
        temp = new FlowPipeImpl(1, 2, 3.0, 0.5);
        temp.addResidualFlow(1, 0.25);
        Assert.assertEquals(0.25, temp.getFlow(), 0);
    }
}
