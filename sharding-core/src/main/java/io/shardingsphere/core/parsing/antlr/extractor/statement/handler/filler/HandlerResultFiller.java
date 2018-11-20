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

package io.shardingsphere.core.parsing.antlr.extractor.statement.handler.filler;

import io.shardingsphere.core.metadata.table.ShardingTableMetaData;
import io.shardingsphere.core.parsing.parser.sql.SQLStatement;

/**
 * Handler result filler.
 * 
 * @author duhongjun
 */
public interface HandlerResultFiller {
    
    /**
     * Fill result to SQLStatement.
     *
     * @param extractResult extract result from AST
     * @param statement SQL statement
     * @param shardingTableMetaData sharding table meta data
     */
    void fill(Object extractResult, SQLStatement statement, ShardingTableMetaData shardingTableMetaData);
}
