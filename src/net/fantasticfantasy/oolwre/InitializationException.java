/*Copyright (c) 2017 Fantastic Fantasy All rights reserved.
 *
 * Permission to use, copy, modify and/or redistribute in source or binary form
 * is hereby granted, free of charge, subject to the following conditions:
 *
 * - Redistribution of source code shall include the above copyright notice,
 *  this list of conditions and the following disclaimer.
 *
 * - Redistribution in binary form shall include the above copyright notice,
 *  this list of conditions and the following disclaimer in the documentation
 *  and/or other materials provided with the distribution.
 *
 * - Neither the name Object Oriented Lightweight Render Engine nor the names
 *  of its contributors may be used to endorse or promote products derived
 *  from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
 * IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT,
 * INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING,
 * BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE
 * OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED
 * OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package net.fantasticfantasy.oolwre;

/**The <code>InitializationException</code> class represents any
 * error that could have happened during the initialization.
 */
public class InitializationException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	/**Constructs a {@link InitializationException} with the specified
	 * error message.
	 */
	public InitializationException(String message) {
		super(message);
	}
	
	/**Constructs a {@link InitializationException} with the specified
	 * cause and error message.
	 */
	public InitializationException(Throwable cause, String message) {
		super(message, cause);
	}
	
	/**Constructs a {@link InitializationException} with the specified
	 * cause.
	 */
	public InitializationException(Throwable cause) {
		super(cause);
	}
}
