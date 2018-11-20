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
import lombok.RequiredArgsConstructor;

/**
 * Abstract handler result filler.
 *
 * @author duhongjun
 */
@RequiredArgsConstructor
public abstract class AbstractHandlerResultFiller implements HandlerResultFiller {
    
    private final Class<?> extractResultClass;
    
    @Override
    public final void fill(final Object extractResult, final SQLStatement statement, final ShardingTableMetaData shardingTableMetaData) {
        if (!compatClass(extractResult)) {
            return;
        }
        fillSQLStatement(extractResult, statement, shardingTableMetaData);
    }
    
    private boolean compatClass(final Object extractResult) {
        if (null == extractResultClass) {
            return false;
        }
        return extractResultClass == extractResult.getClass() || extractResultClass.isAssignableFrom(extractResult.getClass());
    }
    
    protected abstract void fillSQLStatement(Object extractResult, SQLStatement statement, ShardingTableMetaData shardingTableMetaData);
}
