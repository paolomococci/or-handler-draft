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

public class Queue<Element> 
        implements 
        AbstractDataType<Element>, 
        Iterable<Element> {
    
    private Label<Element> begin;
    private Label<Element> end;
    private long elements;

    public Queue() {
        this.begin = null;
        this.end = null;
        this.elements = 0;
    }
    
    private boolean existBegin() {
        return null != this.begin;
    }
    
    private boolean existEnd() {
        return null != this.end;
    }
    
    public void enqueue(Element element) {
        Label<Element> oldEnd = this.end;
        this.end = new Label<>();
        this.end.element = element;
        this.end.next = null;
        if (this.isEmpty()) {
            this.begin = this.end;
        } else {
            oldEnd.next = this.end;
        }
        this.elements++;
    }
    
    public Element dequeue() {
        if (this.isEmpty()) {
            throw new NoSuchElementException("queue is empty");
        }
        Element element = this.begin.element;
        this.begin = this.begin.next;
        this.elements--;
        if (this.isEmpty()) {
            this.end = null;
        }
        return element;
    }

    public Label<Element> getBegin() {
        return begin;
    }

    public Label<Element> getEnd() {
        return end;
    }

    @Override
    public long getElements() {
        return elements;
    }

    @Override
    public Iterator<Element> iterator() {
        return new LabelIterator<>(this.begin);
    }

    @Override
    public Element peep() {
        if (this.isEmpty()) {
            throw new NoSuchElementException("queue is empty");
        }
        return this.begin.element;
    }

    @Override
    public boolean isEmpty() {
        return !(this.existBegin() && this.existEnd());
    }
}
