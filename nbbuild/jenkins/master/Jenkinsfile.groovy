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

pipeline {
    
    agent any
    
    //    agent { 
    //        node { 
    //            label 'ubuntu' 
    //        } 
    //    }
    
    environment {
        OPTS = '-Dcluster.config=full -Djavac.compilerargs=-nowarn -Dbuild.compiler.deprecation=false'
    }
    
    tools {
        jdk 'JDK 1.8 (latest)'
    } 
    
    stages {
        
        stage("Clean") {
            steps {
                withAnt(installation: 'Ant 1.9 (latest)') { 
                    sh "ant $OPTS clean"
                }
            }
        }
        
        stage("Build") {
            steps {
                withAnt(installation: 'Ant 1.9 (latest)') { 
                    sh "ant $OPTS build"
                    sh "ant $OPTS test -Dtest.includes=NoTestsJustBuild"
                }
            }
        }
        
    }
    
}
