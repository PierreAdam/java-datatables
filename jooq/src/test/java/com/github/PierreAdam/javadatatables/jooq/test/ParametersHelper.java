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

package com.github.PierreAdam.javadatatables.jooq.test;

import com.github.PierreAdam.javadatatables.core.entities.Column;
import com.github.PierreAdam.javadatatables.core.entities.Parameters;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * ParametersHelper.
 *
 * @author Pierre Adam
 * @since 21.03.02
 */
public class ParametersHelper {

    /**
     * Create for name entity parameters.
     *
     * @return the parameters
     */
    public static Parameters createForNameEntity() {
        final Parameters parameters = new Parameters();
        final ColumnFactory columnFactory = new ColumnFactory();
        parameters.setDraw(1);
        parameters.setStart(0);
        parameters.setLength(10);
        parameters.setColumns(columnFactory.getColumns());

        columnFactory
                .addColumn("createdAt")
                .addColumn("uid")
                .addColumn("firstName")
                .addColumn("lastName")
                .addColumn("fullName") // Computed column that does not exists in the original entity
                .addColumn("title")
                .addColumn("bloodGroup")
                .addColumn("active");

        return parameters;
    }

    /**
     * The type Column factory.
     */
    @Getter
    public static class ColumnFactory {

        /**
         * The Columns.
         */
        private final List<Column> columns;

        /**
         * Instantiates a new Column factory.
         */
        public ColumnFactory() {
            this(new ArrayList<>());
        }

        /**
         * Instantiates a new Column factory.
         */
        public ColumnFactory(final List<Column> columns) {
            this.columns = columns;
        }

        /**
         * Add column column factory.
         *
         * @param name the name
         * @return the column factory
         */
        public ColumnFactory addColumn(final String name) {
            return this.addColumn(name, true, true);
        }

        /**
         * Add column column factory.
         *
         * @param name        the name
         * @param searcheable the searcheable
         * @param orderable   the orderable
         * @return the column factory
         */
        public ColumnFactory addColumn(final String name, final boolean searcheable, final boolean orderable) {
            final int lastId = this.columns.stream().map(Column::getData).map(Integer::parseInt).max(Comparator.comparingInt(o -> o)).orElse(-1);

            this.columns.add(new Column() {{
                this.setData(String.valueOf(lastId + 1));
                this.setName(name);
                this.setSearchable(searcheable);
                this.setOrderable(orderable);
            }});
            return this;
        }
    }
}
