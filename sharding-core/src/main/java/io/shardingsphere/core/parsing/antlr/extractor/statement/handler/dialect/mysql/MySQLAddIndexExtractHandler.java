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

package io.shardingsphere.core.parsing.antlr.extractor.statement.handler.dialect.mysql;

import java.util.Collection;
import java.util.Collections;

import org.antlr.v4.runtime.ParserRuleContext;

import io.shardingsphere.core.parsing.antlr.extractor.statement.handler.ASTExtractHandler;
import io.shardingsphere.core.parsing.antlr.extractor.statement.handler.IndexesNameExtractHandler;
import io.shardingsphere.core.parsing.antlr.extractor.statement.handler.RuleName;
import io.shardingsphere.core.parsing.antlr.extractor.statement.handler.result.IndexExtractResult;
import io.shardingsphere.core.parsing.antlr.extractor.statement.util.ASTUtils;

/**
 * Add index extract handler for MySQL.
 *
 * @author duhongjun
 */
public final class MySQLAddIndexExtractHandler implements ASTExtractHandler<Collection<IndexExtractResult>> {
    
    private final IndexesNameExtractHandler indexNamesExtractHandler = new IndexesNameExtractHandler();
    
    @Override
    public Collection<IndexExtractResult> extract(final ParserRuleContext ancestorNode) {
        Collection<ParserRuleContext> addIndexNodes = ASTUtils.getAllDescendantNodes(ancestorNode, RuleName.ADD_INDEX);
        if (addIndexNodes.isEmpty()) {
            return Collections.emptyList();
        }
       
        return indexNamesExtractHandler.extract(ancestorNode);
    }
}
