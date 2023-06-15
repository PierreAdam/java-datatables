/*
 * MIT License
 *
 * Copyright (c) 2021 Pierre Adam
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

package mocking.dataprovider.enums;

import java.util.Random;

/**
 * NumberEnum.
 *
 * @author Pierre Adam
 * @since 21.03.29
 */
public enum NumberEnum {

    /**
     * Pending number enum.
     */
    PENDING(0),

    /**
     * Active number enum.
     */
    ACTIVE(1),

    /**
     * Blocked number enum.
     */
    BLOCKED(2),

    /**
     * Deleted number enum.
     */
    DELETED(3);

    /**
     * The Value.
     */
    private final int value;

    /**
     * Instantiates a new Number enum.
     *
     * @param value the value
     */
    NumberEnum(final int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.valueOf(this.value);
    }

    /**
     * Rand number enum.
     *
     * @param random the random
     * @return the number enum
     */
    public static NumberEnum rand(final Random random) {
        return NumberEnum.values()[random.nextInt(NumberEnum.values().length)];
    }
}
