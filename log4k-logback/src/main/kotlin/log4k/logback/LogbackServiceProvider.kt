/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * MIT License
 *
 * Copyright (c) 2019 Jun Kurihara
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

package log4k.logback

import log4k.ILogFactory
import log4k.ILogger
import log4k.Log4kServiceProvider

/**
 * Provide logging service by logback
 *
 */
class LogbackServiceProvider : Log4kServiceProvider {

    companion object {
        val logFactory: ILogFactory = LogbackFactory()
    }

    /**
     * Initialize logback
     *
     */
    override fun initialize() = Unit

    /**
     * Get logFactory class for logging by logback
     *
     * @return log factory class
     */
    override fun getLogFactory(): ILogFactory {
        return logFactory
    }

    private class LogbackFactory : ILogFactory {
        override fun getLogger(className: String): ILogger {
            return LogbackLogger(className)
        }
    }
}