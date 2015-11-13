/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MVC;

import javax.swing.AbstractListModel;

/**
 *
 * @author kerbrase
 */
public class CustomListModel extends AbstractListModel<String> {

    private String[] content = {};

    @Override
    public int getSize() {
        return getContent().length;
    }

    @Override
    public String getElementAt(int i) {
        return getContent()[i];
    }

    /**
     * @return the content
     */
    public String[] getContent() {
        return content;
    }

    /**
     * @param content the content to set
     */
    public void setContent(String[] content) {
        this.content = content;
        fireContentsChanged(this, 0, getSize());
    }
}
