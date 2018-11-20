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

package io.shardingsphere.core.parsing.antlr.extractor.statement.handler;

import org.antlr.v4.runtime.ParserRuleContext;

import com.google.common.base.Optional;

import io.shardingsphere.core.parsing.antlr.extractor.statement.handler.result.ExtractResult;
import io.shardingsphere.core.parsing.antlr.extractor.statement.util.ASTUtils;
import io.shardingsphere.core.parsing.parser.exception.SQLParsingUnsupportedException;

/**
 * Rename column extract handler.
 * 
 * @author duhongjun
 */
public final class RenameColumnExtractHandler implements ASTExtractHandler<Optional<ExtractResult>> {
    
    @Override
    public Optional<ExtractResult> extract(final ParserRuleContext ancestorNode) {
        Optional<ParserRuleContext> modifyColumnNode = ASTUtils.findFirstChildNode(ancestorNode, RuleName.RENAME_COLUMN);
        if (!modifyColumnNode.isPresent()) {
            return Optional.absent();
        }
        throw new SQLParsingUnsupportedException("Unsupported SQL statement of rename column");
    }
}
