/*
 * +-+ +-+ +-+ +-+ +-+ +-+ +-+ +-+ +-+ +-+ +-+
 * |4| |7| |R| |o| |n| |i| |n| |L| |a| |b| |s|
 * +-+ +-+ +-+ +-+ +-+ +-+ +-+ +-+ +-+ +-+ +-+
 */
package com.starboard.b2b.exception;

/**
 *
 * @author MaGicBank <magicbank@gmail.com>
 */
public class B2BException extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public B2BException() {
        super();
    }

    public B2BException(String message) {
        super(message);
    }

    public B2BException(String message, Throwable cause) {
        super(message, cause);
    }

    public B2BException(Throwable cause) {
        super(cause);
    }
}
