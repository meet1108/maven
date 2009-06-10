/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.apache.maven.it;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.maven.artifact.versioning.InvalidVersionSpecificationException;
import org.apache.maven.it.AbstractMavenIntegrationTestCase;
import org.apache.maven.it.Verifier;
import org.apache.maven.it.util.ResourceExtractor;

/**
 * This is a test set for <a href="http://jira.codehaus.org/browse/MNG-3203">MNG-3203</a>.
 *
 * @todo Fill in a better description of what this test verifies!
 * 
 * @author <a href="mailto:brianf@apache.org">Brian Fox</a>
 * @author jdcasey
 * 
 */
public class MavenITmng3203DefaultLifecycleExecIdTest
    extends AbstractMavenIntegrationTestCase
{
    public MavenITmng3203DefaultLifecycleExecIdTest()
        throws InvalidVersionSpecificationException
    {
        super( "(2.1.99,)" );
    }

    public void testitMNG3203 ()
        throws Exception
    {
        // The testdir is computed from the location of this
        // file.
        File testDir = ResourceExtractor.simpleExtractResources( getClass(), "/mng-3203" );

        Verifier verifier = new Verifier( testDir.getAbsolutePath() );

        verifier.executeGoal( "compile" );
        verifier.verifyErrorFreeLog();
        verifier.resetStreams();
    }
}
