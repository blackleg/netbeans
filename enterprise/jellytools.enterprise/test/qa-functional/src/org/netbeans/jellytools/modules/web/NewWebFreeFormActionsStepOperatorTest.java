/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.netbeans.jellytools.modules.web;

import java.io.File;
import java.io.IOException;
import junit.framework.Test;
import org.netbeans.jellytools.JellyTestCase;

/**
 * Test of org.netbeans.jellytools.NewJspFileNameStepOperator.
 *
 * @author Martin Schovanek
 */
public class NewWebFreeFormActionsStepOperatorTest extends JellyTestCase {

    /**
     * Constructor required by JUnit.
     *
     * @param testName method name to be used as testcase
     */
    public NewWebFreeFormActionsStepOperatorTest(String testName) {
        super(testName);
    }

    /** Method used for explicit testsuite definition
     * @return  created suite
     */
    public static Test suite() {
        return createModuleTest(NewWebFreeFormActionsStepOperatorTest.class);
    }

    @Override
    public void setUp() {
        System.out.println("### " + getName() + " ###");
    }

    /** Invokes and verifies the dialog. */
    public void testVerify() throws IOException {
        NewWebFreeFormNameStepOperator nameStep = NewWebFreeFormNameStepOperator.invoke();
        nameStep.setProjectLocation(new File(getDataDir(), "WebFreeFormSrc").getCanonicalPath());
        nameStep.next();
        NewWebFreeFormActionsStepOperator actionsStep = new NewWebFreeFormActionsStepOperator();
        actionsStep.verify();
        actionsStep.close();
    }
}
