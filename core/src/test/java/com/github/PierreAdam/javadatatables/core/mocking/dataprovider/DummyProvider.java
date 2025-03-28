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

package com.github.PierreAdam.javadatatables.core.mocking.dataprovider;

import com.github.PierreAdam.javadatatables.testdata.PersonEntity;
import com.github.javafaker.Faker;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * DummyQuery.
 *
 * @author Pierre Adam
 * @since 21.03.02
 */
public class DummyProvider {

    /**
     * The constant SAMPLE_SIZE.
     */
    public static final int SAMPLE_SIZE = 200;

    /**
     * The Start idx.
     */
    private int startIdx;

    /**
     * The Number of elem.
     */
    private int numberOfElem;

    /**
     * The Data.
     */
    @Getter
    private List<PersonEntity> data;

    /**
     * Instantiates a new Dummy query.
     */
    public DummyProvider() {
        this.data = new ArrayList<>();
    }

    /**
     * Initialize data.
     */
    public void initializeData() {
        final Faker faker = new Faker();

        for (int i = 0; i < DummyProvider.SAMPLE_SIZE; i++) {
            this.data.add(new PersonEntity(faker));
        }
    }

    /**
     * Sets pagination.
     *
     * @param startIdx     the start idx
     * @param numberOfElem the number of elem
     */
    public void setPagination(final int startIdx, final int numberOfElem) {
        this.startIdx = startIdx;
        this.numberOfElem = numberOfElem;
    }

    /**
     * Gets result.
     *
     * @return the result
     */
    public List<PersonEntity> getResult() {
        if (this.startIdx >= this.data.size()) {
            return new ArrayList<>();
        }
        final int endIdx = this.startIdx + this.numberOfElem;
        return this.data.subList(this.startIdx, Math.min(endIdx, this.data.size()));
    }

    /**
     * Gets initial size.
     *
     * @return the initial size
     */
    public int getInitialSize() {
        return DummyProvider.SAMPLE_SIZE;
    }

    /**
     * Alter data.
     *
     * @param alterCall the alter call
     */
    public void alterData(final Function<List<PersonEntity>, List<PersonEntity>> alterCall) {
        this.data = alterCall.apply(this.data);
    }
}
