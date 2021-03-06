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

package local.example.draft.or.algorithm.util;

/**
 *
 * @author paolo mococci
 */

public interface FlowPipe {
    public static final double EPSILON = 1E-14D;
    public int getPrevious();
    public int getFollowing();
    public double getCapacity();
    public double getFlow();
    public int getOther(int junction);
    double getResidualCapacity(int junction);
    public void addResidualFlow(int junction, double delta);
    public boolean epsilonCheck(double value);
}
