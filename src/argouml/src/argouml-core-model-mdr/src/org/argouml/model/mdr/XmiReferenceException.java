// $Id: XmiReferenceException.java 15583 2008-08-19 16:06:02Z tfmorris $
// Copyright (c) 2006 The Regents of the University of California. All
// Rights Reserved. Permission to use, copy, modify, and distribute this
// software and its documentation without fee, and without a written
// agreement is hereby granted, provided that the above copyright notice
// and this paragraph appear in all copies. This software program and
// documentation are copyrighted by The Regents of the University of
// California. The software program and documentation are supplied "AS
// IS", without any accompanying services from The Regents. The Regents
// does not warrant that the operation of the program will be
// uninterrupted or error-free. The end-user understands that the program
// was developed for research purposes and is advised not to rely
// exclusively on the program for any reason. IN NO EVENT SHALL THE
// UNIVERSITY OF CALIFORNIA BE LIABLE TO ANY PARTY FOR DIRECT, INDIRECT,
// SPECIAL, INCIDENTAL, OR CONSEQUENTIAL DAMAGES, INCLUDING LOST PROFITS,
// ARISING OUT OF THE USE OF THIS SOFTWARE AND ITS DOCUMENTATION, EVEN IF
// THE UNIVERSITY OF CALIFORNIA HAS BEEN ADVISED OF THE POSSIBILITY OF
// SUCH DAMAGE. THE UNIVERSITY OF CALIFORNIA SPECIFICALLY DISCLAIMS ANY
// WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF
// MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE. THE SOFTWARE
// PROVIDED HEREUNDER IS ON AN "AS IS" BASIS, AND THE UNIVERSITY OF
// CALIFORNIA HAS NO OBLIGATIONS TO PROVIDE MAINTENANCE, SUPPORT,
// UPDATES, ENHANCEMENTS, OR MODIFICATIONS.

package org.argouml.model.mdr;


/**
 * Exception for external reference problems with XMI files.  This is an
 * internal MDR exception which extends RuntimeException so that it can be
 * thrown from MDR internals.
 * 
 * @author Tom Morris
 */
public class XmiReferenceException extends RuntimeException {
    
    private String reference;
    
    /**
     * Construct an XmiReferenceException with the given message.
     * 
     * @param message the message
     */
    public XmiReferenceException(String message) {
        super(message);
    }

    /**
     * Construct an XmiReferenceException for the given reference
     * 
     * @param href the reference that caused the error
     * @param cause the nested exception if available
     */
    public XmiReferenceException(String href, Throwable cause) {
        super(href, cause);
        reference = href;
    }

    /**
     * @return the external reference (href) that caused the exception
     */
    public String getReference() {
        return reference;
    }

    /**
     * Construct an exception with a causing exception.
     *
     * @param c the cause of the exception
     */
    public XmiReferenceException(Throwable c) {
        super(c);
    }


}
