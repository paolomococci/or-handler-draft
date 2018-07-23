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

import java.util.Iterator;
import java.util.NoSuchElementException;
import local.example.draft.adt.util.LabelIterator;

/**
 *
 * @author paolo mococci
 * @param <Element>
 */

public class Stack<Element> 
        implements 
        AbstractDataType<Element>, 
        Iterable<Element> {
    
    private Label<Element> top;
    private long elements;

    public Stack() {
        this.top = null;
        this.elements = 0;
    }
    
    private boolean existTop() {
        return null != this.top;
    }
    
    public void push(Element element) {
        Label<Element> oldTop = this.top;
        this.top = new Label<>();
        this.top.element = element;
        this.top.next = oldTop;
        this.elements++;
    }
    
    public Element pop() {
        if (this.isEmpty()) {
            throw new NoSuchElementException("stack is empty");
        }
        Element element = this.top.element;
        this.top = this.top.next;
        this.elements--;
        return element;
    }

    public Label<Element> getTop() {
        return top;
    }

    @Override
    public long getElements() {
        return elements;
    }

    @Override
    public Iterator<Element> iterator() {
        return new LabelIterator<>(this.top);
    }

    @Override
    public Element peep() {
        if (this.isEmpty()) {
            throw new NoSuchElementException("stack is empty");
        }
        return this.top.element;
    }

    @Override
    public boolean isEmpty() {
        return !(this.existTop());
    }
}
