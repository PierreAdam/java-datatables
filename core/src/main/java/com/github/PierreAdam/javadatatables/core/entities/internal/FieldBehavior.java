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

package com.github.PierreAdam.javadatatables.core.entities.internal;

import com.github.PierreAdam.javadatatables.core.enumerations.OrderEnum;
import lombok.Setter;

import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;

/**
 * FieldBehavior.
 *
 * @param <E> the Entity type
 * @param <S> the Source Provider type
 * @param <C> the Context type
 * @author Pierre Adam
 * @since 21.03.18
 */
@Setter
public class FieldBehavior<E, S, C> {

    /**
     * If set, the supplier will be called when forging the ajax response object.
     * If not set, the value will try to be resolved from the type of the data.
     */
    private BiFunction<E, C, String> displaySupplier;

    /**
     * If set, the search handler will be called when searching.
     * If not set, the search will fallback to the default behavior
     */
    private BiConsumer<S, String> searchHandler;

    /**
     * The Order handler.
     */
    private BiConsumer<S, OrderEnum> orderHandler;

    /**
     * Gets display supplier.
     *
     * @return the display supplier
     */
    public Optional<BiFunction<E, C, String>> getDisplaySupplier() {
        return Optional.ofNullable(this.displaySupplier);
    }

    /**
     * Gets search handler.
     *
     * @return the search handler
     */
    public Optional<BiConsumer<S, String>> getSearchHandler() {
        return Optional.ofNullable(this.searchHandler);
    }

    /**
     * Gets order handler.
     *
     * @return the order handler
     */
    public Optional<BiConsumer<S, OrderEnum>> getOrderHandler() {
        return Optional.ofNullable(this.orderHandler);
    }
}
