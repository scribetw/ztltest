/* B30_1819318Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:01 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B30

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget


class B30_1819318Test extends ZTL4ScalaTestCase {
  @Test
  def testDatabind() = {
    var zscript =
      """
<?init class="org.zkoss.zkplus.databind.AnnotateDataBinderInit" ?>
<zk>
<html><![CDATA[
1. Select randomly an item from the 1st listbox.<br/>
2. The selected item should appear in the 2nd listbox.<br/>
3. Repeat 1 and 2 in RANDOM order, the 2nd listbox should list items in order no matter the added sequence.<br/>
4. Press the parentModel button and check the real order of the 2nd listbox. It should be in order.<br/>
5. Press the parents button and check the real order of the inner TreeSet. It should be in order.<br/>
6. If everything ok. Now start to check "remove" item from 2nd listbox.<br/>
7. DoubleClick randomly on the item of the 2nd listbox and check if it is removed properly and kept the order.<br/>
8. Now repeate 4 and 5 to see if the inner data structure is in the same order as shown on the 2nd listbox.<br/>
]]></html>

<window closable="true" id="testArticoloWind" width="200px" title="Test"
 xmlns="http://www.zkoss.org/2005/zul" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
 xsi:schemaLocation="http://www.zkoss.org/2005/zul http://www.zkoss.org/2005/zul/zul.xsd ">
<zscript><![CDATA[
public class BlahComparator implements Comparator {

	public int compare(Object o1, Object o2) {
		int p1 = ((Blah)o1).getNumber();
		int p2 = ((Blah)o2).getNumber();
		int res = 0;
		if(p1 > p2) res = 1;
		else if(p1 < p2) res = -1;
		return res;
	}

}

class Person {
	TreeSet parents = new TreeSet(new BlahComparator());

	public TreeSet getParents(){
		return parents;
	}

	public void addParent(Object o){
		parents.add(o);
	}

}

class Blah implements Comparable{
	int number = 0;
	private String name ;
	private static int counter = 1;

	public Blah(){
		name = "Blah " + Integer.toString((number = counter++));
	}

	public void setName(String n){
		name  = n;
	}

	public String getName(){
		return name;
	}
	public String toString(){
		return name;
	}

	public int getNumber(){
		return number;
	}

	public int compareTo(Object o){
		int n = ((Blah)o).getNumber();
		if(number > n) return 1;
		if(number < n) return -1;
		return 0;
	}

}
Person person = new Person();
int actionCounter = 1;
ArrayList l = new ArrayList(20);
for(int i = 0; i < 20; i++)
	l.add(new Blah());

]]></zscript>

<groupbox>
<caption label="1st listbox"/>
<listbox id="select" model="@{l}" mold="select" >
<attribute name="onSelect">
	Blah p = l.get(self.selectedIndex);
	((ListModelSet)parentsList.getModel()).add(p);
</attribute>
</listbox>
</groupbox>

<groupbox>
<caption label="2nd listbox"/>
<listbox id="parentsList" model="@{person.parents}">
	<listhead>
		<listheader label="Parent"/>
	</listhead>
	<listitem self="@{each=obj}" value="@{obj}">
		<attribute name="onDoubleClick">
			Blah b = (Blah)self.value;
			((ListModelSet)parentsList.getModel()).remove(b);
		</attribute>
		<listcell label="@{obj}"/>
	</listitem>
</listbox>
</groupbox>

<button id="parentModel" label="parentModel" onClick='alert(""+parentsList.getModel())'/>
<button id="parents" label="parents" onClick='alert(""+person.getParents())'/>
<button id="selectionInModel" label="selectionInModel" onClick='alert(""+parentsList.getModel().getSelection())'/>
</window>
</zk>
		 """
    val ztl$engine = engine()
    val testArticoloWind = ztl$engine.$f("testArticoloWind")
    val selectWidget = ztl$engine.$f("select")
    val parentsList = ztl$engine.$f("parentsList")
    val parentModel = ztl$engine.$f("parentModel")
    val parents = ztl$engine.$f("parents")
    val selectionInModel = ztl$engine.$f("selectionInModel")
    runZTL(zscript, () => {
      sleep(1000); //for DataBinding
      verifyFalse(jq("@listbox > @listitem").exists())
      select(selectWidget, "Blah 2")
      waitResponse()
      verifyEquals("Blah 2", widget(jq("@listbox > @listitem")).attr("label"))
      select(selectWidget, "Blah 4")
      waitResponse()
      verifyEquals("Blah 4", widget(jq("@listbox > @listitem:last-child")).attr("label"))
      select(selectWidget, "Blah 9")
      waitResponse()
      verifyEquals("Blah 9", widget(jq("@listbox > @listitem:last-child")).attr("label"))
      click(parentModel)
      waitResponse()
      //for event thread compatible
      verifyEquals("[Blah 2, Blah 4, Blah 9]", getAlertMessage())
      clickAlert()
      waitResponse()
      click(parents)
      waitResponse()
      sleep(500)
      verifyEquals("[Blah 2, Blah 4, Blah 9]", getAlertMessage())
      clickAlert()
      waitResponse()
      click(jq("@listbox > @listitem:last-child"))
      waitResponse()
      click(selectionInModel)
      waitResponse()
      verifyEquals("[Blah 9]", getAlertMessage())
      clickAlert()
      waitResponse()
      doubleClick(jq("@listbox > @listitem:last-child"))
      waitResponse()
      verifyEquals("Blah 4", widget(jq("@listbox > @listitem:last-child")).attr("label"))
      click(parents)
      waitResponse()
      verifyEquals("[Blah 2, Blah 4]", getAlertMessage())
      clickAlert()
      waitResponse()
      click(parentModel)
      waitResponse()
      verifyEquals("[Blah 2, Blah 4]", getAlertMessage())
      clickAlert()
      waitResponse()
      doubleClick(jq("@listbox > @listitem:first-child"))
      waitResponse()
      verifyEquals("Blah 4", widget(jq("@listbox > @listitem")).attr("label"))
      click(parents)
      waitResponse()
      verifyEquals("[Blah 4]", getAlertMessage())
      clickAlert()
      waitResponse()
      click(parentModel)
      waitResponse()
      verifyEquals("[Blah 4]", getAlertMessage())
      clickAlert()
      waitResponse()
      // including listhead
      verifyEquals("2", parentsList.nChildren())
    })
  }
}



