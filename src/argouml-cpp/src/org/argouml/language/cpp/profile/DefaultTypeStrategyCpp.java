// $Id: DefaultTypeStrategyCpp.java 305 2009-01-16 16:17:20Z tfmorris $
// Copyright (c) 2009 The Regents of the University of California. All
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

package org.argouml.language.cpp.profile;

import java.util.Collection;

import org.argouml.model.Model;
import org.argouml.profile.DefaultTypeStrategy;

/**
 * Implements the strategy to provide default types for return values, 
 * parameters and attributes in models that use the UML profile for C++.
 *
 * @author Luis Sergio Oliveira (euluis)
 */
public class DefaultTypeStrategyCpp implements DefaultTypeStrategy {
    
    private Collection profileModels;
    
    private String defaultTypeName = "int"; //$NON-NLS-1$
    
    DefaultTypeStrategyCpp(Collection profileModels) {
        if (profileModels.isEmpty()) {
            throw new IllegalArgumentException(
                "profileModels is empty, but, it must contain at " //$NON-NLS-1$
                + "least one model."); //$NON-NLS-1$
        }
        this.profileModels = profileModels;
    }
    
    public Object getDefaultAttributeType() {
        return getDefaultType(defaultTypeName);
    }
    
    public Object getDefaultParameterType() {
        return getDefaultType(defaultTypeName);
    }
    
    public Object getDefaultReturnType() {
        return getDefaultType(defaultTypeName);
    }
    
    private Object getDefaultType(String typeName) {
        for (Object model : profileModels) {
            Collection dataTypes = Model.getCoreHelper().getAllDataTypes(model);
            for (Object dataType : dataTypes) {
                if (typeName.equals(Model.getFacade().getName(dataType))) {
                    return dataType;
                }
            }
        }
        return null;
    }

}
