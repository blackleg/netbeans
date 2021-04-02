<?php

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
$test1 = 100;
$test2 = 2;

array_fill(   start_index  : 0, count   : 100, value:50);
array_fill(
    value:50,    
   count   : 100, 
   start_index     :0
  );

class ParentClass {

    public function __construct(
            public int $foo,
            public string $bar = "",
    ) {
    }

}

class ExampleClass extends ParentClass {

public function __construct(
        public string $test1,
        public ?int $test2 = null,
) {
    parent::__construct(foo: $test1);
}

public function test(int $test1, string|int $test2 = "") {}

public static function staticTest(ExampleClass $exampleClass, int $test) {}
}

$instance = new ExampleClass($test1, test2: $test2);
$instance->test(test1:$test2);
ExampleClass::staticTest(  exampleClass  : $instance, test  : $test2);
ExampleClass::staticTest(
        exampleClass  : $instance,
        test  : $test2,
);
$array_fill = "array_fill";
$array_fill(   start_index   : 0, count : 100, value            : 50);
$array_fill(
        start_index   : 0,
        count : 100,
        value            : 50
    );

test(test(1, 2, 3), test3:test(1, 2, 3), test2   : test(1, test2   : 2, test3   : [1, 2, 3]));
test(
        test(1, 2, 3),
        test3:test(1, 2, 3),
        test2   : test(1, test2   : 2, test3   : [1, 2, 3])
        );

reservedKeyWord(   array         : []);
reservedKeyWord(
        array         : []
  );

test(  1,   2,   test3    :    $test1   === 0 ? 0:1);
test(
1,
2,
test3    :    $test1   === 0 ? 0:1
);

function test(int $test1, int $test2, int|array $test3):int {
    return 0;
}

function reservedKeyWord($array) {
    var_dump($array);
}
