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

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author paolo mococci
 * 
 * Implement arch perspective.
 * Groups: Plant, Pipe and Junction.
 */

public class Plant {
    
    private long id;
    private final List<Pipe> pipes = new ArrayList<>();
}
