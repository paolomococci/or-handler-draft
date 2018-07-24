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

package local.example.draft.adt.perspective.arch;

/**
 *
 * @author paolo mococci
 */

public class Pipe {
    
    private long id;
    private double capacity;
    private double flow;
    private Junction previous;
    private Junction following;

    public Pipe() {
        super();
    }

    public Pipe(long id, double capacity, Junction previous, Junction following) {
        super();
        this.id = id;
        this.capacity = capacity;
        this.flow = 0.0D;
        this.previous = previous;
        this.following = following;
    }

    public Pipe(long id, double capacity, double flow, Junction previous, Junction following) {
        super();
        this.id = id;
        this.capacity = capacity;
        this.flow = flow;
        this.previous = previous;
        this.following = following;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getCapacity() {
        return capacity;
    }

    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }

    public double getFlow() {
        return flow;
    }

    public void setFlow(double flow) {
        this.flow = flow;
    }

    public Junction getPrevious() {
        return previous;
    }

    public void setPrevious(Junction previous) {
        this.previous = previous;
    }

    public Junction getFollowing() {
        return following;
    }

    public void setFollowing(Junction following) {
        this.following = following;
    }
}
