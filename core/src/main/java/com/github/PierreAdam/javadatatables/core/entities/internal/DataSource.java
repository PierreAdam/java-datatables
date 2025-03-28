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

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * DataSource.
 *
 * @param <E> the Entity type
 * @author Pierre Adam
 * @since 21.03.01
 */
@Getter
@Setter
public class DataSource<E> {

    /**
     * The Entities.
     */
    private List<E> entities;

    /**
     * The Records total.
     */
    private long recordsTotal;

    /**
     * The Records filtered.
     */
    private long recordsFiltered;

    /**
     * Instantiates a new Data source.
     */
    public DataSource() {
    }

    /**
     * Instantiates a new Data source.
     *
     * @param recordsTotal    the records total
     * @param recordsFiltered the records filtered
     * @param entities        the entities
     */
    public DataSource(final long recordsTotal, final long recordsFiltered, final List<E> entities) {
        this.entities = entities;
        this.recordsTotal = recordsTotal;
        this.recordsFiltered = recordsFiltered;
    }
}
