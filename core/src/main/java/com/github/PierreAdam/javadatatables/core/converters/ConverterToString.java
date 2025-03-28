/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2025 Pierre Adam
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.github.PierreAdam.javadatatables.core.converters;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.NullNode;
import com.fasterxml.jackson.databind.node.TextNode;

/**
 * ConverterToString.
 *
 * @param <T> the type parameter
 * @author Pierre Adam
 * @since 21.03.29
 */
public abstract class ConverterToString<T> extends Converter<T> {

    /**
     * Instantiates a new converter.
     *
     * @param tClass the class of T
     */
    public ConverterToString(final Class<T> tClass) {
        super(tClass);
    }

    @Override
    protected JsonNode internalAsValueNode(final T obj, final Object context) {
        return (obj == null ? NullNode.getInstance() : TextNode.valueOf(this.convert(obj, context)));
    }

    /**
     * Convert the object to a string.
     *
     * @param obj     the object
     * @param context the context
     * @return the string
     */
    public abstract String convert(final T obj, final Object context);
}
