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
package oolwre.util;

/**A <code>ReferencePointer</code> refers to an object of
 * type <code>T</code>.
 *
 * @param <T> Which object type the pointer should refer to
 */
public class ReferencePointer<T> {
	
	/** The {@link ReferencePointer}'s reference */
	public T reference;
	
	/**Constructs a {@link ReferencePointer} that points to
	 * <code>null</code>.
	 */
	public ReferencePointer() {}
	
	/**Constructs a {@link ReferencePointer} that points to
	 * <code>reference</code>.
	 * 
	 * @param reference - The initial reference of the
	 * {@link ReferencePointer}
	 */
	public ReferencePointer(T reference) {
		this.reference = reference;
	}
	
	/**Returns the {@link #reference} pointed by this
	 * {@link ReferencePointer}.
	 * 
	 * @return The {@link #reference}
	 */
	public T getReference() {
		return this.reference;
	}
	
	/**Sets the {@link #reference} pointed by this {@link ReferencePointer}.
	 * 
	 * @param reference - The new reference to by pointed
	 * 
	 * @return The last reference pointed by this {@link ReferencePointer}
	 */
	public T setReference(T reference) {
		T t = this.reference;
		this.reference = reference;
		return t;
	}
	
	/**Sets the {@link #reference} pointed by this {@link ReferencePointer}
	 * to <code>null</code>.
	 * 
	 * @return The last reference pointed by this {@link ReferencePointer}
	 */
	public T clearReference() {
		return this.setReference(null);
	}
	
	/**Returns the {@link Class} of the {@link #reference}, or
	 * <code>null</code> if currently pointing to <code>null</code>.
	 * 
	 * @return The reference's {@link Class}
	 */
	public Class<T> getReferenceClass() {
		if (this.reference == null) {
			return null;
		} else {
			return (Class<T>) this.reference.getClass();
		}
	}
	
	/**Returns the {@link #reference}'s {@link #hashCode()}.
	 * 
	 * @return The reference's hash code
	 */
	public int referenceHashCode() {
		if (this.reference == null) {
			return 0;
		} else {
			return this.reference.hashCode();
		}
	}
	
	/**Returns a new {@link ReferencePointer} that points to the same
	 * {@link #reference} as <code>this</code>.
	 */
	public ReferencePointer<T> clone() {
		try {
			return (ReferencePointer<T>) super.clone();
		} catch (CloneNotSupportedException e) {
			return null;
		}
	}
	
	/**Returns whether or not <code>obj</code> 'equals' <code>this</code>;<br><br>
	 * <i>If <code>obj</code> instanceof {@link ReferencePointer}</i>:<ul>
	 * <li>Returns <code>true</code> only if <code>obj</code> points to
	 * the same {@link #reference}.</li>
	 * </ul>
	 * <br><i>Else</i>:<ul>
	 * <li>Returns <code>true</code> only if <code>obj</code> is the same
	 * as the {@link #reference}.
	 * </ul>
	 */
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		} else if (obj == this) {
			return true;
		} else if (obj instanceof ReferencePointer<?>) {
			ReferencePointer<?> pointer = (ReferencePointer<?>) obj;
			return pointer.reference == this.reference;
		} else {
			return this.reference == obj;
		}
	}
	
	/**Returns whether or not <code>pointer</code> points to the
	 * same {@link #reference}.
	 * 
	 * @param pointer - The {@link ReferencePointer} to be compared
	 * to <code>this</code>
	 * 
	 * @return Whether or not <code>pointer</code> points to the
	 * same reference
	 */
	public boolean equals(ReferencePointer<?> pointer) {
		if (pointer == null) {
			return false;
		} else if (pointer == this) {
			return true;
		} else {
			return pointer.reference == this.reference;
		}
	}
	
	/**Returns a {@link String} representation of this
	 * {@link ReferencePointer} exactly as:
	 * <p><code>&nbsp;&nbsp;&nbsp;&nbsp;{@link #getClass()
	 * }.{@link Class#getName() getName()} + " pointing to " +
	 * {@link #reference}</code></p>
	 */
	public String toString() {
		return this.getClass().getName() + " pointing to " + this.reference;
	}
}
