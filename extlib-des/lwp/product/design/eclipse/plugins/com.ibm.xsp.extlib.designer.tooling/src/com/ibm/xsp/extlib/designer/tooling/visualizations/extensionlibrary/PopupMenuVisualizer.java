/*
 * � Copyright IBM Corp. 2011
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); 
 * you may not use this file except in compliance with the License. 
 * You may obtain a copy of the License at:
 * 
 * http://www.apache.org/licenses/LICENSE-2.0 
 * 
 * Unless required by applicable law or agreed to in writing, software 
 * distributed under the License is distributed on an "AS IS" BASIS, 
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or 
 * implied. See the License for the specific language governing 
 * permissions and limitations under the License.
 */
package com.ibm.xsp.extlib.designer.tooling.visualizations.extensionlibrary;

import org.w3c.dom.Node;

import com.ibm.designer.domino.constants.XSPAttributeNames;
import com.ibm.designer.domino.constants.XSPTagNames;
import com.ibm.xsp.extlib.designer.tooling.visualizations.AbstractCommonControlVisualizer;
import com.ibm.xsp.registry.FacesRegistry;

/**
 * This class generates the following source
 * 
 *  <?xml version="1.0" encoding="UTF-8"?>
 *  <xp:view xmlns:xp="http://www.ibm.com/xsp/core">
 * 
 *      <xp:table style="border-color:rgb(126,171,205);border-style:solid;border-width:1px;background-color:rgb(247,247,247)">
 *          
 *          <xp:tr>
 *              <xp:td style="border:none;padding-right:5px">
 *                  Menu item 1
 *              </xp:td>
 *          </xp:tr>
 *          
 *          <xp:tr style="background-color:rgb(64,86,116);color:rgb(255,255,255)">
 *              <xp:td style="border:none;padding-right:5px">
 *                  Menu item 2
 *              </xp:td>
 *          </xp:tr>
 *  
 *          <xp:tr>
 *              <xp:td style="border:none;padding-right:5px">
 *                  Menu item 3
 *              </xp:td>    
 *          </xp:tr>
 *  
 *      </xp:table>
 * 
 *  </xp:view>
 *
 */
public class PopupMenuVisualizer extends AbstractCommonControlVisualizer{

    private static final String CHOICE_1_TEXT = "Menu item 1"; // $NLX-PopupMenuVisualizer.Choice1-1$
    private static final String CHOICE_2_TEXT = "Menu item 2"; // $NLX-PopupMenuVisualizer.Choice2-1$
    private static final String CHOICE_3_TEXT = "Menu item 3"; // $NLX-PopupMenuVisualizer.HierarchicalChoice3-1$
    
    /*
     * (non-Javadoc)
     * @see com.ibm.designer.domino.xsp.api.visual.AbstractVisualizationFactory#getXSPMarkupForControl(org.w3c.dom.Node, com.ibm.designer.domino.xsp.api.visual.AbstractVisualizationFactory.IVisualizationCallback, com.ibm.xsp.registry.FacesRegistry)
     */
    @Override
    public String getXSPMarkupForControl(Node nodeToVisualize,  IVisualizationCallback callback, FacesRegistry registry) {

        StringBuilder strBuilder = new StringBuilder();
        
        Tag table = new Tag(XP_PREFIX, XSPTagNames.XSP_TAG_TABLE);
        table.addAttribute(XSPAttributeNames.XSP_ATTR_STYLE, "border-color:rgb(126,171,205);border-style:solid;border-width:1px;background-color:rgb(247,247,247)"); // $NON-NLS-1$
        
        Tag firstRow = new Tag(XP_PREFIX, XSPTagNames.XSP_TAG_TABLE_ROW);
        table.addChildTag(firstRow);
        
        Tag firstRowCell1 = new Tag(XP_PREFIX, XSPTagNames.XSP_TAG_TABLE_CELL);
        firstRowCell1.addAttribute(XSPAttributeNames.XSP_ATTR_STYLE, "border:none;padding-right:5px"); // $NON-NLS-1$
        firstRowCell1.addTextChild(CHOICE_1_TEXT);
        firstRow.addChildTag(firstRowCell1);
        
        Tag secondRow = new Tag(XP_PREFIX, XSPTagNames.XSP_TAG_TABLE_ROW);
        secondRow.addAttribute(XSPAttributeNames.XSP_ATTR_STYLE, "background-color:rgb(64,86,116);color:rgb(255,255,255)"); // $NON-NLS-1$
        table.addChildTag(secondRow);
        
        Tag secondRowCell = new Tag(XP_PREFIX, XSPTagNames.XSP_TAG_TABLE_CELL);
        secondRowCell.addAttribute(XSPAttributeNames.XSP_ATTR_STYLE, "border:none;padding-right:5px"); // $NON-NLS-1$
        secondRowCell.addTextChild(CHOICE_2_TEXT);
        secondRow.addChildTag(secondRowCell);
        
        Tag thirdRow = new Tag(XP_PREFIX, XSPTagNames.XSP_TAG_TABLE_ROW);
        table.addChildTag(thirdRow);
        
        Tag thirdRowCell = new Tag(XP_PREFIX, XSPTagNames.XSP_TAG_TABLE_CELL);
        thirdRowCell.addAttribute(XSPAttributeNames.XSP_ATTR_STYLE, "border:none;padding-right:5px"); // $NON-NLS-1$
        thirdRowCell.addTextChild(CHOICE_3_TEXT);
        thirdRow.addChildTag(thirdRowCell);
        
        strBuilder.append(table.toString());
        strBuilder.append(LINE_DELIMITER);
        
        return strBuilder.toString();   
    }
}