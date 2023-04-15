/*
 * Sly Technologies Free License
 * 
 * Copyright 2023 Sly Technologies Inc.
 *
 * Licensed under the Sly Technologies Free License (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.slytechs.com/free-license-text
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package org.jnetpcap.internal;

import java.lang.Thread.UncaughtExceptionHandler;
import java.lang.foreign.MemoryAddress;

import org.jnetpcap.PcapHandler.NativeCallback;

public interface PcapDispatcher extends NativeCallback, AutoCloseable {

	int captureLength(MemoryAddress address);

	int dispatchNative(int count, NativeCallback handler, MemoryAddress user);

	int dispatchRaw(int count, MemoryAddress callbackFunc, MemoryAddress userData);

	int headerLength(MemoryAddress address);

	int loopNative(int count, NativeCallback handler, MemoryAddress user);

	int loopRaw(int count, MemoryAddress callbackFunc, MemoryAddress userData);

	RuntimeException getUncaughtException();

	/**
	 * @param exceptionHandler
	 */
	void setUncaughtExceptionHandler(UncaughtExceptionHandler exceptionHandler);

	@Override
	void close();
}