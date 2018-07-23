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

package local.example.draft.adt.util;

import java.util.Iterator;
import java.util.NoSuchElementException;
import local.example.draft.adt.Label;

/**
 *
 * @author paolo mococci
 * @param <Element>
 */

public class LabelIterator<Element> 
        implements Iterator<Element> {
    
    private Label<Element> current;

    public LabelIterator(Label<Element> current) {
        this.current = current;
    }

    @Override
    public boolean hasNext() {
        return this.current != null;
    }

    @Override
    public Element next() {
        if (!this.hasNext()) {
            throw new NoSuchElementException();
        }
        Element temp = this.current.getElement();
        this.current = this.current.getNext();
        return temp;
    }

    @Override
    public void remove() {
        Iterator.super.remove();
    }

    public Label<Element> getCurrent() {
        return current;
    }

    public void setCurrent(Label<Element> current) {
        this.current = current;
    }
}
