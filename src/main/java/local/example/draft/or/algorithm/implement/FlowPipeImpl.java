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

package local.example.draft.or.algorithm.implement;

import local.example.draft.or.algorithm.FlowPipe;

/**
 *
 * @author paolo mococci
 */

public class FlowPipeImpl 
        implements FlowPipe {
    
    private final int previous;
    private final int following;
    private final double capacity;
    private double flow;

    public FlowPipeImpl(int previous, int following, double capacity) {
        this.previous = this.checkPrevious(previous);
        this.following = this.checkFollowing(following);
        this.capacity = this.checkCapacity(capacity);
        this.flow = 0.0;
    }

    public FlowPipeImpl(int previous, int following, double capacity, double flow) {
        this.previous = this.checkPrevious(previous);
        this.following = this.checkFollowing(following);
        this.capacity = this.checkCapacity(capacity);
        this.flow = this.checkFlow(flow);
    }

    public FlowPipeImpl(FlowPipeImpl pipe) {
        super();
        this.previous = pipe.previous;
        this.following = pipe.following;
        this.capacity = pipe.capacity;
        this.flow = pipe.flow;
    }

    private int checkPrevious(int previous) {
        if (0b0 >= previous) {
            throw new IllegalArgumentException("invalid index for previous junction");
        }
        return previous;
    }

    private int checkFollowing(int following) {
        if (0b0L >= following || following == this.previous) {
            throw new IllegalArgumentException("invalid index for following junction");
        }
        return following;
    }

    private double checkCapacity(double capacity) {
        if (0.0D > capacity) {
            throw new IllegalArgumentException("invalid value ofcapacity");
        }
        return capacity;
    }

    private double checkFlow(double flow) {
        if (0.0D > flow || flow > this.capacity) {
            throw new IllegalArgumentException("invalid value of flow");
        }
        return flow;
    }

    @Override
    public int getPrevious() {
        return this.previous;
    }

    @Override
    public int getFollowing() {
        return this.following;
    }

    @Override
    public double getCapacity() {
        return this.capacity;
    }

    @Override
    public double getFlow() {
        return this.flow;
    }

    @Override
    public int getOther(int junction) {
        if (junction == this.previous) {
            return this.following;
        } else if (junction == this.following) {
            return this.previous;
        } else {
            throw new IllegalArgumentException("invalid index of junction");
        }
    }

    @Override
    public double getResidualCapacity(int junction) {
        if (junction == this.previous) {
            return this.flow;
        } else if (junction == this.following) {
            return this.capacity - this.flow;
        } else {
            throw new IllegalArgumentException("invalid index of junction");
        }
    }

    @Override
    public void addResidualFlow(int junction, double delta) {
        if (0.0D > delta) {
            throw new IllegalArgumentException("delta must non be negative");
        }
        
        if (junction == this.previous) {
            this.flow -= delta;
        } else if (junction == this.following) {
            this.flow += delta;
        } else {
            throw new IllegalArgumentException("invalid index of junction");
        }
        
        if (0.0D > this.flow) {
            throw new IllegalArgumentException("flow must not be negative");
        }
        
        if (this.flow > this.capacity) {
            throw new IllegalArgumentException("flow must not be exceeds capacity");
        }
        
        if (this.epsilonCheck(this.flow)) {
            this.flow = 0.0D;
        }
        
        if (this.epsilonCheck(this.flow - this.capacity)) {
            this.flow = this.capacity;
        }
    }

    @Override
    public boolean epsilonCheck(double value) {
        return (Math.abs(value) <= EPSILON);
    }
}
