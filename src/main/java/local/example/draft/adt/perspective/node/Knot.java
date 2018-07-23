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

package local.example.draft.adt.perspective.node;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author paolo mococci
 * @param <Line>
 */

public class Knot<Line> 
        implements Iterable<Line>{
    
    private final long id;
    private final double capacity;
    private final List<Line> lines;

    public Knot(long id, double capacity) {
        super();
        this.lines = new ArrayList<>();
        this.id = id;
        this.capacity = capacity;
    }

    public long getId() {
        return id;
    }

    public double getCapacity() {
        return capacity;
    }

    public List<Line> getLines() {
        return lines;
    }

    @Override
    public Iterator<Line> iterator() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
