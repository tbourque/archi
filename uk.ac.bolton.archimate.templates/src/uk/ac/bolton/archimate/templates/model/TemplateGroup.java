/**
 * This program and the accompanying materials
 * are made available under the terms of the License
 * which accompanies this distribution in the file LICENSE.txt
 */
package uk.ac.bolton.archimate.templates.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import uk.ac.bolton.archimate.editor.utils.StringUtils;



/**
 * Template Group
 * 
 * @author Phillip Beauvoir
 */
public class TemplateGroup implements ITemplateGroup {
    
    private List<ITemplate> fTemplates = new ArrayList<ITemplate>();
    private String fName;
    
    public TemplateGroup() {
    }

    public TemplateGroup(String name) {
        fName = name;
    }

    public String getName() {
        return fName;
    }

    public void setName(String name) {
        fName = name;
    }

    public List<ITemplate> getTemplates() {
        return fTemplates;
    }

    public void addTemplate(ITemplate template) {
        fTemplates.add(template);
    }

    public boolean removeTemplate(ITemplate template) {
        return fTemplates.remove(template);
    }

    @Override
    public List<ITemplate> getSortedTemplates() {
        List<ITemplate> list = new ArrayList<ITemplate>(getTemplates());
        
        Collections.sort(list, new Comparator<ITemplate>() {
            @Override
            public int compare(ITemplate t1, ITemplate t2) {
                String name1 = StringUtils.safeString(t1.getName()).toLowerCase().trim();
                String name2 = StringUtils.safeString(t2.getName()).toLowerCase().trim();
                return name1.compareTo(name2);
            }
        });
        
        return list;
    }
}
