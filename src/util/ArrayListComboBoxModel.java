/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package util;

import java.util.ArrayList;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 *
 * @author Joel Povis
 */
public class ArrayListComboBoxModel extends AbstractListModel implements  ComboBoxModel
{
   private Object selectedItem;

   private ArrayList anArrayList;

   public ArrayListComboBoxModel ( ArrayList arrayList )
   {
     anArrayList = arrayList;
   }

   public Object getSelectedItem ()
   {
     return selectedItem;
   }

   public void setSelectedItem ( Object newValue )
   {
     selectedItem = newValue;
   }

   public int getSize ()
   {
     return anArrayList.size () ;
   }

   public Object getElementAt ( int i )
   {
     return anArrayList.get ( i ) ;
   }
   
   public void setElementAt(Object newValue)
    {
      anArrayList.add(newValue);
   }

   public ArrayList getLista()
    {
        return anArrayList;
   }
}