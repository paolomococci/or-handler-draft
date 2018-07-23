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

import java.util.Iterator;

/**
 *
 * @author paolo mococci
 * @param <Knot>
 * 
 * Implement node perspective.
 * Groups: Net, Knot and Line
 */

public class Net<Knot> 
        implements Iterable<Knot> {
    
    private final long id;

    public Net(long id) {
        this.id = id;
    }

    @Override
    public Iterator<Knot> iterator() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
