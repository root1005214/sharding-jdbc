/*
 * Copyright 2016-2018 shardingsphere.io.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * </p>
 */

package io.shardingsphere.transaction;

import io.shardingsphere.core.constant.transaction.TransactionType;
import io.shardingsphere.core.transaction.TransactionTypeHolder;
import io.shardingsphere.transaction.fixture.ShardingTransactionalTestService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ShardingTransactionalSpringBootTest.class)
@SpringBootApplication
@ComponentScans({@ComponentScan("io.shardingsphere.transaction.aspect"), @ComponentScan("io.shardingsphere.transaction.fixture")})
public class ShardingTransactionalSpringBootTest {
    
    @Autowired
    private ShardingTransactionalTestService testService;
    
    @Before
    public void setUp() {
        TransactionTypeHolder.set(TransactionType.LOCAL);
    }
    
    @Test
    public void assertChangeTransactionTypeToXA() {
        testService.testChangeTransactionTypeToXA();
        assertThat(TransactionTypeHolder.get(), is(TransactionType.XA));
    }
    
    @Test
    public void assertChangeTransactionTypeToBASE() {
        testService.testChangeTransactionTypeToBASE();
        assertThat(TransactionTypeHolder.get(), is(TransactionType.BASE));
    }
    
    @Test
    public void assertChangeTransactionTypeToLocal() {
        TransactionTypeHolder.set(TransactionType.XA);
        testService.testChangeTransactionTypeToLOCAL();
        assertThat(TransactionTypeHolder.get(), is(TransactionType.LOCAL));
    }
    
    @Test
    public void assertChangeTransactionTypeInClass() {
        testService.testChangeTransactionTypeInClass();
        assertThat(TransactionTypeHolder.get(), is(TransactionType.XA));
    }
    
    @Test
    public void assertChangeTransactionTypeWithEnvironment() {
        testService.testChangeTransactionTypeWithEnvironment();
        assertThat(TransactionTypeHolder.get(), is(TransactionType.LOCAL));
    }
}
