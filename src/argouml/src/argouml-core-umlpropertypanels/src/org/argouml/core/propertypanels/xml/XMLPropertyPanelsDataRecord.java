// $Id: XMLPropertyPanelsDataRecord.java 15049 2008-06-23 12:33:04Z penyaskito $
// Copyright (c) 2008 The Regents of the University of California. All
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

package org.argouml.core.propertypanels.xml;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Entry of the XML that defines the property panels
 *
 * @author penyaskito
 */
public class XMLPropertyPanelsDataRecord {
    
    private String type;
    private String name;
    
    private List<XMLPropertyPanelsDataRecord> children;
    
    // TODO: this is a tree node, we must refine the tree structure
    
    public XMLPropertyPanelsDataRecord (String theType, String theName) {
        this.type = theType;
        this.name = theName;
        children = new LinkedList<XMLPropertyPanelsDataRecord>();
    }
    
    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }
    
    public List<XMLPropertyPanelsDataRecord> getChildren() {
        return Collections.unmodifiableList(children);
    }
    
    public void addChild(XMLPropertyPanelsDataRecord child) {
        children.add(child);
    }
    public void removeChild(XMLPropertyPanelsDataRecord child) {
        children.remove(child);
    }
    
}
