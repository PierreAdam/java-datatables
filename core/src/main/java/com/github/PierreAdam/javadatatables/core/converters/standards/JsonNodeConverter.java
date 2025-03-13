/*
 * Copyright (C) 2014 - 2023 PayinTech, SAS - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 */

package com.github.PierreAdam.javadatatables.core.converters.standards;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.PierreAdam.javadatatables.core.converters.Converter;

/**
 * JsonNodeConverter.
 *
 * @author Pierre Adam
 * @since 21.03.29
 */
public class JsonNodeConverter extends Converter<JsonNode> {

    /**
     * Instantiates a new converter.
     */
    public JsonNodeConverter() {
        super(JsonNode.class);
    }

    @Override
    protected JsonNode internalAsValueNode(final JsonNode obj, final Object context) {
        return obj;
    }
}
